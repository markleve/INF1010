import java.util.concurrent.atomic.AtomicInteger;

public class BlaaResept extends Resept {

  private static final AtomicInteger idGenerator = new AtomicInteger();
  private static final double PROSENT_BETALE = 0.25;

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
    id = idGenerator.getAndIncrement();
  }
  /**
  * Returnerer reseptens farge. Enten "blaa" eller "hvit".
  * @return      reseptens farge
  */
  public String farge() { return "blaa"; }

  /**
  * Returnerer prisen pasienten maa betale.
  * @return      prisen pasienten maa betale
  */
  public double prisAaBetale() {
    return hentLegemiddel().hentPris()*PROSENT_BETALE;
  }

  @Override
  public String toString() {
    return "Blå resept " + super.toString();
  }
}
