package be.kdg.model;

/**
 * Hoofdmodelklasse die door de presenter zal worden aangesproken.
 * Hier wordt oa bepaald wie er aan de beurt is en wie er gewonnen heeft
 */
public class VierOpRij {
    private SpelBord spelbord;
    private Schijf aanDeBeurtKleur;
    private boolean isSpelGedaan;

    public VierOpRij() {
        reset();
    }

    public void reset() {
        spelbord = new SpelBord();
        aanDeBeurtKleur = Schijf.GEEL; //Geel begint
        isSpelGedaan = false;
    }

    public boolean isGeldigeZet(int rij, int kolom) {
        return spelbord.controleerLocatie(rij, kolom);
    }

    public void plaatsSchijf(int rij, int kolom) {
        spelbord.doeZet(aanDeBeurtKleur, rij, kolom);
        if(spelbord.checkGewonnen(aanDeBeurtKleur, rij, kolom)) {
            isSpelGedaan = true;
        }
        else {
            aanDeBeurtKleur = (aanDeBeurtKleur == Schijf.GEEL) ? Schijf.ROOD : Schijf.GEEL;
        }
    }

    public Schijf wieIsAanZet() {
        return aanDeBeurtKleur;
    }

    public boolean isSpelGedaan() {
        return isSpelGedaan;
    }

    public Schijf getWinnaar() {
        if(isSpelGedaan) return aanDeBeurtKleur;
        return null;
    }

    public Schijf[][] getSpelbord() {
        return spelbord.getBord();
    }
}
