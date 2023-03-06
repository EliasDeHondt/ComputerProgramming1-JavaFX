package be.kdg.mywoordle.model;

/**
 * De klasse Woord is eigenlijk een wrapperclass rond een String
 */
public class Woord implements Comparable<Woord>{
    public final static int WOORD_LENGTE = 5;
    private final String woord;

    public Woord(String invoer) {
        if (!controleerWoord(invoer)) {
            throw new WoordleException("Het woord moet 5 karkters zijn");
        }
        this.woord =  invoer.toUpperCase();
    }
    public static boolean controleerWoord(String invoer) {
        if (invoer == null) return false;
        invoer = invoer.toUpperCase();
        if (invoer.length() != WOORD_LENGTE) return false;
        for(int i  = 0; i < invoer.length(); i++) {
            if (invoer.charAt(i) < 'A' || invoer.charAt(i) >'Z') return false;
        }
        return true;
    }

    public String getWoord() {
        return this.woord;
    }

    public char getLetter(int pos) {
        if(pos < 0 || pos >= WOORD_LENGTE) {
            throw new WoordleException("Opgegeven positie valt buiten het bereik van het woord");
        }
        return this.woord.charAt(pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Woord other = (Woord) o;
        return this.woord.equals(other.woord);
    }

    @Override
    public int hashCode() {
        return this.woord.hashCode();
    }

    @Override
    public int compareTo(Woord other) {
        return this.woord.compareTo(other.woord);
    }

    @Override
    public String toString() {
        return this.woord;
    }
}
