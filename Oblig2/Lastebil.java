class Lastebil extends Fossilbil {
  // subklasse av superklassen fossilbil

  protected double nyttevekt;

  Lastebil(String registreringsnummer, double co2Utslipp, double nyttevekt) {
    super(registreringsnummer, co2Utslipp);
    this.nyttevekt = nyttevekt;
  }

  @Override
  public String toString() {
    return super.toString() + "\nNyttevekt (kg): " + nyttevekt;
  }
}
