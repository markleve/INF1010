import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

public class Monitor {

  private final Lock laas = new ReentrantLock();
  private final Condition erTom = laas.newCondition();
  private Koe<Melding> meldingListe = new Koe<Melding>();
  private boolean alleTelegrafisterFerdig = false;
  private boolean alleKryptograferFerdig = false;

  public void settInnMelding(Melding melding) {
    laas.lock();
    try {
      meldingListe.settInn(melding);
      erTom.signalAll();

      /*if(meldingListe.erTom()) {      // er dette nødvendig???
        meldingListe.settInn(melding);
        erTom.signalAll();              // signaliserer bare alle dersom meldingsliste er tom
      } else {
        meldingListe.settInn(melding);
      }*/
    } finally {
      laas.unlock();
    }
  }

  // henter den første meldingen som ble satt inn
  public Melding hentMelding() {
    laas.lock();
    try {
      //if(alleKryptograferFerdig) { return null; }
      while(meldingListe.erTom()) {
        if(alleTelegrafisterFerdig) { return null; }
        erTom.await();                    // så lenge listen er tom skal kryptografene vente med å hente meldinger
      }
      return meldingListe.fjern();        // kan man returnere i try metoden ????
    } catch(InterruptedException e) {
      return null;      // denne måtte ha en return, hvorfor??
    } finally {
      laas.unlock();
    }
  }

  public boolean hentAlleTelegrafisterFerdig() { return alleTelegrafisterFerdig; }

  public void alleTelegrafisterFerdige() { alleTelegrafisterFerdig = true; }
  public void alleKryptograferFerdige() { alleKryptograferFerdig = true; }
  public Koe<Melding> hentMeldingListe() { return meldingListe; }

}
