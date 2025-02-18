
import Model.Charakter;
import Model.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }
    public Console() {}

    public void setController(Controller controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. Alles anschreiben
                    2. Produkt CRUD
                    3. Kunde CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {controller.alleCharacterAnsehen();
                    controller.alleProdukteAnschreiben();
                    break;}

                case 2: {
                    System.out.println("""
                            1. Neues Produkt hinzufugen
                            2. Alle Produkte sehen
                            3. Ein bestimmtes Produkt finden
                            4. Ein Produkt aktualisieren
                            5. Ein Produkt loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createProdukt(); break;}
                        case 2: {controller.alleProdukteAnschreiben(); break;}
                        case 3: {controller.showAProdukt(); break;}
                        case 4: {controller.updateProduktValidate(); break;}
                        case 5: {controller.deleteProdukt(); break;}
                        case 0:break;
                    }
                }

                case 3:
                {
                    System.out.println("""
                            1. Neuer Character hinzufugen
                            2. Alle Character sehen
                            3. Einen bestimmten Character finden
                            4. Einen Character aktualisieren
                            5. Einen Character loschen
                            6. Character nach Ort filtrieren
                            7. Kunden finden, die ein Produkt in einer gegebenen Jahreszeit gekauft haben
                            8. Sortiere Produkte eines Kunden nach Preis
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createCharacter(); break;}
                        case 2: {controller.alleCharacterAnsehen(); break;}
                        case 3: {controller.showCharacter(); break;}
                        case 4: {controller.updateCharacterValidate(); break;}
                        case 5: {controller.deleteCharacter(); break;}
                        case 6: {controller.CharacterNachOrtFiltrieren(); break;}
                        case 7: {controller.CharacterNachOrtFiltrieren(); break;}
                        case 8: {controller.CharacterNachOrtFiltrieren(); break;}
                        case 0:break;
                    }
                }

                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkt> produktRepository = new Repository<>();
        Repository<Charakter> charakterRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(charakterRepository,produktRepository);

        Service service = new Service(charakterRepository, produktRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Charakter> charakterRepository, Repository<Produkt> produktRepository) {
        List<Produkt> produkte = new ArrayList<>();
        produkte.add(new Produkt("Kunai", 50.0, "Konoha"));
        produkte.add(new Produkt("Shuriken", 30.0, "Konoha"));
        produkte.add(new Produkt("Schwert", 200.0, "Kirigakure"));
        produkte.add(new Produkt("Heiltrank", 100.0, "Sunagakure"));
        produkte.add(new Produkt("Sprengsiegel", 75.0, "Iwagakure"));
        produkte.add(new Produkt("Riesenfächer", 300.0, "Sunagakure"));
        produkte.add(new Produkt("Giftklinge", 150.0, "Kirigakure"));
        produkte.add(new Produkt("Explosionskugel", 250.0, "Iwagakure"));
        produkte.add(new Produkt("Schattendolch", 180.0, "Konoha"));
        produkte.add(new Produkt("Wasserperle", 90.0, "Kirigakure"));

        // Initialisierung der Charaktere
        List<Charakter> charaktere = new ArrayList<>();

        Charakter c1 = new Charakter(1, "Naruto Uzumaki", "Konoha");
        c1.kaufeProdukt(produkte.get(0)); // Kunai
        c1.kaufeProdukt(produkte.get(3)); // Heiltrank
        c1.kaufeProdukt(produkte.get(8)); // Schattendolch
        c1.kaufeProdukt(produkte.get(5)); // Riesenfächer

        Charakter c2 = new Charakter(2, "Gaara", "Sunagakure");
        c2.kaufeProdukt(produkte.get(2)); // Schwert
        c2.kaufeProdukt(produkte.get(4)); // Sprengsiegel
        c2.kaufeProdukt(produkte.get(6)); // Giftklinge
        c2.kaufeProdukt(produkte.get(1)); // Shuriken

        Charakter c3 = new Charakter(3, "Kisame Hoshigaki", "Kirigakure");
        c3.kaufeProdukt(produkte.get(1)); // Shuriken
        c3.kaufeProdukt(produkte.get(2)); // Schwert
        c3.kaufeProdukt(produkte.get(3)); // Heiltrank
        c3.kaufeProdukt(produkte.get(7)); // Explosionskugel
        c3.kaufeProdukt(produkte.get(9)); // Wasserperle

        Charakter c4 = new Charakter(4, "Deidara", "Iwagakure");
        c4.kaufeProdukt(produkte.get(0)); // Kunai
        c4.kaufeProdukt(produkte.get(4)); // Sprengsiegel
        c4.kaufeProdukt(produkte.get(7)); // Explosionskugel
        c4.kaufeProdukt(produkte.get(9)); // Wasserperle

        Charakter c5 = new Charakter(5, "Itachi Uchiha", "Konoha");
        c5.kaufeProdukt(produkte.get(8)); // Schattendolch
        c5.kaufeProdukt(produkte.get(6)); // Giftklinge
        c5.kaufeProdukt(produkte.get(2)); // Schwert
        c5.kaufeProdukt(produkte.get(7)); // Explosionskugel

        charaktere.add(c1);
        charaktere.add(c2);
        charaktere.add(c3);
        charaktere.add(c4);
        charaktere.add(c5);
    }
}
