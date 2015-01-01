package aanimatopeli.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PalaTest {

    private Pala pala;

    @Before
    public void setUp() {
        this.pala = new Pala(5, 2);
    }
    
    @Test
    public void toStringOikein() {
        Assert.assertEquals("5,2", pala.toString());
    }
    
    @Test
    public void palaOsuuToiseen() {
        Assert.assertEquals(true, pala.osuu(new Pala(pala.getX(), pala.getY())));
    }
    
    @Test
    public void palaEiOsu() {
        Assert.assertEquals(false, pala.osuu(new Pala(1, 6)));
    }
    
}