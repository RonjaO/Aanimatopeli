package  aanimatopeli.aanet;

import java.io.File;
/**
 * enum-arvot pelin k‰ytt‰mille ‰‰nitiedostoille
 */
public enum Aani {

    SYOOMPPU("SyoOmppu.wav"),
    OMPPUYLOS("OmppuYlhaalla.wav"),
    OMPPUALAS("OmppuAlhaalla.wav"),
    OMPPUVASEN("OmppuVasen.wav"),
    OMPPUOIKEA("OmppuOikea.wav"),
    TORMAYS("Tormays.wav"),
    TORMAAITSEENSA("TormaaItseensa.wav"),
    SEINAVAROITUS("SeinaVaroitus.wav"),
    MATOVAROITUS("MatoVaroitus.wav");

    private File tiedosto;

    private Aani(String tiedostonimi) {
        this.tiedosto = new File(tiedostonimi);
    }

/**
 * @return palauttaa tiedoston, johon enum-arvo viittaa
 */
    public File getTiedosto() {
        return this.tiedosto;
    }
}
