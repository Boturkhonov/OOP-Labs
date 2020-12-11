package Model;

public class MilkProduct extends Product {

    private Double fatPercentage;

    public void setFatPercentage(Double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public Double getFatPercentage() {
        return fatPercentage;
    }

    public MilkProduct(String name, Double price) {
        super(name, price);
    }

    public void showDescription() {
        super.showDescription();
        System.out.println("Жир :" + this.fatPercentage + "%");
    }
}