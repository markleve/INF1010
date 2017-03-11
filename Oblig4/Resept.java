
public abstract class Resept {

  protected int id;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected int pasientId;   // referanse til pasienten sin id???
  protected int reit;

  public Resept(Legemiddel legemiddel, Lege lege, int pasientId, int reit) {
    this.legemiddel = legemiddel;
    this.lege = lege;
    this.pasient = pasient;
    this.reit = reit;
  }

  public int hentId() { return id; }
  public Legemiddel hentLegemiddel() { return legemiddel; }
  public Lege hentLege() { return utskrivendeLege; }
  public int hentPasientId() { return pasientId; }
  public int hentReit() { return reit; }

  // skal det vaere en @Override her ???
  public String toString() {
    return "[" + hentId() + "]" + "\nLegemiddel: " + hentLegemiddel()
    + "\nUtskrivende lege: " + hentLege() + "\nPasient id: "
    + hentPasientId() + "\nReit: " + hentReit();
  }

}
