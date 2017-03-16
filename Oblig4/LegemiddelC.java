
public class LegemiddelC extends Legemiddel {

  private static int teller = 0;

  public LegemiddelC(String navn, double pris, double virkestoff) {
    super(navn, pris, virkestoff);
  id = teller;
  teller++;
  }

  @Override
  public String toString() {
    return "Vanlig " + super.toString();
  }
}
