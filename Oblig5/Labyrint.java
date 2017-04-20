import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Collections;

// Spørsmål
//      - Dersom jeg skriver inn koordinatene til en av rutene som er en åpning
//        gås det bare en vei (altså printes bare den gjeldende ruten ut), men
//        jeg ønsker jo også at den skal gå til den andre ruten også (bruker filen 2.in)

public class Labyrint {

  private static int antRader;
  private static int antKolonner;
  private static Rute[][] labArray;
  private static Liste<String> utveier;
  private static int antUtveier;

  // skal antrader og antkolonner inn i konstruktøren?
  // skal den bare lagre et rute arrat og ikke initialisere det her?
  //    skal arrayet heller initialiseres når man leser fra fil?
  private Labyrint() {
    labArray = new Rute[antRader][antKolonner];
  }

  public int hentAntRader() { return antRader; }
  public int hentAntKolonner() { return antKolonner; }
  public Rute[][] hentlabArray() { return labArray; }
  public int hentAntUtveier() { return antUtveier; }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
    Scanner scanner = new Scanner(fil);

    String[] storrelse = scanner.nextLine().split(" ");  // array med størrelsen til labyrinten (antall rader og kolonner)
    antRader = Integer.parseInt(storrelse[0]);
    antKolonner = Integer.parseInt(storrelse[1]);

    Labyrint labyrint = new Labyrint();
    int rad = 0;      // raden programmet leser

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
  } else {    // antar her at det enten er . eller # i rutene (hvordan kan jeg skrive det for å fange opp eventuelle feil ??)
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
    utveier = labArray[rad-1][kol-1].finnUtvei();
    antUtveier = utveier.storrelse();
    return utveier;
  }

  // hva skal egentlig denne gjøre ???
  public void settMinimalUtskrift() { }

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
