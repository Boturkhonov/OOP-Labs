package Controller;

import Model.MilkProduct;
import Model.MyData;
import Model.Supermarket;
import Model.Toy;
import View.AddDialog;
import View.MyFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controller implements ActionListener {

    MyFrame mainFrame;
    Supermarket supermarket;

    public Controller(MyFrame frame) {
        mainFrame = frame;
    }

    public void execute() {

        for (JMenuItem item: mainFrame.getFileMenuItems()) {
            item.addActionListener(this);
        }

        mainFrame.getRemoveButton().addActionListener(this);
        mainFrame.getAddButton().addActionListener(this);

        mainFrame.getAddDialog().getSaveButton().addActionListener(this);
        mainFrame.getAddDialog().getGoodType().addActionListener(this);

        mainFrame.getCreateDialog().getCreateButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String className = e.getSource().getClass().getName();
        switch (className) {
            case "javax.swing.JMenuItem" -> menuActionHandler(e);
            case "javax.swing.JButton"   -> buttonActionHandler(e);
            case "javax.swing.JComboBox" -> comboBoxActionHandler(e);
            default -> System.out.println(className);
        }
    }

    private void comboBoxActionHandler(ActionEvent e) {
        JComboBox comboBox = (JComboBox)(e.getSource());
        if (comboBox.getSelectedIndex() == 0) {
            mainFrame.getAddDialog().getToyPanel().setVisible(false);
            mainFrame.getAddDialog().getMilkProductPanel().setVisible(true);
        } else {
            mainFrame.getAddDialog().getMilkProductPanel().setVisible(false);
            mainFrame.getAddDialog().getToyPanel().setVisible(true);
        }
    }

    private void buttonActionHandler(ActionEvent e) {
        JButton source = (JButton)(e.getSource());
        switch (source.getText()) {
            case "Добавить товар" -> showAddGood();
            case "Удалить товар" -> deleteGood();
            case "Добавить" -> addGood();
            case "Создать" -> createNewSupermarket();
        }
    }

    private void createNewSupermarket() {
        if (mainFrame.getCreateDialog().getSupermarketName().getText().equals("")) {
            JOptionPane.showMessageDialog(mainFrame, "Имя не может быть пустым!");
        } else {
            supermarket = new Supermarket(mainFrame.getCreateDialog().getSupermarketName().getText());
            mainFrame.getCreateDialog().dispose();
            enableButtons();
            fillSupermarketInfo();
        }
    }

    private void enableButtons() {
        mainFrame.getAddButton().setEnabled(true);
        mainFrame.getRemoveButton().setEnabled(true);
    }

    private void addGood() {
        if (mainFrame.getAddDialog().getGoodType().getSelectedIndex() == 0) {
            if (mainFrame.getAddDialog().areAllMilkProductFieldsFilled()) {
                addMilkProduct();
                mainFrame.getAddDialog().dispose();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Все поля должны быть заполнены!");
            }

        } else {
            if (mainFrame.getAddDialog().areAllToyFieldsFilled()) {
                addToy();
                mainFrame.getAddDialog().dispose();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Все поля должны быть заполнены!");
            }
        }
        System.out.println(mainFrame.getAddDialog().getMilkProductExpireDate().getText());
    }

    private void addToy() {
        AddDialog addDialog = mainFrame.getAddDialog();
        String name = addDialog.getToyName().getText();
        Double price = Double.valueOf(addDialog.getToyPrice().getText().replaceAll(",", ""));
        Toy toy = new Toy(name, price);
        toy.setMaterial(addDialog.getToyMaterial().getText());
        toy.setProductionDate(addDialog.getToyProductionDate().getText());
        supermarket.addToy(toy);

        Object[] row = new Object[] {
                toy.getName(),
                toy.getPrice(),
                toy.getMaterial(),
                toy.getProductionDate(),

        };

        mainFrame.getToyTableModel().addRow(row);
    }

    private void addMilkProduct() {
        AddDialog addDialog = mainFrame.getAddDialog();
        String name = addDialog.getMilkProductName().getText();
        Double price = Double.valueOf(addDialog.getMilkProductPrice().getText().replaceAll(",", ""));
        MilkProduct milkProduct = new MilkProduct(name, price);
        milkProduct.setWeigh(Double.valueOf(addDialog.getMilkProductWeight().getText().replaceAll(",", "")));
        milkProduct.setComposition(addDialog.getMilkProductComposition().getText());
        milkProduct.setProductionDate(addDialog.getMilkProductProductionDate().getText());
        milkProduct.setExpirationDate(addDialog.getMilkProductExpireDate().getText());
        supermarket.addMilkProduct(milkProduct);

        Object[] row = new Object[] {
                milkProduct.getName(),
                milkProduct.getPrice(),
                milkProduct.getWeigh(),
                milkProduct.getComposition(),
                milkProduct.getProductionDate(),
                milkProduct.getExpirationDate()
        };
        mainFrame.getMilkProductTableModel().addRow(row);

    }

    private void deleteGood() {
        int row = mainFrame.getMilkProductTable().getSelectedRow();
        if (row > -1) {
            mainFrame.getMilkProductTableModel().removeRow(row);
            mainFrame.getMilkProductTableModel().fireTableDataChanged();
            supermarket.deleteMilkProduction(row);
        }
        System.out.println(row);

        row = mainFrame.getToyTable().getSelectedRow();
        if (row > -1) {
            mainFrame.getToyTableModel().removeRow(row);
            mainFrame.getToyTableModel().fireTableDataChanged();
            supermarket.deleteToy(row);
        }
        System.out.println(row);


    }

    private void showAddGood() {
        mainFrame.getAddDialog().setVisible(true);
        mainFrame.getAddDialog().clearAllFields();
        System.out.println("Добавить товар");
    }

    private void menuActionHandler(ActionEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        switch (source.getText()) {
            case "Создать новый" -> showNewSupermarketDialog();
            case "Открыть..."    -> fileChooserMenu(false);
            case "Сохранить"     -> fileChooserMenu(true);
            case "Выход"         -> closeMenu();
        }
    }

    private void showNewSupermarketDialog() {
        mainFrame.getCreateDialog().setVisible(true);
    }

    private void closeMenu() {
        mainFrame.dispose();
    }

    private void fileChooserMenu(boolean isSaving) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("База данных (.data)", "data"));
        fileChooser.setAcceptAllFileFilterUsed(false);

        if (isSaving) {
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                MyData.setOutputPath(fileChooser.getSelectedFile().getAbsolutePath());
                MyData.saveSupermarket(supermarket);
            }
        } else {
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                MyData.setInputPath(fileChooser.getSelectedFile().getAbsolutePath());
                this.supermarket = MyData.getSupermarket();
                fillSupermarketInfo();
                fillMilkProductTable();
                fillToyTable();
                enableButtons();
            }
        }
    }

    private void fillSupermarketInfo() {
        mainFrame.getSupermarketName().setHorizontalTextPosition(JLabel.CENTER);
        mainFrame.getSupermarketName().setText("<html> База данных <br> супермаркета <br>" + supermarket.getName() + "</html>");
    }

    private void fillMilkProductTable() {
        DefaultTableModel tableModel = mainFrame.getMilkProductTableModel();

        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        int size = supermarket.getMilkProducts().size();
        for (int i = 0; i < size; i++) {
            MilkProduct milkProduct = supermarket.getMilkProducts().get(i);
            Object[] row = new Object[] {
                    milkProduct.getName(),
                    milkProduct.getPrice(),
                    milkProduct.getWeigh(),
                    milkProduct.getComposition(),
                    milkProduct.getProductionDate(),
                    milkProduct.getExpirationDate()
            };
            tableModel.addRow(row);
        }
    }

    private void fillToyTable() {
        DefaultTableModel tableModel = mainFrame.getToyTableModel();

        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        int size = supermarket.getToys().size();
        for (int i = 0; i < size; i++) {
            Toy toy = supermarket.getToys().get(i);
            Object[] row = new Object[] {
                    toy.getName(),
                    toy.getPrice(),
                    toy.getMaterial(),
                    toy.getProductionDate(),

            };
            tableModel.addRow(row);
        }
    }
}
