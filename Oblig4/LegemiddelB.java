import java.util.concurrent.atomic.AtomicInteger;

public class LegemiddelB extends Legemiddel {

  private int styrke;
  private static final AtomicInteger nesteIdB = new AtomicInteger();


  public LegemiddelB(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;
    id = nesteIdB.getAndIncrement();
  }

  public int hentVanedannendeStyrke() {return styrke; }

  @Override
  public String toString() {
    return "Vanedannende " + super.toString() + "\nVanedannende styrke: "
    + hentVanedannendeStyrke();
  }
}
