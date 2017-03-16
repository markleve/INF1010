
public class Legeliste extends OrdnetLenkeliste<Lege> {

  /**
  * Soeker gjennom listen etter en lege med samme navn som `navn`
  * og returnerer legen (uten aa fjerne den fra listen).
  * Hvis ingen slik lege finnes, returneres `null`.
  * @param   navn    navnet til legen
  * @return  legen
  */

  // for each lokke: this (denne legelisten!)
  public Lege finnLege(String navn) {
    for(Lege lege : this) {
      if(lege.hentNavn().equals(navn)) {
        return lege;
      }
    }
    return null;
  }

  /**
  * Returnerer et String[] med navnene til alle legene i listen
  * i samme rekkefoelge som de staar i listen.
  * @return array med navn til alle legene
  */
  public String[] stringArrayMedNavn() {
    int indeks = 0;
    String[] legelisteNavn = new String[this.storrelse()];
    for(Lege lege : this) {
      legelisteNavn[indeks] = lege.hentNavn();
      indeks++;
    }
    return legelisteNavn;
  }

}
