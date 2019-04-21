package www.arivan.Test4_21;

/**
 * 产品
 */
public class Goods {
    private String name;
    private Double price;

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
