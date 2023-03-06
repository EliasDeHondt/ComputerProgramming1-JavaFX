import model.Berghut;
import model.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Deze klasse demonstreert het lezen en schrijven van data naar een tekstbestand.
 * De exception handling gebeurt in deze klasse.
 * Er wordt gebruik gemaakt van FileChooser als dialoogvenster.
 */
public class DemoBerghutten {
    public static void main(String[] args) {
        try {
            List<Berghut> berghuttenList = FileHandler.txtFile2List("W16P3/Berghutten/data/berghutten.txt");
            System.out.println("Ingelezen data:");
            for (Berghut berghut : berghuttenList) {
                System.out.println(berghut);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nTik de naam van de nieuwe berghut: ");
            String naam = scanner.nextLine();
            System.out.print("Locatie: ");
            String locatie = scanner.nextLine();
            System.out.print("Hoogte: ");
            int hoogte = scanner.nextInt();
            berghuttenList.add(new Berghut(naam, hoogte, locatie));
            FileHandler.list2TxtFile(berghuttenList, "data/berghutten.txt");
            System.out.println("Nieuw record toegevoegd en weggeschreven.");

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
