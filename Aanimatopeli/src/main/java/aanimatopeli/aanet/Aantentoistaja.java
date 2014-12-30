package aanimatopeli.aanet;

import java.io.*;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;
import aanimatopeli.domain.Mato;
import aanimatopeli.domain.Omena;
import aanimatopeli.domain.Pala;

/**
 * Lataa enum-arvojen perusteella äänitiedostot
 * ja toistaa ne halutulla tavalla
 */
public class Aantentoistaja {

    private Mato mato;
    private Pala omena;

/**
 * Toistaa omenan sijainnin kertovaa ääntä luuppina
 */
    public void kerroSuunta(Aani aanitehoste) {
        Clip clip = lataa(aanitehoste);
        
        if (clip.isRunning()) {
            return;
        }
        
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
/**
 * Lopettaa äänitiedoston toistamisen, mikäli se on käynnissä
 */
    public void lopeta(Aani aanitehoste) {
        Clip clip = lataa(aanitehoste);

        if (clip.isRunning()) {
            clip.stop();
        }
    }

/**
 * Toistaa annetun äänitiedoston kerran
*/ 
    public void toista(Aani aanitehoste) {
        Clip clip = lataa(aanitehoste);

        clip.start();
    }
    
/**
 * Lataa äänitiedoston annetun enum-arvon perusteella
 * @return äänitiedostoa vastaava Clip-olio
 */
    private Clip lataa(Aani aanitehoste) {
        try {
            AudioInputStream aani = AudioSystem.getAudioInputStream(aanitehoste.getTiedosto());
        
            Clip clip = AudioSystem.getClip();
            
            clip.open(aani);
            
            return clip;
        } catch (Exception e) {
            System.out.println("Aanitiedostoa ei loydy");
        }
        
        return null;
    }
    
/**
 * Laskee madon pään ja omenan sijaintien perusteella, mikä suuntatiedostoista 
 * tulee toistaa ja mikä lopettaa
 * Pitäisi ehkä olla jossain muussa luokassa kuin täällä
 */
    public void suunta() {
        if (this.mato.getPaa().getX() == this.omena.getX()) {
            lopeta(Aani.OMPPUOIKEA);
            lopeta(Aani.OMPPUVASEN);
        }
        
        if (this.mato.getPaa().getX() < this.omena.getX()) {
            kerroSuunta(Aani.OMPPUOIKEA);
        } else if (this.mato.getPaa().getX() > this.omena.getX()) {
            kerroSuunta(Aani.OMPPUVASEN);
        }
        
        if (this.mato.getPaa().getY() == this.omena.getY()) {
            lopeta(Aani.OMPPUYLOS);
            lopeta(Aani.OMPPUALAS);
        }
        
        if (this.mato.getPaa().getY() < this.omena.getY()) {
            kerroSuunta(Aani.OMPPUYLOS);
        } else if (this.mato.getPaa().getY() > this.omena.getY()) {
            kerroSuunta(Aani.OMPPUALAS);
        }
    }
        
    public void setMato(Mato mato) {
        this.mato = mato;
    }
    
    public void setOmena(Pala omena) {
        this.omena = omena;
    }
        
}
