import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static String input, output;

    public static void showMenu() {
        int option = 1;
        while (option != 0) {
            System.out.println(" Выберите один из следующих пунктов и нажмите Enter: \n");
            System.out.println("\t [1] Задание A");
            System.out.println("\t [2] Задание B");
            System.out.println("\t [3] Задание C");
            System.out.println();
            System.out.println("\t [0] Выход\n");
            System.out.print(" -> ");
            option = scanner.nextInt();
            if (option == 0) continue;
            System.out.println("Выберите способ ввода & вывода.");
            System.out.print("Введите 'c' для ввода & вывода через консоль или 'f' через файл: ");
            scanner.nextLine();
            char inputOption = scanner.nextLine().charAt(0);
            if (inputOption == 'f') {
                if (option != 1) {
                    System.out.println("Введите полный путь к файлу для чтения: ");
                    input = scanner.nextLine();
                    MyFile.setInputFilePath(input);
                }
                if (option != 3) {
                    System.out.println("Введите полный путь к файлу для записи результатов: ");
                    output = scanner.nextLine();
                    MyFile.setOutputFilePath(output);
                }
            }
            switch (option) {
                case 1:
                    System.out.println("Задание A: ");
                    taskA(inputOption);
                break;
                case 2:
                    System.out.println("Задание B: ");
                    taskB(inputOption);
                break;
                case 3:
                    System.out.println("Задание C: ");
                    taskC(inputOption);
                break;
//                case 0:
//                    continue;
                default:
                    System.out.println("Пункт №" + option + " не найден");
            }
            System.out.println("Нажмите Enter для продолжения...");
            scanner.nextLine();
            scanner.nextLine();
        }

    }
    private static void taskA(char inputOption) {
        System.out.println("Введите n: ");
        int n = scanner.nextInt();
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        fibonacciNumbers.setSize(n);

        if (inputOption == 'f') {
            MyFile.writeLine("Первые " + n + " числа Фибоначчи: ");
            MyFile.writeArray(fibonacciNumbers.getFibonacciNumbers());
        } else {
            System.out.println("Первые " + n + " числа Фибоначчи: ");
            fibonacciNumbers.printFibonacciNumbers();
        }
    }
    private static void taskB(char inputOption) {
        //-----------------------------Ввод массива-------------------------------------
        int size;
        MyArray myArray = new MyArray();

        if (inputOption == 'f') {
            myArray.fill(MyFile.readArray());
        } else {
            System.out.print("Введите размер массива: ");
            size = scanner.nextInt();
            myArray.setSize(size);
            System.out.println("Введите массив: ");
            myArray.fill();
        }

        //--------------------------Операция с массивом---------------------------------
        System.out.print("Введите знак операции: ");
        String operationSign = scanner.next();
        System.out.print("Введите операнд: ");
        double operand = scanner.nextInt();
        myArray.changeAllElements(operationSign.charAt(0), operand);
        //----------------------------Вывод массива-------------------------------------
        if (inputOption == 'f') {
            MyFile.writeLine("Массив, полученный в результате арифметических действий:");
            MyFile.writeArray(myArray.getArray());
        } else {
            System.out.println("Массив, полученный в результате арифметических действий:");
            myArray.print();
        }
    }

    private static void taskC(char inputOption) {

        String line = "";

        if (inputOption == 'f') {
            line = MyFile.readString();
            System.out.println("Считанная сторока из файла: ");
            System.out.println(line);
        } else {
            System.out.println("Введите строку, содержащую ряд чисел в двоичном виде: ");
            scanner.nextLine();
            line = scanner.nextLine();
        }

        LineWithBinaryNumbers lineWithBinaryNumbers = new LineWithBinaryNumbers(line);

        if (lineWithBinaryNumbers.isSorted()) {
            System.out.println("Ряд упорядочен");
        } else {
            System.out.println("Ряд не упорядочен");
        }
    }
}
