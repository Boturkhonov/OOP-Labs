import java.util.ArrayList;

public class Menu {
    private static Supermarket supermarket;
    private static boolean isOpened = false;
    private static boolean isChanged = false;
    private static String path;

    public static void showMenu() {
        int option = 1;
        while (option != 0) {
            option = mainMenu();
            switch (option) {
                case 1 -> createNewSupermarket();
                case 2 -> openFile();
            }
            while (option != 0 && option != 4) {
                option = supermarketMenu();
                switch (option) {
                    case 1 -> listGoods();
                    case 2 -> addGood();
                    case 3 -> deleteGood();
                }

            }
            if (isChanged) saveChanges();
        }
        if (isChanged) saveChanges();
    }

    private static int mainMenu() {
        int option;
        System.out.println("\t Главная меню");
        System.out.println(" Выберите одну из следующих действий и нажмите Enter: ");
        System.out.println();
        System.out.println("\t [1] Создать новую базу данных для супермаркета");
        System.out.println("\t [2] Открыть существующую базу данных");
        System.out.println();
        System.out.println("\t [0] Выйти из программы");

        option = getOption(2);

        return option;
    }

    private static int getOption(int maxOption) {
        int option;
        showHint();
        option = MyScanner.getInt();

        while (option < 0 || option > maxOption) {
            System.out.println("Пункт №" + option + " не найден");
            System.out.println("Выберите пунк заново");
            showHint();
            option = MyScanner.getInt();
        }

        return option;
    }

    private static void createNewSupermarket() {
        System.out.print("Введите название супермаркета: ");
        MyScanner.getString();
        String name = MyScanner.getString();
        supermarket = new Supermarket(name);
        System.out.println("База данных успешно создана");
        pause();
    }

    private static void pause() {
        System.out.println("Нажмите Enter для продолжения...");
        MyScanner.getString();
    }

    private static void openFile() {
        System.out.print("Введите полный путь к файлу: ");
        MyScanner.getString();
        path = MyScanner.getString();
        while (!MyData.setInputPath(path)) {
            System.out.println("Введите заново: ");
            path = MyScanner.getString();
        }
        supermarket = MyData.getSupermarket();
        isOpened = true;
        pause();
    }

    private static int supermarketMenu() {
        int option;

        System.out.println(" Выберите однин из следующих пунктов и нажмите Enter: ");
        System.out.println();
        System.out.println("\t [1] Список товар");
        System.out.println("\t [2] Добавить новый товар");
        System.out.println("\t [3] Удалить товар");
        System.out.println();
        System.out.println("\t [4] Вернутся назад");
        System.out.println("\t [0] Выйти из программы");

        option = getOption(4);
        return option;
    }

    private static void listGoods() {
        int option = 1;
        while (option != 0) {
            System.out.println(" Выберите однин из следующих пунктов и нажмите Enter: ");
            System.out.println();
            System.out.println("\t [1] Список молочных продуктов");
            System.out.println("\t [2] Список игрушек");
            System.out.println();
            System.out.println("\t [0] Вернутся назад");

            option = getOption(2);

            switch (option) {
                case 1 -> showMilkProducts(false);
                case 2 -> showToys(false);
            }
        }
    }

    private static void addGood() {
        int option = 1;
        while (option != 0) {
            System.out.println(" Выберите однин из следующих пунктов и нажмите Enter: ");
            System.out.println();
            System.out.println("\t [1] Добавить молочный продукт");
            System.out.println("\t [2] Добавить игрушку");
            System.out.println();
            System.out.println("\t [0] Вернутся назад");

            option = getOption(2);

            switch (option) {
                case 1 -> addMilkProduct();
                case 2 -> addToy();
            }
        }
    }

    private static void deleteGood() {
        int option = 1;
        while (option != 0) {
            System.out.println(" Выберите однин из следующих пунктов и нажмите Enter: ");
            System.out.println();
            System.out.println("\t [1] Удалить молочный продукт");
            System.out.println("\t [2] Удалить игрушку");
            System.out.println();
            System.out.println("\t [0] Вернутся назад");

            option = getOption(2);

            switch (option) {
                case 1 -> showMilkProducts(true);
                case 2 -> showToys(true);
            }

        }
    }

