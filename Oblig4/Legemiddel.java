import java.util.concurrent.atomic.AtomicInteger;

public abstract class Legemiddel {

  // skal variablene vaere protected eller private?
  // trenger subklassene tilgang til variablene?
  // kan bruke hent metodene i subkassene for aa gi tilgang til variablene
  protected String navn;
  protected int id;    // skal dene gjores finale?? Slik at den ikke kan endre?
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

  // overskriver denne en annen toString metode??
  public String toString() {
    return "legemiddel [" + hentId() + "] " + hentNavn() + "\nPris: "
    + hentPris() + "\nVirkestoff: " + hentVirkestoff();
  }
}
