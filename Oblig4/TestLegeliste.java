class TestLegeliste {

  public static void main(String[] args) {

    Lege lege = new Lege("Dr. Klever");
    Lege lege2 = new Lege("Dr. Herre");
    Lege lege3 = new Lege("Dr. Lala");

    Fastlege fastlege = new Fastlege("Dr. Kim", 12334);
    Fastlege fastlege2 = new Fastlege("Dr. Hans", 54334);

    Legeliste legeliste = new Legeliste();
    legeliste.settInn(lege);
    legeliste.settInn(lege2);
    legeliste.settInn(lege3);
    legeliste.settInn(fastlege);
    legeliste.settInn(fastlege2);

    for (Lege legene: legeliste) {
      System.out.println(legene);
    }

    System.out.println("------------------");

    System.out.println(legeliste.finnLege("Dr. Klever"));
    System.out.println(legeliste.finnLege("Dr. lala"));

    System.out.println("------------------");

    String[] legelisteNavn = legeliste.stringArrayMedNavn();

    for(String navn : legelisteNavn) {
      System.out.println(navn);  
    }
  }
}
