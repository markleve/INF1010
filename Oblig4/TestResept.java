
public class TestResept {

  public static void main(String[] args) {

    LegemiddelA legemiddelA = new LegemiddelA("kampa", 23.6, 123, 34);
    LegemiddelB legemiddelB = new LegemiddelB("klupa", 122.6, 12, 354);
    LegemiddelC legemiddelC = new LegemiddelC("paracet", 3.6, 12.5);

    Lege lege2 = new Lege("Dr. Herre");
    Lege lege3 = new Lege("Dr. Lala");

    Fastlege fastlege = new Fastlege("Dr. Kim", 12334);
    Fastlege fastlege2 = new Fastlege("Dr. Hans", 54334);

    Pasient pasient = new Pasient("Marie Klever", 123445697, "Moerveien 36a", 1430);
    Pasient pasient2 = new Pasient("Kaja Klave", 12344297, "Moerveien 36a", 1430);
    Pasient pasient3 = new Pasient("Markus Johan", 14345697, "Haabakken 32", 4355);

    BlaaResept resept1 = new BlaaResept(legemiddelA, lege2, pasient.hentId(), 10);
    BlaaResept resept2 = new BlaaResept(legemiddelA, lege2, pasient.hentId(), 10);
    BlaaResept resept3 = new BlaaResept(legemiddelA, lege2, pasient.hentId(), 10);
    System.out.println(resept1);
    System.out.println(resept2);
    System.out.println(resept3);

    HvitResept resept4 = new HvitResept(legemiddelA, lege2, pasient.hentId(), 10);
    HvitResept resept5 = new HvitResept(legemiddelA, lege2, pasient.hentId(), 10);
    HvitResept resept6 = new HvitResept(legemiddelA, lege2, pasient.hentId(), 10);

    System.out.println(resept4);
    System.out.println(resept5);
    System.out.println(resept6);




  }
}
