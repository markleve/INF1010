import java.util.concurrent.atomic.AtomicInteger;

public class LegemiddelC extends Legemiddel {

  private static final AtomicInteger idGenerator = new AtomicInteger();

  public LegemiddelC(String navn, double pris, double virkestoff) {
    super(navn, pris, virkestoff);
    id = idGenerator.getAndIncrement();
  }

  @Override
  public String toString() {
    return "Vanlig " + super.toString();
  }
}
