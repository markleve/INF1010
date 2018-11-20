import java.util.ArrayList;

class Regneklynge {

  private int antNoderPerRack;
  private ArrayList<Rack> alleRack;
  private Rack sisteRack;

  public Regneklynge(int antNoderPerRack) {
    this.antNoderPerRack = antNoderPerRack;
    alleRack = new ArrayList<Rack>();
    sisteRack = new Rack(antNoderPerRack);
    alleRack.add(sisteRack);
  }

  public void settInnNode(Node node) {
    if(sisteRack.harPlass()) {
      sisteRack.leggTilNode(node);
    } else {
      sisteRack = new Rack(antNoderPerRack);
      sisteRack.leggTilNode(node);
      alleRack.add(sisteRack);
    }
  }

  public double flops() {
    double totFlopsRegneklynge = 0;
    for(Rack rack : alleRack) {
      totFlopsRegneklynge += rack.beregnFlopsRack();
    }
    return totFlopsRegneklynge;
  }

  public int noderMedNokMinne(int paakrevdMinne) {
    int totNoderMedNokMinne = 0;
    for(Rack rack : alleRack) {
      totNoderMedNokMinne += rack.noderMedNokMinneRack(paakrevdMinne);
    }
    return totNoderMedNokMinne;
  }

  public int antRack() {
    return alleRack.size();
  }
}
