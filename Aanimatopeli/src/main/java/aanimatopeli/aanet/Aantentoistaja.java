package aanimatopeli.aanet;

import java.io.*;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;
import aanimatopeli.domain.Mato;
import aanimatopeli.domain.Omena;
import aanimatopeli.domain.Pala;

/**
 * Lataa enum-arvojen perusteella ‰‰nitiedostot
 * ja toistaa ne halutulla tavalla
 */
public class Aantentoistaja {

    private Mato mato;
    private Pala omena;

/**
 * Toistaa omenan sijainnin kertovaa ‰‰nt‰ luuppina
 */
    public void kerroSuunta(Aani aanitehoste) {
        Clip clip = lataa(aanitehoste);
        
        if (clip.isRunning()) {
            return;
        }
        
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
/**
 * Lopettaa ‰‰nitiedoston toistamisen, mik‰li se on k‰ynniss‰
 */
    public void lopeta(Aani aanitehoste) {
        Clip clip = lataa(aanitehoste);

        if (clip.isRunning()) {
            clip.stop();
        }
    }

/**
 * Toistaa annetun ‰‰nitiedoston kerran
*/ 
    public void toista(Aani aanitehoste) {
        Clip clip = lataa(aanitehoste);

        clip.start();
    }
    
/**
 * Lataa ‰‰nitiedoston annetun enum-arvon perusteella
 * @return ‰‰nitiedostoa vastaava Clip-muuttuja
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
 * Laskee madon p‰‰n ja omenan sijaintien perusteella, mik‰ suuntatiedostoista 
 * tulee toistaa ja mik‰ lopettaa
 * Pit‰isi ehk‰ olla jossain muussa luokassa kuin t‰‰ll‰
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
