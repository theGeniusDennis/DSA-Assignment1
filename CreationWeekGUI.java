import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreationWeekGUI {
    public static void main(String[] args) {
        String[][] days = {
            {"Creation of light", "Genesis 1:3-5"},
            {"Creation of sky", "Genesis 1:6-8"},
            {"Creation of land, sea, and vegetation", "Genesis 1:9-13"},
            {"Creation of sun, moon, and stars", "Genesis 1:14-19"},
            {"Creation of birds and sea creatures", "Genesis 1:20-23"},
            {"Creation of land animals and humans", "Genesis 1:24-31"},
            {"God rested", "Genesis 2:1-3"}
        };

        JFrame frame = new JFrame("Creation Week");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, days);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, String[][] days) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Enter a day of the creation week (1-7):");
        userLabel.setBounds(10, 20, 300, 25);
        panel.add(userLabel);

        JTextField dayText = new JTextField(20);
        dayText.setBounds(10, 50, 165, 25);
        panel.add(dayText);

        JButton showButton = new JButton("Show Events");
        showButton.setBounds(10, 80, 150, 25);
        panel.add(showButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 110, 300, 25);
        panel.add(resultLabel);

        JLabel verseLabel = new JLabel("");
        verseLabel.setBounds(10, 140, 300, 25);
        panel.add(verseLabel);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int day = Integer.parseInt(dayText.getText());
                    if (day < 1 || day > 7) {
                        resultLabel.setText("Invalid day. Please enter a number between 1 and 7.");
                        verseLabel.setText("");
                    } else {
                        int index = day - 1;
                        resultLabel.setText("Day " + day + ": " + days[index][0]);
                        verseLabel.setText("Recorded in: " + days[index][1]);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter a number.");
                    verseLabel.setText("");
                }
            }
        });
    }
}
