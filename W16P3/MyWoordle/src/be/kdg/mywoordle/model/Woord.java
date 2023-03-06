package be.kdg.mywoordle.model;

/**
 * De klasse Woord is eigenlijk een wrapperclass rond een String
 */
public class Woord implements Comparable<Woord>{
    public final static int WOORD_LENGTE = 5;
    private String woord;

    public Woord(String invoer) {
        //TODO: controleer de invoer die binnenkomt: mag niet null zijn, moet 5 letters lang zijn, mag geen cijfers bevatten
        //TODO: gooi een WoordleException indien niet goed.
        //TODO: Zet ook om naar hoofdletters

    }

    public String getWoord() {
        return woord;
    }

    public char getLetter(int pos) {
        if(pos < 0 || pos >= WOORD_LENGTE) {
            throw new WoordleException("Opgegeven positie valt buiten het bereik van het woord");
        }
        return woord.charAt(pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Woord other = (Woord) o;
        return woord.equals(other.woord);
    }

    @Override
    public int hashCode() {
        return woord.hashCode();
    }

    @Override
    public int compareTo(Woord other) {
        return this.woord.compareTo(other.woord);
    }

    @Override
    public String toString() {
        return woord;
    }
}
