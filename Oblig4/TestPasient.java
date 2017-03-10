public class TestPasient {

  public static void main(String[] args) {
    Pasient pasient = new Pasient("Marie Klever", 123445697, "Moerveien 36a", 1430);
    System.out.println("\nDette er pasient med id: " + pasient.hentId());
    System.out.println("Navn: " + pasient.hentNavn());
    System.out.println("Fødselsnummer: " + pasient.hentFodselsnummer());
    System.out.println("Adresse: " + pasient.hentGateadresse());
    System.out.println("Postnummer: " + pasient.hentPostnummer() + "\n");

    Pasient pasient2 = new Pasient("Marie Klever", 123445697, "Moerveien 36a", 1430);
    System.out.println("Dette er pasient med id: " + pasient2.hentId());
    System.out.println("Navn: " + pasient2.hentNavn());
    System.out.println("Fødselsnummer: " + pasient2.hentFodselsnummer());
    System.out.println("Adresse: " + pasient2.hentGateadresse());
    System.out.println("Postnummer: " + pasient2.hentPostnummer()+ "\n");

    Pasient pasient3 = new Pasient("Marie Klever", 123445697, "Moerveien 36a", 1430);
    System.out.println("Dette er pasient med id: " + pasient3.hentId());
    System.out.println("Navn: " + pasient3.hentNavn());
    System.out.println("Fødselsnummer: " + pasient3.hentFodselsnummer());
    System.out.println("Adresse: " + pasient3.hentGateadresse());
    System.out.println("Postnummer: " + pasient3.hentPostnummer()+ "\n");
  }
}
