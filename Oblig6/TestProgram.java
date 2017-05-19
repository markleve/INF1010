import krypto.*;
import java.util.concurrent.CountDownLatch;

public class TestProgram {

  public static void main(String[] args) {
    int antTelegrafer = 3;
    int antKryptografer = 20;

    Operasjonssentral ops = new Operasjonssentral(antTelegrafer);
    Kanal[] kanaler = ops.hentKanalArray();
    Monitor kryptoMonitor = new Monitor(antTelegrafer);

    for(int i = 0; i < antTelegrafer; i++) {
      Runnable telegrafist = new Telegrafist(kryptoMonitor, kanaler[i]);
      Thread traad = new Thread(telegrafist);
      traad.start();
    }

    Monitor deKryptoMonitor = new Monitor(antKryptografer);

    for(int i = 0; i < antKryptografer; i++) {
      Runnable kryptograf = new Kryptograf(kryptoMonitor, deKryptoMonitor);
      Thread traad = new Thread(kryptograf);
      traad.start();
    }

    Operasjonsleder operasjoneleder = new Operasjonsleder(deKryptoMonitor, antTelegrafer);
    Thread traad = new Thread(operasjoneleder);
    traad.start();
  }

}
