public class Lege implements Comparable<Lege> {
  private String navn;   // denne skal vaere unik

  public Lege(String navn) {
    this.navn = navn;
  }

  public String hentNavn() { return navn; }

  public int compareTo(Lege annenLege) {
    return 1;
  }
}
