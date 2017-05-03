import krypto.*;
import java.util.concurrent.CountDownLatch;

public class Telegrafist implements Runnable {
  private final Monitor kryptoMonitor;        // static ????    final?????
  private Kanal kanal;                        // static ????    final?????
  private final CountDownLatch alleFerdigBarriere;

  public Telegrafist(Monitor kryptoMonitor, Kanal kanal, CountDownLatch alleFerdigBarriere) {
    this.kryptoMonitor = kryptoMonitor;
    this.kanal = kanal;
    this.alleFerdigBarriere = alleFerdigBarriere;
  }

  @Override
  public void run() {
    System.out.println("Telegrafist " + kanal.hentId() + " har startet");

    // hadde en feil her !!!!
    String mld = kanal.lytt();
    while(mld != null) {
      Melding melding = new Melding(mld, kanal.hentId());
      kryptoMonitor.settInnMelding(melding);
      mld = kanal.lytt();
    }

    alleFerdigBarriere.countDown();
  //  System.out.println("Telegrafist " + kanal.hentId()+ " er ferdig");
    try {
      alleFerdigBarriere.await();
    } catch (InterruptedException e){ }

    kryptoMonitor.setTelegraferFerdige();
  //  System.out.println("Telegrafist " + kanal.hentId()+" ferdig: "+ kryptoMonitor.telegraferFerdig());

  /*  for(Melding melding: kryptoMonitor.hentMeldingListe()) {
      System.out.println("\nMelding fra kanal " + melding.hentKanalId() + " med id " + melding.hentMeldingId() + "\n" + melding.hentMelding());
    }*/
  }
}
