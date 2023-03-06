import be.kdg.mywoordle.model.*;
import java.io.IOException;
import java.util.Scanner;

import static be.kdg.mywoordle.model.Woordle.AANTAL_BEURTEN;

/**
 * Tijdelijke consoleapplicatie om model te testen
 */
public class TestWoordle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Woordle woordle = new Woordle();
            System.out.println("te zoeken: " + woordle.getZoekWoord());
            while (!woordle.isWoordGevonden() && woordle.getBeurtenTeller() < Woordle.AANTAL_BEURTEN) {
                try {
                    System.out.printf("\nUw gok (%d): ", woordle.getBeurtenTeller() + 1);
                    String invoer = scanner.next();
                    Evaluatie[] evaluatie = woordle.evalueer(invoer);
                    System.out.println(invoer.toUpperCase());
                    for (Evaluatie feedback : evaluatie) {
                        System.out.print(feedback);
                    }
                }
                catch(WoordleException e) {
                    System.out.println("\nFoutieve invoer: " + e.getMessage());
                }
            }
            if(woordle.isWoordGevonden()) {
                System.out.printf("\nProficiat; gevonden in %d beurten!", woordle.getBeurtenTeller());
            }
            else {
                System.out.println("\nDe 6 beurten zijn voorbij");
            }
        } catch (WoordleException e) {
            e.printStackTrace();
        }
    }
}
