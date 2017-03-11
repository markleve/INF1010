
public class Fastlege extends Lege implements Kommuneavtale {

  private int avtalenummer;

  public Fastlege(int avtalenummer) {
    this.avtalenummer = avtalenummer;
  }

  public int hentAvtalenummer() { return avtalenummer; }

}
