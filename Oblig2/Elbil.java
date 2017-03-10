class Elbil extends Bil {
  // subklasse av superklassen bil

  // batterikapasiteten er målt i kWh
  protected double batteriKapasitet;

  Elbil(String registreringsnummer, double batteriKapasitet) {
    super(registreringsnummer);
    this.batteriKapasitet = batteriKapasitet;
  }

  @Override
  public String toString() {
    return super.toString() + "\nBatterikapasitet (kWh): " + batteriKapasitet;
  }

  public String bilType() {
    return "EL";
  }
}
