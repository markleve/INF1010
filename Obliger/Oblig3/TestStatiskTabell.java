import java.util.Iterator;

class TestStatiskTabell {

  public static void main(String[] args) {
    StatiskTabell<String> stringTabell = new StatiskTabell<String>(3);
    System.out.println("Paa plass nummer " + 0 + " er element:" + stringTabell.hentFraPlass(0));


    System.out.println("Er tabellen tom: " + stringTabell.erTom());
    System.out.println("Elementer i tabellen: " + stringTabell.storrelse());
    stringTabell.settInn("hallo");
    stringTabell.settInn("her er jeg");
    stringTabell.settInn("neste element");
    System.out.println("Elementer i tabellen: " + stringTabell.storrelse());

    for(String str : stringTabell) {
      System.out.println("Elementet er : " + str);

    }
    // skal plassen starte fra 0 eller fra 1 ????? (selv om listen starter paa 0)
    System.out.println("Paa plass nummer " + 0 + " er element:" + stringTabell.hentFraPlass(0));
    System.out.println("Paa plass nummer " + 2 + " er element:" + stringTabell.hentFraPlass(2));

    System.out.println("--------------------------------------");
    StatiskTabell<String> stringTabell2 = new StatiskTabell<String>(3);
    stringTabell2.settInn("hallo");
    stringTabell2.settInn("her er jeg");
    stringTabell2.settInn("neste element");

    Iterator<String> itr = stringTabell2.iterator();
    while(itr.hasNext()) {
      System.out.println("Elementet er : " + itr.next());
    }



  }
}
