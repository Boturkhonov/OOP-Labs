import java.io.Serializable;
import java.util.Scanner;

public class LineWithBinaryNumbers implements Cloneable, Serializable {

    private String[] binaryNumbers;

    public void setLine(String line) {
        binaryNumbers = line.split(" ");
    }

    public LineWithBinaryNumbers(String line) {
        setLine(line);
    }

    public boolean isSorted () {

        boolean sorted = true;

        for (int i = 0; i < binaryNumbers.length - 1; i++) {
            if (binToDec(binaryNumbers[i]) > binToDec(binaryNumbers[i+1])) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    private int binToDec (String binaryNumber) {
        int n = 0;
        try {
            n = Integer.parseInt(binaryNumber, 2);
        } catch (NumberFormatException error) {
            System.err.println("Ошибка: Неверный ввод данных");
            System.exit(0);
        }
        return n;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LineWithBinaryNumbers clone = (LineWithBinaryNumbers) super.clone();

        clone.binaryNumbers = (String[]) this.binaryNumbers.clone();

        return clone;
    }
}
