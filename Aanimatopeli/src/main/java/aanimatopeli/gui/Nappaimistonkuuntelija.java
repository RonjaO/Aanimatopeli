package aanimatopeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;
import aanimatopeli.domain.Mato;
import aanimatopeli.Suunta;

public class Nappaimistonkuuntelija implements KeyListener {

    private Mato mato;
    
    public Nappaimistonkuuntelija(Mato mato) {
        this.mato = mato;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.mato.setSuunta(Suunta.VASEN);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.mato.setSuunta(Suunta.OIKEA);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.mato.setSuunta(Suunta.YLOS);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.mato.setSuunta(Suunta.ALAS);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}
