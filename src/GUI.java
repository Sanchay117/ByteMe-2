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
        frame.setSize(820,420);

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

        ArrayList<Food> menuList = main.menu;

        JList<Food> menuJList = new JList<>(menuList.toArray(new Food[0]));
        JScrollPane scrollPane = new JScrollPane(menuJList);

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
        frame.setSize(820, 420);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());

        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(e -> {
            frame.setVisible(false);
            showHomeScreen();
        });

        ArrayList<Order> menuList = main.orders;

        JList<Order> menuJList = new JList<>(menuList.toArray(new Order[0]));
        JScrollPane scrollPane = new JScrollPane(menuJList);

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