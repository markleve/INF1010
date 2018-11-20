
import java.util.Iterator;

class TestKoe {

  public static void main(String[] args) {

    Koe<String> koe = new Koe<String>();
    koe.settInn("hei");
    koe.settInn("ja");
    koe.settInn("nei");
    koe.settInn("her");
    koe.settInn("hallosann");


    Iterator<String> iter = koe.iterator();

    while(iter.hasNext()) {
      System.out.println("Har neste: " + iter.hasNext());
      System.out.println("Element: " + iter.next());
    }

/*

    System.out.println("Størrelsen: " + koe.storrelse());


    for(String h: koe) {
      System.out.println(h);
    }
    System.out.println("Har fjernet: " + koe.fjern());
    System.out.println("Størrelsen: " + koe.storrelse());
    for(String h: koe) {
      System.out.println(h);
    }*/

  }
}
