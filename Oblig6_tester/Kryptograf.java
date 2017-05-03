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
    System.out.println("Kryptograf har startet");

    Melding melding = kryptoMonitor.hentMelding();
    while(melding != null) {
    //  System.out.println("\nMelding fra kanal " + melding.hentKanalId() + " med id " + melding.hentMeldingId() + "\n" + melding.hentMelding());
      String dekryptertTekst = Kryptografi.dekrypter(melding.hentMeldingen());
      melding.setDekryptertMelding(dekryptertTekst);
  //    System.out.println("\nMelding fra kanal " + melding.hentKanalId() + " med id " + melding.hentMeldingId() + "\n" + melding.hentDekryptertMelding());
      dekryptoMonitor.settInnMelding(melding);
      melding = kryptoMonitor.hentMelding();
    }

    alleFerdigBarriere.countDown();
  //  System.out.println("Kryptograf er ferdig");

    try {
      alleFerdigBarriere.await();
    } catch (InterruptedException e){ }

    dekryptoMonitor.setKryptograferFerdige();
    //System.out.println("Kryptograf ferdig: " + dekryptoMonitor.kryptograferFerdig());

    for(Melding m: dekryptoMonitor.hentMeldingListe()) {
      System.out.println("\nMelding fra kanal " + m.hentKanalId() + " med id " + m.hentMeldingId() + "\n" + m.hentDekryptertMelding());
    }
  }
}
