package aanimatopeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import aanimatopeli.peli.Matopeli;
import aanimatopeli.domain.Mato;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Matopeli matopeli;
    
    public Kayttoliittyma(Matopeli matopeli) {
        this.matopeli = matopeli;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Äänimatopeli");
        
        frame.setPreferredSize(new Dimension(400, 300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        Nappaimistonkuuntelija nappaimistonkuuntelija = new Nappaimistonkuuntelija(this.matopeli.getMato());
        
        frame.addKeyListener(nappaimistonkuuntelija);
        
        JButton aloitus = new JButton("Aloita peli!");
        
        Tapahtumankuuntelija tapahtumankuuntelija = new Tapahtumankuuntelija(this.matopeli, frame);
        
        aloitus.addActionListener(tapahtumankuuntelija);
        
        container.add(aloitus);
    }
        
    public JFrame getFrame() {
        return frame;
    }
    
}
