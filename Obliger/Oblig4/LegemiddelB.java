
public class LegemiddelB extends Legemiddel {

  private int styrke;
  private static int teller = 0;

  public LegemiddelB(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;
    id = teller;
    teller++;
  }

  /**
  * Returnerer styrken til det vanedannende legemiddelet
  * @return       styrken
  */
  public int hentVanedannendeStyrke() {return styrke; }

  @Override
  public String toString() {
    return "Vanedannende " + super.toString() + "\nStyrke: "
    + styrke;
  }
}
