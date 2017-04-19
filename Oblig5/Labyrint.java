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
  }

  public int hentAntRader() { return antRader; }
  public int hentAntKolonner() { return antKolonner; }
  public Rute[][] hentlabArray() { return labArray; }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
    Scanner scanner = new Scanner(fil);

    String[] storrelse = scanner.nextLine().split(" ");  // array med størrelsen til labyrinten (antall rader og kolonner)
    antRader = Integer.parseInt(storrelse[0]);
    antKolonner = Integer.parseInt(storrelse[1]);

    Labyrint labyrint = new Labyrint();
    int rad = 0;

    while(scanner.hasNextLine()) {       // leser inn resten av filen (selve labyrinten)
      char[] charArray = scanner.nextLine().toCharArray();
      for(int kolonne = 0; kolonne < charArray.length; kolonne++) {
        Rute rute = opprettRute(charArray[kolonne], rad, kolonne, labyrint);
        labArray[rad][kolonne] = rute;
      }
      rad++;
    }
    leggTilNaboer();
    return labyrint;
  }

  // er det mulig å referere til labyrinten på en annen måte?
      // this: gikk ikke da dette er et statisk miljø...
  public static Rute opprettRute(char tegn, int rad, int kolonne, Labyrint labyrint) {
    if(tegn == '.') {
      if(rad == 0 || rad == (antRader-1) || kolonne == 0 || kolonne == (antKolonner-1)) {
        return new Aapning(rad, kolonne, labyrint);
    } else {
      return new HvitRute(rad, kolonne, labyrint);
    }
  } else {
    return new SortRute(rad, kolonne, labyrint);
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
