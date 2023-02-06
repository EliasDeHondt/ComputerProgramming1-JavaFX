package model;

/**
 * Hier hoef je niets te wijzigen!
 */
public class Kleuren {
    private static final String[] COLOURS = {
            "cornsilk", "chartreuse", "orange",
            "darkkhaki", "goldenrod", "aquamarine",
            "silver", "burlywood", "orchid"
    };

    private int count = 0;

    public String getBackgroundColour() {
        // LET OP: voor de eenvoud van de oefening wordt er voorlopig met CSS gewerkt, dit hoort NIET thuis in een MODEL!
        String result = "-fx-background-color: " + COLOURS[count++];
        if (count >= COLOURS.length) {
            count = 0;
        }
        return result;
    }
}
