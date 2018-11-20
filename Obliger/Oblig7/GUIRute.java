import javafx.application.Application;
import javafx.scene.input.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Optional;

public class GUIRute extends Pane {
  private int storrelse;
  private Rute rute;
  private int antRader;
  private int antKolonner;

  public GUIRute(Rute rute, int antRader, int antKolonner) {
    this.rute = rute;
    this.antRader = antRader;
    this.antKolonner = antKolonner;
    beregnRuteStorrelse();

    setDefaultFarger();
    setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    setMinWidth(storrelse);
    setMinHeight(storrelse);
    addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
          Liste<String> losninger = null;
          try {
            losninger = Labyrint.finnUtveiFra(rute.hentKolonne()+1, rute.hentRad()+1);
            if(rute instanceof HvitRute) {
              Oblig7.resetFarger();
              setUtveiFarge();
              Oblig7.finnerLosninger(losninger);
            } else {
              setUtveiFarge();
              Oblig7.resetFarger();
              Oblig7.setIngenUtveier();
              Oblig7.oppdaterAntUtveier();
              System.out.println("Kan ikke klikke på en svart rute!");
            }
          } catch(NullPointerException e) {
            Oblig7.setIngenUtveier();
            Oblig7.oppdaterAntUtveier();
            System.out.println("Det finnes ingen løsninger");
          }
        }
    });

  }

  public void beregnRuteStorrelse() {
    if(antRader > antKolonner) {
      storrelse = 635/antRader;
    }
    if(antKolonner >= antRader) {
      storrelse = 585/antKolonner;
    }
  }

  public void setDefaultFarger() {
    if(rute instanceof HvitRute) {
      setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
    }
    if(rute instanceof SortRute) {
      setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    }
  }

  public void setUtveiFarge() {
    setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
  }
}
