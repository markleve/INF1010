import krypto.*;
import java.util.concurrent.CountDownLatch;

public class Telegrafist implements Runnable {
  private final Monitor kryptoMonitor;       
  private Kanal kanal;

  public Telegrafist(Monitor kryptoMonitor, Kanal kanal) {
    this.kryptoMonitor = kryptoMonitor;
    this.kanal = kanal;
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

    System.out.println("Telegrafist " + kanal.hentId()+ " er ferdig");

    kryptoMonitor.setErFerdig(); // sier i fra at telegrafisten er ferdige

    System.out.println("Antall ferdige: " + kryptoMonitor.hentAntArbeidereFerdige());
    System.out.println("Alle ferdige: " + kryptoMonitor.alleArbeidereFerdige());
  }
}
