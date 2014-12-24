package aanimatopeli.aanet;

import java.io.File;

public enum Aani {

    SYOOMPPU("syoOmppu.wav"),
    OMPPUYLOS("omppuYlhaalla.wav"),
    OMPPUALAS("omppuAlhaalla.wav");
    
    private File tiedosto;
    
    private Aani(String tiedostonimi) {
        this.tiedosto = new File(tiedostonimi);
    }
    
    
    public File getTiedosto() {
        return this.tiedosto;
    }
}