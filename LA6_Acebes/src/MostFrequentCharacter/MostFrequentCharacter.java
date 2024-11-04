package MostFrequentCharacter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.HashMap;

public class MostFrequentCharacter extends JFrame{
    private JPanel MainPanel;
    private JTextArea textArea;
    private JLabel frequentCharLabel;
    private JLabel bannerLabel;


    public MostFrequentCharacter() {
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                getFreqChar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getFreqChar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getFreqChar();
            }
        });
    }

    private void getFreqChar() {
        HashMap<Character, Integer> charFreqList= new HashMap<>();
        String LastChar = textArea.getText().replaceAll("\\s+","").toLowerCase();
        char mostFreqChar = 0;
        int mostFreqNum=0;

        for(int i=0;i<LastChar.length();i++) {
            char c = LastChar.charAt(i);
            charFreqList.put(c, charFreqList.getOrDefault(c, 0) + 1);

            if (mostFreqNum < charFreqList.get(c)) {
                mostFreqChar = c;
                mostFreqNum = charFreqList.get(c);
            }
        }
        frequentCharLabel.setText("The most frequent character is:      " + mostFreqChar);
    }

    public static void main(String[] args) {
        MostFrequentCharacter app = new MostFrequentCharacter();
        app.setTitle("Most Frequent Character");
        app.setContentPane(app.MainPanel);
        app.setSize(450, 550);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setResizable(false);
    }
}
