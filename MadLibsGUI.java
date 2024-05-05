import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MadLibsGUI extends JFrame {

    private ArrayList<JTextField> textFields;

    public MadLibsGUI() {
        setTitle("Fill in the Blanks");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Fill in the Blanks Story");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        textFields = new ArrayList<>();

        // Add labels and text fields for each blank
        String[] blanks = {"noun", "verb", "adjective"};
        for (String blank : blanks) {
            JLabel label = new JLabel("Enter a " + blank + ":");
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(label);

            JTextField textField = new JTextField();
            textField.setAlignmentX(Component.CENTER_ALIGNMENT);
            textFields.add(textField);
            panel.add(textField);
        }

        JButton generateButton = new JButton("Generate Story");
        generateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateStory();
            }
        });
        panel.add(generateButton);

        getContentPane().add(panel);

        setVisible(true);
    }

    private void generateStory() {
        StringBuilder story = new StringBuilder("Once upon a time, there was a ");

        // Get user input from text fields and construct the story
        for (JTextField textField : textFields) {
            story.append(textField.getText()).append(" ");
        }

        story.append("who liked to ").append(textFields.get(1).getText()).append(" ");
        story.append("and was very ").append(textFields.get(2).getText()).append(".");

        JOptionPane.showMessageDialog(this, story.toString(), "Generated Story", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MadLibsGUI();
            }
        });
    }
}
