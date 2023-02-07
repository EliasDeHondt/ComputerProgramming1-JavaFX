package be.kdg.dobbelen.model;

import java.util.Random;

public class Dobbelen {
    public static final int MAX_AANTAL_OGEN = 6;
    public static final int MAX = 5;

    private int aantalOgen1;
    private int aantalOgen2;
    private Random random;

    public Dobbelen() {
        this.aantalOgen1 = 1;
        this.aantalOgen2 = 1;
        this.random = new Random();
    }

    public void werp(){
        this.aantalOgen1 = this.random.nextInt(MAX_AANTAL_OGEN) + 1;
        this.aantalOgen2 = this.random.nextInt(MAX_AANTAL_OGEN) + 1;
    }

    public int getAantalOgen1() {
        return this.aantalOgen1;
    }

    public int getAantalOgen2() {
        return this.aantalOgen2;
    }
}
