package be.kdg.dictee.model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 * @author Van Elias De Hondt
 * 6/02/2023
 */

public class Dictee {
    // Attributes
    private String voiceName;
    private String tekst = "No text";
    // Constructors
    public Dictee() {
        System.setProperty("freetts.voices",
                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        this.voiceName = "kevin16";
    }
    // Methods
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
    public void leesVoor() {
        Voice voice = VoiceManager.getInstance().getVoice(voiceName);
        voice.allocate();
        voice.speak(tekst);
        voice.deallocate();
    }
}