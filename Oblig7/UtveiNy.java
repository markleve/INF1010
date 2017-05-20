import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class UtveiNy extends Pane {
  private String navn;

  public UtveiNy(String navn) {
    this.navn = navn;

    addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
          System.out.println("Løsningen: " + navn);
        }
    });
  }

  @Override
  public String toString() {
    return navn;
  }
}
