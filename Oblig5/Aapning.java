
public class Aapning extends HvitRute {

  public Aapning(int rad, int kolonne) {
    super(rad, kolonne);
  }

  @Override
  public void gaa(Rute forrigeRute, String vei, Liste<String> utveier) {
    vei += "(" + (kolonne+1) + ", " + (rad+1) + ")";
    utveier.settInn(vei);
  }

  @Override
  public String toString() {
    return tilTegn() + " [" + rad + "][" + kolonne + "]";
  }

  @Override
  public char tilTegn() {
    return 'A';
  }
}
