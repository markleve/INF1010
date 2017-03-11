
public class TestLegemiddel {

  public static void main(String[] args) {

    LegemiddelA legemiddelA = new LegemiddelA("kampa", 23.6, 123, 34);
    LegemiddelA legemiddelA2 = new LegemiddelA("kampa", 23.6, 123, 34);
    LegemiddelA legemiddelA3 = new LegemiddelA("kampa", 23.6, 123, 34);

    LegemiddelB legemiddelB = new LegemiddelB("klupa", 122.6, 12, 354);
    LegemiddelB legemiddelB2 = new LegemiddelB("klupa", 122.6, 12, 354);
    LegemiddelB legemiddelB3 = new LegemiddelB("klupa", 122.6, 12, 354);

    LegemiddelC legemiddelC = new LegemiddelC("paracet", 3.6, 12.5);
    LegemiddelC legemiddelC2 = new LegemiddelC("paracet", 3.6, 12.5);
    LegemiddelC legemiddelC3 = new LegemiddelC("paracet", 3.6, 12.5);


    System.out.println(legemiddelA);
    System.out.println(legemiddelA2);
    System.out.println(legemiddelA3);

    System.out.println(legemiddelB);
    System.out.println(legemiddelB2);
    System.out.println(legemiddelB3);

    System.out.println(legemiddelC);
    System.out.println(legemiddelC2);
    System.out.println(legemiddelC3);


    // Id tildelingen fungerer ikke som den skal .. :(

  }
}
