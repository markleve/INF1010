
import java.util.Iterator;

class TestOrdnetLenkeliste {

  public static void main(String[] args) {

    OrdnetLenkeliste<Integer> ordnetLenkeliste = new OrdnetLenkeliste<Integer>();

    // tester med integer
    ordnetLenkeliste.settInn(1);
    ordnetLenkeliste.settInn(2);
    ordnetLenkeliste.settInn(-1);
    ordnetLenkeliste.settInn(4);
    ordnetLenkeliste.settInn(3);
    ordnetLenkeliste.settInn(9);

    for(Integer h: ordnetLenkeliste) {
      System.out.println(h);
    }
    System.out.println("------------------------------------------");


    Iterator<Integer> iter = ordnetLenkeliste.iterator();

    while(iter.hasNext()) {
      System.out.println("Har neste: " + iter.hasNext());
      System.out.println("Element: " + iter.next());
    }
    System.out.println("------------------------------------------");


    // tester med string
    OrdnetLenkeliste<String> ordnetLenkeliste2 = new OrdnetLenkeliste<String>();
    ordnetLenkeliste2.settInn("hei");
    ordnetLenkeliste2.settInn("ja");
    ordnetLenkeliste2.settInn("nei");
    ordnetLenkeliste2.settInn("her");
    ordnetLenkeliste2.settInn("hallosann");
    ordnetLenkeliste2.settInn("hallosinn");

    System.out.println("Størrelsen: " + ordnetLenkeliste2.storrelse());


    for(String h: ordnetLenkeliste2) {
      System.out.println(h);
    }
    System.out.println("------------------------------------------");

    System.out.println("Har fjernet: " + ordnetLenkeliste2.fjern());
    System.out.println("Størrelsen: " + ordnetLenkeliste2.storrelse());
    for(String h: ordnetLenkeliste2) {
      System.out.println(h);
    }
  }
}
