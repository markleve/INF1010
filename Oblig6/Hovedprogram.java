import krypto.*;
import java.util.concurrent.CountDownLatch;

public class Hovedprogram {

  public static void main(String[] args) {
    int antallTelegrafister = 3;
    int antallKryptografer = 5;

    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal[] kanaler = ops.hentKanalArray();

    // monitorene er beholdere som lagrer informasjonen som sendes til dem
    // denne tar imot alle meldingene fra telegrafistene og lagrer dem i en kø (FIFO)
    // den sender en melding videre til hver kryptograf (må dermed låse og låse opp for å sende en melding av gangen til kryptografene)
          // låser, henter en melding fra køen, en kryptograf henter denne meldingen, meldingen slettes fra køen, låses opp
    Monitor kryptoMonitor = new Monitor();

    CountDownLatch alleTelegrafisterFerdig = new CountDownLatch(antallTelegrafister);
    for(int i = 0; i < antallTelegrafister; i++) {
      Runnable telegrafist = new Telegrafist(kryptoMonitor, kanaler[i], alleTelegrafisterFerdig);
      Thread traad = new Thread(telegrafist);
      traad.start();
    }

    Monitor deKryptoMonitor = new Monitor();

    CountDownLatch alleKryptograferFerdig = new CountDownLatch(antallKryptografer);
    for(int i = 0; i < antallKryptografer; i++) {
      Runnable kryptograf = new Kryptograf(kryptoMonitor, deKryptoMonitor, alleKryptograferFerdig);
      Thread traad = new Thread(kryptograf);
      traad.start();
    }

    Operasjonsleder operasjoneleder = new Operasjonsleder(deKryptoMonitor);
    Thread traad = new Thread(operasjoneleder);
    traad.start();
  }
}
