
/**
* Klassen representerer en pasient, med dens informasjon og egenskaper.
*/
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

  /**
  * Returnerer pasientens id.
  * @return      pasientens id
  */
  public int hentId() { return id; }
  /**
  * Returnerer pasientens navn.
  * @return      pasientens navn
  */
  public String hentNavn() { return navn; }
  /**
  * Returnerer pasientens fodselsnummer.
  * @return      pasientens fodselsnummer
  */
  public long hentFodselsnummer() { return fodselsNr; }
  /**
  * Returnerer pasientens adresse.
  * @return      pasientens adresse
  */
  public String hentGateadresse() { return adresse; }
  /**
  * Returnerer pasientens postnummer.
  * @return      pasientens postnummer
  */
  public int hentPostnummer() { return postnummer; }
  /**
  * Returnerer listen (en stabel) over pasientens resepter.
  * @return      pasientens reseptliste
  */
  public Stabel<Resept> hentReseptliste() { return reseptliste; }

  /**
   * Legger ny resept til reseptlisten
   * @param   resept    resepten som legges til
   */
  public void leggTilResept(Resept resept) {
    reseptliste.settInn(resept);
  }

  /**
   * Returnerer en string med informasjon om pasienten.
   * @return   informasjon om pasienten
   */
  @Override
  public String toString() {
    return "\nPassient " + "[" + id + "]: " + navn + " (" +
    fodselsNr + ")\n" + "Adresse: " + adresse +
    "\nPostnummer: " + postnummer;
  }
}
