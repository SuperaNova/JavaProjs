package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField tfNumber1;
    private JComboBox<String> cbOperations;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JPanel MainPanel;
    private JLabel lblResult;

    public SimpleCalculator() {
        tfNumber1.setName("tfNumber1");
        tfNumber2.setName("tfNumber2");
        cbOperations.setName("cbOperations");
        btnCompute.setName("btnCompute");
        lblResult.setName("lblResult");

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    double x = Double.parseDouble(tfNumber1.getText());
                    double y = Double.parseDouble(tfNumber2.getText());
                    double res = 0;
                    switch (cbOperations.getSelectedIndex()) {
                        case 0:
                            res = x+y;
                            break;
                        case 1:
                            res = x-y;
                            break;
                        case 2:
                            res = x*y;
                            break;
                        case 3:
                            if(y == 0) throw new ArithmeticException();
                            res = x/y;
                            break;
                    }
                    lblResult.setText(String.format("%.2f", res));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter proper number inputs!");
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalculator app = new SimpleCalculator();
        app.setContentPane(app.MainPanel);
        app.setTitle("Simple Calculator");
        app.setSize(600, 400);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
