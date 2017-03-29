import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LabyrintTest {

  public static void main(String[] args) {
/*
    try {
      Labyrint labyrint = Labyrint.lesFraFil(new File(args[0]));
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Du må skrive inn en fil!.");
    } catch(FileNotFoundException e) {
      System.out.println("Kan ikke åpne filen " + args[0] + ". Sjekk at den er stavet riktig.");
    }
*/
    for(Rute r : Labyrint.lesFraFil(new File(args[0]))) {
      System.out.println("Dette: " + r.tilTegn());
    }
  }
}
