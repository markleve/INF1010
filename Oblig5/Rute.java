

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

  public void settAlleNaboer(Rute[][] labArray) {
    setNaboNord(labArray);
    setNaboOst(labArray);
    setNaboSyd(labArray);
    setNaboVest(labArray);
  }

  public void setNaboNord(Rute[][] labArray) {
    if(rad-2 < 0) {
      naboNord = null;
    } else {
      naboNord = labArray[rad-2][kolonne-1];
    }
  }

  public void setNaboOst(Rute[][] labArray) {
    if(kolonne+1 > tilhorendeLabyrint.hentAntKolonner()) {
      naboOst = null;
    } else {
      naboOst = labArray[rad-1][kolonne];
    }
  }

  public void setNaboSyd(Rute[][] labArray) {
    if(rad+1 > tilhorendeLabyrint.hentAntRader()) {
      naboSyd = null;
    } else {
      naboSyd = labArray[rad][kolonne-1];
    }
  }

  public void setNaboVest(Rute[][] labArray) {
    if(kolonne-2 < 0) {
      naboVest = null;
    } else {
      naboVest = labArray[rad-1][kolonne-2];
    }
  }
  abstract char tilTegn();
}
