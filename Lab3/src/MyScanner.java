import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        int integer = 0;
        boolean isCorrect = false;
        do {
            try {
                integer = scanner.nextInt();
                isCorrect = true;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка ввода");
                System.out.println();
                System.out.println("Введите заново");
                getString();
            }
        } while (!isCorrect);

        return integer;
    }

    public static Double getDouble() {
        Double d = (double) 0;
        boolean isCorrect = false;
        do {
            try {
                d = scanner.nextDouble();
                isCorrect = true;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка ввода");
                System.out.println();
                System.out.println("Введите заново");
                getString();
            }
        } while (!isCorrect);

        return d;
    }

    public static String getString() {
        String result = scanner.nextLine();
        return result;
    }
}
