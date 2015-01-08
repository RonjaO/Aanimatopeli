package aanimatopeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
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
        
        frame.setPreferredSize(new Dimension(400, 700));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        Nappaimistonkuuntelija nappaimistonkuuntelija = new Nappaimistonkuuntelija(this.matopeli.getMato());
        
        frame.addKeyListener(nappaimistonkuuntelija);
        
        JButton aloitus = new JButton("Aloita peli!");
        JLabel tekstikentta = new JLabel();
        JButton ohjeet = new JButton("Ohjeet");
        JButton pisteet = new JButton("TOP10 pisteet");
        JButton aanet = new JButton("Kuuntele äänet");

        
        Tapahtumankuuntelija tapahtumankuuntelija = new Tapahtumankuuntelija(this.matopeli, frame,
                tekstikentta, aloitus, ohjeet, pisteet, aanet);
                this.matopeli.setTekstikentta(tekstikentta);
        
        aloitus.addActionListener(tapahtumankuuntelija);
        ohjeet.addActionListener(tapahtumankuuntelija);
        pisteet.addActionListener(tapahtumankuuntelija);
        aanet.addActionListener(tapahtumankuuntelija);
        
        
        container.add(tekstikentta);
        
        container.add(aloitus, BorderLayout.SOUTH);
        
        
        container.add(valikko(ohjeet, pisteet, aanet), BorderLayout.WEST);
    }
    
    public JPanel valikko(JButton ohjeet, JButton pisteet, JButton aanet) {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        
        panel.add(ohjeet);
        panel.add(pisteet);
        panel.add(aanet);
        
        return panel;
    }
        
        
        
    public JFrame getFrame() {
        return frame;
    }
    
}
