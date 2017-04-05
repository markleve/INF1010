import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LabyrintTest {

  public static void main(String[] args) {

    try {
      Labyrint labyrint = Labyrint.lesFraFil(new File(args[0]));
      System.out.println("Labyrinten ------");
      System.out.println(labyrint);
      System.out.println("Ant rader: " + labyrint.hentAntRader());
      System.out.println("Ant kolonner:" + labyrint.hentAntKolonner());

      Rute[][] labArray = labyrint.hentlabArray();

      for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          System.out.println(labArray[i][j]);
        }
      }

      System.out.println("-------- Rute nummer 1,1 informasjon -------");

      Rute rute1 = labArray[0][0];
      System.out.println(rute1);
      System.out.println("Rad: " + rute1.hentRad());
      System.out.println("Kolonne: " + rute1.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute1.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute1.tilTegn());

      System.out.println("-------- Rute nummer 1,2 informasjon -------");

      Rute rute2 = labArray[0][1];
      System.out.println(rute2);
      System.out.println("Rad: " + rute2.hentRad());
      System.out.println("Kolonne: " + rute2.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute2.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute2.tilTegn());

      System.out.println("-------- Rute nummer 2,1 informasjon -------");

      Rute rute3 = labArray[1][0];
      System.out.println(rute3);
      System.out.println("Rad: " + rute3.hentRad());
      System.out.println("Kolonne: " + rute3.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute3.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute3.tilTegn());







    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Du må skrive inn en fil!.");
    } catch(FileNotFoundException e) {
      System.out.println("Kan ikke åpne filen " + args[0] + ". Sjekk at den er stavet riktig.");
    }
    /*for(Rute r : Labyrint.lesFraFil(new File(args[0]))) {
      System.out.println("Dette: " + r.tilTegn());
    }*/
  }
}
