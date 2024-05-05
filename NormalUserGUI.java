package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome " + user.getUsername() + "!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JButton writeStoryButton = new JButton("Write a Story");
        writeStoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.writeStory(library);
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
    
    
    private void logout() {
        dispose(); 
        new MainGUI();
    }
}
