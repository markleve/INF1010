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
    char[] charArrayForste = sc.nextLine().toCharArray();
    konstruerEnLinje(charArrayForste, labyrint);

    while(sc.hasNextLine()) {
      char[] charArray = sc.nextLine().toCharArray();
      if(!sc.hasNextLine()) {
        konstruerEnLinje(charArray, labyrint);
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

  public static void konstruerEnLinje(char[] charArray, Labyrint labyrint) {
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
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        labArray[rad][kol].settAlleNaboer(labArray);
      }
    }
  }
}
