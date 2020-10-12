import java.io.Serializable;

public class FibonacciNumbers implements Cloneable, Serializable {

    private int size;
    private int[] fibonacciNumbers;
    public void setSize(int size) {
        if (size > 0) {
            this.size = size;
        } else {
            System.err.println("Ошибка: N < 0");
        }
    }

    public FibonacciNumbers() {
        setSize(10);
    }

    public FibonacciNumbers(int size) {
        setSize(size);
    }

    public int[] getFibonacciNumbers() {
        fibonacciNumbers = new int[size];
        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;
        for (int i = 2; i < size; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i-2] + fibonacciNumbers[i-1];
        }
        return fibonacciNumbers;
    }
    public void printFibonacciNumbers () {
        getFibonacciNumbers();
        for (int i = 0; i < size; i++) {
            System.out.print(fibonacciNumbers[i]);
            if (fibonacciNumbers[i] % 2 == 0) {
                char ch = '%';
                System.out.print(ch);
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (FibonacciNumbers) super.clone();
    }
}
