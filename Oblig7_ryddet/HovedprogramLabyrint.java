import javafx.application.Application;
import javafx.stage.Stage;

public class HovedprogramLabyrint extends Application {

  Stage hovedVindu;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage vindu) {
    hovedVindu = new HovedVindu(this);
    hovedVindu.show();

  }


}
