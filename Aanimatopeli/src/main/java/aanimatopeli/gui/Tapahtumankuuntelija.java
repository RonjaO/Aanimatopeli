package aanimatopeli.gui;

import aanimatopeli.peli.Matopeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tapahtumankuuntelija implements ActionListener {

    private Matopeli peli;
    private JFrame frame;
    private JLabel tekstikentta;
    private JButton aloitus;
    private JButton ohjeet;
    private JButton pisteet;
    
    public Tapahtumankuuntelija(Matopeli peli, JFrame frame, JLabel t, JButton a, JButton o, JButton p) {
        this.peli = peli;
        this.frame = frame;
        this.tekstikentta = t;
        this.aloitus = a;
        this.ohjeet = o;
        this.pisteet = p;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == aloitus) {
            this.frame.requestFocus();
            this.peli.start();
            this.tekstikentta.setText("Pelataan...");
        }
        
        if (ae.getSource() == this.ohjeet) {
            this.tekstikentta.setText(lueTiedosto("Ohjeet.txt"));
        }
    }
    
    public String lueTiedosto(String tiedosto) {
        Scanner lukija = null;
        
        try {
            lukija = new Scanner(new File(tiedosto));
        } catch (Exception e) {
            System.out.println("tiedostoa ei loydy");
        }
        
        String teksti = "";
        
        while (lukija.hasNextLine()) {
            teksti += lukija.nextLine();
        }
        
        lukija.close();
        
        return teksti;
    }
    
}
