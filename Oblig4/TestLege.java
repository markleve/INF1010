
public class TestLege {
  public static void main(String[] args) {
    Lege lege = new Lege("Dr. Klever");
    System.out.println(lege);


    Resept r1 = new Resept("første", 2);
    Resept r2 = new Resept("andre", 3);
    pasient.leggTilResept(r1);
    pasient.leggTilResept(r2);
    System.out.println("\nReseptliste");
    for (Resept rep: pasient.hentReseptliste()) {
      System.out.println(rep);
    }

    Pasient pasient2 = new Pasient("Marie Klever", 123445697, "Moerveien 36a", 1430);
    System.out.println(pasient2);
    Pasient pasient3 = new Pasient("Marie Klever", 123445697, "Moerveien 36a", 1430);
    System.out.println(pasient3);
  }
}
