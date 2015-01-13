package aanimatopeli.pisteet;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka, joka pitää huolta tiedostosta, joka sisältää pistetilastot
 */
public class Pistehallinnoija {

    private Scanner lukija;
    private FileWriter kirjoittaja;
    private ArrayList<Integer> pisteet;
    
/**
 * Konstruktorissa luetaan pisteet sisältävä tiedosto ja talletetaan pisteet listaan
 */
    public Pistehallinnoija() throws FileNotFoundException, IOException {
        this.lukija = new Scanner(new File("pisteettop10.txt"));
        this.pisteet = new ArrayList<Integer>();
        
        while (this.lukija.hasNextLine()) {
            String rivi = this.lukija.nextLine();
           
            String[] pilkottu = rivi.split(" ");
            int pistemaara = Integer.parseInt(pilkottu[1]);
           
            this.pisteet.add(pistemaara);
        }
    }

/**
 * Lisää listaan uuden pistemäärän
 * @param listaan lisättävät pisteet
 */ 
    public void lisaaPisteet(int pistemaara) {
        if (!this.pisteet.contains(pistemaara)) {
            this.pisteet.add(pistemaara);
        }
        
        Collections.sort(this.pisteet);
        Collections.reverse(this.pisteet);
    }
 
/**
 * Tallentaa listasta maksimissaan 10 parasta pistettä tiedostoon
 * ylikirjoittaa vanhan sisällön
 */ 
    public void tallennaPisteetTiedostoon() throws IOException {
        kirjoittaja = new FileWriter("pisteettop10.txt");
        if (this.pisteet.size() == 0) {
            return;
        } else if (this.pisteet.size() < 10) {
            int mones = 1;
            for (int pistemaara : this.pisteet) {
                this.kirjoittaja.write(mones + ". " + pistemaara + "\n");
                
                mones++;
            }
        } else {
            int mones = 1;
            for (int i = 0; i < 10; i++) {
                this.kirjoittaja.write(mones + ". " + this.pisteet.get(i) + "\n");
                mones++;
            }
        }
        
        this.kirjoittaja.close();
    }
    
}
