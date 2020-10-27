import java.util.Calendar;

public class MilkProduct extends Product {

    private Double fatPercentage;

    public void setFatPercentage(Double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public MilkProduct(String name, Calendar productionDate, Double price) {
        super(name, productionDate, price);
    }

    public void showDescription() {
        super.showDescription();
        System.out.println("Жир :" + this.fatPercentage + "%");
    }
}