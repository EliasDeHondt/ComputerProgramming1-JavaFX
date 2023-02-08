package be.kdg.scramble.model;

import java.util.*;

//HET MODEL IS GEGEVEN EN MAG NIET AANGEPAST WORDEN
public class Scrambler {
    // Attributes
    private String tekst = "test";
    // Constructors
    // Methods
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
    public String getTekst() {
        return this.tekst;
    }
    public void scramble(){
        List<String> letters = Arrays.asList(tekst.split(""));
        Collections.shuffle(letters);
        this.tekst = "";
        for (String letter: letters) {
            tekst += letter;
        }
    }
}
