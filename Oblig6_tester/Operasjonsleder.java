
public class Operasjonsleder implements Runnable {
  private final Monitor dekryptoMonitor;      // static ????    final?????

  public Operasjonsleder(Monitor dekryptoMonitor) {
    this.dekryptoMonitor = dekryptoMonitor;
  }

  @Override
  public void run() {
    System.out.println("Operasjonsleder starter");
  //  while(!dekryptoMonitor.kryptograferFerdig()) {}

  // sjekkes det kontinuerlig om denne betingelsen er oppfylt
    if(dekryptoMonitor.kryptograferFerdig()) {
      System.out.println("jeg er her");
      while(!dekryptoMonitor.meldingListeTom()) {
        Melding melding = dekryptoMonitor.hentMelding();
        System.out.println("Meldingen er: " + melding.hentMeldingen() + "\n");
        System.out.println("Dekryptert melding er: " + melding.hentDekryptertMelding() + "\n");
        System.out.println("Kanal er: " + melding.hentKanalId() + "\n");
        System.out.println("Melding id er: " + melding.hentMeldingId() + "\n");
      }

      System.out.println("slutt");

    /*  Koe<Melding> meldingListe = dekryptoMonitor.hentMeldingListe();
      for(Melding melding: meldingListe) {
        System.out.println("Meldingen er: " + melding.hentMelding() + "\n");
        System.out.println("Dekryptert melding er: " + melding.hentDekryptertMelding() + "\n");
        System.out.println("Kanal er: " + melding.hentKanalId() + "\n");
        System.out.println("Melding id er: " + melding.hentMeldingId() + "\n");
      }*/
    }

      // skriv meldinger til fil
      // skriver en fil per kanal
          // hver melding adskilt av to linjeskift
          // meldingene skal skrives ut i riktig rekkefølge


  }
}
