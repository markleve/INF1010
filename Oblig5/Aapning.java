

public class Aapning extends HvitRute {

  public Aapning(int rad, int kolonne, Labyrint tilhorendeLabyrint) {
    super(rad, kolonne, tilhorendeLabyrint);
  }

  @Override
  public String toString() {
    return "Åpning [" + rad + "][" + kolonne + "]";
  }

  @Override
  public char tilTegn() {
    return 'A';
  }
}
