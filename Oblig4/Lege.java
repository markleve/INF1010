public class Lege implements Comparable<Lege> {
  private String navn;   // denne skal vaere unik
  private Koe<Resept> reseptliste;

  public Lege(String navn) {
    this.navn = navn;
    reseptliste = new Koe<Resept>();
  }

  public String hentNavn() { return navn; }
  public Koe<Resept> hentReseptliste() {return reseptliste; }
  public void leggTilResept(Resept resept) {
    hentReseptliste().settInn(resept);
  }

  public int compareTo(Lege annenLege) {
    return 1;
  }
}
