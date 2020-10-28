import java.util.ArrayList;

public class Supermarket {
    private final String name;
    private final ArrayList<MilkProduct> milkProducts = new ArrayList<>();
    private final ArrayList<Toy> toys = new ArrayList<>();

    public Supermarket(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addMilkProduct(MilkProduct milkProduct) {
        milkProducts.add(milkProduct);
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void deleteMilkProduction(int index) {
        milkProducts.remove(index);
    }

    public void deleteToy(int index) {
        toys.remove(index);
    }

    public ArrayList<MilkProduct> getMilkProducts() {
        return milkProducts;
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }
}
