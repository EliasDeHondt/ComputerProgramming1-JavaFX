package be.kdg.model;

/**
 * In deze modelklasse zit de spelintelligentie die te maken heeft met het plaatsen van
 * een schijf op het bord. Ook controle daarop en check op 4 op een rij
 */
public class SpelBord {
    public static final int RIJEN = 6;
    public static final int KOLOMMEN = 7;
    private Schijf[][] bord;


    public SpelBord() {
        bord = new Schijf[RIJEN][KOLOMMEN];
    }

    public boolean doeZet(Schijf schijf, int r, int k) {
        if (controleerLocatie(r, k)) {
            bord[r][k] = schijf;
            return true;
        }
        return false;
    }

    public boolean controleerLocatie(int r, int k) {
        if (r < 0 || r >= RIJEN) return false; //buiten range
        if (k < 0 || k > KOLOMMEN) return false; //buiten range
        if (bord[r][k] != null) return false; //vakje al bezet
        if (r == RIJEN - 1) return true; //onderste rij is altijd goed
        if (bord[r + 1][k] == null) return false; //er is eronder nog een leeg vakje; dat mag niet
        return true;
    }

    public boolean checkGewonnen(Schijf schijf, int r, int k) {
        if (checkHorizontaal(schijf, r)
                || checkVerticaal(schijf, r, k)
                || checkDiagonaal(schijf, r, k)) {
            return true;
        }
        return false;
    }

    private boolean checkDiagonaal(Schijf schijf, int r, int k) {
        //check diagonaal rechts:
        for (int i = 0; i < RIJEN - 3; i++) {
            for (int j = 0; j < KOLOMMEN - 3; j++) {
                if (bord[i][j] == schijf
                        && bord[i + 1][j + 1] == schijf
                        && bord[i + 2][j + 2] == schijf
                        && bord[i + 3][j + 3] == schijf) {
                    return true;
                }
            }
        }

        //check diagonaal links:
        for (int i = 0; i < RIJEN - 3; i++) {
            for (int j = 3; j < KOLOMMEN; j++) {
                if (bord[i][j] == schijf
                        && bord[i + 1][j - 1] == schijf
                        && bord[i + 2][j - 2] == schijf
                        && bord[i + 3][j - 3] == schijf) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVerticaal(Schijf schijf, int r, int k) {
        if (r > 2) return false; //er moeten minstens 4 rijen zijn
        for (int i = r; i < RIJEN - 3; i++) {
            if (bord[i][k] == schijf
                    && bord[i + 1][k] == schijf
                    && bord[i + 2][k] == schijf
                    && bord[i + 3][k] == schijf) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontaal(Schijf schijf, int r) {
        for (int j = 0; j < KOLOMMEN - 3; j++) {
            if (bord[r][j] == schijf
                    && bord[r][j + 1] == schijf
                    && bord[r][j + 2] == schijf
                    && bord[r][j + 3] == schijf) {
                return true;
            }
        }
        return false;
    }

    public Schijf[][] getBord() {
        return bord;
    }
}

