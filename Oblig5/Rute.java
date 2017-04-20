
abstract class Rute {
  protected int rad;
  protected int kolonne;
  protected Labyrint tilhorendeLabyrint;
  protected Rute naboNord = null;
  protected Rute naboSyd = null;
  protected Rute naboOst = null;
  protected Rute naboVest = null;

  public Rute(int rad, int kolonne) {
    this.rad = rad;
    this.kolonne = kolonne;
  }

  public int hentRad() { return rad; }
  public int hentKolonne() { return kolonne; }
  public Labyrint hentTilhorendeLabyrint() { return tilhorendeLabyrint; }
  public Rute hentNaboNord() { return naboNord; }
  public Rute hentNaboSyd() { return naboSyd; }
  public Rute hentNaboOst() { return naboOst; }
  public Rute hentNaboVest() { return naboVest; }

  public void settLabyrint(Labyrint labyrint) {
    tilhorendeLabyrint = labyrint;
  }

  public void settAlleNaboer(Rute[][] labArray, int antRader, int antKolonner) {
    if(rad > 0) {
      naboNord = labArray[rad-1][kolonne];
    }
    if(kolonne+1 < antKolonner ) {
      naboOst = labArray[rad][kolonne+1];
    }
    if(rad+1 < antRader) {
      naboSyd = labArray[rad+1][kolonne];
    }
    if(kolonne > 0) {
      naboVest = labArray[rad][kolonne-1];
    }
  }

  public Liste<String> finnUtvei() {
    Liste<String> utveier = new OrdnetLenkeliste<String>();
    String vei = "";
    gaa(this, vei, utveier);

    if(utveier.erTom()) {
      utveier.settInn("Det er ingen utveier.");
    }
    return utveier;
  }

  abstract void gaa(Rute forrigeRute, String vei, Liste<String> utveier);
  abstract char tilTegn();
}
