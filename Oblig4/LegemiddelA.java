
public class LegemiddelA extends Legemiddel {

  private int styrke;
  private static int teller = 0;

  public LegemiddelA(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;
    id = teller;
    teller++;
  }

  /**
  * Returnerer styrken til det narkotiske legemiddelet
  * @return       styrken
  */
  public int hentNarkotiskStyrke() { return styrke;}

  @Override
  public String toString() {
    return "Narkotisk " + super.toString() + "\nStyrke: "
    + styrke;
  }
}
