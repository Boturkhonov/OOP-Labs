package Model;

import java.io.*;
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
            System.out.println();
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
            System.out.println();
        }
        return flag;
    }

    public static Supermarket getSupermarket () {
        Supermarket supermarket = null;
        try (DataInputStream dis = new DataInputStream(fis)) {

            String name = dis.readUTF();
            supermarket = new Supermarket(name);


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
            System.out.println("Файл успешно открыт");
            System.out.println("Название супермаркета: " + supermarket.getName());
            System.out.println("Список товар:");
            ArrayList<MilkProduct> milkProducts = supermarket.getMilkProducts();
            if (milkProducts.size() > 0) {
                System.out.println("Молочные продукты: ");
                for (int i = 0; i < milkProducts.size(); i++) {
                    System.out.println((i+1) + "." + " " + milkProducts.get(i).getName());
                }
            }
            ArrayList<Toy> toys = supermarket.getToys();
            if (toys.size() > 0) {
                System.out.println("Игрушки: ");
                for (int i = 0; i < toys.size(); i++) {
                    System.out.println((i+1) + "." + " " + toys.get(i).getName());
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка! Файл поврежден");
            System.exit(123);
        }

        return supermarket;
    }

    public static void saveSupermarket (Supermarket supermarket) {

        try (DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeUTF(supermarket.getName());

            dos.writeInt(supermarket.getMilkProducts().size());

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

            dos.writeInt(supermarket.getToys().size());

            for (int j = 0; j < supermarket.getToys().size(); j++) {

                Toy toy = supermarket.getToys().get(j);

                dos.writeUTF(toy.getName());
                dos.writeDouble(toy.getPrice());
                dos.writeUTF(toy.getMaterial());
                dos.writeUTF(toy.getProductionDate());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
