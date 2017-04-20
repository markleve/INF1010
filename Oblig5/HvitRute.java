// disse rutene kan man gaa paa

public class HvitRute extends Rute {

  public HvitRute(int rad, int kolonne) {
    super(rad, kolonne);
  }

  @Override
  public char tilTegn() {
    return ' ';
  }

  @Override
  public String toString() {
    return tilTegn() + " [" + rad + "][" + kolonne + "]";
  }
}
