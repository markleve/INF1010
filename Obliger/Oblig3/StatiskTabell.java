import java.util.Iterator;
import java.util.NoSuchElementException;

public class StatiskTabell<T> implements Tabell<T>  {
  private int arrayLengde;
  private int antElementer;
  private T[] arrayList;

  /**
  * Konstruktoren
  * Oppretter pekere til overliggende variabler
  * @param    arrayLengde       tabellens kapasitet
  */
  public StatiskTabell(int arrayLengde) {
    this.arrayLengde = arrayLengde;
    antElementer = 0;
    arrayList = (T[]) new Object[arrayLengde];
  }

  /**
  * Beregner antall elementer i listen
  * @return   antall elementer i listen
  */
  @Override
  public int storrelse() {
    return antElementer;
  }

  /**
  * Sjekker om listen er tom
  * @return   om listen er tom
  */
  @Override
  public boolean erTom() {
    return antElementer == 0;
  }

  /**
  * Setter inn et element i tabellen
  * @param    element             elementet som settes inn
  * @throws   FullTabellUnntak    hvis tabellen allerede er full
  */
  @Override
  public void settInn(T element) {
    if(antElementer == arrayLengde) {
      throw new FullTabellUnntak(arrayLengde);
    }
    arrayList[antElementer] = element;
    antElementer++;
  }

  /**
  * Henter (uten aa fjerne) et element fra tabellen
  * @param    plass               plassen i tabellen som det hentes fra
  * @return                       elementet paa plassen
  * @throws   UgyldigPlassUnntak  hvis plassen ikke er en gyldig indeks i arrayet
  */
  @Override
  public T hentFraPlass(int plass) {
    if (plass < 0 || plass >= arrayLengde) {    // arrayen gaar fra 0 -> arrayLengde-1
      throw new UgyldigPlassUnntak(plass, arrayLengde);
    }
    return arrayList[plass];
  }

  /**
  * Oppretter en ny StatiskTabellIterator
  * @return                       StatiskTabellIterator
  */
  @Override
  public Iterator<T> iterator() {
    return new StatiskTabellIterator();
  }

  private class StatiskTabellIterator implements Iterator<T> {
    private int gjeldendeElement = 0;

    /**
    * Sjekker om tabellen har et neste element. Returnerer false dersom
    * tabellen er tom.
    * @return            true dersom det er et neste element
    */
    @Override
    public boolean hasNext() {
      if(erTom()) {
        return false;
      }
      return (gjeldendeElement < antElementer);
    }

    /**
    * Henter gjeldende element fra tabellen
    * @return                           gjeldende element
    * @throws   NoSuchElementException  dersom det ikke er et neste element
    */
    @Override
    public T next() {
      if(!hasNext()) {
        throw new NoSuchElementException();
      }
      gjeldendeElement++;
      return arrayList[gjeldendeElement-1];
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
