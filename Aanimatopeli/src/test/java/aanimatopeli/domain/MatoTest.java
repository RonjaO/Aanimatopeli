package aanimatopeli.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class MatoTest {

    private Mato mato;
    
    @Before
    public void setUp() {
        this.mato = new Mato(10, 10, Suunta.VASEN);
    }
    
    @Test
    public void madonPituusLuodessaOikein() {
        Assert.assertEquals(1, mato.getPituus());
    }
    
}