import krypto.*;
import java.util.concurrent.CountDownLatch;

public class TestProgram {
  public static void main(String[] args) {
    int antallTelegrafister = 3;
    int antallKryptografer = 5;

    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal[] kanaler = ops.hentKanalArray();
    Monitor kryptoMonitor = new Monitor();

    CountDownLatch alleTelegrafisterFerdig = new CountDownLatch(antallTelegrafister);
    for(int i = 0; i < antallTelegrafister; i++) {
      Runnable telegrafist = new Telegrafist(kryptoMonitor, kanaler[i], alleTelegrafisterFerdig);
      Thread traad = new Thread(telegrafist);
      traad.start();
    }

/*
    Melding m1 = new Melding("Melding 1", 1, 1);
    Melding m2 = new Melding("Melding 2", 1, 2);
    Melding m3 = new Melding("Melding 3", 1, 3);
    kryptoMonitor.settInnMelding(m1);
    kryptoMonitor.settInnMelding(m2);
    kryptoMonitor.settInnMelding(m3);

    System.out.println(m1.hentMelding() + " fra kanal " + m1.hentKanalId() + " med id " + m1.hentMeldingId());
    System.out.println(m2.hentMelding() + " fra kanal " + m2.hentKanalId() + " med id " + m2.hentMeldingId());
    System.out.println(m3.hentMelding() + " fra kanal " + m3.hentKanalId() + " med id " + m3.hentMeldingId());

    m1.setDekryptertMelding("jaja");
    System.out.println("Har dekryptert " + m1.hentMelding() + " : " + m1.hentDekryptertMelding());



    Koe<Melding> meldinger = kryptoMonitor.hentMeldingListe();
    if(meldinger.erTom()) {
      System.out.println("Listen er tom");
    }
    for(Melding melding: meldinger) {
      System.out.println(melding.hentMelding());
    }

    System.out.println("\nFjernet denne meldingen: " + kryptoMonitor.hentMelding().hentMelding());
    for(Melding melding: meldinger) {
      System.out.println(melding.hentMelding());
    }*/


/*
    Monitor deKryptoMonitor = new Monitor();

    CountDownLatch alleKryptograferFerdig = new CountDownLatch(antallKryptografer);
    for(int i = 0; i < antallKryptografer; i++) {
      Runnable kryptograf = new Kryptograf(kryptoMonitor, deKryptoMonitor, alleKryptograferFerdig);
      Thread traad = new Thread(kryptograf);
      traad.start();
    }

    Operasjonsleder operasjoneleder = new Operasjonsleder(deKryptoMonitor);
    Thread traad = new Thread(operasjoneleder);
    traad.start();*/
  }

}
