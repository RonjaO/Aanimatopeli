package aanimatopeli.domain;

/**
 * Pala-luokka on tärkeä palanen sekä madon että omenan kannalta.
 */
public class Pala {

    private int x;
    private int y;
    
    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
/**
 * Tarkistetaan, osuuko pala johonkin toiseen palaan.
 * @param toinen Pala-olio
 * @return totuusarvo siitä, osuiko
 */
    public boolean osuu(Pala pala) {
        if (this.x == pala.getX() && this.y == pala.getY()) {
            return true;
        }
        
        return false;
    }
    
    public String toString() {
        return this.x + "," + this.y;
    }
    
}