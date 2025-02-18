

import Model.Charakter;
import Model.Produkt;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private Repository<Charakter> charakterRepository;
    private Repository<Produkt> produktRepository;

    public Service(Repository<Charakter> charakterRepository, Repository<Produkt> produktRepository) {
        this.charakterRepository = charakterRepository;
        this.produktRepository = produktRepository;
    }


    public List<Charakter> alleCharakterZuruckgeben() {
        return charakterRepository.getAllElements();
    }

    public List<Produkt> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }

    public void createAProdukt(String name, double price, String herrkunftregion){
        produktRepository.addElement(new Produkt(name, price, herrkunftregion));
    }

    public Produkt getProdukt(String name){
        int id = -1;
        for (Produkt p : produktRepository.getAllElements()) {
            if (p.getName().equals(name))
            {id = produktRepository.getAllElements().indexOf(p); break;}
        }
        return produktRepository.getElement(id);
    }

    public void updateProdukt(Produkt produkt){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(produkt.getName())){
                int index = produktRepository.getAllElements().indexOf(p);
                p.setPrice(produkt.getPrice());
                p.setHerrkunftregion(produkt.getHerrkunftregion());
                produktRepository.updateElement(index,produkt);
                break;
            }
        }
    }

    public void deleteProdukt(String name){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(name)){
                produktRepository.remove(p);
                break;
            }
        }
    }

    public void createACharacter(String name, String herkunftsdorf){
        int id = -1;
        for (Charakter k : charakterRepository.getAllElements()){
            if (id < k.getId())
                id = k.getId();
        }
        id += 1;

        charakterRepository.addElement(new Charakter(id,name,herkunftsdorf));
    }

    public Charakter getKunde(int id){
        for (Charakter p : charakterRepository.getAllElements()) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("Charakkter nicht gefunden");
    }

    public void updateCharacter(Charakter charakter){
        for (Charakter p : charakterRepository.getAllElements()){
            if (p.getId() == charakter.getId()){
                int index = charakterRepository.getAllElements().indexOf(p);
                p.setName(charakter.getName());
                p.setHerkunftsdorf(charakter.getHerkunftsdorf());
                charakterRepository.updateElement(index,p);
                break;
            }
        }
    }

    public void deleteCharacter(int id){
        for (Charakter p : charakterRepository.getAllElements()){
            if (p.getId() == id){
                charakterRepository.remove(p);
                break;
            }
        }
    }


    public List<Charakter> filterNachOrt(String ort){
        List<Charakter> kundeList = new ArrayList<>();
        kundeList = charakterRepository.getAllElements().stream().filter(kunde -> ort.equals(kunde.getHerkunftsdorf())).toList();

        return kundeList;
    }




}
