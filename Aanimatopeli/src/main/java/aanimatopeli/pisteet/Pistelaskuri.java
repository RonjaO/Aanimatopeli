package aanimatopeli.pisteet;

public class Pistelaskuri {

    private int pisteet;
    
    public Pistelaskuri() {
        this.pisteet = 0;
    }
    
    public void lisaaPiste() {
        this.pisteet++;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
}
