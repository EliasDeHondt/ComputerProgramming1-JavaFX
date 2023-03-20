package be.kdg.model;

import java.io.*;
import java.util.Properties;

import static java.lang.System.in;

public class PropertiesManager {
    private static final String PROP_FILE = "Application.properties";

    public static void writeProperties(SpelModel model) throws IOException {
       FileOutputStream out = new FileOutputStream(PROP_FILE);
       Properties properties = new Properties();

       properties.setProperty("Naam", String.valueOf(model.getNaam()));
       properties.setProperty("Level", String.valueOf(model.getLevel()));

       properties.storeToXML(out, "Instellingen van Mastermind");

       out.close();
    }

    public static void readProperties(SpelModel model) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(in);

        String naam = properties.getProperty("Naam");
        String level = properties.getProperty("Level");

        model.setNaam(naam);
        model.setLevel(Integer.parseInt(level));

        in.close();
    }
}

