import Model.Charakter;
import Model.Produkt;

import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void alleProdukteAnschreiben(){
        for (Produkt produkt: service.alleProdukteZuruckgeben())
            System.out.println(produkt);
    }
    public void alleCharacterAnsehen(){
        for (Charakter charakter: service.alleCharakterZuruckgeben())
            System.out.println(charakter);
    }

    public void createProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Ort");
        String ort = sc.nextLine();

        service.createAProdukt(name, preis, ort);
    }

    public void showAProdukt(){
        System.out.println("Gebe den Namen des Produktes ein: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Produkt produkt = service.getProdukt(name);
        System.out.println(produkt);
    }

    public void updateProduktValidate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geandert werden soll: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Ort:");
        String ort = sc.nextLine();

        service.updateProdukt(new Produkt(name, preis, ort));
    }

    public void deleteProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geloescht werden soll: ");
        String name = sc.nextLine();
        service.deleteProdukt(name);
    }


    public void createCharacter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Ort: ");
        String ort = sc.nextLine();

        service.createACharacter(name,ort);
    }

    public void showCharacter(){
        for (Charakter charakter: service.alleCharakterZuruckgeben())
            System.out.println(charakter);

        System.out.println("ID des Character:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(service.getKunde(id));
    }

    public void updateCharacterValidate(){
        Scanner sc = new Scanner(System.in);

        System.out.println("ID des Character, das geandert werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Neuer Name: ");
        String name = sc.nextLine();
        System.out.println("Neuer Ort: ");
        String ort = sc.nextLine();

        Charakter charakter = new Charakter(id,name,ort);
        service.updateCharacter(charakter);
    }

    public void deleteCharacter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID des Character, der geloescht werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();
        service.deleteCharacter(id);
    }

    public void CharacterNachOrtFiltrieren(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ort: ");
        String ort = sc.nextLine();
        for (Charakter charakter: service.filterNachOrt(ort))
            System.out.println(charakter);
    }

    public void CharacterNachProductFilter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Product Name: ");
        String ort = sc.nextLine();
        for (Charakter charakter: service.alleCharakterZuruckgeben())
            for (Produkt produkt : charakter.getProdukten()){
                if(produkt.getHerrkunftregion().equalsIgnoreCase(ort)){
                    System.out.println(charakter.getName());
                }
            }
    }


}
