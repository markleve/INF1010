

public class Pasient {
  private String navn;
  private long fodselsNr;
  private String adresse;
  private int postnummer;
  private Stabel<Resept> reseptliste;
  private static int teller = 0;
  private int id;

  public Pasient(String navn, long fodselsNr, String adresse, int postnummer) {
    this.navn = navn;
    this.fodselsNr = fodselsNr;
    this.adresse = adresse;
    this.postnummer = postnummer;
    id = teller;
    teller++;
    reseptliste = new Stabel<Resept>();
  }

  // hvordan skal man skrive javadoc til get metoder ??
  public int hentId() { return id; }
  public String hentNavn() { return navn; }
  public long hentFodselsnummer() { return fodselsNr; }
  public String hentGateadresse() { return adresse; }
  public int hentPostnummer() { return postnummer; }
  public Stabel<Resept> hentReseptliste() { return reseptliste; }

  /**
   * Legger ny resept til reseptlisten
   * @param   resept    resepten som legges til
   */
  public void leggTilResept(Resept resept) {
    reseptliste.settInn(resept);
  }

  @Override
  public String toString() {
    return "\nPassient " + "[" + id + "]: " + navn + " (" +
    fodselsNr + ")\n" + "Adresse: " + adresse +
    "\nPostnummer: " + postnummer;
  }
}
