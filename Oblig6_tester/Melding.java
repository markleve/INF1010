
public class Melding {
  private String melding;
  private int kanalId;
  private int meldingId;
  private String dekryptertMelding;
  private static int teller = 1;

  public Melding(String melding, int kanalId) {
    this.melding = melding;
    this.kanalId = kanalId;
    this.meldingId = teller++;
  }

  public String hentMeldingen() { return melding; }
  public String hentDekryptertMelding() { return dekryptertMelding; }
  public int hentKanalId() { return kanalId; }
  public int hentMeldingId() { return meldingId; }

  public void setDekryptertMelding(String melding) { dekryptertMelding = melding; }
}