    private static void showMilkProducts(boolean delete) {
        ArrayList<MilkProduct> milkProducts = supermarket.getMilkProducts();
        int option = 1;
        while (option != 0) {
            if (milkProducts.size() == 0) {
                System.out.println("Список пуст");
            } else {
                System.out.println("\t Список молочных продуктов");
                if (delete)
                    System.out.println("Выберите номер товара для удаления");
                else
                    System.out.println(" Выберите номер товара для подробной информации: ");
                for (int i = 0; i < milkProducts.size(); i++) {
                    System.out.println("\t [" + (i + 1) +"]" + " " + milkProducts.get(i).getName());
                }
            }
            System.out.println();
            System.out.println("\t [0] Вернутся назад");
            option = getOption(milkProducts.size());
            if (option != 0) {
                if (delete) {
                    supermarket.deleteMilkProduction(option-1);
                    System.out.println("Товар удалён");
                    isChanged = true;
                } else
                    milkProducts.get(option - 1).showDescription();
                MyScanner.getString();
                pause();
            }
        }
    }

    private static void showToys(boolean delete) {
        ArrayList<Toy> toys = supermarket.getToys();
        int option = 1;
        while (option != 0) {
            if (toys.size() == 0) {
                System.out.println("Список пуст");
            } else {
                System.out.println("\t Список игрушек");
                if (delete)
                    System.out.println("Выберите номер товара для удаления");
                else
                    System.out.println(" Выберите номер товара для подробной информации: ");
                for (int i = 0; i < toys.size(); i++) {
                    System.out.println("\t [" + (i + 1) +"]" + " " + toys.get(i).getName());
                }
            }
            System.out.println();
            System.out.println("\t [0] Вернутся назад");
            option = getOption(toys.size());
            if (option != 0) {
                if (delete) {
                    supermarket.deleteToy(option-1);
                    System.out.println("Товар удалён");
                    isChanged = true;
                } else
                    toys.get(option - 1).showDescription();
                MyScanner.getString();
                pause();
            }
        }
    }

    private static void addMilkProduct() {

        System.out.print("Введите наименование товара: ");
        MyScanner.getString();
        String name = MyScanner.getString();
        System.out.print("Введите цену: ");
        Double price = MyScanner.getDouble();

        MilkProduct milkProduct = new MilkProduct(name, price);

        System.out.print("Введите вес: ");
        Double weigh = MyScanner.getDouble();
        milkProduct.setWeigh(weigh);

        System.out.print("Введите состав: ");
        MyScanner.getString();
        String composition = MyScanner.getString();
        milkProduct.setComposition(composition);

        System.out.print("Введите дату производства (дд.мм.гггг): ");
        String productionDate = MyScanner.getString();
        while (!milkProduct.setProductionDate(productionDate)) {
            System.out.println("Введите дату заново (дд.мм.гггг)");
            productionDate = MyScanner.getString();
        }

        System.out.print("Введите срок годности (дд.мм.гггг): ");
        String expirationDate = MyScanner.getString();
        while (!milkProduct.setExpirationDate(expirationDate)) {
            System.out.println("Введите дату заново (дд.мм.гггг)");
            expirationDate = MyScanner.getString();
        }

        System.out.print("Введите процент жира: ");
        Double fatPercentage = MyScanner.getDouble();
        milkProduct.setFatPercentage(fatPercentage);

        supermarket.addMilkProduct(milkProduct);
        isChanged = true;
    }

    private static void addToy() {
        System.out.print("Введите наименование товара: ");
        MyScanner.getString();
        String name = MyScanner.getString();
        System.out.print("Введите цену: ");
        Double price = MyScanner.getDouble();

        Toy toy = new Toy(name, price);

        System.out.print("Введите материал: ");
        MyScanner.getString();
        String material = MyScanner.getString();
        toy.setMaterial(material);

        System.out.print("Введите дату производства (дд.мм.гггг): ");
        String productionDate = MyScanner.getString();
        while (!toy.setProductionDate(productionDate)) {
            System.out.println("Введите дату заново (дд.мм.гггг)");
            productionDate = MyScanner.getString();
        }
        supermarket.addToy(toy);
        isChanged = true;
    }

    private static void saveChanges() {

        System.out.println("Сохранить изменения?");

        System.out.println("\t [1] Да");
        System.out.println("\t [0] Нет");
        int option = getOption(1);

        if (option == 1) {
            if (isOpened) {
                MyData.setOutputPath(path);
            } else {
                System.out.print("Введите полный путь: ");
                MyScanner.getString();
                String path = MyScanner.getString();
                while (!MyData.setOutputPath(path)) {
                    System.out.println("Введите заново: ");
                    path = MyScanner.getString();
                }
            }
            MyData.saveSupermarket(supermarket);
            System.out.println("Изменения успешно сохранены");
            isChanged = false;
            pause();

        } else {
            isChanged = false;
        }
    }

    private static void showHint () {
        System.out.println();
        System.out.print(" -> ");
    }

}
