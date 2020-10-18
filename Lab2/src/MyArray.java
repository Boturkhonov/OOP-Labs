import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyArray implements Cloneable, Serializable {
    private ArrayList<Double> array = new ArrayList<>();
    private final transient Scanner in = new Scanner(System.in);
    private int size;
    private final int DEFAULT_SIZE = 10;

    public ArrayList<Double> getArray() {
        return array;
    }

    public void setSize(int size) {
        if (size > 0) {
            this.size = size;
        } else {
            System.err.println("Размер массива должен быть строго положителным!");
        }
    }

    public MyArray() {
        setSize(DEFAULT_SIZE);
    }

    public MyArray(int size) {
        setSize(size);
    }

    public MyArray (MyArray myArray) {
        this.size = myArray.size;
        for (int i = 0; i < size; i++) {
            this.array.add(myArray.array.get(i));
        }
    }

    public void fill() {
        array.clear();
        for (int i = 0; i < size; i++) {
            array.add(in.nextDouble());
        }
    }

    public void fill(double[] array) {
        this.array.clear();
        for (double j : array) {
            this.array.add(j);
        }
    }

    public void changeAllElements(final char operationSign, final double operand) {
        switch (operationSign) {
            case '+' -> {
                for (int i = 0; i < array.size(); i++) {
                    array.set(i, array.get(i) + operand);
                }
            }
            case '-' -> {
                for (int i = 0; i < array.size(); i++) {
                    array.set(i, array.get(i) - operand);
                }
            }
            case '*' -> {
                for (int i = 0; i < array.size(); i++) {
                    array.set(i, array.get(i) * operand);
                }
            }
            case '/' -> {
                for (int i = 0; i < array.size(); i++) {
                    array.set(i, array.get(i) / operand);
                }
            }
        }
    }

    public void print() {
        for (Double elem: array) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyArray clone = (MyArray) super.clone();
        clone.array = (ArrayList<Double>) array.clone();
        return clone;
    }
}
