import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

import java.io.File;

import javafx.stage.FileChooser;


public class HovedVindu extends Stage {

  private Application applicationObjekt;

  /*  Variablene som sier noe om størrelsen på de ulike Objektene */
  private static final int VINDU_BREDDE = 850;
  private static final int VINDU_HOYDE = 650;

  private static final double TOPPBOKS_HOYDE = VINDU_HOYDE*0.07;
  private static final double BUNNBOKS_HOYDE = VINDU_HOYDE*0.03;
  private static final double MIDTBOKS_HOYDE = VINDU_HOYDE-TOPPBOKS_HOYDE-BUNNBOKS_HOYDE;

  private static final double VENSTREBOKS_BREDDE = VINDU_BREDDE*0.18;
  private static final double HOYREBOKS_BREDDE = VINDU_BREDDE*0.03;
  private static final double MIDTBOKS_BREDDE = VINDU_BREDDE-VENSTREBOKS_BREDDE-HOYREBOKS_BREDDE;

  private static final double KNAPP_BREDDE = VENSTREBOKS_BREDDE*0.90;

  /*  Objektene som skal inn i scenen opprettes under  */
  // Hovedscene (foreldre node)
  private BorderPane rotNode;

  // Toppboks (barne node)
  private HBox toppBoks;
  private Button velgFilKnapp = new Button("Velg fil..");
  private TextField filFelt = new TextField();
  private Button lastInnKnapp = new Button("Last inn");

  // Menubar
  MenuBar menuBarEn = new MenuBar();
  MenuBar menuBarTo = new MenuBar();
  Menu menuFile = new Menu("File");
  MenuItem opneFil = new MenuItem("Åpne fil");
  MenuItem clearFil = new MenuItem("Clear");
  MenuItem lukkFil = new MenuItem("Lukk");
  Menu menuEdit = new Menu("Edit");
  Menu menuView = new Menu("View");
  Menu menuHelp = new Menu("Hjelp");

  // Senterboks (barne node)
  private LabyrintNode labyrintGridPane = null;
  // Venstre boks (barne node)
  private VBox venstreBoks;
  private Button resetLabyrintKnapp = new Button("Reset labyrint");
  private Text visAntLosninger = new Text("Antall løsninger: ");
  private Text velgLosning = new Text("Velg løsning:");
  private ComboBox<String> velgLosningListe = new ComboBox<String>();
  private VBox kortLosning;
  private Button kortestLosningKnapp = new Button("Korteste løsning");
  private Text kortLosningLengde = new Text("");
  private VBox langLosning;
  private Button lengstLosningKnapp = new Button("Lengste løsning");
  private Text langLosningLengde = new Text("");

  // Hoyre boks (barne node)
  private VBox hoyreBoks;

  // Bunnboks (barne node - vis tekst linje)
  private HBox bunnBoks;
  private Text beskjedTilBruker = new Text("");

  public HovedVindu(Application appObjekt) {
    this.applicationObjekt = appObjekt;
    setTitle("Finner utveier fra labyrint");
    rotNode = new BorderPane();
    byggOppScene();
    opprettHandlinger();
    setScene(new Scene(rotNode));
  }

  public void byggOppScene() {
    // Oppretter toppboksen

    menuFile.getItems().addAll(opneFil, clearFil, new SeparatorMenuItem(), lukkFil);
    menuBarEn.getMenus().addAll(menuFile, menuEdit, menuView);
    menuBarEn.setPrefWidth(VINDU_BREDDE*0.90);
    menuBarTo.getMenus().addAll(menuHelp);
    menuBarTo.setPrefWidth(VINDU_BREDDE*0.10);

    toppBoks = new HBox(menuBarEn, menuBarTo);
  //  toppBoks = new HBox(lastInnKnapp, filFelt, lastInnKnapp);

  //  toppBoks.setStyle("-fx-background-color: GAINSBORO; -fx-padding: 10 10 10 10; -fx-spacing: 10; -fx-border-color: LIGHTGREY; -fx-border-width: 2px;");
    toppBoks.setPrefWidth(VINDU_BREDDE);
    toppBoks.setPrefHeight(TOPPBOKS_HOYDE);
    rotNode.setTop(toppBoks);

    // Oppretter venstre boks
    resetLabyrintKnapp.setPrefWidth(KNAPP_BREDDE);
    velgLosningListe.setPrefWidth(KNAPP_BREDDE);
    kortestLosningKnapp.setPrefWidth(KNAPP_BREDDE);
    lengstLosningKnapp.setPrefWidth(KNAPP_BREDDE);

    kortLosning = new VBox(kortestLosningKnapp);
    kortLosning.setSpacing(10);

    langLosning = new VBox(lengstLosningKnapp);
    langLosning.setSpacing(10);

    venstreBoks = new VBox(resetLabyrintKnapp, new Separator(), visAntLosninger,
                           new Separator(), velgLosning, velgLosningListe, new Separator(),
                           kortLosning, new Separator(), langLosning);
    venstreBoks.setStyle("-fx-background-color: GAINSBORO; -fx-padding: 10 10 10 10; -fx-spacing: 10;");
    venstreBoks.setPrefWidth(VENSTREBOKS_BREDDE);
    venstreBoks.setPrefHeight(MIDTBOKS_HOYDE);

    // Oppretter hoyre boksen
    hoyreBoks = new VBox();
    hoyreBoks.setStyle("-fx-background-color: GAINSBORO; -fx-padding: 10 10 10 10; -fx-spacing: 10;");
    hoyreBoks.setPrefWidth(HOYREBOKS_BREDDE);
    hoyreBoks.setPrefHeight(MIDTBOKS_HOYDE);

    // Oppretter bunnboksen
    bunnBoks = new HBox(beskjedTilBruker);
    bunnBoks.setStyle("-fx-background-color: GAINSBORO; -fx-padding: 10 10 10 10; -fx-spacing: 10; -fx-border-color: LIGHTGREY; -fx-border-width: 2px;");
    bunnBoks.setPrefWidth(VINDU_BREDDE);
    bunnBoks.setPrefHeight(BUNNBOKS_HOYDE);
    rotNode.setBottom(bunnBoks);
  }

