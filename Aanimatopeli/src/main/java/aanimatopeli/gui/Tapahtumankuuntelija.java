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
import aanimatopeli.aanet.Aani;
import aanimatopeli.aanet.Aantentoistaja;

public class Tapahtumankuuntelija implements ActionListener {

    private Matopeli peli;
    private JFrame frame;
    private JLabel tekstikentta;
    private JButton aloitus;
    private JButton ohjeet;
    private JButton pisteet;
    private JButton aanet;
    
    public Tapahtumankuuntelija(Matopeli peli, JFrame frame, JLabel t, JButton a, JButton o, JButton p, JButton aa) {
        this.peli = peli;
        this.frame = frame;
        this.tekstikentta = t;
        this.aloitus = a;
        this.ohjeet = o;
        this.pisteet = p;
        this.aanet = aa;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == aloitus) {
            this.frame.requestFocus();
            this.peli.start();
            this.tekstikentta.setText("Pelataan...");
        }
        
        if (ae.getSource() == this.ohjeet) {
            this.tekstikentta.setText("Ohjeet: \n" + lueTiedosto("Ohjeö.txt"));
        }
        
        if (ae.getSource() == pisteet) {
            this.tekstikentta.setText("TOP 10 pisteet: " + lueTiedosto("pisteettop10.txt"));
        }
        
        if (ae.getSource() == aanet) {
            this.tekstikentta.setText("Äänet: \n 1. Syodään omena\n2. törmää seinään\n3. törmää itseensä\n" +
                "4. omena alhaalla\n5. omena ylhäällä\n6. omena vasemmalla\n7. omena oikealla\n" +
                "8. varoitus, seinä lähestyy\n9. varoitus, mato lähestyy");
            Aantentoistaja toistaja = new Aantentoistaja();
            toistaja.toista(Aani.KAIKKIAANET);
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
            teksti += lukija.nextLine() + "\n";
        }
        
        lukija.close();
        
        return teksti;
    }
    
}
