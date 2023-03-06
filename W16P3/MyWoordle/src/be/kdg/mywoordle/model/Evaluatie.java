package be.kdg.mywoordle.model;

/**
 * Evaluatie van 1 letter:
 * ofwel juiste letter op juiste plek
 * ofwel juiste letter maar op foute plek
 * ofwel foute letter (komt niet voor in het woord
 */
public enum Evaluatie {
    JUIST, FOUTE_PLEK, FOUT;

    @Override
    public String toString() {
        return switch (this.ordinal()) {
            case 0 -> "J";
            case 1 -> "P";
            default -> "F";
        };
    }
}
