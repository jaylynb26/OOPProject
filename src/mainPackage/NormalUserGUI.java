package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class NormalUserGUI extends JFrame {

	private NormalUser user;
	private Library library;

    public NormalUserGUI(NormalUser user, Library library) {
        this.user = user;
        this.library = library;

        setTitle("Normal User Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("Welcome " + user.getUsername() + "!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);
        
        // drop down for genres
        JLabel genreLabel = new JLabel("Select Genre:");
        JComboBox<String> genreDropdown = new JComboBox<>(getAvailableGenres());
        panel.add(genreLabel);
        panel.add(genreDropdown);


        JButton writeStoryButton = new JButton("Write a Story");
        writeStoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String selectedGenre = (String) genreDropdown.getSelectedItem();
            	Story template = library.getTemplateByGenre(selectedGenre);
            	if (template == null) {
            	    JOptionPane.showMessageDialog(null, "No story template found for the selected genre.");
            	} else {
            	    showFillInBlanksGUI(template);
            	}

            }
        });
        panel.add(writeStoryButton);

        JButton viewSavedStoriesButton = new JButton("View Saved Stories");
        viewSavedStoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	user.viewSavedStories();            }
        });
        panel.add(viewSavedStoriesButton);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        panel.add(logoutButton);

        getContentPane().add(panel);

        setVisible(false); 
    }
    
    private String[] getAvailableGenres() {
        return new String[]{"fantasy", "sci-fi", "horror"};
    }
    
    private void showFillInBlanksGUI(Story template) {
        JFrame fillInBlanksFrame = new JFrame("Fill in the Blanks");
        fillInBlanksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fillInBlanksFrame.setSize(400, 300);
        fillInBlanksFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(template.getContent().size() + 2, 1)); // Adjusted size here

        JLabel titleLabel = new JLabel("Fill in the Blanks Story: " + template.getTitle());
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        for (String line : template.getContent()) {
            JLabel label = new JLabel("Enter a " + line + ":");
            panel.add(label);

            JTextField textField = new JTextField();
            panel.add(textField);
        }

        JButton publishButton = new JButton("Publish");
        publishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillInBlanksFrame.dispose();
            }
        });
        panel.add(publishButton);

        fillInBlanksFrame.getContentPane().add(panel);
        fillInBlanksFrame.setVisible(true);
    }

    private void logout() {
        dispose(); 
        new MainGUI();
    }
}
