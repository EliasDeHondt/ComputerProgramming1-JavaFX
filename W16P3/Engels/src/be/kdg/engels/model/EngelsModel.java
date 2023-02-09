package be.kdg.engels.model;

import java.util.HashMap;
import java.util.Map;

public class EngelsModel {
    private final Map<String, Double> data;

    public EngelsModel() {
        this.data = new HashMap<>();
        this.data.put("School", 5.0);
        this.data.put("Boeken", 5.0);
        this.data.put("Games", 90.0);
    }

    public Map<String, Double> getData() {
        return this.data;
    }
}
