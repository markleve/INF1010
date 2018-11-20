
public class Fastlege extends Lege implements Kommuneavtale {

  private int avtalenummer;

  public Fastlege(String navn, int avtalenummer) {
    super(navn);
    this.avtalenummer = avtalenummer;
  }

  /**
  * Returnerer fastlegens avtalenummer
  * @return       fastlegens avtalenummer
  */
  @Override
  public int hentAvtalenummer() { return avtalenummer; }

  @Override
  public String toString() {
    return super.toString() + " har avtalenummer " + avtalenummer;
  }

}
