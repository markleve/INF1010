// disse rutene kan man gaa paa

public class HvitRute extends Rute {

  public HvitRute(int rad, int kolonne, Labyrint tilhorendeLabyrint) {
    super(rad, kolonne, tilhorendeLabyrint);
  }

  @Override
  public char tilTegn() {
    return '.';
  }

  @Override
  public String toString() {
    return "Hvit rute: .";
  }
}
