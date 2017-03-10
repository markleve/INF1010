public class Stabel<T> extends Lenkeliste<T> {

  /**
   * Setter inn et element i starten av listen
   * @param   element     elementet som settes inn
   */
  @Override
  public void settInn(T element) {
    Node nyNode = new Node(element);
    nyNode.forrige = hode;
    nyNode.neste = hode.neste;
    hode.neste.forrige = nyNode;
    hode.neste = nyNode;
    antElement++;
  }
}
