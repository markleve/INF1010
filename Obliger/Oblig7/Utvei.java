

public class Utvei implements Comparable<Utvei> {
  String utvei;
  int lengde;

  public Utvei(String utvei, int lengde) {
    this.utvei = utvei;
    this.lengde = lengde;
  }

  public String hentUtvei() {  return utvei; }
  public int hentLengde() { return lengde; }

  @Override
  public int compareTo(Utvei annenUtvei) {
    return lengde - annenUtvei.hentLengde();
  }

  @Override
  public String toString() {
    return "Korteste utvei: " + utvei + "\n Lengde: " + lengde + "\n";
  }
}
