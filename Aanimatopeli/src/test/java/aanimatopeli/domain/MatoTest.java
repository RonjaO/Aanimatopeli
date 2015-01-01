package aanimatopeli.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import aanimatopeli.Suunta;
import java.util.List;

public class MatoTest {

    private Mato mato;
    
    @Before
    public void setUp() {
        this.mato = new Mato(10, 8, Suunta.VASEN);
    }
    
    @Test
    public void madonPituusLuodessaOikein() {
        Assert.assertEquals(1, mato.getPituus());
    }
    
    @Test
    public void madonPituusKasvaaKunLiikutaan() {
        mato.liiku();
        mato.liiku();
        Assert.assertEquals(3, mato.getPituus());
    }
    
    @Test
    public void madonPituusEiKasvaYliKolmenJosEiKasvataMetodiaKutsuta() {
        mato.liiku();
        mato.liiku();
        mato.liiku();
        mato.liiku();
        mato.liiku();
        Assert.assertEquals(3, mato.getPituus());
    }
    
    @Test
    public void suuntaMuuttuu() {
        mato.setSuunta(Suunta.ALAS);
        Assert.assertEquals(Suunta.ALAS, mato.getSuunta());
    }
    
    @Test
    public void kasvaEiKasvataJosMatoAlleKolmen() {
        mato.liiku();
        mato.kasva();
        Assert.assertEquals(2, mato.getPituus());
    }
    
    @Test
    public void madonSijaintiOikeaKunLiikuttuVasemmalle() {
        mato.setSuunta(Suunta.VASEN);
        mato.liiku();
        mato.liiku();
        
        Assert.assertEquals("8,8", mato.getPalat().get(mato.getPituus() - 1).toString());
    }
    
    @Test
    public void madonPaanToStringOikeinLuodessa() {
        Assert.assertEquals("10,8", mato.getPalat().get(0).toString());
    }
    
    @Test
    public void matoLiikkuuOikeinKunSuuntanaAlas() {
        mato.setSuunta(Suunta.ALAS);
        mato.liiku();
        
        Assert.assertEquals("10,9", mato.getPalat().get(mato.getPituus() - 1).toString());
    }
    
    @Test
    public void matoTormaaItseensa() {
        mato.liiku();
        mato.setSuunta(Suunta.ALAS);
        mato.liiku();
        mato.setSuunta(Suunta.OIKEA);
        mato.kasva();
        mato.liiku();
        mato.setSuunta(Suunta.YLOS);
        mato.kasva();
        mato.liiku();
        
        Assert.assertEquals(true, mato.osuuItseensa());
    }
}