package aanimatopeli.peli;

import aanimatopeli.Suunta;
import aanimatopeli.domain.Mato;
import aanimatopeli.domain.Pala;
import aanimatopeli.domain.Omena;
import java.util.List;
import java.util.Random;

public class Matopeli {

    private int leveys;
    private int korkeus;
    private Mato mato;
    private Pala omena;
    private Random random = new Random();
    
    public Matopeli(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.mato = new Mato(0, korkeus / 2, Suunta.OIKEA);
        this.omena = new Omena(random.nextInt(leveys), random.nextInt(korkeus));
    }
    
}