package LeapYearChecker;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {
    private JTextField yearTextField;
    private JButton checkYearButton;
    private JPanel MainPanel;

    public LeapYearChecker() {
        yearTextField.setName("yearTextField");
        checkYearButton.setName("checkYearButton");
        MainPanel.setName("Leap Year Checker");
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(yearTextField.getText());
                    boolean isLeapYear = false;
                    if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) isLeapYear = true;

                    if(isLeapYear) {
                        JOptionPane.showMessageDialog(null, "Leap year");
                    } else {
                        JOptionPane.showMessageDialog(null, "Not a leap year");
                    }
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input a proper year!");
                }
            }
        });
    }
    public static void main(String[] args) {
        LeapYearChecker app = new LeapYearChecker();
        app.setTitle("Leap Year Checker");
        app.setContentPane(app.MainPanel);
        app.setSize(300, 200);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
