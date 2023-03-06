package be.kdg.mywoordle.model;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Modelklasse die alle filehandling doet
 */
public class WoordleFileManager {
    private List<Woord> woordleList;

    public WoordleFileManager() {
        readWoordleListFromFile();
    }

    private void readWoordleListFromFile() {
        woordleList = new ArrayList<>();
        //TODO: Gebruik een BufferedReader om de woordenlijst in te lezen
        //TODO: lees elke regel apart in en controleer of het een geschikt woord is: gebruik daarvoor de methode controleerWoord hieronder.
        //TODO: Alle geschikte woorden verzamel je in de ArrayList.

    }

    private boolean controleerWoord(String woord) {
        if (Character.isUpperCase(woord.charAt(0))) return false; //Geen eigennamen
        if (woord.length() != Woord.WOORD_LENGTE) return false; //enkel woorden van 5 letters
        for (char c : woord.toCharArray()) {
            if (!Character.isAlphabetic(c)) return false; //enkel alfabetische karakters
        }
        return true;
    }

    public Woord getRandomWoord() {
        return new Woord("test"); //woordleList.get(new Random().nextInt(woordleList.size()));
    }

    public boolean bestaatWoord(Woord woord) {
        return woordleList.contains(woord);
    }

    public void saveResultToFile(Woord woord, int beurten) {
        //TODO: Gebruik een PrintWriter om het resultaat aan het einde van het spel weg te schrijven naar een tekstbestand: woordleResults.log
        //TODO: zorg dat de nieuwe data achteraan in het bestand worden toegevoegd (append)
        //TODO: Schrijf weg in volgend formaat: "Op 2022-03-07 werd het woord RACES gevonden in 4 beurten"

    }
}

