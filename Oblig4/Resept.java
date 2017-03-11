
public abstract class Resept {

  protected int id;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected int pasientId;   // referanse til pasienten sin id???
  protected int reit;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasientId = pasientId;
    this.reit = reit;
  }

  public int hentId() { return id; }
  public Legemiddel hentLegemiddel() { return legemiddel; }
  public Lege hentLege() { return utskrivendeLege; }
  public int hentPasientId() { return pasientId; }
  public int hentReit() { return reit; }

  /**
  * Bruker resepten én gang. Returner false om resepten er
  * oppbrukt, ellers returnerer den true.
  * @return      om resepten kunne brukes
  */
  public boolean bruk() {
    if(hentReit() > 0) {
      reit--;
      return true;
    }
    return false;     // beskjed til bruker om at den er oppbrukt??
  }

  /**
  * Returnerer reseptens farge. Enten "blaa" eller "hvit".
  * @return      reseptens farge
  */
  abstract public String farge();

  /**
  * Returnerer prisen pasienten maa betale.
  * @return      prisen pasienten maa betale
  */
  abstract public double prisAaBetale();

  // skal det vaere en @Override her ???
  public String toString() {
    return "[" + hentId() + "]" + "\nLegemiddel: " + hentLegemiddel()
    + "\nUtskrivende lege: " + hentLege() + "\nPasient id: "
    + hentPasientId() + "\nReit: " + hentReit();
  }

}
