import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Labyrint {

  private static int antRader;
  private static int antKolonner;
  private static int radStart = 0;    // startelementet for rad
  private static Rute[][] labArray;

  private Labyrint() {
    labArray = new Rute[antRader][antKolonner];
  }

  public int hentAntRader() { return antRader; }
  public int hentAntKolonner() { return antKolonner; }
  public Rute[][] hentlabArray() { return labArray; }

  @Override
  public String toString() {
    return "Labyrint [" + antRader + "][" + antKolonner + "]";
  }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {

    if(!fil.exists()) {
      throw new FileNotFoundException();
    }
    Scanner sc = new Scanner(fil);

    String[] linje = sc.nextLine().split(" ");
    antRader = Integer.parseInt(linje[0]);
    antKolonner = Integer.parseInt(linje[1]);

    Labyrint labyrint = konstruerLabyrint(sc);
    leggTilNaboer();
    return labyrint;
  }

  public static Labyrint konstruerLabyrint(Scanner sc) {
    Labyrint labyrint = new Labyrint();
    konstruerForsteLinje(sc, labyrint);

    while(sc.hasNextLine()) {
      char[] charArray = sc.nextLine().toCharArray();
      if(!sc.hasNextLine()) {
        konstruerSisteLinje(charArray, labyrint);
        break;
      }
      for(int i = 0; i < charArray.length; i++) {
        if(charArray[i] == '#') {
          labArray[radStart][i] = new SortRute(radStart+1, i+1, labyrint);  // brukeren skal tenke at labyrinten begynner fra plass (1,1)
        } else if(charArray[i] == '.') {
          if(i == 0) {
            labArray[radStart][i] = new Aapning(radStart+1, i+1, labyrint);
          } else if(i == (charArray.length-1)) {
            labArray[radStart][i] = new Aapning(radStart+1, i+1, labyrint);
          } else {
            labArray[radStart][i] = new HvitRute(radStart+1, i+1, labyrint);
          }
        }
      }
      radStart++;
    }
    return labyrint;
  }

  public static void konstruerForsteLinje(Scanner sc, Labyrint labyrint) {
    char[] charArray = sc.nextLine().toCharArray();
    for(int i = 0; i < charArray.length; i++) {
      if(charArray[i] == '#') {
        labArray[radStart][i] = new SortRute(radStart+1, i+1, labyrint);  // brukeren skal tenke at labyrinten begynner fra plass (1,1)
      } else if(charArray[i] == '.') {
        labArray[radStart][i] = new Aapning(radStart+1, i+1, labyrint);
      }
    }
    radStart++;
  }

  public static void konstruerSisteLinje(char[] charArray, Labyrint labyrint) {
    for(int i = 0; i < charArray.length; i++) {
      if(charArray[i] == '#') {
        labArray[radStart][i] = new SortRute(radStart+1, i+1, labyrint);  // brukeren skal tenke at labyrinten begynner fra plass (1,1)
      } else if(charArray[i] == '.') {
        labArray[radStart][i] = new Aapning(radStart+1, i+1, labyrint);
      }
    }
    radStart++;
  }

  public static void leggTilNaboer() {
    // kan jeg da bruke ENUM???
    // dei retningene som ruten ikke har en nabo er satt til null !

    leggTilNaboMidten();
    leggTilNaboHjorner();
    leggTilNaboForsteRad();
    leggTilNaboSisteRad();
    leggTilNaboForsteKolonne();
    leggTilNaboSisteKolonne();
  }

  public static void leggTilNaboMidten() {
    for(int i = 1; i < (antRader-1); i++) {
      for(int j = 1; j < (antKolonner-1); j++) {
        labArray[i][j].setAlleNaboer(labArray[i-1][j], labArray[i][j+1], labArray[i+1][j], labArray[i][j-1]);
      }
    }
  }

  public static void leggTilNaboHjorner() {
    labArray[0][0].setAlleNaboer(null, labArray[0][1], labArray[1][0], null);
    labArray[0][antKolonner-1].setAlleNaboer(null, null, labArray[1][antKolonner-1], labArray[0][antKolonner-2]);
    labArray[antRader-1][0].setAlleNaboer(labArray[antRader-2][0], labArray[antRader-1][1], null, null);
    labArray[antRader-1][antKolonner-1].setAlleNaboer(labArray[antRader-2][antKolonner-1], null, null, labArray[antRader-1][antKolonner-2]);
  }

  public static void leggTilNaboForsteRad() {
    for(int j = 1; j < (antKolonner-1); j++) {
      labArray[0][j].setAlleNaboer(null, labArray[0][j+1], labArray[1][j], labArray[0][j-1]);
    }
  }

  public static void leggTilNaboSisteRad() {
    for(int j = 1; j < (antKolonner-1); j++) {
      labArray[antRader-1][j].setAlleNaboer(labArray[antRader-2][j], labArray[antRader-1][j+1], null, labArray[antRader-1][j-1]);
    }
  }

  public static void leggTilNaboForsteKolonne() {
    for(int i = 1; i < (antRader-1); i++) {
      labArray[i][0].setAlleNaboer(labArray[i-1][0], labArray[i][1], labArray[i+1][0], null);
    }
  }

  public static void leggTilNaboSisteKolonne() {
    for(int i = 1; i < (antRader-1); i++) {
      labArray[i][antKolonner-1].setAlleNaboer(labArray[i-1][antKolonner-1], null, labArray[i+1][antKolonner-1], labArray[i][antKolonner-2]);

    }
  }


}
