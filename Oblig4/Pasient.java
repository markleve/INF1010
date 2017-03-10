import java.util.concurrent.atomic.AtomicInteger;

public class Pasient {
  private String navn;
  private long fodselsNr;
  private String adresse;
  private int postnummer;
//  private Stabel<Resept> resepter;
  private static AtomicInteger nesteId = new AtomicInteger();
  private static int id;    // skal dene gjores finale?? Slik at den ikke kan endre?

  public Pasient(String navn, long fodselsNr, String adresse, int postnummer) {
    this.navn = navn;
    this.fodselsNr = fodselsNr;
    this.adresse = adresse;
    this.postnummer = postnummer;
    id = nesteId.incrementAndGet();
  //  resepter = new Stabel<Resept>();
  }

  // hvordan skal man skrive javadoc til get metoder ??
  public int hentId() { return id; }
  public String hentNavn() { return navn; }
  public long hentFodselsnummer() { return fodselsNr; }
  public String hentGateadresse() { return adresse; }
  public int hentPostnummer() { return postnummer; }
}
