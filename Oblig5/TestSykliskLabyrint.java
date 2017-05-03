import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class TestSykliskLabyrint {

  public static void main(String[] args) {

    try {
      Labyrint labyrint = Labyrint.lesFraFil(new File(args[0]));
      System.out.println("Labyrinten ------");
      System.out.println(labyrint);
      System.out.println("Ant rader: " + labyrint.hentAntRader());
      System.out.println("Ant kolonner:" + labyrint.hentAntKolonner());

      

      /*
      Rute[][] labArray = labyrint.hentlabArray();

      for(int i = 0; i < labArray.length; i++) {
        System.out.println();
        for(int j = 0; j < labArray[i].length; j++) {
          System.out.println(labArray[i][j]);
        }
      }*/
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Du må skrive inn en fil!.");
    } catch(FileNotFoundException e) {
      System.out.println("Kan ikke åpne filen " + args[0] + ". Sjekk at den er stavet riktig.");
    }

  }


}
