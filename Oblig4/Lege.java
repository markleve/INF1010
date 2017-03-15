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
    reseptliste.settInn(resept);
  }

  // a.compareTo(b) returnerer folgende tall:
  //    Negativt   a < b
  //    0          a = b
  //    Positivt   a > b
  public int compareTo(Lege annenLege) {
    return navn.compareTo(annenLege.hentNavn());
  }

  @Override
  public String toString() {
    return "\nDoktoren: " + navn;
  }
}
