
public class LegemiddelC extends Legemiddel {

  public LegemiddelC(String navn, double pris, double virkestoff) {
    super(navn, pris, virkestoff);
  }

  @Override
  public String toString() {
    return "Vanlig " + super.toString();
  }
}
