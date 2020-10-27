import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        MilkProduct milkProduct = new MilkProduct("powder", new GregorianCalendar(), 12.2D);
        milkProduct.showDescription();
    }
}
