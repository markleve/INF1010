import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

public class Monitor {

  private final Lock laas = new ReentrantLock();
  private final Condition erTom = laas.newCondition();
  private Koe<Melding> meldingListe = new Koe<Melding>();

  private int antArbeidere;
  private int antArbeidereFerdige = 0;

  public Monitor(int antArbeidere) {
    this.antArbeidere = antArbeidere;
  }

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
        if(alleArbeidereFerdige()) { return null; }
        erTom.await();
      }
      return meldingListe.fjern();
    } catch(InterruptedException e) {
      return null;     
    } finally {
      laas.unlock();
    }
  }

  public boolean alleArbeidereFerdige() {
    laas.lock();
    try {
      return (antArbeidereFerdige == antArbeidere);
    } finally {
      laas.unlock();
    }
  }

  public void setErFerdig() {
    laas.lock();
    try {
      antArbeidereFerdige += 1;
    } finally {
      laas.unlock();
    }
  }

  public Koe<Melding> hentMeldingListe() { return meldingListe; }
  public int hentAntArbeidereFerdige() { return antArbeidereFerdige; }
}
