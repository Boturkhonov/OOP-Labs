package View;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class AddDialog extends JDialog {

    final int WIDTH = 400;
    final int HEIGHT = 400;
    final int MARGIN = 10;

    private JButton saveButton;
    private JComboBox goodType;

    private JPanel milkProductPanel;
    private JTextField milkProductName;
    private JTextField milkProductPrice;
    private JTextField milkProductWeight;
    private JTextField milkProductComposition;
    private JTextField milkProductProductionDate;
    private JTextField milkProductExpireDate;

    private NumberFormat numberFormat;

    private JPanel toyPanel;
    private JTextField toyName;
    private JTextField toyPrice;
    private JTextField toyMaterial;
    private JTextField toyProductionDate;

    public JComboBox getGoodType() {
        return goodType;
    }

    public JPanel getMilkProductPanel() {
        return milkProductPanel;
    }

    public JPanel getToyPanel() {
        return toyPanel;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JTextField getMilkProductName() {
        return milkProductName;
    }

    public JTextField getMilkProductPrice() {
        return milkProductPrice;
    }

    public JTextField getMilkProductWeight() {
        return milkProductWeight;
    }

    public JTextField getMilkProductComposition() {
        return milkProductComposition;
    }

    public JTextField getMilkProductProductionDate() {
        return milkProductProductionDate;
    }

    public JTextField getMilkProductExpireDate() {
        return milkProductExpireDate;
    }

    public JTextField getToyName() {
        return toyName;
    }

    public JTextField getToyPrice() {
        return toyPrice;
    }

    public JTextField getToyMaterial() {
        return toyMaterial;
    }

    public JTextField getToyProductionDate() {
        return toyProductionDate;
    }



    public AddDialog(JFrame frame) {
        super(frame, "Добавить товар", true);
        setResizable(false);
        setLayout(null);
        setBounds(frame.getBounds().x + frame.getWidth() / 2 - WIDTH / 2,
                frame.getBounds().y + frame.getHeight() / 2 - HEIGHT / 2,
                WIDTH, HEIGHT);
        setUpContent();

    }

    private void setUpContent() {
        JLabel goodTypeLabel = new JLabel("Выберите вид товара: ");
        goodTypeLabel.setBounds(MARGIN, MARGIN, 150, 20);
        this.add(goodTypeLabel);

        setUpFormats();
        setUpMilkProductPanel();
        setUpToyPanel();

        saveButton = new JButton("Добавить");
        saveButton.setBounds(90, HEIGHT - 9 * MARGIN, 200, 30);
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(saveButton);

        goodType = new JComboBox();
        goodType.setBounds(WIDTH / 2 + MARGIN, MARGIN, 150, 20);
        goodType.addItem("Молочный продукт");
        goodType.addItem("Игрушка");
        this.add(goodType);
    }

    private void setUpToyPanel() {
        toyPanel = new JPanel(null);
        toyPanel.setBounds(0, 4 * MARGIN, WIDTH, HEIGHT - 15 * MARGIN);
        toyPanel.setBackground(new Color(115, 215, 255));

        JLabel name = new JLabel("Наименование: ");
        name.setBounds(MARGIN, MARGIN, 150, 20);
        toyPanel.add(name);
        toyName = new JTextField(30);
        toyName.setBounds(150 + MARGIN, MARGIN, 150, 20);
        toyPanel.add(toyName);

        JLabel price = new JLabel("Цена: ");
        price.setBounds(MARGIN, 4 *MARGIN, 150, 20);
        toyPanel.add(price);
        toyPrice = new JFormattedTextField(numberFormat);
        toyPrice.setColumns(10);
        toyPrice.setBounds(150 + MARGIN, 4 * MARGIN, 150, 20);
        toyPanel.add(toyPrice);

        JLabel material = new JLabel("Материал: ");
        material.setBounds(MARGIN, 12 * MARGIN, 150, 20);
        toyPanel.add(material);
        toyMaterial = new JTextField();
        toyMaterial.setBounds(150 + MARGIN, 12 * MARGIN, 150, 20);
        toyPanel.add(toyMaterial);

        JLabel productionDate = new JLabel("Дата производства: ");
        productionDate.setBounds(MARGIN, 16 * MARGIN, 150, 20);
        toyPanel.add(productionDate);
        toyProductionDate = new JFormattedTextField(createFormatter("##.##.####"));
        toyProductionDate.setColumns(10);
        toyProductionDate.setBounds(150 + MARGIN, 16 * MARGIN, 150, 20);
        toyPanel.add(toyProductionDate);

        this.add(toyPanel);
    }

    private void setUpFormats() {
        numberFormat = NumberFormat.getNumberInstance();
    }

    public void setUpMilkProductPanel() {
        milkProductPanel = new JPanel(null);
        milkProductPanel.setBounds(0, 4 * MARGIN, WIDTH, HEIGHT - 15 * MARGIN);
        milkProductPanel.setBackground(new Color(252, 220, 173));

        JLabel name = new JLabel("Наименование: ");
        name.setBounds(MARGIN, MARGIN, 150, 20);
        milkProductPanel.add(name);
        milkProductName = new JTextField(30);
        milkProductName.setBounds(150 + MARGIN, MARGIN, 150, 20);
        milkProductPanel.add(milkProductName);

        JLabel price = new JLabel("Цена: ");
        price.setBounds(MARGIN, 4 *MARGIN, 150, 20);
        milkProductPanel.add(price);
        milkProductPrice = new JFormattedTextField(numberFormat);
        milkProductPrice.setColumns(10);
        milkProductPrice.setBounds(150 + MARGIN, 4 * MARGIN, 150, 20);
        milkProductPanel.add(milkProductPrice);

        JLabel weight = new JLabel("Вес: ");
        weight.setBounds(MARGIN, 8 * MARGIN, 150, 20);
        milkProductPanel.add(weight);
        milkProductWeight = new JFormattedTextField(numberFormat);
        milkProductWeight.setColumns(10);
        milkProductWeight.setBounds(150 + MARGIN, 8 * MARGIN, 150, 20);
        milkProductPanel.add(milkProductWeight);

        JLabel composition = new JLabel("Состав: ");
        composition.setBounds(MARGIN, 12 * MARGIN, 150, 20);
        milkProductPanel.add(composition);
        milkProductComposition = new JTextField();
        milkProductComposition.setBounds(150 + MARGIN, 12 * MARGIN, 150, 20);
        milkProductPanel.add(milkProductComposition);

        JLabel productionDate = new JLabel("Дата производства: ");
        productionDate.setBounds(MARGIN, 16 * MARGIN, 150, 20);
        milkProductPanel.add(productionDate);
        milkProductProductionDate = new JFormattedTextField(createFormatter("##.##.####"));
        milkProductProductionDate.setColumns(10);
        milkProductProductionDate.setBounds(150 + MARGIN, 16 * MARGIN, 150, 20);
        milkProductPanel.add(milkProductProductionDate);

        JLabel expireDate = new JLabel("Годен до: ");
        expireDate.setBounds(MARGIN, 20 * MARGIN, 150, 20);
        milkProductPanel.add(expireDate);
        milkProductExpireDate = new JFormattedTextField(createFormatter("##.##.####"));
        milkProductExpireDate.setColumns(10);
        milkProductExpireDate.setBounds(150 + MARGIN, 20 * MARGIN, 150, 20);
        milkProductPanel.add(milkProductExpireDate);

        this.add(milkProductPanel);
    }

    public void clearAllFields() {
        milkProductName.setText("");
        milkProductPrice.setText("");
        milkProductWeight.setText("");
        milkProductComposition.setText("");
        milkProductProductionDate.setText("");
        milkProductExpireDate.setText("");

        toyName.setText("");
        toyPrice.setText("");
        toyMaterial.setText("");
        toyProductionDate.setText("");
    }

    public boolean areAllMilkProductFieldsFilled() {
        return !milkProductName.getText().equals("") &&
                !milkProductPrice.getText().equals("") &&
                !milkProductWeight.getText().equals("") &&
                !milkProductComposition.getText().equals("") &&
                !milkProductProductionDate.getText().equals("") &&
                !milkProductExpireDate.getText().equals("");
    }

    public boolean areAllToyFieldsFilled() {
        return !toyName.getText().equals("") &&
                !toyPrice.getText().equals("") &&
                !toyMaterial.getText().equals("") &&
                !toyProductionDate.getText().equals("");
    }

    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

}
