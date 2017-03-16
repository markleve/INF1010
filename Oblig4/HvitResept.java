
public class HvitResept extends Resept {

  private static int teller = 0;

  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
    id = teller;
    teller++;
  }

  /**
  * Returnerer reseptens farge. Enten "blaa" eller "hvit".
  * @return      reseptens farge
  */
  @Override
  public String farge() { return "hvit"; }

  /**
  * Returnerer prisen pasienten maa betale.
  * @return      prisen pasienten maa betale
  */
  @Override
  public double prisAaBetale() {
    return legemiddel.hentPris();
  }

  @Override
  public String toString() {
    return "Hvit resept " + super.toString();
  }
}
