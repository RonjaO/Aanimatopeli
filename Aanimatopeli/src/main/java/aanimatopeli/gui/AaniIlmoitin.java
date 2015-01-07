package aanimatopeli.gui;

import aanimatopeli.aanet.Aantentoistaja;
import aanimatopeli.aanet.Aani;
import aanimatopeli.domain.Mato;
import aanimatopeli.domain.Pala;
import aanimatopeli.domain.Omena;
import aanimatopeli.Suunta;

public class AaniIlmoitin {

    private Mato mato;
    private Pala omena;
    private int leveys;
    private int korkeus;
    private Aantentoistaja toistaja;
    
    public AaniIlmoitin(Mato mato, Pala omena, int leveys, int korkeus, Aantentoistaja toistaja) {
        this.mato = mato;
        this.omena = omena;
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.toistaja = toistaja;
    }
    
    public void setOmena(Pala omena) {
        this.omena = omena;
    }
    
    public void suunta() {
        if (this.mato.getPaa().getX() == this.omena.getX()) {
            this.toistaja.lopeta(Aani.OMPPUOIKEA);
            this.toistaja.lopeta(Aani.OMPPUVASEN);
        } else if (this.mato.getPaa().getX() < this.omena.getX()) {
            this.toistaja.kerroSuunta(Aani.OMPPUOIKEA);
        } else if (this.mato.getPaa().getX() > this.omena.getX()) {
            this.toistaja.kerroSuunta(Aani.OMPPUVASEN);
        }
        
        if (this.mato.getPaa().getY() == this.omena.getY()) {
            this.toistaja.lopeta(Aani.OMPPUYLOS);
            this.toistaja.lopeta(Aani.OMPPUALAS);
        } else if (this.mato.getPaa().getY() > this.omena.getY()) {
            this.toistaja.kerroSuunta(Aani.OMPPUYLOS);
        } else if (this.mato.getPaa().getY() < this.omena.getY()) {
            this.toistaja.kerroSuunta(Aani.OMPPUALAS);
        }
    }
    
    public void varoitukset() {
        
        matovaroitus();
            
        seinavaroitus();
    }
    
    public void matovaroitus() {
        Pala paa = this.mato.getPaa();
        
        for (Pala pala : this.mato.getPalat()) {
            if (pala == paa) {
                continue;
            }
            
            if (this.mato.getSuunta() == Suunta.VASEN) {
                if (paa.getY() == pala.getY() && paa.getX() - pala.getX() <= 3 && paa.getX() - pala.getX() > 0) {
                    this.toistaja.toista(Aani.MATOVAROITUS);
                    return;
                }
            } else if (this.mato.getSuunta() == Suunta.OIKEA) {
                if (paa.getY() == pala.getY() && pala.getX() - paa.getX() <= 3 && pala.getX() - paa.getX() > 0) {
                    this.toistaja.toista(Aani.MATOVAROITUS);
                    return;
                }
            } else if (this.mato.getSuunta() == Suunta.ALAS) {
                if (paa.getX() == pala.getX() && pala.getY() - paa.getY() <= 3 && pala.getY() - paa.getY() > 0) {
                    this.toistaja.toista(Aani.MATOVAROITUS);
                    return;
                }
            } else if (this.mato.getSuunta() == Suunta.YLOS) {
                if (paa.getX() == pala.getX() && paa.getY() - pala.getY() <= 3 && paa.getY() - pala.getY()  >  0) {
                    this.toistaja.toista(Aani.MATOVAROITUS);
                    return;
                }
            }
        }
    }
    
    public void seinavaroitus() {
        if (this.mato.getSuunta() == Suunta.YLOS) {
            if (this.mato.getPaa().getY() <= 3) {
                this.toistaja.toista(Aani.SEINAVAROITUS);
                return;
            }
        } else if (this.mato.getSuunta() == Suunta.ALAS) {
            if (this.korkeus - 1 - this.mato.getPaa().getY() <= 3) {
                this.toistaja.toista(Aani.SEINAVAROITUS);
                return;
            }
        } else if (this.mato.getSuunta() == Suunta.VASEN) {
            if (this.mato.getPaa().getX() <= 3) {
                this.toistaja.toista(Aani.SEINAVAROITUS);
                return;
            }
        } else if (this.mato.getSuunta() == Suunta.OIKEA) {
            if (this.leveys - 1 - this.mato.getPaa().getX() <= 3) {
                this.toistaja.toista(Aani.SEINAVAROITUS);
                return;
            }
        }
    }
    
}
