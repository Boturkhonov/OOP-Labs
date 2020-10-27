public class Toy extends Good {
    private String material;

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public Toy(String name, Double price) {
        super(name, price);
    }

    public void showDescription() {
        System.out.println("Наименование: " + this.getName());
        System.out.println("Цена: " + this.getPrice());
        System.out.println("Материал: " + this.material);
        System.out.println("Дата производства: " + this.getProductionDate());
    }
}
