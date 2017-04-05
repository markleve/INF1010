

abstract class Rute {
  protected int rad;
  protected int kolonne;
  protected Labyrint tilhorendeLabyrint;
  protected Rute naboNord;
  protected Rute naboSyd;
  protected Rute naboOst;
  protected Rute naboVest;

  public Rute(int rad, int kolonne, Labyrint tilhorendeLabyrint) {
    this.rad = rad;
    this.kolonne = kolonne;
    this.tilhorendeLabyrint = tilhorendeLabyrint;
  }

  public int hentRad() { return rad; }
  public int hentKolonne() { return kolonne; }
  public Labyrint hentTilhorendeLabyrint() { return tilhorendeLabyrint; }
  public Rute hentNaboNord() { return naboNord; }
  public Rute hentNaboSyd() { return naboSyd; }
  public Rute hentNaboOst() { return naboOst; }
  public Rute hentNaboVest() { return naboVest; }

  public void setAlleNaboer(Rute naboNord, Rute naboOst, Rute naboSyd, Rute naboVest) {
    this.naboNord = naboNord;
    this.naboOst = naboOst;
    this.naboSyd = naboSyd;
    this.naboVest = naboVest;
  }

  abstract char tilTegn();
}
