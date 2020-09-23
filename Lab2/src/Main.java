import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Задание A: ");
        taskA();
        System.out.println("Задание B: ");
        taskB();
        System.out.println("Задание C: ");
        taskC();
    }

    static void taskA() {
        final int N = 10;
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers(N);
        fibonacciNumbers.printFibonacciNumbers();
    }

    static void taskB() throws CloneNotSupportedException {
        //-----------------------------Ввод массива-------------------------------------
        int size;
        System.out.print("Введите размер массива: ");
        size = in.nextInt();
        System.out.println("Введите массив: ");
        MyArray myArray = new MyArray(size);
        myArray.fill();
        //--------------------------Операция с массивом---------------------------------
        System.out.print("Введите знак операции: ");
        String operationSign = in.next();
        System.out.print("Введите операнд: ");
        double operand = in.nextInt();
        myArray.changeAllElements(operationSign.charAt(0), operand);
        //----------------------------Вывод массива-------------------------------------
        System.out.println("Массив, полученный в результате арифметического действия: ");
        myArray.print();
        //---------------------------- Сериализация ------------------------------------
//        Serializer<MyArray> serializer = new Serializer<>();
//        if (serializer.serialization(myArray)) {
//            MyArray cloned = serializer.deserialization();
//            System.out.println("Десериализованный массив: ");
//            cloned.print();
//        }
        //---------------------------- Клонирование ------------------------------------
//        System.out.println("Клонированный массив: ");
//        MyArray cloned = (MyArray) myArray.clone();
//        cloned.print();
    }

    static void taskC() {
        System.out.println("Введите строку, содержащую ряд чисел в двоичном виде: ");
        in.nextLine();
        String line = in.nextLine();

        LineWithBinaryNumbers lineWithBinaryNumbers = new LineWithBinaryNumbers(line);

        if (lineWithBinaryNumbers.isSorted()) {
            System.out.println("Ряд упорядочен");
        } else {
            System.out.println("Ряд не упорядочен");
        }
    }

}
