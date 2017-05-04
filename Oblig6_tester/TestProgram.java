import krypto.*;
import java.util.concurrent.CountDownLatch;

public class TestProgram {

  public static CountDownLatch kryptograferFerdig ;

  public static void main(String[] args) {
    int antTelegrafer = 1;
    int antKryptografer = 4;

    Operasjonssentral ops = new Operasjonssentral(antTelegrafer);
    Kanal[] kanaler = ops.hentKanalArray();
    Monitor kryptoMonitor = new Monitor();

    CountDownLatch telegraferFerdig = new CountDownLatch(antTelegrafer);
    for(int i = 0; i < antTelegrafer; i++) {
      Runnable telegrafist = new Telegrafist(kryptoMonitor, kanaler[i], telegraferFerdig);
      Thread traad = new Thread(telegrafist);
      traad.start();
    }

    Monitor deKryptoMonitor = new Monitor();

    kryptograferFerdig = new CountDownLatch(antKryptografer);
    for(int i = 0; i < antKryptografer; i++) {
      Runnable kryptograf = new Kryptograf(kryptoMonitor, deKryptoMonitor, kryptograferFerdig);
      Thread traad = new Thread(kryptograf);
      traad.start();
    }

    Operasjonsleder operasjoneleder = new Operasjonsleder(deKryptoMonitor);
    Thread traadO = new Thread(operasjoneleder);
    traadO.start();
  }

}
