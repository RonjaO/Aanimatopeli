package aanimatopeli.pisteet;

/**
 * Laskee pelatessa pisteet
 */
public class Pistelaskuri {

    private int pisteet;
    
    public Pistelaskuri() {
        this.pisteet = 0;
    }
    
/**
 * Kasvattaa piste-muuttujan arvoa yhdellä
 */
    public void lisaaPiste() {
        this.pisteet++;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
/**
 * Asettaa pisteiden määräksi nollan
 */
    public void nollaa() {
        this.pisteet = 0;
    }

}
