package aanimatopeli.aanet;

import java.io.*;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;

public class Aantentoistaja {

    public void kerroSuunta(Aani aanitehoste) {
        try {
            AudioInputStream aani = AudioSystem.getAudioInputStream(aanitehoste.getTiedosto());

            Clip clip = AudioSystem.getClip();
            
            clip.open(aani);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void lopeta(Aani aanitehoste) {
        AudioInputStream aani = AudioSystem.getAudioInputStream(aanitehoste.getTiedosto());
        
        Clip clip = AudioSystem.getClip();
        
        clip.open(aani);
        
        if (clip.isRunning()) {
            clip.stop();
        }
    }
    
    public void toista(Aani aanitehoste) {
        try {
            AudioInputStream aani = AudioSystem.getAudioInputStream(aanitehoste.getTiedosto());

            Clip clip = AudioSystem.getClip();
        
            clip.open(aani);
        
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
}