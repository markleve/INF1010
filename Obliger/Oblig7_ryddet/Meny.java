import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Meny extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  private Stage hovedVindu;
  private BorderPane rotNode = new BorderPane();
  private static final int BREDDE = 850;


  @Override
  public void start(Stage vindu) {
    this.hovedVindu = vindu;
    hovedVindu.setTitle("Meny trial");

    HBox foreldre = new HBox();
    foreldre.setPrefWidth(BREDDE);

    // Menu bar en
    MenuBar menuBarEn = new MenuBar();

    // --- Menu File ---
    Menu menuFile = new Menu("File");
    MenuItem openKnapp = new MenuItem("Åpne fil");
    MenuItem clearKnapp = new MenuItem("Clear");
    MenuItem exitKnapp = new MenuItem("Exit");
    menuFile.getItems().addAll(openKnapp, clearKnapp, new SeparatorMenuItem(), exitKnapp);

    // --- Menu Edit ---
    Menu menuEdit = new Menu("Edit");

    // --- Menu View ---
    Menu menuView = new Menu("View");


    // Menu bar to
    MenuBar menuBarTo = new MenuBar();

    // --- Menu Help ---
    Menu menuHelp = new Menu("Hjelp");

    menuBarEn.getMenus().addAll(menuFile, menuEdit, menuView);
    menuBarEn.setPrefWidth(BREDDE*0.90);

    menuBarTo.getMenus().addAll(menuHelp);
    menuBarTo.setPrefWidth(BREDDE*0.10);

    foreldre.getChildren().addAll(menuBarEn, menuBarTo);
    rotNode.setTop(foreldre);
    hovedVindu.setScene(new Scene(rotNode));
    hovedVindu.show();
  }


}
