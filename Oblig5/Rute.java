

abstract class Rute {
  protected int rad;
  protected int kolonne;
  protected Labyrint tilhorendeLabyrint;
  protected Rute naboNord = null;
  protected Rute naboSyd = null;
  protected Rute naboOst = null;
  protected Rute naboVest = null;

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
    if(rad > 0) {
      naboNord = labArray[rad-1][kolonne];
    }
    if(kolonne+1 < tilhorendeLabyrint.hentAntKolonner() ) {
      naboOst = labArray[rad][kolonne+1];
    }
    if(rad+1 < tilhorendeLabyrint.hentAntRader()) {
      naboSyd = labArray[rad+1][kolonne];
    }
    if(kolonne > 0) {
      naboVest = labArray[rad][kolonne-1];
    }
  }

  public void gaa(Rute forrigeRute, String vei, Liste<String> utveier) {

    // gå tilbake til alle rutene og sette vei til en tom liste
          // hvordan blir 'vei' til hver rute slettet/nullstilt?

    // basistilfellet
    if(this instanceof Aapning) {
      // det er forvirrende at kolonne skal først og rad etterpå !
      vei += "Åpning (" + (rad+1) + ", " + (kolonne+1) + ")";
      utveier.settInn(vei);
      return;         // må jeg returnere her, eller går den tilbake av seg selv?
    }
    vei += "(" + (rad+1) + ", " + (kolonne+1) + ") --> ";

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
