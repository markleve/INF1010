class Prosessor {

  private int antKjerner;
  private double maxFrekvens;
  final static int OPERASJONER = 8;

  public Prosessor(int antKjerner, double maxFrekvens){
    this.antKjerner = antKjerner;
    this.maxFrekvens = maxFrekvens;
  }

  public double beregnFlopsProsessor() {
    return (antKjerner * maxFrekvens * OPERASJONER);
  }

}
