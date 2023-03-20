package be.kdg.model;

import java.io.IOException;

public class SpelModel {
    private int level;
    private String naam;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void saveSettings() throws IOException {
        PropertiesManager.writeProperties(this);
    }

    public void readSettings() throws IOException {
        PropertiesManager.readProperties(this);
    }
}
