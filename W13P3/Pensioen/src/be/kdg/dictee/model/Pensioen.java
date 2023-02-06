package be.kdg.dictee.model;

/* Hier mag je niets aan wijzigen! */
public class Pensioen {
    private static final int PENSIOEN_LEEFTIJD = 65;
    private int geboorteJaar;
    public void setGeboorteJaar(int geboorteJaar) {
        this.geboorteJaar = geboorteJaar;
    }
    public int getPensioenJaar() {
        return geboorteJaar + PENSIOEN_LEEFTIJD;
    }
}
