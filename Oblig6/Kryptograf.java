import krypto.*;
import java.util.concurrent.CountDownLatch;

public class Kryptograf implements Runnable {
  private final Monitor kryptoMonitor;
  private final Monitor dekryptoMonitor; 
  private static int teller = 1;
  private int kryptoId;

  public Kryptograf(Monitor kryptoMonitor, Monitor dekryptoMonitor) {
    this.kryptoMonitor = kryptoMonitor;
    this.dekryptoMonitor = dekryptoMonitor;
    this.kryptoId = teller++;
  }

  public int hentKryptoId() { return kryptoId; }

  @Override
  public void run() {
    System.out.println("Kryptograf " + kryptoId + " starter");

    Melding melding = kryptoMonitor.hentMelding();
    while(melding != null) {
      String dekryptertTekst = Kryptografi.dekrypter(melding.hentMeldingen());
      melding.setDekryptertMelding(dekryptertTekst);
      dekryptoMonitor.settInnMelding(melding);
      melding = kryptoMonitor.hentMelding();
    }

    System.out.println("Kryptograf " + kryptoId + " er ferdig");

    dekryptoMonitor.setErFerdig();    // sier i fra at kryptografen er ferdige

    System.out.println("Antall ferdige krypto: " + dekryptoMonitor.hentAntArbeidereFerdige());
    System.out.println("Alle ferdige krypto: " + dekryptoMonitor.alleArbeidereFerdige());
  }
}
