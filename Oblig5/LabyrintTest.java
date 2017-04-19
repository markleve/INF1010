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

      for(int i = 0; i < labArray.length; i++) {
        System.out.println();
        for(int j = 0; j < labArray[i].length; j++) {
          System.out.println(labArray[i][j]);
        }
      }

      System.out.println("-------- Rute nummer 1,1 informasjon -------");

      Rute rute1 = labArray[1][1];
      System.out.println(rute1);
      System.out.println("Rad: " + rute1.hentRad());
      System.out.println("Kolonne: " + rute1.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute1.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute1.tilTegn());

      System.out.println("Informasjon om naboene til denne ruten ");
      System.out.println("Nord " + rute1.hentNaboNord());
      System.out.println("Øst " + rute1.hentNaboOst());
      System.out.println("Syd " + rute1.hentNaboSyd());
      System.out.println("Vest " + rute1.hentNaboVest());

      System.out.println("-------- Rute nummer 0,0 informasjon -------");

      Rute rute2 = labArray[0][0];
      System.out.println(rute2);
      System.out.println("Rad: " + rute2.hentRad());
      System.out.println("Kolonne: " + rute2.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute2.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute2.tilTegn());

      System.out.println("Informasjon om naboene til denne ruten ");
      System.out.println("Nord " + rute2.hentNaboNord());
      System.out.println("Øst " + rute2.hentNaboOst());
      System.out.println("Syd " + rute2.hentNaboSyd());
      System.out.println("Vest " + rute2.hentNaboVest());

      System.out.println("-------- Rute nummer 0,2 informasjon -------");

      Rute rute3 = labArray[0][2];
      System.out.println(rute3);
      System.out.println("Rad: " + rute3.hentRad());
      System.out.println("Kolonne: " + rute3.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute3.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute3.tilTegn());

      System.out.println("Informasjon om naboene til denne ruten ");
      System.out.println("Nord " + rute3.hentNaboNord());
      System.out.println("Øst " + rute3.hentNaboOst());
      System.out.println("Syd " + rute3.hentNaboSyd());
      System.out.println("Vest " + rute3.hentNaboVest());

      System.out.println("-------- Rute nummer 2,0 informasjon -------");

      Rute rute4 = labArray[2][0];
      System.out.println(rute4);
      System.out.println("Rad: " + rute4.hentRad());
      System.out.println("Kolonne: " + rute4.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute4.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute4.tilTegn());

      System.out.println("Informasjon om naboene til denne ruten ");
      System.out.println("Nord " + rute4.hentNaboNord());
      System.out.println("Øst " + rute4.hentNaboOst());
      System.out.println("Syd " + rute4.hentNaboSyd());
      System.out.println("Vest " + rute4.hentNaboVest());

      System.out.println("-------- Rute nummer 2,2 informasjon -------");

      Rute rute5 = labArray[2][2];
      System.out.println(rute5);
      System.out.println("Rad: " + rute5.hentRad());
      System.out.println("Kolonne: " + rute5.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute5.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute5.tilTegn());

      System.out.println("Informasjon om naboene til denne ruten ");
      System.out.println("Nord " + rute5.hentNaboNord());
      System.out.println("Øst " + rute5.hentNaboOst());
      System.out.println("Syd " + rute5.hentNaboSyd());
      System.out.println("Vest " + rute5.hentNaboVest());

      System.out.println("-------- Rute nummer 0,1 informasjon -------");

      Rute rute6 = labArray[0][1];
      System.out.println(rute6);
      System.out.println("Rad: " + rute6.hentRad());
      System.out.println("Kolonne: " + rute6.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute6.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute6.tilTegn());

      System.out.println("Informasjon om naboene til denne ruten ");
      System.out.println("Nord " + rute6.hentNaboNord());
      System.out.println("Øst " + rute6.hentNaboOst());
      System.out.println("Syd " + rute6.hentNaboSyd());
      System.out.println("Vest " + rute6.hentNaboVest());

      System.out.println("-------- Rute nummer 2,1 informasjon -------");

      Rute rute7 = labArray[2][1];
      System.out.println(rute7);
      System.out.println("Rad: " + rute7.hentRad());
      System.out.println("Kolonne: " + rute7.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute7.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute7.tilTegn());

      System.out.println("Informasjon om naboene til denne ruten ");
      System.out.println("Nord " + rute7.hentNaboNord());
      System.out.println("Øst " + rute7.hentNaboOst());
      System.out.println("Syd " + rute7.hentNaboSyd());
      System.out.println("Vest " + rute7.hentNaboVest());

      System.out.println("-------- Rute nummer 1,0 informasjon -------");

      Rute rute8 = labArray[1][0];
      System.out.println(rute8);
      System.out.println("Rad: " + rute8.hentRad());
      System.out.println("Kolonne: " + rute8.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute8.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute8.tilTegn());

      System.out.println("Informasjon om naboene til denne ruten ");
      System.out.println("Nord " + rute8.hentNaboNord());
      System.out.println("Øst " + rute8.hentNaboOst());
      System.out.println("Syd " + rute8.hentNaboSyd());
      System.out.println("Vest " + rute8.hentNaboVest());

      System.out.println("-------- Rute nummer 6,8 informasjon -------");

      Rute rute9 = labArray[6][2];
      System.out.println(rute9);
      System.out.println("Rad: " + rute9.hentRad());
      System.out.println("Kolonne: " + rute9.hentKolonne());
      System.out.println("Tilhørende labyrint: " + rute9.hentTilhorendeLabyrint());
      System.out.println("Tegn: " + rute9.tilTegn());

      System.out.println("Informasjon om naboene til denne ruten ");
      System.out.println("Nord " + rute9.hentNaboNord());
      System.out.println("Øst " + rute9.hentNaboOst());
      System.out.println("Syd " + rute9.hentNaboSyd());
      System.out.println("Vest " + rute9.hentNaboVest());





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
