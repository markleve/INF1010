import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;


public class FilVelger implements EventHandler<ActionEvent> {
  TextField filFelt;

  public FilVelger(TextField filFelt) {
    this.filFelt = filFelt;
  }

  @Override
  public void handle(ActionEvent event) {
    FileChooser filVelger = new FileChooser();
    filVelger.setTitle("Velg labyrintfil");
    File valgtFil = filVelger.showOpenDialog(null);
    if(valgtFil != null) {
      filFelt.setText(valgtFil.getPath());
      //System.out.println("Valgt fil: " + valgtFil.getPath());
    }
  }
}
