import krypto.*;
import java.util.concurrent.CountDownLatch;

public class Kryptograf implements Runnable {
  private final Monitor kryptoMonitor;        // static ????    final?????
  private final Monitor dekryptoMonitor;      // static ????    final?????
  private final CountDownLatch alleFerdigBarriere;

  public Kryptograf(Monitor kryptoMonitor, Monitor dekryptoMonitor, CountDownLatch alleFerdigBarriere) {
    this.kryptoMonitor = kryptoMonitor;
    this.dekryptoMonitor = dekryptoMonitor;
    this.alleFerdigBarriere = alleFerdigBarriere;
  }

  @Override
  public void run() {
    // hentMelding returnerer null når alle kryptografistene er ferdige og
    // listen med meldinger er tom
    while(kryptoMonitor.hentMelding() != null) {
      System.out.println("Kryptograf har startet");
      Melding melding = kryptoMonitor.hentMelding();
      System.out.println("\nMelding fra kanal " + melding.hentKanalId() + " med id " + melding.hentMeldingId() + "\n");
      // dekrypterer meldingen
    //  String dekryptertTekst = Kryptografi.dekrypter(melding.hentMelding());
    //  melding.setDekryptertMelding(dekryptertTekst);

    //  dekryptoMonitor.settInnMelding(melding);
    }
/*
    alleFerdigBarriere.countDown();
    try {
      alleFerdigBarriere.await();
    } catch (InterruptedException e){ }

    dekryptoMonitor.alleKryptograferFerdige();*/
  }
}
