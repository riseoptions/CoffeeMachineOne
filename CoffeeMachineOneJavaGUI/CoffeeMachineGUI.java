package machine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoffeeMachineGUI extends JFrame {

    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int cash = 550;

    private JLabel statusLabel;

    public CoffeeMachineGUI() {
        setTitle("Coffee Machine");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create buttons
        JButton buyButton = new JButton("Buy");
        JButton fillButton = new JButton("Fill");
        JButton takeButton = new JButton("Take");
        JButton remainingButton = new JButton("Remaining");
        JButton exitButton = new JButton("Exit");

        // Status label
        statusLabel = new JLabel("Choose an action");

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.add(buyButton);
        panel.add(fillButton);
        panel.add(takeButton);
        panel.add(remainingButton);
        panel.add(exitButton);

        // Add panel and label to the frame
        add(panel, "Center");
        add(statusLabel, "South");

        // Button actions
        buyButton.addActionListener(e -> buyCoffee());
        fillButton.addActionListener(e -> fillResources());
        takeButton.addActionListener(e -> takeCash());
        remainingButton.addActionListener(e -> showRemaining());
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void buyCoffee() {
        String[] options = {"Espresso", "Latte", "Cappuccino"};
        int choice = JOptionPane.showOptionDialog(this, "Select coffee type", "Buy Coffee",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0 -> makeEspresso();
            case 1 -> makeLatte();
            case 2 -> makeCappuccino();
            default -> statusLabel.setText("No coffee selected");
        }
    }

    private void makeEspresso() {
        if (water >= 250 && coffeeBeans >= 16 && disposableCups >= 1) {
            water -= 250;
            coffeeBeans -= 16;
            disposableCups--;
            cash += 4;
            statusLabel.setText("Espresso made!");
        } else {
            statusLabel.setText("Not enough resources for Espresso");
        }
    }

    private void makeLatte() {
        if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposableCups >= 1) {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            disposableCups--;
            cash += 7;
            statusLabel.setText("Latte made!");
        } else {
            statusLabel.setText("Not enough resources for Latte");
        }
    }

    private void makeCappuccino() {
        if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposableCups >= 1) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            disposableCups--;
            cash += 6;
            statusLabel.setText("Cappuccino made!");
        } else {
            statusLabel.setText("Not enough resources for Cappuccino");
        }
    }

    private void fillResources() {
        water += 200;
        milk += 100;
        coffeeBeans += 50;
        disposableCups += 5;
        statusLabel.setText("Resources refilled!");
    }

    private void takeCash() {
        JOptionPane.showMessageDialog(this, "You took $" + cash);
        cash = 0;
    }

    private void showRemaining() {
        String remaining = "<html>Water: " + water + "ml<br>Milk: " + milk + "ml<br>Beans: " + coffeeBeans + "g<br>Cups: " + disposableCups +
                "<br>Cash: $" + cash + "</html>";
        statusLabel.setText(remaining);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CoffeeMachineGUI coffeeMachine = new CoffeeMachineGUI();
            coffeeMachine.setVisible(true);
        });
    }
}
