import java.io.PrintWriter;
import java.io.File;
import java.util.HashMap;

public class Operasjonsleder implements Runnable {
  private final Monitor dekryptoMonitor;
  private int antKalaner;
  private final OrdnetLenkeliste<Melding> alleMeldinger;

  public Operasjonsleder(Monitor dekryptoMonitor, int antKalaner) {
    this.dekryptoMonitor = dekryptoMonitor;
    this.antKalaner = antKalaner;
    alleMeldinger = new OrdnetLenkeliste<Melding>();
  }

  @Override
  public void run() {
    System.out.println("Operasjonsleder starter");

     // operasjonslederen henter meldinger og sorterer dem
    Melding meldingen = dekryptoMonitor.hentMelding();
    while(meldingen != null) {
      alleMeldinger.settInn(meldingen);
      System.out.print(".");                                                            // uten denne kommer ikke programmet videre... Hvorfor??
      meldingen = dekryptoMonitor.hentMelding();
    }

    // Operasjonsleder skriver til fil
    File[] utfiler = opprettUtfiler();
    int kanalId = 1;
    for(File utfil: utfiler) {
      skrivTilFil(kanalId, utfil);
      kanalId++;
    }
  }

  public File[] opprettUtfiler() {
    File[] utfiler = new File[antKalaner];
    for(int i = 0; i < antKalaner; i++) {
      String filnavn = "kanal_" + (i+1) + ".txt";
      File filen = new File(filnavn);
      utfiler[i] = filen;
    }
    return utfiler;
  }

  public void skrivTilFil(int kanalId, File utfil) {
    try {
      PrintWriter skriver = new PrintWriter(utfil, "utf-8");
      for(Melding m: alleMeldinger) {
        if(m.hentKanalId() == kanalId) {
          skriver.append("[" + m.hentKanalId() + "] [" + m.hentMeldingId() +
          "]\n" + m.hentDekryptertMelding() + "\n\n");
        }
      }
      skriver.close();
    } catch(Exception e) {}
  }

}
