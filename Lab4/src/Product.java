import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Product extends Good {
    private String composition;
    private Double weigh;
    private Calendar expirationDate = null;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public void setWeigh(Double weigh) {
        this.weigh = weigh;
    }

    public boolean setExpirationDate(String expirationDate) {
        boolean flag = false;

        try {
            Date date = this.simpleDateFormat.parse(expirationDate);
            this.expirationDate = new GregorianCalendar();
            this.expirationDate.setTime(date);
            flag = true;
        } catch (ParseException var4) {
            System.err.println("Ошибка! Неверный формат");
            System.out.println();
        }

        return flag;
    }

    public Calendar getExpirationDate() {
        return this.expirationDate;
    }

    public Product(String name, Calendar productionDate, Double price) {
        super(name, productionDate, price);
    }

    public void showDescription() {
        System.out.println("Наименование: " + this.getName());
        System.out.println("Цена: " + this.getPrice());
        System.out.println("Вес: " + this.weigh);
        System.out.println("Состав: " + this.composition);
        System.out.println("Дата производства: " + this.getProductionDate());
        System.out.println("Годен до: " + this.getExpirationDate());
    }
}
