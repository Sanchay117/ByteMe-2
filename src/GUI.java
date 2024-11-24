import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI{
    private static final Main main = new Main();

    private void showHomeScreen(){
        JFrame frame = new JFrame();

        frame.setTitle("Byte Me!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1020,420);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(e -> showMenuScreen(frame));

        JButton orderButton = new JButton("Orders");
        orderButton.addActionListener(e -> showOrderScreen(frame));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(menuButton, gbc);

        gbc.gridy = 1;
        panel.add(orderButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showMenuScreen(JFrame frame_previous){
        frame_previous.setVisible(false); // Hide the previous frame

        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(820, 420);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());

        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(e -> {
            frame.setVisible(false);
            showHomeScreen();
        });

        String[] columns = {"ID","Name","Price","Availability"};

        ArrayList<Food> menuList = main.menu;
        Object[][] menuData = new Object[menuList.size()][4];

        for (int i = 0; i < menuList.size(); i++) {
            Food food = menuList.get(i);
            menuData[i][0] = food.getID();
            menuData[i][1] = food.getName();
            menuData[i][2] = "₹" + food.getPrice();
            menuData[i][3] = food.isAvailable() ? "In Stock" : "Out of Stock";
        }

        JTable menuTable = new JTable(menuData, columns);
        menuTable.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(menuTable);

        menuPanel.add(goBackButton, BorderLayout.NORTH);
        menuPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(menuPanel);
        frame.setVisible(true);
    }

    private void showOrderScreen(JFrame frame_previous){
        frame_previous.setVisible(false); // Hide the previous frame

        JFrame frame = new JFrame("Orders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1020, 420);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());

        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(e -> {
            frame.setVisible(false);
            showHomeScreen();
        });

        ArrayList<Order> menuList = main.orders;

        String[] columns = {"Time","Price","Payment Method","Address","Status","Ordered By"};

        Object[][] menuData = new Object[menuList.size()][6];

        for (int i = 0; i < menuList.size(); i++) {
            Order order = menuList.get(i);
            menuData[i][0] = order.getOrderDate();
            menuData[i][1] = "₹" + order.getPrice();
            menuData[i][2] = order.getPaymentMethod();
            menuData[i][3] = order.getAddress();
            menuData[i][4] = order.getStatus();
            menuData[i][5] = order.getOrderedBy();
        }

        JTable menuTable = new JTable(menuData, columns);
        menuTable.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(menuTable);

        menuPanel.add(goBackButton, BorderLayout.NORTH);
        menuPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(menuPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        main.prepopulate();

        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.showHomeScreen();
        });
    }
}