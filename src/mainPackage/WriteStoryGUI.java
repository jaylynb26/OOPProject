package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class WriteStoryGUI extends JFrame {

    private NormalUser user;
    private Library library;
    private List<Story> templates;

    public WriteStoryGUI(NormalUser user, Library library) {
        this.user = user;
        this.library = library;
        
        // Load templates from the "templates" folder
        templates = TemplateLoader.loadTemplatesFromFolder("templates");

        setTitle("Write a Story");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("Write a Story");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JLabel genreLabel = new JLabel("Select Genre:");
        JComboBox<String> genreDropdown = new JComboBox<>(getAvailableGenres());
        panel.add(genreLabel);
        panel.add(genreDropdown);

        JButton writeButton = new JButton("Write");
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedGenre = (String) genreDropdown.getSelectedItem();
                Story template = getTemplateByGenre(selectedGenre);
                if (template != null) {
                    writeStory(template);
                } else {
                    JOptionPane.showMessageDialog(null, "No template available for the selected genre.");
                }
            }
        });
        panel.add(writeButton);

        getContentPane().add(panel);
        setVisible(true);
    }

    private String[] getAvailableGenres() {
        List<String> genres = new ArrayList<>();
        for (Story template : templates) {
            genres.add(template.getGenre());
        }
        return genres.toArray(new String[0]);
    }

    private Story getTemplateByGenre(String genre) {
        for (Story template : templates) {
            if (template.getGenre().equalsIgnoreCase(genre)) {
                return template;
            }
        }
        return null;
    }

    private void writeStory(Story template) {
        JFrame writeStoryFrame = new JFrame();
        writeStoryFrame.setTitle("Write Your Story");
        writeStoryFrame.setSize(400, 300);
        writeStoryFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(template.getContent().size() * 2 + 3, 1));

        for (String line : template.getContent()) {
            JLabel label = new JLabel(line);
            panel.add(label);

            JTextField textField = new JTextField();
            panel.add(textField);
        }

        JButton publishButton = new JButton("Publish");
        publishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> filledBlanks = new ArrayList<>();
                Component[] components = panel.getComponents();
                for (int i = 1; i < components.length; i += 2) {
                    JTextField textField = (JTextField) components[i];
                    filledBlanks.add(textField.getText());
                }
                publishStory(template.getTitle(), template.getGenre(), filledBlanks);
                writeStoryFrame.dispose();
            }
        });
        panel.add(publishButton);

        writeStoryFrame.add(panel);
        writeStoryFrame.setVisible(true);
    }

    private void publishStory(String title, String genre, ArrayList<String> filledBlanks) {
        Story filledStory = new Story(title, genre, filledBlanks);
        user.addSavedStory(filledStory);
        JOptionPane.showMessageDialog(null, "Story published successfully!");
    }
}
