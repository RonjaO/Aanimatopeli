package aanimatopeli.gui;

import aanimatopeli.peli.Matopeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tapahtumankuuntelija implements ActionListener {

    private Matopeli peli;
    
    public Tapahtumankuuntelija(Matopeli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.peli.start();
    }
    
}
