package aanimatopeli.peli;

import aanimatopeli.Suunta;
import aanimatopeli.domain.Mato;
import aanimatopeli.domain.Pala;
import aanimatopeli.domain.Omena;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JTextArea;
import aanimatopeli.aanet.Aani;
import aanimatopeli.aanet.Aantentoistaja;
import aanimatopeli.gui.AaniIlmoitin;
import aanimatopeli.gui.Nappaimistonkuuntelija;
import aanimatopeli.pisteet.Pistelaskuri;
import aanimatopeli.pisteet.Pistehallinnoija;

/**
 * Pelilogiikka
 */
public class Matopeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private Mato mato;
    private Pala omena;
    private boolean jatkuu;
    private Random random = new Random();
    private Aantentoistaja toistaja;
    private AaniIlmoitin ilmoitin;
    private JTextArea tekstikentta;
    private Nappaimistonkuuntelija nappaimistonkuuntelija;
    private Pistelaskuri laskuri;

    public Matopeli(int leveys, int korkeus, Aantentoistaja toistaja) {
        super(2000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        this.mato = new Mato(0, korkeus / 2, Suunta.OIKEA);
        this.omena = luoOmena();
        this.toistaja = toistaja;
        
        this.ilmoitin = new AaniIlmoitin(this.mato, this.omena, this.leveys, this.korkeus, this.toistaja);
        this.laskuri = new Pistelaskuri();
        
        addActionListener(this);
        setInitialDelay(1000);
        
    }

/**
 * Plauattaa totuusarvon siitä, jatkuuko peli
 * @return pelin jatkumisen totuusarvo
 */
    public boolean jatkuu() {
        return this.jatkuu;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getLeveys() {
        return this.leveys;
    }

/**
 * Kutsuu metodia, joka määrittää yhden liikahduksen tapahtumat
 */
    @Override 
    public void actionPerformed(ActionEvent ae) {
        liikahdus();
    }
    
    public Mato getMato() {
        return this.mato;
    }
    
    public void setMato() {
        this.mato = mato;
    }
    
    public Pala getOmena() {
        return this.omena;
    }
    
    public void setOmena(Omena omena) {
        this.omena = omena;
    }
    
/**
 * Luo uuden omena-olion. Tarkistaa luomisen yhteydessä, ettei omena osu matoon.
 * @return palautetaan uusi omena.
 */
    public Omena luoOmena() {
        Omena omena = null;
        while (true) {
            int x = 1 + random.nextInt(this.leveys) - 1;
            int y = 1 + random.nextInt(this.korkeus) - 1;

            omena = new Omena(x, y);

            if (this.mato.osuu(omena)) {
                continue;
            } else {
                break;
            }
        }

        return omena;
    }

/**
 * Määrittää yhden liikahduksen tapahtumat
 * Peli jatkuu, jos jatkuu-muuttuja on true
 */
    public void liikahdus() {
        if (!jatkuu()) {
            this.stop();
            this.toistaja.lopeta(Aani.OMPPUYLOS);
            this.toistaja.lopeta(Aani.OMPPUALAS);
            this.toistaja.lopeta(Aani.OMPPUOIKEA);
            this.toistaja.lopeta(Aani.OMPPUVASEN);
            peliPaattyi();
            return;
        }
        
        this.ilmoitin.suunta();
        this.ilmoitin.varoitukset();

        this.mato.liiku();
        
        this.ilmoitin.suunta();
        
        if (this.mato.osuu(this.omena)) {
            this.toistaja.toista(Aani.SYOOMPPU);
            this.toistaja.lopeta(Aani.OMPPUYLOS);
            this.toistaja.lopeta(Aani.OMPPUALAS);
            this.toistaja.lopeta(Aani.OMPPUVASEN);
            this.toistaja.lopeta(Aani.OMPPUOIKEA);
            
            this.mato.kasva();
            this.omena = luoOmena();
            this.ilmoitin.setOmena(this.omena);
            this.laskuri.lisaaPiste();
            this.setInitialDelay(1000 / this.mato.getPituus());
        }
        
        if (this.mato.osuuItseensa()) {
            this.toistaja.toista(Aani.TORMAAITSEENSA);
            this.jatkuu = false;
        }
      
        Pala madonPaa = this.mato.getPaa();
        
        if (madonPaa.getX() < 0 || madonPaa.getX() >= this.leveys) {
            this.jatkuu = false;
            this.toistaja.toista(Aani.TORMAYS);
        } else if (madonPaa.getY() < 0 || madonPaa.getY() >= this.korkeus) {
            this.jatkuu = false;
            this.toistaja.toista(Aani.TORMAYS);
        }
    }
    
    public void setTekstikentta(JTextArea tekstikentta) {
        this.tekstikentta = tekstikentta;
    }
    
    public void setNappaimistonkuuntelija(Nappaimistonkuuntelija kuuntelija) {
        this.nappaimistonkuuntelija = kuuntelija;
    }
    
/**
 * Kutsutaan, kun peli on päättynyt.
 * Kertoo käyttöliittymän tekstikentälle saadun pistemäärän
 * ja antaa pisteet myös pistehallinnoijalle
 */
    public void peliPaattyi() {
        this.tekstikentta.setText("Peli päättyi! \n \n Sait " + this.laskuri.getPisteet() + " pistettä");
        
        Pistehallinnoija hallinnoija = null;
        try {
            hallinnoija = new Pistehallinnoija();
        } catch (Exception e) {
            System.out.println("Tiedostoa ei loydy");
        }
        
        hallinnoija.lisaaPisteet(this.laskuri.getPisteet());
        
        try {
            hallinnoija.tallennaPisteetTiedostoon();
        } catch (Exception e) {
            System.out.println("tiedostoon tallentaminen ei onnistu");
        }
    }
    
/**    
 * Tekee tarvittavat toimenpiteet, jotta voidaan aloittaa uusi peli
 */
    public void aloitaUusiPeli() {
        if (this.jatkuu == false) {
            this.mato = new Mato(0, this.korkeus / 2, Suunta.OIKEA);
            this.omena = luoOmena();
            this.jatkuu = true;
        
            this.laskuri.nollaa();
            this.ilmoitin.setOmena(this.omena);
            this.ilmoitin.setMato(this.mato);
            this.nappaimistonkuuntelija.setMato(this.mato);
        }
    }
        
}
