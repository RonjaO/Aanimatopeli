package aanimatopeli.domain;

import java.util.List;
import java.util.ArrayList;
import aanimatopeli.Suunta;


/**
 * Pelin mato. Koostuu paloista.
 */
public class Mato {

    private List<Pala> palat;
    private int x;
    private int y;
    private Suunta suunta;
    private boolean kasvaKutsuttu;

    public Mato(int x, int y, Suunta suunta) {
        this.x = x;
        this.y = y;
        this.suunta = suunta;
        this.palat = new ArrayList<Pala>();
        
        this.palat.add(new Pala(x, y));
        this.kasvaKutsuttu = false;
    }
    
    public Suunta getSuunta() {
        return this.suunta;
    }
    
    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }
    
    public int getPituus() {
        return this.palat.size();
    }
    
/**
 * @return lista paloista, joista mato muodostuu
*/ 
    public List<Pala> getPalat() {
        return this.palat;
    }
  
/**
 * Liikuttaa matoa suunta-muuttujan mukaisesti
 * luo aina uuden pään uuteen sijaintiin
 */ 
    public void liiku() {
        int paanX = this.palat.get(this.palat.size() - 1).getX();
        int paanY = this.palat.get(this.palat.size() - 1).getY();
        
        if (this.suunta == Suunta.VASEN) {
            this.palat.add(new Pala(paanX - 1, paanY));
        } else if (this.suunta == Suunta.OIKEA) {
            this.palat.add(new Pala(paanX + 1, paanY));
        } else if (this.suunta == Suunta.ALAS) {
            this.palat.add(new Pala(paanX, paanY + 1));
        } else if (this.suunta == Suunta.YLOS) {
            this.palat.add(new Pala(paanX, paanY - 1));
        }
        
        if (this.kasvaKutsuttu) {
            this.kasvaKutsuttu = false;
        } else if (this.palat.size() < 4) {
            return;
        } else {
            this.palat.remove(0);
        }
            
    }
    
/**
 * Kasvattaa madon pituutta yhdellä
 * tiettyjä poikkeustilanteita lukuunottamatta
 */
    public void kasva() {
        if (getPituus() < 3) {
            return;
        }
        
        this.kasvaKutsuttu = true;
    }
    
/**
 * Selvittää, osuuko mato annettuun palaan
 * @param pala (yleisimmin omena)
 * @return totuusarvo siitä, osuiko vai eikö
 */ 
    public boolean osuu(Pala pala) {
        for (Pala madonPala : this.palat) {
            if (madonPala.osuu(pala)) {
                return true;
            }
        }
        
        return false;
    }
    
/**
 * Selvittää, osuuko jokin madon paloista itseensä
 * @return totuusarvo siitä, osuiko vai eikö
 */
    public boolean osuuItseensa() {
        for (Pala tutkittava : this.palat) {
            for (Pala pala : this.palat) {
                if (tutkittava == pala) {
                    continue;
                }
                
                if (tutkittava.osuu(pala)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
/**
 * @return madon pään Pala-esitys
*/ 
    public Pala getPaa() {
        return this.palat.get(getPituus() - 1);
    }
    
}
