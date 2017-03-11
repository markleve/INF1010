
public class LegemiddelA extends Legemiddel {

  private int styrke;

  public LegemiddelA(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentNarkotiskStyrke() { return styrke;}

  @Override
  public String toString() {
    return "Narkotisk " + super.toString() + "\nNarkotisk styrke: "
    + hentNarkotiskStyrke();
  }
}
