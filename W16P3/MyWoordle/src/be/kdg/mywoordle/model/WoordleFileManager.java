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
        try {
            BufferedReader br = new BufferedReader(new FileReader("W16P3/MyWoordle/data/woordenlijst.txt"));
            String regel = br.readLine();
            while (regel != null) {

                if (Woord.controleerWoord(regel)) {
                    if (!Character.isUpperCase(regel.charAt(0))) {
                        woordleList.add(new Woord(regel));
                    }
                }
                regel = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Woord getRandomWoord() {
        return this.woordleList.get(new Random().nextInt(this.woordleList.size()));
    }

    public boolean bestaatWoord(Woord woord) {
        return this.woordleList.contains(woord);
    }

    public void saveResultToFile(Woord woord, int beurten) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("W16P3/MyWoordle/data/woordleResults.log", true)));
            pw.format("Op %s werd het woorf %s gevonden in %d beurten%n", LocalDate.now(), woord, beurten);
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

