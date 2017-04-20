

public class Aapning extends HvitRute {

  public Aapning(int rad, int kolonne) {
    super(rad, kolonne);
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
