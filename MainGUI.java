package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public MainGUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // authentication
                if (authenticate(username, password)) {
                    dispose(); // close login window
                    showMainMenu(username); // show main menu with username
                } else {
                    JOptionPane.showMessageDialog(MainGUI.this, "Invalid username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);
        
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSignUpForm(); // show the registration form
            }
        });
        panel.add(signUpButton);


        getContentPane().add(panel);

        setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        // replace with authentication logic
        // check if username and password are not empty
        return !username.isEmpty() && !password.isEmpty();
    }
    
    private void showSignUpForm() {
        // instantiate and display registration form
        SignUp signUpForm = new SignUp();
        signUpForm.setVisible(true);
    }

    private void showMainMenu(String username) {
    	boolean isAdmin = username.equals("admin");

        if (isAdmin) {
            AdminGUI adminGUI = new AdminGUI(username);
            adminGUI.setVisible(true);
        } else {
            NormalUserGUI normalUserGUI = new NormalUserGUI(username);
            normalUserGUI.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI();
            }
        });
    }
}