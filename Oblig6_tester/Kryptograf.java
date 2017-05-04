import krypto.*;
import java.util.concurrent.CountDownLatch;

public class Kryptograf implements Runnable {
  private final Monitor kryptoMonitor;        // static ????    final?????
  private final Monitor dekryptoMonitor;      // static ????    final?????
  private final CountDownLatch alleFerdigBarriere;
  private static int teller = 1;
  private int kryptoId;

  public Kryptograf(Monitor kryptoMonitor, Monitor dekryptoMonitor, CountDownLatch alleFerdigBarriere) {
    this.kryptoMonitor = kryptoMonitor;
    this.dekryptoMonitor = dekryptoMonitor;
    this.alleFerdigBarriere = alleFerdigBarriere;
    this.kryptoId = teller++;
  }

  public int hentKryptoId() { return kryptoId; }

  @Override
  public void run() {
    System.out.println("Kryptograf " + kryptoId + " starter");

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
    System.out.println("Kryptograf " + kryptoId + " ferdig");
    System.out.println("Kryptografer er ferdige: " + dekryptoMonitor.erFerdig());


    try {
      alleFerdigBarriere.await();
    } catch (InterruptedException e) { }

    // SPØRSMÅL !!!!
    // alle kommer hit og setter erFerdig, hvordan kan man få bare den
    // siste tråden som kommer hit til å sette den??

    dekryptoMonitor.setErFerdig();    // sier i fra at alle kryptografer er ferdige
    //System.out.println("Jeg er her ");

  /*  for(Melding m: dekryptoMonitor.hentMeldingListe()) {
      System.out.println("\nMelding fra kanal " + m.hentKanalId() + " med id " + m.hentMeldingId() + "\n" + m.hentDekryptertMelding());
    }*/
  }
}
