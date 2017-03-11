import java.util.concurrent.atomic.AtomicInteger;

public class LegemiddelA extends Legemiddel {

  private int styrke;
  private static final AtomicInteger idGenerator = new AtomicInteger();

  public LegemiddelA(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;
    id = idGenerator.getAndIncrement();
  }

  public int hentNarkotiskStyrke() { return styrke;}

  @Override
  public String toString() {
    return "Narkotisk " + super.toString() + "\nNarkotisk styrke: "
    + hentNarkotiskStyrke();
  }
}
