// eksempel paa hvordan man kan bruke javadoc


/**
* Informasjon om anvendelsen av denne Klassen
* -> kan bruke html markup for aa spesifisere og framheve, eksempelvis:
*       <b> dette </b>        boald (fet)
*       <i> dette </i>        italic (kursiv)
*       <u> dette </u>        underline (understrek)
*       <br>                  definerer en ny linje (single line break)
*       <ul> dette </ul>      liste med bullet points
*           <li> dette </li>  hvert element i listen
*       <p> dette </p>        paragraf
*       <h1> <h2>             headings
*       <ol>                  ordered list
*       <ul>                  unordered list
*       <table>               table
*/
public class TestJava {

  private int tall;

  public TestJava(int tall) {
    this.tall = tall;
  }

  /**
  * Beskrive hva denne metoden gjor
  * @return     hva som returneres
  * @param      nyttTall     hva denne variabelen er
  */
  public int hentOgEndreTall(int nyttTall) {
    int tmp = tall;
    tall = nyttTall;
    return tmp;
  }
}
