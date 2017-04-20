import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;

class Main {

  private static int startKol;
  private static int startRad;

  public static void main(String[] args) {
    String filnavn = null;
    if(args.length > 0) {
      filnavn = args[0];
    } else {
      System.out.println("Du må skrive inn en fil.");
      return;
    }

    File fil = new File(filnavn);
    Labyrint labyrint = null;

    try {
      labyrint = Labyrint.lesFraFil(fil);
    } catch(FileNotFoundException e) {
      System.out.println("FEIL: Kunne ikke lese fra '" + filnavn + "'");
      System.exit(1);
    }
    labyrint.settMinimalUtskrift();

    // skriver ut labyrinten og informasjon om denne
    Rute[][] labArray = labyrint.hentlabArray();
    System.out.println(labyrint);
    System.out.println("#: Sort rute");
    System.out.println(" : Hvit rute");
    System.out.println("A: Åpning");
    System.out.println("S: Startpunkt\n");

    // leser inn koordinater brukeren skriver inn og skriver informasjon om utveiene
    System.out.println("Skriv inn startkoordinater slik: kolonne rad");
    System.out.println("For å avslutte, skriv inn: ESC");
    System.out.println("For korteste utvei, skriv inn: KORT");
    System.out.println("For å finne antall utvaier, skriv inn: NUM\n");
    Scanner inn = new Scanner(System.in);
    while(inn.hasNextLine()) {
      String linje = inn.nextLine();
      if(linje.equals("ESC")) { break; }
      if(linje.equals("KORT")) {
        System.out.println(labyrint.kortesteUtvei(startKol, startRad));
        continue;
      }
      if(linje.equals("NUM")) {
        System.out.println("Antall utveier: " + labyrint.hentAntUtveier());
        continue;
      }
      String[] ord = linje.split(" ");
      startKol = Integer.parseInt(ord[0]);
      startRad = Integer.parseInt(ord[1]);
      if(labArray[startRad-1][startKol-1] instanceof SortRute) {
        System.out.println("Kan ikke starte på en sort rute.");
        continue;
      }
      System.out.println("Utveier fra posisjon (" + startKol + ", " + startRad + ")");

      Liste<String> utveier = labyrint.finnUtveiFra(startKol, startRad);
      if(utveier.erTom()) {
        System.out.println("Det er ingen utveier.");
      } else {
        for(String vei: utveier) {
          System.out.println(vei + "\n");
        }
      }
    }
  }
}
