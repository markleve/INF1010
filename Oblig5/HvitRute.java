// disse rutene kan man gaa paa

public class HvitRute extends Rute {

  public HvitRute(int rad, int kolonne, Labyrint tilhorendeLabyrint, Rute naboNord,
  Rute naboSyd, Rute naboOst, Rute naboVest) {
    super(rad, kolonne, tilhorendeLabyrint, naboNord, naboSyd, naboOst, naboVest);
  }

  @Override
  public char tilTegn() {
    return '.';
  }
}
