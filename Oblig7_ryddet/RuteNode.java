import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.paint.Color;

public class RuteNode extends Rectangle {
  private Rute rute;
  private int antRader;
  private int antKolonner;
  private double labyrintNodeBredde;
  private double labyrintNodeHoyde;
  private int storrelse;
  private boolean startRute = false;

  public RuteNode(Rute rute, int antRader, int antKolonner, double labyrintNodeBredde, double labyrintNodeHoyde) {
    this.rute = rute;
    this.antRader = antRader;
    this.antKolonner = antKolonner;
    this.labyrintNodeBredde = labyrintNodeBredde;
    this.labyrintNodeHoyde = labyrintNodeHoyde;
    settRuteStorrelse();
    setHeight(storrelse);
    setWidth(storrelse);
    settDefaultFarge();
    setStroke(Color.WHITESMOKE);      // kan ha WHITE istede .. (da separeres alle rutene)
    setStrokeType(StrokeType.INSIDE);
    setStrokeWidth(0.6);

  }

  public void settDefaultFarge() {
    Color farge = null;

    if(rute instanceof Aapning) {
      farge = Color.LIGHTCORAL;
    } else if (rute instanceof HvitRute) {
      farge = Color.WHITESMOKE;
    } else {
      farge = Color.BLACK;
    }
    this.setFill(farge);
  }

  public void settStartRuteFarge() { this.setFill(Color.RED); }
  public void settVeiRuteFarge() { this.setFill(Color.POWDERBLUE); }
  public void settStartRute(boolean start) { startRute = start; }

  public void settRuteStorrelse() {
    if(antRader > antKolonner) {
      storrelse = (int) labyrintNodeHoyde/antRader;
    }
    if(antKolonner >= antRader) {
      storrelse = (int) labyrintNodeHoyde/antKolonner;
    }
  }

  public Rute hentRuteType() { return rute; }
  public boolean erStartRute() { return startRute; }


}
