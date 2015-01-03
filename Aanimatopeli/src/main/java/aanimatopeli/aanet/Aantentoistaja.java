package aanimatopeli.aanet;

import java.io.*;
import javax.sound.sampled.*;
import aanimatopeli.domain.Mato;
import aanimatopeli.domain.Omena;
import aanimatopeli.domain.Pala;
import java.util.HashMap;

/**
 * Lataa enum-arvojen avulla äänitiedostot
 * ja toistaa ne halutulla tavalla
 */
public class Aantentoistaja {

    private Mato mato;
    private Pala omena;
    private HashMap<Aani, Clip> aanet;
    
    public Aantentoistaja() {
        this.aanet = new HashMap<Aani, Clip>();
    }
    
/**
 * Toistaa omenan sijainnin kertovaa ääntä luuppina
 */
    public void kerroSuunta(Aani aanitehoste) {
        Clip clip = lataa(aanitehoste);
        
        if (clip.isRunning()) {
            return;
        }
        
        clip.loop(Clip.LOOP_CONTINUOUSLY );
    }
    
/**
 * Lopettaa äänitiedoston soittamisen, mikäli se on käynnissä
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
        
        this.aanet.remove(aanitehoste);
    }
    
/**
 * Lataa äänitiedoston annetun enum-arvon perusteella
 * @param ääneen viittaava enum-arvo
 * @return äänitiedostoa vastaava clip-olio
 */
    private Clip lataa(Aani aanitehoste) {
        if (this.aanet.containsKey(aanitehoste)) {
            return this.aanet.get(aanitehoste);
        }
        
        try {
            AudioInputStream aani = AudioSystem.getAudioInputStream(aanitehoste.getTiedosto());
            
            Clip clip = AudioSystem.getClip();
            
            this.aanet.put(aanitehoste, clip);
            
            this.aanet.get(aanitehoste).open(aani);
            
            return this.aanet.get(aanitehoste);
        } catch (Exception e) {
            System.out.println("Aanitiedostoa ei loydy");
        }
        
        return null;
    }       

}
