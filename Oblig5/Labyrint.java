import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Labyrint {

  private static int antRader;
  private static int antKolonner;
  private static Rute[][] labArray;

  // skal antrader og antkolonner inn i konstruktøren?
  // skal den bare lagre et rute arrat og ikke initialisere det her?
  //    skal arrayet heller initialiseres når man leser fra fil?
  private Labyrint() {
    labArray = new Rute[antRader][antKolonner];
    // this.labArray = labArray;
  }

  public int hentAntRader() { return antRader; }
  public int hentAntKolonner() { return antKolonner; }
  public Rute[][] hentlabArray() { return labArray; }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
    // trenger jeg denne? Eller er det nok at bare metoden kaster dette unntaket??
    if(!fil.exists()) {
      throw new FileNotFoundException();
    }

    Scanner sc = new Scanner(fil);
    String[] storrelse = sc.nextLine().split(" ");  // array med størrelsen til labyrinten (antall rader og kolonner)
    antRader = Integer.parseInt(storrelse[0]);
    antKolonner = Integer.parseInt(storrelse[1]);

    // Rute[][] labArray = new Rute[antRader][antKolonner];

    Labyrint labyrint = new Labyrint();
    konstruerLabyrint(sc, labyrint);
    leggTilNaboer();
    return labyrint;
  }

  public static void konstruerLabyrint(Scanner sc, Labyrint labyrint) {
    int rad = 0;

    while(sc.hasNextLine()) {       // leser inn resten av filen (selve labyrinten)
      char[] charArray = sc.nextLine().toCharArray();
      for(int kolonne = 0; kolonne < charArray.length; kolonne++) {
        Rute rute = opprettRute(charArray[i], rad, kolonne);
        labArray[rad][kolonne] = rute;
      }


      /*for(int i = 0; i < charArray.length; i++) {
        if(charArray[i] == '.') {
          if(linjenummer == 0 || linjenummer == (antRader-1) || i == 0 || i == (charArray.length-1)) {
            labArray[linjenummer][i] = new Aapning(linjenummer, i, labyrint);
          } else {
            labArray[linjenummer][i] = new HvitRute(linjenummer, i, labyrint);
          }
        }
        else if(charArray[i] == '#') {
          labArray[linjenummer][i] = new SortRute(linjenummer, i, labyrint);
        }
      }
      linjenummer++;
    }*/
  }

  public static Rute opprettRute(char tegn, int rad, int kolonne) {
    if(tegn == '.') {
      if(rad == 0 || rad == (antRader-1) || kolonne == 0 || kolonne == (antKolonner-1)) {
    }
  }

  public static void leggTilNaboer() {
    for(int rad = 0; rad < antRader; rad++) {
      for(int kol = 0; kol < antKolonner; kol++) {
        labArray[rad][kol].settAlleNaboer(labArray);
      }
    }
  }

  // signaturen burde vært int rad, int kolonne (det er slik resten av programmet brukes)
  public static Liste<String> finnUtveiFra(int kol, int rad) {
    return labArray[rad-1][kol-1].finnUtvei();
  }

  // hva skal egentlig denne gjøre ???
  public void settMinimalUtskrift() { }

  @Override
  public String toString() {
    String labyrintTegning = "";
    for(int x = 0; x < antRader; x++) {
      for(int y = 0; y < antKolonner; y++) {
        labyrintTegning += (labArray[x][y].tilTegn() + " ");
      }
      labyrintTegning += "\n";
    }
    return labyrintTegning;
  }
}
