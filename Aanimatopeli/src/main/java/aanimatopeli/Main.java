package aanimatopeli;

import javax.swing.SwingUtilities;
import aanimatopeli.gui.Kayttoliittyma;
import aanimatopeli.peli.Matopeli;
import aanimatopeli.aanet.Aantentoistaja;

public class Main {

    public static void main(String[] args) {
        Aantentoistaja toistaja = new Aantentoistaja();

        Matopeli matopeli = new Matopeli(10, 15, toistaja);
        
        Kayttoliittyma kali = new Kayttoliittyma(matopeli);
        
        SwingUtilities.invokeLater(kali);
        
        
        
    }
}