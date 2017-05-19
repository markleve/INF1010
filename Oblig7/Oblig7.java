import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import java.io.File;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Oblig7 extends Application {
  private Stage vindu;
  private static BorderPane rot;
  private static VBox venstreBoks;
  private static VBox hoyreBoks;
  private static HBox bunnBoks;
  private static TextField displayAntLosning;
  private static int antRader;
  private static int antKolonner;
  private static GUIRute[][] ruter;
  private static int antUtveier = 0;

  public void start(Stage vindu) {
    this.vindu = vindu;

    rot = new BorderPane();
    HBox toppboks = lagToppBoks();
    rot.setTop(toppboks);

    venstreBoks = lagVenstreBoks();

    hoyreBoks = lagHoyreBoks();

    bunnBoks = lagBunnBoks();

    vindu.setScene(new Scene(rot));
    vindu.setTitle("Opprett labyrint");
    vindu.show();
  }

  private HBox lagToppBoks() {
    TextField filFelt = new TextField();
    filFelt.setMinWidth(550);

    Button velgFilKnapp = new Button("Velg fil..");
    velgFilKnapp.setOnAction(new FilVelger(filFelt));

    Button lastInnKnapp = new Button("Last inn");
    lastInnKnapp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        File fil = new File(filFelt.getText());
        opprettLabyrint(fil);
      }
    });
    HBox toppBoks = new HBox(velgFilKnapp, filFelt, lastInnKnapp);
    toppBoks.setPadding(new Insets(10, 10, 5, 10));
    toppBoks.setSpacing(10);
    toppBoks.setPrefHeight(45);
    toppBoks.setPrefWidth(730);
    return toppBoks;
  }

  private static VBox lagVenstreBoks() {
    VBox venstreBoks = new VBox();
    venstreBoks.setPadding(new Insets(10, 10, 10, 10));
    venstreBoks.setSpacing(10);
    venstreBoks.setPrefWidth(125);
    venstreBoks.setPrefHeight(635);

    Button resetLabyrintKnapp = new Button("Reset labyrint");
    resetLabyrintKnapp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        resetFarger();
        antUtveier = 0;
        oppdaterAntUtveier();
      }
    });

    Label antLosningLabel = new Label("Antall løsninger: ");

    displayAntLosning = new TextField();
    displayAntLosning.setText("" + antUtveier);

    //Label





    venstreBoks.getChildren().addAll(resetLabyrintKnapp, antLosningLabel, displayAntLosning);
    return venstreBoks;
  }

  private static VBox lagHoyreBoks() {
    VBox hoyreBoks = new VBox();
    hoyreBoks.setPrefWidth(20);
    hoyreBoks.setPrefHeight(635);
    return hoyreBoks;
  }

  private static HBox lagBunnBoks() {
    HBox bunnBoks = new HBox();
    bunnBoks.setPrefHeight(20);
    bunnBoks.setPrefWidth(730);
    return bunnBoks;
  }

  public void opprettLabyrint(File fil) {
    Labyrint labyrint = null;

    try {
      labyrint = Labyrint.lesFraFil(fil);
    } catch(FileNotFoundException e) {
      System.out.println("FEIL: Kunne ikke lese fil");
      System.exit(1);
    }
    System.out.println(labyrint);

    antRader = labyrint.hentAntRader();
    antKolonner = labyrint.hentAntKolonner();
    Rute[][] labyrintarray = labyrint.hentlabArray();

    GridPane rutenett = new GridPane();
    ruter = new GUIRute[antRader][antKolonner];
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        ruter[rad][kol] = new GUIRute(labyrintarray[rad][kol], antRader, antKolonner);
        rutenett.add(ruter[rad][kol], kol, rad);
      }
    }
    rutenett.setAlignment(Pos.CENTER);
    //rutenett.setPadding(new Insets(10, 0, 0, 10));

    rot.setCenter(rutenett);
    rot.setLeft(venstreBoks);
    rot.setRight(hoyreBoks);
    rot.setBottom(bunnBoks);
    //vindu.setWidth(90);
    //vindu.setHeight(70);
    vindu.sizeToScene();
  }

  public static void finnerKortesteLosning(String utvei) {
    antUtveier += 1;
    boolean[][] losninger = losningStringTilTabell(utvei, antKolonner, antRader);
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        if(losninger[rad][kol]) {
          ruter[rad][kol].setUtveiFarge();
        }
      }
    }
    oppdaterAntUtveier();
  }

  public static void finnerLosninger(Liste<String> utveier) {
    Lenkeliste<String> alleUtveier = new Koe<String>();
    antUtveier = utveier.storrelse();
    for(String str : utveier) {
      alleUtveier.settInn(str);
    }
    String utvei = alleUtveier.hentForsteElement();
    System.out.println(utvei);
    boolean[][] losninger = losningStringTilTabell(utvei, antKolonner, antRader);
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        if(losninger[rad][kol]) {
          ruter[rad][kol].setUtveiFarge();
        }
      }
    }
    oppdaterAntUtveier();
  }

  public static void resetFarger() {
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
          ruter[rad][kol].setDefaultFarger();
      }
    }
  }

  public static void oppdaterAntUtveier() {
    displayAntLosning.setText("" + antUtveier);
  }

  public static void setIngenUtveier() {
    antUtveier = 0;
  }

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
