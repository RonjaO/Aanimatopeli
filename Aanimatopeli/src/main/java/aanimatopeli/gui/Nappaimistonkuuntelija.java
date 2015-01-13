package aanimatopeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import aanimatopeli.domain.Mato;
import aanimatopeli.Suunta;
import aanimatopeli.peli.Matopeli;


/**
 * Näppäintenkuuntelija, joka ohjaa matoa
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Mato mato;
    
    public Nappaimistonkuuntelija(Mato mato) {
        this.mato = mato;
    }
    
    public void setMato(Mato mato) {
        this.mato = mato;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (this.mato.getSuunta() != Suunta.OIKEA) {
                this.mato.setSuunta(Suunta.VASEN);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (this.mato.getSuunta() != Suunta.VASEN) {
                this.mato.setSuunta(Suunta.OIKEA);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (this.mato.getSuunta() != Suunta.ALAS) {
                this.mato.setSuunta(Suunta.YLOS);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (this.mato.getSuunta() != Suunta.YLOS) {
                this.mato.setSuunta(Suunta.ALAS);
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}
