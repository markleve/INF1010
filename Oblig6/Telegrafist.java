import krypto.*;
import java.util.concurrent.CountDownLatch;

public class Telegrafist implements Runnable {
  private final Monitor kryptoMonitor;        // static ????    final?????
  private Kanal kanal;                        // static ????    final?????
  private int id;
  private static int teller = 1;
  private final CountDownLatch alleFerdigBarriere;

  public Telegrafist(Monitor kryptoMonitor, Kanal kanal, CountDownLatch alleFerdigBarriere) {
    this.kryptoMonitor = kryptoMonitor;
    this.kanal = kanal;
    this.alleFerdigBarriere = alleFerdigBarriere;
  }

  /* I tillegg til String objektet skal hver melding ha et sekvensnummer + en kanal ID
       -> mødvendig for å kunne skille meldingene etter kanal og sortere dem i riktig rekkefølge
  */
  @Override
  public void run() {
    System.out.println("Telegrafist " + id + " har startet");

    // når vet telegrafisten at det ikke kommer flere meldinger??
    //    -> lytt returnerer null
    //    -> returneres meldinger kontinuerlig?
    while(kanal.lytt() != null) {
      id = teller++;
      Melding melding = new Melding(kanal.lytt(), kanal.hentId(), id);
      kryptoMonitor.settInnMelding(melding);
    }

    alleFerdigBarriere.countDown();
    try {
      alleFerdigBarriere.await();
    } catch (InterruptedException e){ }

    kryptoMonitor.alleTelegrafisterFerdige();
  }
}
