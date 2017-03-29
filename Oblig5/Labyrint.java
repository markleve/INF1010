import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Labyrint {

  private static int antRader;
  private static int antKolonner;
  private static int radStart = 0;    // startelementet for rad
  private static Rute[][] labArray;
  private static Labyrint labyrintInstans = null;

  private Labyrint() {
    labArray = new Rute[antRader][antKolonner];
  }

  public int hentAntRader() { return antRader; }
  public int hentAntKolonner() { return antKolonner; }
  public Rute[][] hentlabArray() { return labArray; }

  @Override
  public String toString() {
    return "Labyrinten har [" + antRader + "] rader og [" + antKolonner + "] kolonner.";
  }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
    // anta at input filen er gyldig

    if(!fil.exists()) {
      throw new FileNotFoundException();
    }
    Scanner sc = new Scanner(fil);
    antRader = sc.nextInt();      // skal jeg heller bruke parse integer
    antKolonner = sc.nextInt();   // skal jeg heller bruke parse integer

    // oppretter Labyrinten, kan jeg i stede for aa ha en konstruktor, bare
    // opprette et 2D array direkte her??
    if(labyrintInstans == null) {
      labyrintInstans = new Labyrint();
    }

    while(sc.hasNextLine()) {
      char[] charArray = sc.nextLine().toCharArray();
      for(int i = 0; i < charArray.length; i++) {
        if(charArray[i] == '#') {
          labArray[radStart][i] = new SortRute(radStart+1, i+1, labyrintInstans, null, null, null, null);
          //System.out.println("Dette: " + charArray[i]);
        } else if(charArray[i] == '.') {
          labArray[radStart][i] = new HvitRute(radStart+1, i+1, labyrintInstans, null, null, null, null);
          //System.out.println("Dette: " + charArray[i]);
        }
      }
      System.out.println("Rad start: " + radStart);

      radStart++;
    }


    // leser inn labyrinten i filen
    // kaller en privat konstruktor i Labyrint
    // returnerer det resulterende objektet (som skal ha all datastruktur ferdig oppsatt)

    // skal kaste videre FileNotFoundException derosm filen ikke finnes
    return labyrintInstans;
  }

}
