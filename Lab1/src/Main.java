import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание A: ");
        taskA();
        System.out.println("Задание B: ");
        taskB();
        System.out.println("Задание C: ");
        taskC();

    }

    static void taskA() {
        final int N = 20;
        final char ch = '%';

        int[] a = new int[N];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < N; i++) {
            a[i] = a[i-2] + a[i-1];
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(a[i]);
            if (a[i] % 2 == 0) {
                System.out.print(ch);
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    static void taskB() {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.print("Введите размер массива: ");
        n = in.nextInt();
        System.out.println("Введите массив: ");
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.print("Введите знак операции: ");
        String ch = in.next();
        System.out.print("Введите операнд: ");
        double operand = in.nextInt();
        switch (ch.charAt(0)) {
            case '+' -> {
                for (int i = 0; i < n; i++) {
                    a[i] += operand;
                }
            }
            case '-' -> {
                for (int i = 0; i < n; i++) {
                    a[i] -= operand;
                }
            }
            case '*' -> {
                for (int i = 0; i < n; i++) {
                    a[i] *= operand;
                }
            }
            case '/' -> {
                for (int i = 0; i < n; i++) {
                    a[i] /= operand;
                }
            }
        }
        System.out.println("Массив, полученный в результате арифметического действия: ");
        for (double elem: a) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    static void taskC() {
        System.out.println("Введите строку, содержащую ряд чисел в двоичном виде: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] binNumbs = s.split(" ");

        boolean f = true;

        for (int i = 0; i < binNumbs.length - 1; i++) {
            if (binToDec(binNumbs[i]) > binToDec(binNumbs[i+1])) {
                f = false;
                break;
            }
        }
        if (f) {
            System.out.println("Ряд упорядочен");
        } else {
            System.out.println("Ряд не упорядочен");
        }
    }

    static int binToDec(String s) {
        return Integer.parseInt(s, 2);
    }

}
