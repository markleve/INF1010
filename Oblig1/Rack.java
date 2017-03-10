import java.util.ArrayList;

class Rack {

  private int antNoderPerRack;
  private ArrayList<Node> rack;

  public Rack(int antNoderPerRack) {
    this.antNoderPerRack = antNoderPerRack;
    rack = new ArrayList<Node>();
  }

  public boolean harPlass(){
    if(rack.size() < antNoderPerRack) {
      return true;
    }
    return false;
  }

  public void leggTilNode(Node node) {
    rack.add(node);
  }

  public double beregnFlopsRack() {
    double totFlopsRack = 0;
    for(Node node : rack) {
      totFlopsRack += node.beregnFlopsNode();
    }
    return totFlopsRack;
  }

  // metoden returnerer antall noder med minst paakrevdMinne GB minne
  public int noderMedNokMinneRack(int paakrevdMinne) {
    int antNoderMedNokMinneRack = 0;
    for(Node node : rack) {
      if (node.hentMinne() >= paakrevdMinne) {
        antNoderMedNokMinneRack += 1;
      }
    }
    return antNoderMedNokMinneRack;
  }
}
