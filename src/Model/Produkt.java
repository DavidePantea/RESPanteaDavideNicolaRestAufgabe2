package Model;

public class Produkt {
    private String Name;
    private double Price;
    private String Herrkunftregion;


    public Produkt(String name, double price, String herrkunftregion) {
        Name = name;
        Price = price;
        Herrkunftregion = herrkunftregion;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getHerrkunftregion() {
        return Herrkunftregion;
    }

    public void setHerrkunftregion(String herrkunftregion) {
        Herrkunftregion = herrkunftregion;
    }

    @Override
    public String toString() {
        return "Model.Produkt{" +
                "Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Herrkunftregion='" + Herrkunftregion + '\'' +
                '}';
    }
}
