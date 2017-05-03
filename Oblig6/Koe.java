public class Koe<T> extends Lenkeliste<T> {

  /**
   * Setter inn et element i slutten av listen
   * @param   element     elementet som settes inn
   */
  @Override
  public void settInn(T element) {
    Node nyNode = new Node(element);
    nyNode.neste = hale;
    nyNode.forrige = hale.forrige;
    hale.forrige.neste = nyNode;
    hale.forrige = nyNode;
    antElement++;
  }
}
