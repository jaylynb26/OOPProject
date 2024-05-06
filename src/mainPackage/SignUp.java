package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public SignUp() {
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);

        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });
        panel.add(signUpButton);

        getContentPane().add(panel);

        setVisible(false); // starts out invisible, shown when "Sign Up" button is clicked
    }

    // sign up method
    private void signUp() {
        // Get username and password from fields
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // validate username and password
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username and password.", "Sign Up Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // add new user to credentials manager
        AuthenticationManager.addUser(username, password);

        // display success message
        JOptionPane.showMessageDialog(this, "User account created successfully!", "Sign Up Success", JOptionPane.INFORMATION_MESSAGE);

        // close form
        dispose();
    }
}