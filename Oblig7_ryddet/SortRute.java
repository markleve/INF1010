
public class SortRute extends Rute {

  public SortRute(int rad, int kolonne) {
    super(rad, kolonne);
  }

  @Override
  public void gaa(Rute forrigeRute, String vei, Liste<String> utveier) { return; }

  @Override
  public char tilTegn() {
    return '#';
  }

  @Override
  public String toString() {
    return tilTegn() +  " [" + rad + "][" + kolonne + "]";
  }
}
