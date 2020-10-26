import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyFile {

    private static FileInputStream fis = null;
    private static FileWriter writer = null;

    public static boolean setInputFilePath(String path) {
        boolean flag = false;
        try {
            fis = new FileInputStream(path);
            flag = true;
        } catch (FileNotFoundException e) {
            System.err.print("Ошибка! Файл не найден");
            System.out.println();
        }
        return flag;
    }

    public static void setOutputFilePath(String path) {
        try {
            writer = new FileWriter(path);
        } catch (IOException e) {
            System.err.println("Ошибка! Невозможно создать файл");
            System.out.println();
        }
    }

    public static void writeLine (String line) {
        try {
            writer.write(line + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeArray(int [] array) {
        try {
            writer.write(Arrays.toString(array));
            System.out.println("Результат успешно записан");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeArray(ArrayList<Double> arrayList) {
        try {
            writer.write(Arrays.toString(arrayList.toArray()));
            System.out.println("Результат успешно записан");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static double [] readArray () {
        double [] array = null;

        try (DataInputStream dis = new DataInputStream(fis)) {
            int size = (int) dis.readDouble();
            array = new double[size];
            for (int i = 0; i < size; i++) {
                array[i] = dis.readDouble();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }

    public static String readString () {
        StringBuilder line = new StringBuilder();
        try {
            // читаем посимвольно
            int c;
            while((c = fis.read())!=-1){
                line.append((char) c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return line.toString();
    }

}
