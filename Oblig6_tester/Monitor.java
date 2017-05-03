import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

public class Monitor {

  private final Lock laas = new ReentrantLock();
  private final Condition erTom = laas.newCondition();
  private Koe<Melding> meldingListe = new Koe<Melding>();
  private boolean telegraferFerdig = false;
  private boolean kryptograferFerdig = false;
  private boolean heltFerdig = false;

  public void settInnMelding(Melding melding) {
    laas.lock();
    try {
      if(meldingListe.erTom()) {
        meldingListe.settInn(melding);
        erTom.signalAll();
      } else {
        meldingListe.settInn(melding);
      }
    } finally {
      laas.unlock();
    }
  }

  public Melding hentMelding() {
    laas.lock();
    try {
      while(meldingListe.erTom()) {
      //  if(telegraferFerdig) { heltFerdig = true; }
        erTom.await();
      }
      Melding melding = meldingListe.fjern();
      if(meldingListe.erTom() && telegraferFerdig) { return null; } //heltFerdig = true;
      return melding;        // kan man returnere i try metoden ????
    } catch(InterruptedException e) {
      return null;      // denne måtte ha en return, hvorfor??
    } finally {
      laas.unlock();
    }
  }

  public boolean meldingListeTom() { return meldingListe.erTom(); }

  public boolean telegraferFerdig() { return telegraferFerdig; }
  public boolean kryptograferFerdig() { return kryptograferFerdig; }
  public boolean heltFerdige() { return heltFerdig; }

  public void setTelegraferFerdige() { telegraferFerdig = true; }
  public void setKryptograferFerdige() { kryptograferFerdig = true; }
  public Koe<Melding> hentMeldingListe() { return meldingListe; }

}
