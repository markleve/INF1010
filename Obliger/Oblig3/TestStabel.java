
import java.util.Iterator;

class TestStabel {

  public static void main(String[] args) {

    Stabel<String> stabel = new Stabel<String>();
    stabel.settInn("hei");
    stabel.settInn("ja");
    stabel.settInn("nei");
    stabel.settInn("her");
    stabel.settInn("hallosann");

    Iterator<String> iter = stabel.iterator();

    while(iter.hasNext()) {
      System.out.println("Har neste: " + iter.hasNext());
      System.out.println("Element: " + iter.next());
    }
    iter.remove();




    /*
    stabel.settInn("hei");
    stabel.settInn("ja");
    stabel.settInn("nei");
    stabel.settInn("her");
    stabel.settInn("hallosann");
    System.out.println("Størrelsen: " + stabel.storrelse());


    for(String h: stabel) {
      System.out.println(h);
    }
    System.out.println("Har fjernet: " + stabel.fjern());
    System.out.println("Størrelsen: " + stabel.storrelse());
    for(String h: stabel) {
      System.out.println(h);
    }
    */

  }
}
