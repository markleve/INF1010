import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Collections;

public class Labyrint {

  private static int antRader;
  private static int antKolonner;
  private static Rute[][] labArray;
  private static Liste<String> utveier;
  private static int antUtveier;

  private Labyrint(int antRader, int antKolonner, Rute[][] labArray) {
    this.antRader = antRader;
    this.antKolonner = antKolonner;
    this.labArray = labArray;

    // legger denne labyrinten til alle rutene
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        labArray[rad][kol].settLabyrint(this);
      }
    }
  }

  public int hentAntRader() { return antRader; }
  public int hentAntKolonner() { return antKolonner; }
  public Rute[][] hentlabArray() { return labArray; }
  public int hentAntUtveier() { return antUtveier; }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
    Scanner scanner = new Scanner(fil);

    String[] storrelse = scanner.nextLine().split(" ");  // array med størrelsen til labyrinten (antall rader og kolonner)
    int antRader = Integer.parseInt(storrelse[0]);
    int antKolonner = Integer.parseInt(storrelse[1]);
    Rute[][] labArray = new Rute[antRader][antKolonner];
    int rad = 0;      // raden programmet leser

    while(scanner.hasNextLine()) {       // leser inn resten av filen (selve labyrinten)
      char[] charArray = scanner.nextLine().toCharArray();
      for(int kolonne = 0; kolonne < charArray.length; kolonne++) {
        Rute rute = opprettRute(charArray[kolonne], rad, kolonne, antRader, antKolonner);
        labArray[rad][kolonne] = rute;
      }
      rad++;
    }
    leggTilNaboer(labArray, antRader, antKolonner);
    return new Labyrint(antRader, antKolonner, labArray);
  }

  public static Rute opprettRute(char tegn, int rad, int kolonne, int antRader, int antKolonner) {
    if(tegn == '.') {
      if(rad == 0 || rad == (antRader-1) || kolonne == 0 || kolonne == (antKolonner-1)) {
        return new Aapning(rad, kolonne);
      } else {
        return new HvitRute(rad, kolonne);
      }
    } else if (tegn == '#'){
      return new SortRute(rad, kolonne);
    } else {
      return null;
    }
  }

  public static void leggTilNaboer(Rute[][] labArray, int antRader, int antKolonner) {
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        labArray[rad][kol].settAlleNaboer(labArray, antRader, antKolonner);
      }
    }
  }

  public static Liste<String> finnUtveiFra(int kol, int rad) {
    utveier = labArray[rad-1][kol-1].finnUtvei();
    antUtveier = utveier.storrelse();
    return utveier;
  }

  public void settMinimalUtskrift() { }


  // kan lage Utvei klassen og putte splittingen og alt det der !!
  // kan lage en lenkeliste med utveier hvor hver utvei er den splittede strengen
      // kan bruke den som sorterer på størrelsen (OrdnetLenkeliste)
      // kan deretter returnere det første elementet i denne listen

      // --> mer objektorientert !!!

  public static String kortesteUtvei() {
    HashMap<String, Integer> utveiLengder = new HashMap<String, Integer>();

    for(String vei : utveier) {
      String[] numSkritt = vei.split("-->");
      int lengde = 0;
      for(String str : numSkritt) {
        lengde++;
      }
      utveiLengder.put(vei, lengde);
    }

    int minLengde = Collections.min(utveiLengder.values());
    for(String utvei : utveiLengder.keySet()) {
      if(utveiLengder.get(utvei) == minLengde) {
        return "Korteste utvei: " + utvei + "\n Lengde: " + minLengde + "\n";
      }
    }
    return "Det finnes ingen utvei.";
  }

  @Override
  public String toString() {
    String labyrintTegning = "\n";
    for(int x = 0; x < antRader; x++) {
      for(int y = 0; y < antKolonner; y++) {
        labyrintTegning += (labArray[x][y].tilTegn() + " ");
      }
      labyrintTegning += "\n";
    }
    return labyrintTegning;
  }
}
