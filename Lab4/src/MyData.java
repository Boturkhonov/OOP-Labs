import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class MyData {
    static FileInputStream fis = null;
    static FileOutputStream fos = null;

    public static boolean setInputPath(String path) {
        boolean flag = false;
        try {
            fis = new FileInputStream(path);
            flag = true;
        }  catch (FileNotFoundException e) {
            System.err.println("Ошибка! Файл не существует");
        }
        return flag;
    }

    public static boolean setOutputPath(String path) {
        boolean flag = false;
        try {
            fos = new FileOutputStream(path);
            flag = true;
        }  catch (FileNotFoundException e) {
            System.err.println("Ошибка! Невозможно создать файл");
        }
        return flag;
    }

    public static ArrayList<Supermarket> getSupermarkets () {
        ArrayList<Supermarket> supermarkets = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(fis)) {
            int numberOfSupermarkets = dis.readInt();
            for (int i = 0; i < numberOfSupermarkets; i++) {

                String name = dis.readUTF();
                Supermarket supermarket = new Supermarket(name);

                int numberOfMilkProducts = dis.readInt();

                for (int j = 0; j < numberOfMilkProducts; j++) {

                    String MilkProductName = dis.readUTF();
                    Double price = dis.readDouble();
                    MilkProduct milkProduct = new MilkProduct(MilkProductName, price);

                    Double weigh = dis.readDouble();
                    String composition = dis.readUTF();
                    String productionDate = dis.readUTF();
                    String expirationDate = dis.readUTF();
                    Double fatPercentage = dis.readDouble();

                    milkProduct.setWeigh(weigh);
                    milkProduct.setComposition(composition);
                    milkProduct.setProductionDate(productionDate);
                    milkProduct.setExpirationDate(expirationDate);
                    milkProduct.setFatPercentage(fatPercentage);

                    supermarket.addMilkProduct(milkProduct);
                }

                int numberOfToys = dis.readInt();

                for (int j = 0; j < numberOfToys; j++) {
                    String toyName = dis.readUTF();
                    Double price = dis.readDouble();
                    Toy toy = new Toy(toyName, price);

                    String material = dis.readUTF();
                    String productionDate = dis.readUTF();

                    toy.setMaterial(material);
                    toy.setProductionDate(productionDate);

                    supermarket.addToy(toy);
                }
                supermarkets.add(supermarket);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return supermarkets;
    }

    public static void saveSupermarkets (ArrayList<Supermarket> supermarkets) {

        try (DataOutputStream dos = new DataOutputStream(fos)) {

            for (int i = 0; i < supermarkets.size(); i++) {
                Supermarket supermarket = supermarkets.get(i);
                dos.writeUTF(supermarket.getName());


                for (int j = 0; j < supermarket.getMilkProducts().size(); j++) {

                    MilkProduct milkProduct = supermarket.getMilkProducts().get(j);

                    dos.writeUTF(milkProduct.getName());
                    dos.writeDouble(milkProduct.getPrice());

                    dos.writeDouble(milkProduct.getWeigh());
                    dos.writeUTF(milkProduct.getComposition());
                    dos.writeUTF(milkProduct.getProductionDate());
                    dos.writeUTF(milkProduct.getExpirationDate());
                    dos.writeDouble(milkProduct.getFatPercentage());

                }

                for (int j = 0; j < supermarket.getToys().size(); j++) {

                    Toy toy = supermarket.getToys().get(j);

                    dos.writeUTF(toy.getName());
                    dos.writeDouble(toy.getPrice());
                    dos.writeUTF(toy.getMaterial());
                    dos.writeUTF(toy.getProductionDate());

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
