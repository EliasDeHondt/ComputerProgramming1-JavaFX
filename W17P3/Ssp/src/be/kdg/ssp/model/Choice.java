package be.kdg.ssp.model;

public enum Choice {
    STEEN("Steen"), SCHAAR("Schaar"), PAPIER("Papier");

    private String tekst;

    Choice(String tekst) {
        this.tekst = tekst;
    }

    public String getTekst() {
        return this.tekst;
    }

    @Override
    public String toString() {
        return this.getTekst();
    }
}
