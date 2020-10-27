import java.util.Calendar;

public class Toy extends Good {
    private String material;

    public void setMaterial(String material) {
        this.material = material;
    }

    public Toy(String name, Calendar productionDate, Double price) {
        super(name, productionDate, price);
    }

    public void showDescription() {
        System.out.println("Наименование: " + this.getName());
        System.out.println("Цена: " + this.getPrice());
        System.out.println("Материал: " + this.material);
        System.out.println("Дата производства: " + this.getProductionDate());
    }
}
