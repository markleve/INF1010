abstract class Fossilbil extends Bil {
  // subklasse av superklassen bil

  // CO2 utslippet er maalt i g/km
  protected double co2Utslipp;

  Fossilbil(String registreringsnummer, double co2Utslipp) {
    super(registreringsnummer);
    this.co2Utslipp = co2Utslipp;
  }

  @Override
  public String toString() {
    return super.toString() + "\nCO2-utslipp (g/km): " + co2Utslipp;
  }

  public String bilType() {
    return "FOSSIL";
  }
}
