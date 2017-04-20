class OrdnetLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

  /**
   * Setter inn et element i listen
   * Elementene settes inn i stigende rekkefolge, med laveste verdi forst
   * @param   element     elementet som settes inn
   */
  @Override
  public void settInn(T element) {
    Node nyNode = new Node(element);
    Node gjeldende = hode.neste;
    Node forrige = hode;

    // nyNode.data.compareTo(gjeldende.data) gir positiv verdi dersom nyNode
    // sin data er storre enn gjeldende sin data
    while(gjeldende != hale && nyNode.data.compareTo(gjeldende.data) >= 0) {
      forrige = gjeldende;
      gjeldende = gjeldende.neste;
    }
    forrige.neste = nyNode;
    gjeldende.forrige = nyNode;
    nyNode.forrige = forrige;
    nyNode.neste = gjeldende;
    antElement++;
  }

  public T hentForsteElement() {
    return hode.neste.data;
  }

  public T hentSisteElement() {
    return hale.forrige.data;
  }
}
