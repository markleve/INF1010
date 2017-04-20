
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

  public void gaa(Rute forrigeRute, String vei, Liste<String> utveier) {

    // kan lage en egen gaa metode i hver av underklassens
        // sort rute har en gaa metode som ikke gjør noe
        // aapning har de to linjene signaturen
        // hvit rute har sine 4 sjekker (trenger ikke da sjekke at det er en instans av hvit rute)

    // basistilfellet
    if(this instanceof Aapning) {
      vei += "(" + (kolonne+1) + ", " + (rad+1) + ")";
      utveier.settInn(vei);
      return;      // returnerer så den går tilbake
    }
    vei += "(" + (kolonne+1) + ", " + (rad+1) + ") --> ";

    if(forrigeRute != naboNord && (naboNord instanceof HvitRute)) {
      naboNord.gaa(this, vei, utveier);
    }
    if(forrigeRute != naboOst && (naboOst instanceof HvitRute)) {
      naboOst.gaa(this, vei, utveier);
    }
    if(forrigeRute != naboSyd && (naboSyd instanceof HvitRute)) {
      naboSyd.gaa(this, vei, utveier);
    }
    if(forrigeRute != naboVest && (naboVest instanceof HvitRute)) {
      naboVest.gaa(this, vei, utveier);
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

  abstract char tilTegn();
}
