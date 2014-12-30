package aanimatopeli;

import java.io.*;
import javax.sound.sampled.*;
import java.util.Timer;
import java.util.Scanner;

public class Aanitesti  {

    public static void main(String[] args) {
    
        Scanner lukija = new Scanner(System.in);
        
        Clip clip = null;
        
        try {
            AudioInputStream aani = AudioSystem.getAudioInputStream(new File("SyoOmppu.wav"));
    
            clip = AudioSystem.getClip();
            
            clip.open(aani);
            
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            System.out.println("Toistettu!");
        } catch (Exception e) {
            System.out.println("Aanitiedostoa ei loydy");
        }
        
        String komento = lukija.nextLine();
        
        if (komento.equals("lopeta")) {
            clip.stop();
        }
        
    }
    
}