  public void opprettHandlinger() {
    HovedVindu hovedVindu = this;

    // Aktiverer handlingene til topp boksen

    opneFil.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        FileChooser filVelger = new FileChooser();
        filVelger.setTitle("Velg labyrintfil");
        File fil = filVelger.showOpenDialog(null);
        try {
          resetVenstreBoks(0, "", true, true, false);
          Labyrint labyrint = Labyrint.lesFraFil(fil);
          labyrintGridPane = new LabyrintNode(hovedVindu, MIDTBOKS_BREDDE, MIDTBOKS_HOYDE);
          labyrintGridPane.opprettLabyrinten(labyrint);
          rotNode.setCenter(labyrintGridPane);
          rotNode.setLeft(venstreBoks);
          rotNode.setRight(hoyreBoks);
          sizeToScene();
        } catch(Exception e) {
          oppdaterBunnTekst("Klarte ikke åpne filen:  " + fil);
        }
      }
    });

/*
    velgFilKnapp.setOnAction(new FilVelger(filFelt));
    lastInnKnapp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        File fil = new File(filFelt.getText());
        try {
          resetVenstreBoks(0, "", true, true, false);
          Labyrint labyrint = Labyrint.lesFraFil(fil);
          labyrintGridPane = new LabyrintNode(hovedVindu, MIDTBOKS_BREDDE, MIDTBOKS_HOYDE);
          labyrintGridPane.opprettLabyrinten(labyrint);
          rotNode.setCenter(labyrintGridPane);
          rotNode.setLeft(venstreBoks);
          rotNode.setRight(hoyreBoks);
          sizeToScene();
        } catch(Exception e) {
          oppdaterBunnTekst("Klarte ikke åpne filen:  " + fil);
        }
      }
    });*/

    // Aktiverer handlingene til venstre boksen
    resetLabyrintKnapp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        resetVenstreBoks(0, "", true, true, true);
      }
    });
    velgLosningListe.valueProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue observable, String oldValue, String newValue) {
        try {
          int losningNr = Integer.parseInt(newValue);
          labyrintGridPane.visLosningListe(losningNr-1);
        } catch(Exception e) {}
      }
    });
    kortestLosningKnapp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        labyrintGridPane.visKortesteUtvei();
        int lengde = labyrintGridPane.lengdeKortesteUtvei();
        kortLosningLengde.setText("Lengde: " + lengde);
        kortLosning.getChildren().add(kortLosningLengde);
      }
    });
    lengstLosningKnapp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        labyrintGridPane.visLengsteUtvei();
        int lengde = labyrintGridPane.lengdeLengsteUtvei();
        langLosningLengde.setText("Lengde: " + lengde);
        langLosning.getChildren().add(langLosningLengde);
      }
    });
  }

  public void settLosningListe(String[] losninger) {
    velgLosningListe.setItems(FXCollections.observableArrayList(losninger));
  }

  public void oppdaterAntLosninger(int antUtveier) {
    visAntLosninger.setText("Antall løsninger: " + antUtveier);
  }

  public void oppdaterBunnTekst(String beskjeden) {
    beskjedTilBruker.setText(beskjeden);
  }

  public void oppdaterLosningViste() {
    if (kortLosning.getChildren().size() > 1) {
      kortLosning.getChildren().remove(1);
    }
    if (langLosning.getChildren().size() > 1) {
      langLosning.getChildren().remove(1);
    }
  }

  public void venstreBoksDisabled(boolean disabled) {
    resetLabyrintKnapp.setDisable(disabled);
    velgLosningListe.setDisable(disabled);
    kortestLosningKnapp.setDisable(disabled);
    lengstLosningKnapp.setDisable(disabled);
    if(disabled) {
      visAntLosninger.setOpacity(0.5);
      velgLosning.setOpacity(0.5);
    } else {
      visAntLosninger.setOpacity(1);
      velgLosning.setOpacity(1);
    }
  }

  public void resetVenstreBoks(int antLosninger, String bunntekst, boolean disabled, boolean clear, boolean reset) {
    oppdaterAntLosninger(antLosninger);
    oppdaterBunnTekst(bunntekst);
    venstreBoksDisabled(disabled);
    if(clear) { velgLosningListe.getItems().clear(); }
    if(reset) { labyrintGridPane.resetFarger(); }
    oppdaterLosningViste();
  }

}
