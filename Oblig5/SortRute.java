// disse rutene er som en vegg

public class SortRute extends Rute {

  public SortRute(int rad, int kolonne, Labyrint tilhorendeLabyrint) {
    super(rad, kolonne, tilhorendeLabyrint);
  }

  @Override
  public char tilTegn() {
    return '#';
  }

  @Override
  public String toString() {
    return "Sort rute: #";
  }
}
