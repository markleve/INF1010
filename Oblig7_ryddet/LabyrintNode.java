import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class LabyrintNode extends GridPane {
  private HovedVindu hovedVindu;
  private double labyrintNodeBredde;
  private double labyrintNodeHoyde;
  private int padding = 10;
  private Labyrint labyrint;
  private OrdnetLenkeliste<Utvei> utveiene;
  private RuteNode[][] ruter;
  private int antRader;
  private int antKolonner;
  private int antUtveier;
  private RuteNode ruteKlikket;

  public LabyrintNode(HovedVindu hovedVindu, double labyrintNodeBredde, double labyrintNodeHoyde) {
    this.hovedVindu = hovedVindu;
    this.labyrintNodeBredde = labyrintNodeBredde-(padding*2);
    this.labyrintNodeHoyde = labyrintNodeHoyde-(padding*2);
    setStyle("-fx-background-color: GAINSBORO; -fx-padding: 10 10 10 10; -fx-spacing: 10; -fx-alignment: center;");
    setPrefWidth(labyrintNodeBredde);
    setPrefHeight(labyrintNodeHoyde);
  }

  public void opprettLabyrinten(Labyrint labyrinten) {
    this.labyrint = labyrinten;
    antRader = labyrint.hentAntRader();
    antKolonner = labyrint.hentAntKolonner();
    Rute[][] labyrintArray = labyrint.hentlabArray();

    ruter = new RuteNode[antRader][antKolonner];

    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        RuteNode ruteNode = new RuteNode(labyrintArray[rad][kol], antRader, antKolonner, labyrintNodeBredde, labyrintNodeHoyde);
        this.add(ruteNode, kol, rad);

        ruteNode.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
            ruteKlikket = (RuteNode) event.getSource();
            int rad = GridPane.getRowIndex(ruteKlikket);
            int kol = GridPane.getColumnIndex(ruteKlikket);

            if(ruteKlikket.hentRuteType() instanceof SortRute) {
              hovedVindu.resetVenstreBoks(0, "Du kan ikke gå fra sort rute", true, true, true);
              return;
            }
            finnUtveier(rad, kol);
            hovedVindu.oppdaterAntLosninger(antUtveier);

            if(antUtveier == 0) {
              hovedVindu.resetVenstreBoks(0, "Ingen løsning fra denne ruten", true, true, true);
              ruteKlikket.settStartRuteFarge();
              return;
            } else {
              hovedVindu.resetVenstreBoks(antUtveier, "", false, false, true);
              if(ruteKlikket.hentRuteType() instanceof Aapning) { hovedVindu.oppdaterBunnTekst("Dette er en åpning"); }
              visVeien(utveiene.hentForsteElement());   // har valgt at den skal vise den første løsningen
            }
          }
        });
        ruter[rad][kol] = ruteNode;
      }
    }
  }

  public void finnUtveier(int rad, int kol) {
      utveiene = labyrint.finnUtveiFra(kol+1, rad+1);
      antUtveier = utveiene.storrelse();
      String[] losningerLabel = new String[antUtveier];
      for(int i = 0; i < antUtveier; i++) {
        losningerLabel[i] = "" + (i+1);
      }
      hovedVindu.settLosningListe(losningerLabel);
  }

  public void visVeien(Utvei utvei) {
    resetFarger();
    ruteKlikket.settStartRuteFarge();
    ruteKlikket.settStartRute(true);
    boolean[][] losning = losningStringTilTabell(utvei.hentUtvei(), antKolonner, antRader);
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        if(losning[rad][kol]) {
          if(!ruter[rad][kol].erStartRute()) {
            ruter[rad][kol].settVeiRuteFarge();
          }
        }
      }
    }
    ruteKlikket.settStartRute(false);
  }

  public void visLosningListe(int losningNr) {
    int teller = 0;
    for(Utvei utvei: utveiene) {
      if(teller == losningNr) {
        visVeien(utvei);
      }
      teller++;
    }
  }

  public void resetFarger() {
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        ruter[rad][kol].settDefaultFarge();
      }
    }
  }
  public void visKortesteUtvei() {
    Utvei kortesteUtvei = utveiene.hentForsteElement();
    visVeien(kortesteUtvei);
  }
  public int lengdeKortesteUtvei() { return utveiene.hentForsteElement().hentLengde(); }

  public void visLengsteUtvei() {
    Utvei lengsteUtvei = utveiene.hentSisteElement();
    visVeien(lengsteUtvei);
  }
  public int lengdeLengsteUtvei() { return utveiene.hentSisteElement().hentLengde(); }

  /**
  * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
  * av losningstien.
  * @param losningString String-representasjon av utveien
  * @param bredde        bredde til labyrinten
  * @param hoyde         hoyde til labyrinten
  * @return              2D-representasjon av rutene der true indikerer at
  *                      ruten er en del av utveien.
  */
  public static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
    boolean[][] losning = new boolean[hoyde][bredde];
    java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
    java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
    while(m.find()) {
      int x = Integer.parseInt(m.group(1))-1;
      int y = Integer.parseInt(m.group(2))-1;
      losning[y][x] = true;
    }
    return losning;
  }

}
