import java.util.ArrayList;
import java.util.List;

public class Charakter {
    private int id;
    private  String name;
    private  String Herkunftsdorf;
    private List<Produkt> Produkten;


    public Charakter(int id, String name, String herkunftsdorf) {
        this.id = id;
        this.name = name;
        Herkunftsdorf = herkunftsdorf;
        Produkten = new ArrayList<Produkt>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsdorf() {
        return Herkunftsdorf;
    }

    public void setHerkunftsdorf(String herkunftsdorf) {
        Herkunftsdorf = herkunftsdorf;
    }

    public List<Produkt> getProdukten() {
        return Produkten;
    }

    public void setProdukten(List<Produkt> produkten) {
        Produkten = produkten;
    }

    @Override
    public String toString() {
        return "Charakter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Herkunftsdorf='" + Herkunftsdorf + '\'' +
                ", Produkten=" + Produkten +
                '}';
    }

    public void kaufeProdukt(Produkt produkt){
        Produkten.add(produkt);
    }
}
