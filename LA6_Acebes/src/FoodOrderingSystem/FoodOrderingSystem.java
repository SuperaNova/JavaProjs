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
        Order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total=0;
                if(pizzaCheckBox.isSelected()) {
                    total += 100;
                }
                if(burgerCheckBox.isSelected()) {
                    total += 80;
                }
                if(friesCheckBox.isSelected()) {
                    total += 65;
                }
                if(softDrinksCheckBox.isSelected()) {
                    total += 55;
                }
                if(teaCheckBox.isSelected()) {
                    total += 50;
                }
                if(sundaeCheckBox.isSelected()) {
                    total += 40;
                }

                if(a5OffRadioButton.isSelected()) {
                    total = total - (total * 0.05);
                }
                if(a10OffRadioButton.isSelected()) {
                    total = total - (total * 0.10);
                }
                if(a15OffRadioButton.isSelected()) {
                    total = total - (total * 0.15);
                }

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
