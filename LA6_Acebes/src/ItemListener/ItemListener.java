package ItemListener;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ItemListener extends JFrame {

    private JPanel MainPanel;
    private JCheckBox cCheckBox;
    private JCheckBox cppCheckBox;
    private JCheckBox cSharpCheckBox;
    private JCheckBox javaCheckBox;
    private JCheckBox pythonCheckBox;
    private JComboBox<String> proficiencyComboBox;
    private JLabel proficiencyLabel;
    private JLabel languageLabel;


    public ItemListener() {
        ArrayList<String> chosenLang = new ArrayList<>();

        proficiencyComboBox.addActionListener(e -> proficiencyLabel.setText("Proficiency: " + proficiencyComboBox.getSelectedItem()));

        ActionListener listener = e -> {
            JCheckBox genericBox = (JCheckBox)e.getSource();
            if (genericBox.isSelected()) {
                chosenLang.add(genericBox.getText());
            }
            if (!genericBox.isSelected()) {
                chosenLang.remove(genericBox.getText());
            }

            StringBuilder favLang = new StringBuilder("My Favorite Languages: ");
            if(!chosenLang.isEmpty()) {
                favLang.append(String.join(", ", chosenLang));
            }
            languageLabel.setText(favLang.toString());
        };

        cCheckBox.addActionListener(listener);
        cppCheckBox.addActionListener(listener);
        cSharpCheckBox.addActionListener(listener);
        javaCheckBox.addActionListener(listener);
        pythonCheckBox.addActionListener(listener);
    }

    public static void main(String[] args) {
        ItemListener app = new ItemListener();
        app.setTitle("Food Ordering System");
        app.setContentPane(app.MainPanel);
        app.setSize(400, 450);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
