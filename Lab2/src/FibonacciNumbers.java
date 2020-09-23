import java.io.Serializable;

public class FibonacciNumbers implements Cloneable, Serializable {

    private int N;

    public void setN(int n) {
        if (n > 0) {
            N = n;
        } else {
            System.err.println("Ошибка: N < 0");
        }
    }

    public FibonacciNumbers() {
        setN(10);
    }

    public FibonacciNumbers(int n) {
        setN(n);
    }

    public void printFibonacciNumbers () {
        int[] fibonacciNumbers = new int[N];
        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;
        for (int i = 2; i < N; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i-2] + fibonacciNumbers[i-1];
        }
        for (int i = 0; i < N; i++) {
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
