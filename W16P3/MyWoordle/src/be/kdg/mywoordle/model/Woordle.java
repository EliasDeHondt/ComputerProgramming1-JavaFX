package be.kdg.mywoordle.model;

/**
 * De hoofd-modelklasse die door de presenter zal worden aangesproken
 */
public class Woordle {
    public static final int AANTAL_BEURTEN = 6;
    private Woord zoekWoord;
    private int beurtenTeller;
    private WoordleFileManager woordleFileManager;
    private boolean woordGevonden;

    public Woordle() {
        this.woordleFileManager = new WoordleFileManager();
        this.zoekWoord = this.woordleFileManager.getRandomWoord();
    }

    public Evaluatie[] evalueer(String invoer) {
        Woord gok = new Woord(invoer);
        //Een array van evaluatie; voor elke letter één:
        Evaluatie[] evaluatie = {Evaluatie.FOUT, Evaluatie.FOUT, Evaluatie.FOUT, Evaluatie.FOUT, Evaluatie.FOUT};
        if(!woordleFileManager.bestaatWoord(gok)) {
            throw new WoordleException("Dit is geen geldig Nederlands woord!");
        }
        beurtenTeller++;
        if (gok.equals(zoekWoord)) {
            woordGevonden = true;
            woordleFileManager.saveResultToFile(gok, beurtenTeller);
            return new Evaluatie[]{Evaluatie.JUIST, Evaluatie.JUIST, Evaluatie.JUIST, Evaluatie.JUIST, Evaluatie.JUIST};
        } else {
            //Op zoek naar juiste letters op juiste plek:
            for (int i = 0; i < Woord.WOORD_LENGTE; i++) {
                if (gok.getLetter(i) == zoekWoord.getLetter(i)) {
                    evaluatie[i] = Evaluatie.JUIST;
                }
            }

            //Op zoek naar juiste letters op verkeerde plek:
            for (int i = 0; i < Woord.WOORD_LENGTE; i++) {
                if (gok.getLetter(i) != zoekWoord.getLetter(i)) {
                    boolean eldersGevonden = false;
                    for (int j = 0; j < Woord.WOORD_LENGTE && !eldersGevonden; j++) {
                        if (gok.getLetter(j) == zoekWoord.getLetter(i) && evaluatie[j] != Evaluatie.JUIST ) {
                            evaluatie[j] = Evaluatie.FOUTE_PLEK;
                            eldersGevonden = true;
                        }
                    }
                }
            }

            return evaluatie;
        }
    }

    public int getBeurtenTeller() {
        return beurtenTeller;
    }

    public boolean isWoordGevonden() {
        return woordGevonden;
    }

    public boolean isSpelGedaan() {
        return woordGevonden || beurtenTeller >= AANTAL_BEURTEN;
    }

    //alleen om te testen:
    public Woord getZoekWoord() {
        return zoekWoord;
    }
}
