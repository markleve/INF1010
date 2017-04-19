import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Main {

  public static void main(String[] args) {
    try {

      Labyrint labyrint = Labyrint.lesFraFil(new File(args[0]));
      Rute[][] labArray = labyrint.hentlabArray();

      int kolonne = 8;
      int rad = 14;

      System.out.println(labyrint);
      System.out.println();

      System.out.println("#: Sort rute");
      System.out.println(" : Hvit rute");
      System.out.println("A: Åpning");
      System.out.println("S: Startpunkt");
      System.out.println();

      Liste<String> utveier = labyrint.finnUtveiFra(kolonne, rad);

      for(String vei:utveier) {
        System.out.println(vei + "\n");
      }

    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Du må skrive inn en fil.");
    } catch(FileNotFoundException e) {
      System.out.println("Finner ikke filen " + args[0]);
    }
  }
}
