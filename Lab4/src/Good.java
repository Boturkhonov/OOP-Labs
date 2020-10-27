import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Good {
    private String name;
    private final Calendar productionDate;
    private Double price;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String productionDate = simpleDateFormat.format(this.productionDate.getTime());
        return productionDate;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Good(String name, Calendar productionDate, Double price) {
        this.setName(name);
        this.productionDate = productionDate;
        this.setPrice(price);
    }

    public abstract void showDescription();
}
