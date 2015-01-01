package aanimatopeli.peli;

import aanimatopeli.Suunta;
import aanimatopeli.domain.Mato;
import aanimatopeli.domain.Pala;
import aanimatopeli.domain.Omena;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import aanimatopeli.aanet.Aani;
import aanimatopeli.aanet.Aantentoistaja;

/**
 * Pelilogiikka
 */
public class Matopeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private Mato mato;
    private Pala omena;
    private boolean jatkuu;
    private Random random = new Random();
    private Aantentoistaja toistaja;

    public Matopeli(int leveys, int korkeus, Aantentoistaja toistaja) {
        super(2000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        this.mato = new Mato(1, korkeus / 2, Suunta.OIKEA);
        this.omena = luoOmena();
        this.toistaja = toistaja;
        
        addActionListener(this);
        this.toistaja.setMato(this.mato);
        this.toistaja.setOmena(this.omena);
        setInitialDelay(1000);
        this.start();
    }

    public boolean jatkuu() {
        return this.jatkuu;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getLeveys() {
        return this.leveys;
    }

/**
 * Määrittää yhden liikahduksen tapahtumat
 * jatkuu, jos jatkuu-muuttuja on true
 */
    @Override 
    public void actionPerformed(ActionEvent ae) {
        if (!jatkuu()) {
            this.stop();
            this.toistaja.lopeta(Aani.OMPPUYLOS);
            this.toistaja.lopeta(Aani.OMPPUALAS);
            this.toistaja.lopeta(Aani.OMPPUOIKEA);
            this.toistaja.lopeta(Aani.OMPPUVASEN);
            return;
        }
        
        this.toistaja.suunta();

        this.mato.liiku();
        
        if (this.mato.osuu(this.omena)) {
            this.toistaja.toista(Aani.SYOOMPPU);
            this.mato.kasva();
            this.omena = luoOmena();
            this.toistaja.setOmena(this.omena);
        }
        
        if (this.mato.osuuItseensa()) {
            this.toistaja.toista(Aani.TORMAAITSEENSA);
            this.jatkuu = false;
        }
        
        Pala madonPaa = this.mato.getPalat().get(this.mato.getPituus() - 1);
        
        if (madonPaa.getX() == 0 && madonPaa.getX() >= this.leveys) {
            this.jatkuu = false;
            this.toistaja.toista(Aani.TORMAYS);
        } else if (madonPaa.getY() == 0 && madonPaa.getY() >= this.korkeus) {
            this.jatkuu = false;
            this.toistaja.toista(Aani.TORMAYS);
        }
    }
    
    public Mato getMato() {
        return this.mato;
    }
    
    public void setMato() {
        this.mato = mato;
    }
    
    public Pala getOmena() {
        return this.omena;
    }
    
    public void setOmena() {
        this.omena = omena;
    }
    
/**
 * Luo uuden omena-oolion. Tarkistaa luomisen yhteydessä, ettei omena osu matoon.
 * @return palautetaan uusi omena.
 */
    public Omena luoOmena() {
        Omena omena = null;
        while (true) {
            int x = random.nextInt(this.leveys);
            int y = random.nextInt(this.korkeus);

            omena = new Omena(x, y);

            if (this.mato.osuu(omena)) {
                continue;
            } else {
                break;
            }
        }

        return omena;
    }
    
}
