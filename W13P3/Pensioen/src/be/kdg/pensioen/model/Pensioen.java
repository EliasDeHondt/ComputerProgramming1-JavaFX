package be.kdg.pensioen.model;

/* Hier mag je niets aan wijzigen! */
public class Pensioen {
    // Attributes
    private static final int PENSIOEN_LEEFTIJD = 65;
    private int geboorteJaar;
    // Constructors
    // Methods
    public void setGeboorteJaar(int geboorteJaar) {
        this.geboorteJaar = geboorteJaar;
    }
    public int getPensioenJaar() {
        return this.geboorteJaar + PENSIOEN_LEEFTIJD;
    }
}
