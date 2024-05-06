package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {

	private Admin admin;

    public AdminGUI(Admin admin) {
        this.admin = admin;

        setTitle("Admin Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome " + admin.getUsername() + "!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JButton viewLibraryButton = new JButton("View Library");
        viewLibraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.viewLibrary();
            }
        });
        panel.add(viewLibraryButton);

        JButton editStoriesButton = new JButton("Edit Stories");
        editStoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.editStories();
            }
        });
        panel.add(editStoriesButton);
        
        JButton deleteStoriesButton = new JButton("Delete a Story");
        deleteStoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.deleteStories();
            }
        });
        panel.add(deleteStoriesButton);
        
        JButton createTemplateButton = new JButton("Create Template");
        createTemplateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.createTemplate();
            }
        });
        panel.add(createTemplateButton);
        
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