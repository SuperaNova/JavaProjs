package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    private JCheckBox pizzaCheckBox;
    private JCheckBox burgerCheckBox;
    private JCheckBox friesCheckBox;
    private JCheckBox softDrinksCheckBox;
    private JCheckBox teaCheckBox;
    private JCheckBox sundaeCheckBox;
    private JRadioButton noneRadioButton;
    private JRadioButton a5OffRadioButton;
    private JRadioButton a10OffRadioButton;
    private JRadioButton a15OffRadioButton;
    private JButton Order;
    private JPanel MainPanel;

    public FoodOrderingSystem() {
        JRadioButton[] discounts = {noneRadioButton, a5OffRadioButton, a10OffRadioButton, a15OffRadioButton};
        JCheckBox[] foodchoice = {pizzaCheckBox, burgerCheckBox, friesCheckBox, softDrinksCheckBox, teaCheckBox, sundaeCheckBox};
        int[] prices = {100, 80, 65, 55, 50, 40};
        Order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;

                for (int i = 0; i < foodchoice.length; i++) {
                    if (foodchoice[i].isSelected()) {
                        total += prices[i];
                    }
                }

                int discountPercentage = 0;
                if (a5OffRadioButton.isSelected()) {
                    discountPercentage = 5;
                } else if (a10OffRadioButton.isSelected()) {
                    discountPercentage = 10;
                } else if (a15OffRadioButton.isSelected()) {
                    discountPercentage = 15;
                }

                total -= total * discountPercentage / 100;

                JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", total));
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderingSystem app = new FoodOrderingSystem();
        app.setTitle("Food Ordering System");
        app.setContentPane(app.MainPanel);
        app.setSize(350, 450);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}

