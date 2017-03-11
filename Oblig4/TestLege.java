
public class TestLege {
  public static void main(String[] args) {
    Lege lege = new Lege("Dr. Klever");
  //  System.out.println(lege);

/*
    Resept r1 = new Resept("første", 2);
    Resept r2 = new Resept("andre", 3);
    lege.leggTilResept(r1);
    lege.leggTilResept(r2);
    System.out.println("\nReseptliste");
    for (Resept rep: lege.hentReseptliste()) {
      System.out.println(rep);
    }
*/
    Lege lege2 = new Lege("Dr. Herre");
  //  System.out.println(lege2);

    Lege lege3 = new Lege("Dr. Lala");
  //  System.out.println(lege3);
/*
    System.out.println("\nSammenligning av legene");

    System.out.println(lege2.compareTo(lege));
    System.out.println(lege2.compareTo(lege2));
    System.out.println(lege2.compareTo(lege3));
*/
    Fastlege fastlege = new Fastlege("Dr. Kim", 12334);
    Fastlege fastlege2 = new Fastlege("Dr. Hans", 54334);
  //  System.out.println(fastlege);
  //  System.out.println(fastlege2);

    Legeliste legeliste = new Legeliste();
    legeliste.settInn(lege);
    legeliste.settInn(lege2);
    legeliste.settInn(lege3);
    legeliste.settInn(fastlege);
    legeliste.settInn(fastlege2);

    for (Lege legene: legeliste) {
      System.out.println(legene);
    }







  }
}
