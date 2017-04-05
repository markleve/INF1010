import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Labyrint {

  private static int antRader;
  private static int antKolonner;
  private static int radStart = 0;    // startelementet for rad
  private static Rute[][] labArray;
//  private static Labyrint labyrintInstans = null;

  private Labyrint() {
    labArray = new Rute[antRader][antKolonner];
  }

  public int hentAntRader() { return antRader; }
  public int hentAntKolonner() { return antKolonner; }
  public Rute[][] hentlabArray() { return labArray; }

  @Override
  public String toString() {
    return "Labyrinten: [" + antRader + ", " + antKolonner + "]";
  }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {

    if(!fil.exists()) {
      throw new FileNotFoundException();
    }
    Scanner sc = new Scanner(fil);
    antRader = sc.nextInt();      // skal jeg heller bruke parse integer
    antKolonner = sc.nextInt();   // skal jeg heller bruke parse integer
    String linje = sc.nextLine(); // fjerner siste del av linjen over, hvordan gjøre denne annerledels?

    // oppretter Labyrinten, kan jeg i stede for aa ha en konstruktor, bare
    // opprette et 2D array direkte her??
    /*if(labyrintInstans == null) {
      labyrintInstans = new Labyrint();
    }*/
    Labyrint labyrint = new Labyrint();

    while(sc.hasNextLine()) {
      char[] charArray = sc.nextLine().toCharArray();
      for(int i = 0; i < charArray.length; i++) {
        if(charArray[i] == '#') {
          labArray[radStart][i] = new SortRute(radStart+1, i+1, labyrint);  // brukeren skal tenke at labyrinten begynner fra plass (1,1)
        } else if(charArray[i] == '.') {
          labArray[radStart][i] = new HvitRute(radStart+1, i+1, labyrint);
        }
      }
      radStart++;
    }
    this.leggTilNaboer();
    return labyrint;
  }

  public static void konstruerLabyrint(Scanner sc) {

  }

  public static void leggTilNaboer() {

  }

}
