abstract class Bil {

  protected String registreringsnummer;

  Bil(String registreringsnummer) {
    this.registreringsnummer = registreringsnummer;
  }

  @Override
  public String toString() {
    return "Reg.nr: " + registreringsnummer;
  }

  abstract public String bilType();
}
