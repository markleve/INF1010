class Main {

  public static void main(String[] args) {
    int antNoderPerRack = 12;
    Regneklynge abel = new Regneklynge(antNoderPerRack);

    for(int i = 0; i < 650; i++) {
      Node node = new Node(64, 8, 2.6*Math.pow(10,9), 8, 2.6*Math.pow(10,9));
      abel.settInnNode(node);
    }

    for(int i = 0; i < 16; i++) {
      Node node = new Node(1024, 8, 2.3*Math.pow(10,9), 8, 2.3*Math.pow(10,9));
      abel.settInnNode(node);
    }

    System.out.printf("Samlet FLOPS: %.5e \n", abel.flops());
    System.out.printf("Noder med minst 32 GB: %d \n", abel.noderMedNokMinne(32));
    System.out.printf("Noder med minst 64 GB: %d \n", abel.noderMedNokMinne(64));
    System.out.printf("Noder med minst 128 GB: %d \n", abel.noderMedNokMinne(128));
    System.out.printf("Antall rack: %d \n", abel.antRack());
  }
}
