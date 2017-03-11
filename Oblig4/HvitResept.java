import java.util.concurrent.atomic.AtomicInteger;

public class HvitResept extends Resept {

  private static final AtomicInteger idGenerator = new AtomicInteger();

  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
    id = idGenerator.getAndIncrement();
  }

  /**
  * Returnerer reseptens farge. Enten "blaa" eller "hvit".
  * @return      reseptens farge
  */
  public String farge() { return "hvit"; }

  /**
  * Returnerer prisen pasienten maa betale.
  * @return      prisen pasienten maa betale
  */
  public double prisAaBetale() {
    return hentLegemiddel().hentPris();
  }

  @Override
  public String toString() {
    return "Hvit resept " + super.toString();
  }
}
