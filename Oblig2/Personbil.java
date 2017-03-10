class Personbil extends Fossilbil {
  // subklasse av superklassen fossilbil
  protected int antSeter;

  Personbil(String registreringsnummer, double co2Utslipp, int antSeter) {
    super(registreringsnummer, co2Utslipp);
    this.antSeter = antSeter;
  }

  @Override
  public String toString() {
    return super.toString() + "\nAntall seter: " + antSeter;
  }
}
