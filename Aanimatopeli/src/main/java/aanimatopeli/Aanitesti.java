package aanimatopeli;

import java.io.*;
import javax.sound.sampled.*;

public class Aanitesti {


    public static void main(String[] args) {
    
        try {
            AudioInputStream aani = AudioSystem.getAudioInputStream(new File("SyoOmppu.au"));
    
            Clip clip = AudioSystem.getClip();
            
            clip.open(aani);
            
            clip.start();
            System.out.println("Toistettu!");
        } catch (Exception e) {
            System.out.println("Aanitiedostoa ei loydy");
        }
        
    }
    
}