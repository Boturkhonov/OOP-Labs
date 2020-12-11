package View;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyFrame extends JFrame {

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem[] fileMenuItems = new JMenuItem[4];

    private JPanel infoPanel;

    private JPanel leftInfoPanel;
    private JLabel supermarketName;

    private JPanel rightInfoPanel;
    private JPanel milkProductPanel;
    DefaultTableModel milkProductTableModel;
    private JTable milkProductTable;
    private JPanel toyPanel;
    DefaultTableModel toyTableModel;
    private JTable toyTable;

    private JPanel actionPanel;
    private JButton addButton;
    private JButton removeButton;

    private AddDialog addDialog;
    private CreateDialog createDialog;

    String[] milkProductTableColumnNames = {
            "Наименование",
            "Цена",
            "Вес",
            "Состав",
            "Дата производства",
            "Годен до"
    };

    String[] toyTableColumnNames = {
            "Наименование",
            "Цена",
            "Материал",
            "Дата производства",
    };

    public AddDialog getAddDialog() {
        return addDialog;
    }

    public CreateDialog getCreateDialog() {
        return createDialog;
    }

    public JTable getMilkProductTable() {
        return milkProductTable;
    }

    public JTable getToyTable() {
        return toyTable;
    }

    public JLabel getSupermarketName() {
        return supermarketName;
    }

    public JMenuItem[] getFileMenuItems() {
        return fileMenuItems;
    }

    public DefaultTableModel getMilkProductTableModel() {
        return milkProductTableModel;
    }

    public DefaultTableModel getToyTableModel() {
        return toyTableModel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public MyFrame() {
        setUpWindow();
        setUpMenuBar();
        setUpInfoPanel();
        setUpActionPanel();
        setUpDialogs();
        this.setVisible(true);
    }

    private void setUpDialogs() {
        addDialog = new AddDialog(this);
        createDialog = new CreateDialog(this);
    }

    void setUpWindow() {
        this.setTitle("Управление товарами");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(935, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        ImageIcon imageIcon = new ImageIcon("images/logo.png");
        this.setIconImage(imageIcon.getImage());

    }

    void setUpMenuBar() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);

        fileMenuItems[0] = new JMenuItem("Создать новый");
        fileMenu.add(fileMenuItems[0]);
        fileMenuItems[0].setIcon(new ImageIcon("images/create-icon.png"));

        fileMenuItems[1] = new JMenuItem("Открыть...");
        fileMenu.add(fileMenuItems[1]);
        fileMenuItems[1].setIcon(new ImageIcon("images/open-icon.png"));

        fileMenuItems[2] = new JMenuItem("Сохранить");
        fileMenu.add(fileMenuItems[2]);
        fileMenuItems[2].setIcon(new ImageIcon("images/save-icon.png"));

        fileMenu.addSeparator();

        fileMenuItems[3] = new JMenuItem("Выход");
        fileMenu.add(fileMenuItems[3]);
        fileMenuItems[3].setIcon(new ImageIcon("images/exit-icon.png"));


        this.setJMenuBar(menuBar);
    }

    private void setUpInfoPanel() {
        infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBackground(Color.black);
        infoPanel.setPreferredSize(new Dimension(100, 100));

        leftInfoPanel = new JPanel();
        leftInfoPanel.setLayout(new BorderLayout());
        leftInfoPanel.setPreferredSize(new Dimension(150, 100));
        leftInfoPanel.setBorder(new LineBorder(Color.BLACK, 1));
        infoPanel.add(leftInfoPanel, BorderLayout.WEST);

        supermarketName = new JLabel();
        leftInfoPanel.add(supermarketName);

        rightInfoPanel = new JPanel(new BorderLayout());
        rightInfoPanel.setLayout(new BorderLayout());
        infoPanel.add(rightInfoPanel, BorderLayout.CENTER);

        milkProductPanel = new JPanel();
        milkProductPanel.setBackground(new Color(236, 236, 236, 255));
        milkProductPanel.setLayout(new BorderLayout());
        milkProductPanel.setBorder(new EtchedBorder());
        rightInfoPanel.add(milkProductPanel, BorderLayout.CENTER);

        toyPanel = new JPanel();
        toyPanel.setBackground(new Color(236, 236, 236, 255));
        toyPanel.setPreferredSize(new Dimension(310,100));
        toyPanel.setLayout(new BorderLayout());
        toyPanel.setBorder(new EtchedBorder());
        rightInfoPanel.add(toyPanel, BorderLayout.EAST);

        JLabel label = new JLabel("Список молочных продуктов");
        label.setFont(new Font("Verdana", Font.BOLD, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        milkProductPanel.add(label, BorderLayout.PAGE_START);

        label = new JLabel("Список игрушек");
        label.setFont(new Font("Verdana", Font.BOLD, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        toyPanel.add(label, BorderLayout.PAGE_START);

        milkProductTableModel = new DefaultTableModel();

        milkProductTable = new JTable(milkProductTableModel){
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        milkProductTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                toyTable.getSelectionModel().clearSelection();
            }
        });

        for (String milkProductTableColumnName : milkProductTableColumnNames) {
            milkProductTableModel.addColumn(milkProductTableColumnName);
        }

        milkProductTable.setRowSelectionAllowed(true);
        milkProductTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        milkProductTable.setFillsViewportHeight(true);
        milkProductTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        milkProductPanel.add(new JScrollPane(milkProductTable));

        toyTableModel = new DefaultTableModel();

        toyTable = new JTable(toyTableModel){
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        toyTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                milkProductTable.getSelectionModel().clearSelection();
            }
        });

        for (String toyTableColumnName : toyTableColumnNames) {
            toyTableModel.addColumn(toyTableColumnName);
        }

        toyTable.setRowSelectionAllowed(true);
        toyTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        toyTable.setFillsViewportHeight(true);
        toyPanel.add(new JScrollPane(toyTable));

        infoPanel.setEnabled(false);

        this.add(infoPanel, BorderLayout.CENTER);
    }

    private void setUpActionPanel() {
        actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50,30));
        actionPanel.setPreferredSize(new Dimension(100, 100));

        addButton = new JButton("Добавить товар");

        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setEnabled(false);
        actionPanel.add(addButton);

        removeButton = new JButton("Удалить товар");
        removeButton.setFocusable(false);
        removeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeButton.setEnabled(false);
        actionPanel.add(removeButton);

        this.add(actionPanel, BorderLayout.SOUTH);
    }

}
