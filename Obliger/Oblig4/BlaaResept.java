
public class BlaaResept extends Resept {

  private static int teller = 0;
  private static final double PROSENT_BETALE = 0.25;

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
    id = teller;
    teller++;
  }
  /**
  * Returnerer reseptens farge. Enten "blaa" eller "hvit".
  * @return      reseptens farge
  */
  @Override
  public String farge() { return "blaa"; }

  /**
  * Returnerer prisen pasienten maa betale.
  * @return      prisen pasienten maa betale
  */
  @Override
  public double prisAaBetale() {
    return legemiddel.hentPris()*PROSENT_BETALE;
  }

  @Override
  public String toString() {
    return "Blå resept " + super.toString();
  }
}
