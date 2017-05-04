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

    String tekst = kanal.lytt();
    while(tekst != null) {
      Melding melding = new Melding(tekst, kanal.hentId());
      kryptoMonitor.settInnMelding(melding);
      tekst = kanal.lytt();
    }

    alleFerdigBarriere.countDown();
    System.out.println("Telegrafist " + kanal.hentId()+ " er ferdig");
    System.out.println("Alle telegrafister er ferdige: " + kryptoMonitor.erFerdig());

    try {
      alleFerdigBarriere.await();
    } catch (InterruptedException e){ }

    kryptoMonitor.setErFerdig();      // sier i fra at alle telegrafister er ferdige

    /*for(Melding melding: kryptoMonitor.hentMeldingListe()) {
      System.out.println("\nMelding fra kanal " + melding.hentKanalId() + " med id " + melding.hentMeldingId() + "\n" + melding.hentMeldingen());
    }*/
  }
}
