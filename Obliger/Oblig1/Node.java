class Node {

  private int minne;
  private Prosessor[] prosessor;

  public Node(int minne, int antKjerner, double maxFrekvens) {
    // Konstruktor for en prosessor
    this.minne = minne;
    prosessor = new Prosessor[1];
    prosessor[0] = new Prosessor(antKjerner, maxFrekvens);
  }

  public Node(int minne, int antKjerner1, double maxFrekvens1,
  int antKjerner2, double maxFrekvens2) {
    // Konstruktor for to prosessorer
    this.minne = minne;
    prosessor = new Prosessor[2];
    prosessor[0] = new Prosessor(antKjerner1, maxFrekvens1);
    prosessor[1] = new Prosessor(antKjerner2, maxFrekvens2);
  }

  public double beregnFlopsNode() {
    double totFlopsNode = 0;
    // kan man loope over hvert element i listen prosessor
    // uten å bruke indeks
    for(Prosessor p : prosessor) {
      totFlopsNode += p.beregnFlopsProsessor();
    }
    return totFlopsNode;
  }

  public int hentMinne() {
    return minne;
  }
}
