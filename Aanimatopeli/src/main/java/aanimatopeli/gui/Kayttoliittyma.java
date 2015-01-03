package aanimatopeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import aanimatopeli.peli.Matopeli;

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
        JButton aloitus = new JButton("Aloita peli!");
        
        Tapahtumankuuntelija kuuntelija = new Tapahtumankuuntelija(this.matopeli);
        
        aloitus.addActionListener(kuuntelija);
        
        container.add(aloitus);
        
        Nappaimistonkuuntelija nappaimistonkuuntelija = new Nappaimistonkuuntelija(this.matopeli.getMato());
        
        frame.addKeyListener(nappaimistonkuuntelija);
        
    }
        
    public JFrame getFrame() {
        return frame;
    }
    
}
