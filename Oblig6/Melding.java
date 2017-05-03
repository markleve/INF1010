
public class Melding {
  private String melding;
  private int kanalId;
  private int meldingId;
  private String dekryptertMelding;

  public Melding(String melding, int kanalId, int meldingId) {
    this.melding = melding;
    this.kanalId = kanalId;
    this.meldingId = meldingId;
  }

  public String hentMelding() { return melding; }
  public String hentDekryptertMelding() { return dekryptertMelding; }
  public int hentKanalId() { return kanalId; }
  public int hentMeldingId() { return meldingId; }

  public void setDekryptertMelding(String melding) {dekryptertMelding = melding; }
}
