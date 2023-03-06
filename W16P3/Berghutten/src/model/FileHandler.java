package model;

import java.io.*;
import java.util.*;

/**
 * De klassen model.FileHandler bevat 4 static methoden om een tekst/binair bestand in te lezen naar een ArrayList
 * En omgekeerd om een ArrayList weg te schrijven naar een binair/tekst bestand.
 */
public class FileHandler {
    public static List<Berghut> txtFile2List(String bestand) throws IOException {
        List<Berghut> list = new ArrayList<>();
        String regel = "";
        try (BufferedReader br = new BufferedReader(new FileReader(bestand))) {
            regel = br.readLine();
            while (regel != null) {
                String[] tokens = regel.split("#");
                String naam = tokens[0];
                int hoogte = Integer.parseInt(tokens[1]);
                String locatie = tokens[2];
                Berghut berghut = new Berghut(naam, hoogte, locatie);
                list.add(berghut);
                regel = br.readLine(); // het volgende record lezen
            }
            // list sorteren op naam (zie compareTo in klasse Berghut)
            Collections.sort(list);
            return list;
        } catch (NoSuchElementException | NumberFormatException e1) {
            throw new IOException("Leesfout in regel: " + regel, e1);
        } catch (IOException e2) {
            throw new IOException("Het bronbestand " + bestand + " kan niet geopend worden", e2);
        }
    }

    public static void list2TxtFile(List<Berghut> list, String bestand) throws IOException {
        Collections.sort(list);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(bestand)))) {
            for (Berghut hut : list) {
                pw.printf("%s#%d#%s%n", hut.getNaam(), hut.getHoogte(), hut.getLocatie());
            }
        } catch (IOException e) {
            throw new IOException("Problemen bij het wegschrijven naar het doelbestand " + bestand, e);
        }

    }
}
