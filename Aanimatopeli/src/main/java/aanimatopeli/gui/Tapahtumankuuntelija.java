package aanimatopeli.gui;

import aanimatopeli.peli.Matopeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Tapahtumankuuntelija implements ActionListener {

    private Matopeli peli;
    private JFrame frame;
    
    public Tapahtumankuuntelija(Matopeli peli, JFrame frame) {
        this.peli = peli;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.frame.requestFocus();
        this.peli.start();
    }
    
}
