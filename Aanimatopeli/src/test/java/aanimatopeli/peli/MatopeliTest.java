package aanimatopeli.peli;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import aanimatopeli.Suunta;


public class MatopeliTest {

    private Matopeli matopeli;

    @Before
    public void setUp() {
        this.matopeli = new Matopeli(20, 20, new Aantentoistaja());
    }
    
    @Test
    public void alussaJatkuuOikein() {
        Assert.assertEquals(true, this.matopeli.jatkuu());
    }
    
    @Test
    public void omenaEiOsuMaatoonLuodessa() {
        Assert.assertEquals(false, this.matopeli.getMato().osuu(matopeli.luoOmena()));
    }
    
    @Test
    public void peliEiJAtkuJosMatoOsuuSeinaan() {
        for (int i = 0; i < 20; i++) {
            this.matopeli.getMato().liiku();
        }
        this.matopeli.start();
        Assert.assertEquals(false, this.matopeli.jatkuu());
    }
    
    @Test
    public void peliPaattyyKunMatoOsuuItseensa() {
        this.matopeli.getMato().liiku();
        this.matopeli.getMato().setSuunta(Suunta.YLOS);
        this.matopeli.getMato().liiku();
        this.matopeli.getMato().setSuunta(Suunta.VASEN);
        this.matopeli.getMato().liiku();
        this.matopeli.getMato().setSuunta(Suunta.ALAS);
        this.matopeli.start();
        
        Assert.assertEquals(false, this.matopeli.jatkuu());
    }
    
}
