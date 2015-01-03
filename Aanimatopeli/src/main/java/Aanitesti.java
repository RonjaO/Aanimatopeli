import aanimatopeli.aanet.Aantentoistaja;
import aanimatopeli.aanet.Aani;
import aanimatopeli.domain.Pala;
import aanimatopeli.domain.Mato;
import aanimatopeli.domain.Omena;
import java.util.Scanner;
import aanimatopeli.Suunta;

public class Aanitesti {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        Mato mato = new Mato(10, 10, Suunta.OIKEA);
        Pala omena = new Omena(15, 15);
        
        Aantentoistaja toistaja = new Aantentoistaja();
        toistaja.setMato(mato);
        toistaja.setOmena(omena);
        
        while (true) {
            String komento = lukija.nextLine();
            
            if (komento.equals("sammuta")) {
                break;
            }
            
            if (komento.equals("start")) {
                toistaja.suunta();
            }
            
            if (komento.equals("lopeta")) {
                toistaja.lopeta(Aani.OMPPUALAS);
                toistaja.lopeta(Aani.OMPPUOIKEA);
            }
            
            if (komento.equals("omppu")) {
                toistaja.toista(Aani.SYOOMPPU);
            }
        }
    }
    
}