package be.kdg;

import java.util.Properties;

public class TestSystemProperties {
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        System.out.println("LAND: " + prop.getProperty("user.country"));
        System.out.println("NAAM: " + prop.getProperty("user.name"));
        System.out.println("HUIDIGE DIR: " + prop.getProperty("user.dir"));
        System.out.println("TAAL: " + prop.getProperty("user.language"));
        System.out.println("OS: " + prop.getProperty("os.name"));

        System.out.println("\nALL PROPERTIES:");
        // TODO: Druk in een lus alle system properties af, samen met hun actuele value
        for(String key : prop.stringPropertyNames()) {
            System.out.printf("%-30s -> %s\n", key, prop.getProperty(key));
        }

    }
}
