package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NormalUserGUI extends JFrame {

    public NormalUserGUI(String username) {
        setTitle("Normal User Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome " + username + "!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JButton writeStoryButton = new JButton("Write a Story");
        writeStoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // action to write a story
                JOptionPane.showMessageDialog(NormalUserGUI.this, "Write a Story clicked!");
            }
        });
        panel.add(writeStoryButton);

        JButton viewSavedStoriesButton = new JButton("View Saved Stories");
        viewSavedStoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // action to view saved stories
                JOptionPane.showMessageDialog(NormalUserGUI.this, "View Saved Stories clicked!");
            }
        });
        panel.add(viewSavedStoriesButton);

        getContentPane().add(panel);

        setVisible(false); // starts invisible, shown when normal user logs in
    }
}
