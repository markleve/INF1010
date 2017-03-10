
// kan endre denne til abstact naar jeg har laget de to typene
// resepter som det skal vaere
public class Resept {
  private String type;
  private int mengde;

  public Resept(String type, int mengde) {
    this.type = type;
    this.mengde = mengde;
  }

  @Override
  public String toString() {
    return "Typ: " + type + "\n Mengde:" + mangde;
  }

}
