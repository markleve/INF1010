
public abstract class Legemiddel {

  protected String navn;
  protected int id;
  protected double pris;
  protected double virkestoff;

  public Legemiddel(String navn, double pris, double virkestoff) {
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
  }

  public int hentId() { return id; }
  public String hentNavn() { return navn; }
  public double hentPris() { return pris; }
  public double hentVirkestoff() { return virkestoff; }

  @Override
  public String toString() {
    return "legemiddel [" + id + "] " + navn + "\nPris: "
    + pris + "\nVirkestoff: " + virkestoff;
  }
}
