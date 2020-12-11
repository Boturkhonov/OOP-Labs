package View;

import javax.swing.*;
import java.awt.*;

public class CreateDialog extends JDialog {

    final int WIDTH = 330;
    final int HEIGHT = 130;

    private JTextField supermarketName;
    private JButton createButton;

    public JTextField getSupermarketName() {
        return supermarketName;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public CreateDialog(JFrame frame) {
        super(frame, "Создать новый супермаркет", true);
        setResizable(false);
        setLayout(null);
        setBounds(frame.getBounds().x + frame.getWidth() / 2 - WIDTH / 2,
                frame.getBounds().y + frame.getHeight() / 2 - HEIGHT / 2,
                WIDTH, HEIGHT);
        setUpContent();
    }

    private void setUpContent() {
        JLabel name = new JLabel("Наименование: ");
        name.setBounds(10, 10, 150, 20);
        this.add(name);
        supermarketName = new JTextField(30);
        supermarketName.setBounds(150 + 10, 10, 150, 20);
        this.add(supermarketName);

        createButton = new JButton("Создать");
        createButton.setBounds(110, 50, 100, 25);
        createButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(createButton);
    }
}
