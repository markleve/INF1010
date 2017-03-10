import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


class Main {

  public static void main(String[] args) {

    ArrayList<Bil> bilArray = new ArrayList<Bil>();

    try {
      Scanner sc = new Scanner(new File(args[0]));
      while(sc.hasNext()) {
        String nextElement = sc.next();
        switch (nextElement) {
          case "EL":
            bilArray.add(new Elbil(sc.next(), sc.nextDouble()));
            break;
          case "PERSONBIL":
            bilArray.add(new Personbil(sc.next(), sc.nextDouble(), sc.nextInt()));
            break;
          case "LASTEBIL":
            bilArray.add(new Lastebil(sc.next(), sc.nextDouble(), sc.nextDouble()));
            break;
        }
      }
    } catch(Exception e) {
      System.out.println("Finner ikke filen. Prøv igjen.");
    }

    for (Bil b : bilArray) {
      if(args.length < 2) {
        System.out.println("Type motorvogn: " + b.getClass().getName());
        System.out.println(b + "\n");
      } else if(args[1].equals(b.bilType())) {
        System.out.println("Type motorvogn: " + b.getClass().getName());
        System.out.println(b + "\n");
      }
    }
  }

  void skrivEl(){
    for (Bil b: bilArray) {
      if(b instanceof Elbil) {
        System.out.println("ELBIL");
        System.out.println(b);
      }
    }
  }

  void skrivFossil() {
    for (Bil b: bilArray) {
      if(b instanceof Lastebil or Personbil) {
        System.out.println("Type motorvogn: ")
      }
    }
  }
}
