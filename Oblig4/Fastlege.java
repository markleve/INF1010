
public class Fastlege extends Lege implements Kommuneavtale {

  private int avtalenummer;

  public Fastlege(int avtalenummer) {
    this.avtalenummer = avtalenummer;
  }

  // skal man skrive @Override over metoder fra interface?
  // man overskriver jo ikke en metode, da en metode ikke er
  // implementert ennaa. Det er bare signaturen som er laget
  // i interfacet .... ????
  public int hentAvtalenummer() { return avtalenummer; }

  @Override
  public String toString() {
    return super.toString() + " har avtalenummer " + hentAvtalenummer();
  }

}
