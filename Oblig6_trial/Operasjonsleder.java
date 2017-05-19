
public class Operasjonsleder implements Runnable {
  private final Monitor dekryptoMonitor;      // static ????    final?????

  public Operasjonsleder(Monitor dekryptoMonitor) {
    this.dekryptoMonitor = dekryptoMonitor;
  }

  @Override
  public void run() {

  /*  while(dekryptoMonitor.hentMelding() != null) {

  }*/

    if(dekryptoMonitor.hentMelding() == null) {
      // skriv meldinger til fil
      // skriver en fil per kanal
          // hver melding adskilt av to linjeskift
          // meldingene skal skrives ut i riktig rekkefølge
      Koe<Melding> meldingListe = dekryptoMonitor.hentMeldingListe();
      for(Melding melding: meldingListe) {
        System.out.println("Meldingen er: " + melding.hentMelding() + "\n");
        System.out.println("Dekryptert melding er: " + melding.hentDekryptertMelding() + "\n");
        System.out.println("Kanal er: " + melding.hentKanalId() + "\n");
        System.out.println("Melding id er: " + melding.hentMeldingId() + "\n");
      }
    }
  }
}
