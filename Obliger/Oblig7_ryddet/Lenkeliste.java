import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class Lenkeliste<T> implements Liste<T> {

  protected int antElement = 0;
  protected Node hode;              // forste node (er tom)
  protected Node hale;              // siste node (er tom)

  /**
  * Konstruktoren
  * Oppretter pekere til overliggende variabler
  */
  public Lenkeliste() {
    hode = new Node(null);
    hode.neste = hode;
    hode.forrige = hode;
    hale = hode;
  }

  /**
   * Beregner antall elementer i listen
   * @return      antall elementer i listen
   */
  @Override
  public int storrelse() {
    return antElement;
  }

  /**
   * Sjekker om listen er tom
   * @return      om listen er tom
   */
  @Override
  public boolean erTom() {
    return hode.neste == hale;      // er tom dersom hodet sin neste peker paa halen
  }

  /**
   * Fjerner et element fra starten av listen. Hvis listen er tom,
   * returneres null.
   * @return      elementet
   */
  @Override
  public T fjern() {
    if(erTom()) {
      return null;
    }
    Node gjeldende = hode.neste;
    Node foer = gjeldende.forrige;
    Node etter = gjeldende.neste;
    foer.neste = etter;
    etter.forrige = foer;
    antElement--;
    return gjeldende.data;
  }

  public T hentForsteElement() {
    return hode.neste.data;
  }

  public T hentSisteElement() {
    return hale.forrige.data;
  }

  protected class Node {
    T data;
    Node neste;                     // noden sin neste node
    Node forrige;                   // noden sin forrige node

    /**
    * Konstruktoren
    * @param    data       informasjonen som skal lagres i noden
    */
    public Node(T data) {
      this.data = data;
    }
  }

  /**
  * Oppretter en ny LenkelisteIterator
  * @return                 LenkelisteIterator
  */
  @Override
  public Iterator<T> iterator() {
    return new LenkelisteIterator();
  }

  protected class LenkelisteIterator implements Iterator<T> {

    protected Node posisjon = hode;

    /**
    * Sjekker om lenkelisten har et neste element
    * @return            true dersom den har et neste element
    */
    @Override
    public boolean hasNext() {
      return posisjon.neste != hale;
    }

    /**
    * Henter neste element fra lenkelisten
    * @return                           neste element (hodet sin neste)
    * @throws   NoSuchElementException  dersom det ikke er et neste element
    */
    @Override
    public T next() {
      if(!hasNext()) {
        throw new NoSuchElementException();
      }
      posisjon = posisjon.neste;
      return posisjon.data;
    }

    /**
    * @throws   UnsupportedOperationException  funksjonen implementeres ikke
    */
    @Override
    public void remove() {
      throw new UnsupportedOperationException("Funksjonen remove() blir ikke implementert.");
    }
  }
}
