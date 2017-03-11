import java.util.concurrent.atomic.AtomicInteger;

public class HvitResept extends Resept {

  private static final AtomicInteger idGenerator = new AtomicInteger();

  public HvitResept(Legemiddel legemiddel, Lege lege, int pasientId, int reit) {
    super(legemiddel, lege, pasientId, reit);
    id = idGenerator.getAndIncrement();
  }

  /**
  * Returnerer reseptens farge. Enten "blaa" eller "hvit".
  * @return      reseptens farge
  */
  public String farge() { return "hvit"; }

  @Override
  public String toString() {
    return "Hvit resept " + super.toString();
  }
}
