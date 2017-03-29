// disse rutene er som en vegg

public class SortRute extends Rute {

  public SortRute(int rad, int kolonne, Labyrint tilhorendeLabyrint, Rute naboNord,
  Rute naboSyd, Rute naboOst, Rute naboVest) {
    super(rad, kolonne, tilhorendeLabyrint, naboNord, naboSyd, naboOst, naboVest);
  }

  @Override
  public char tilTegn() {
    return '#';
  }
}
