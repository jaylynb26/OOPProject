package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {

    public AdminGUI(String username) {
        setTitle("Admin Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome " + username + "!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JButton viewLibraryButton = new JButton("View Library");
        viewLibraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // action to view library
                JOptionPane.showMessageDialog(AdminGUI.this, "View Library clicked!");
            }
        });
        panel.add(viewLibraryButton);

        JButton editStoriesButton = new JButton("Edit Stories");
        editStoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // action to edit stories
                JOptionPane.showMessageDialog(AdminGUI.this, "Edit Stories clicked!");
            }
        });
        panel.add(editStoriesButton);

        getContentPane().add(panel);

        setVisible(false); // starts invisible, shown when admin logs in
    }
}
