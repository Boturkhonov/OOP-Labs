import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Good {
    private String name;
    private Calendar productionDate;
    private Double price;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean setProductionDate(String productionDate) {
        boolean flag = false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date date = null;
            date = sdf.parse(productionDate);
            this.productionDate = new GregorianCalendar();
            this.productionDate.setTime(date);
            flag = true;
        } catch (ParseException e) {
            System.err.println("Ошибка! Неверный формат");
            System.out.println();
        }
        return flag;
    }

    public String getProductionDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(this.productionDate.getTime());
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Good(String name, Double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public abstract void showDescription();
}
