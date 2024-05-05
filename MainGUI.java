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
                // Add your login logic here
                if (authenticate(username, password)) {
                    dispose(); // Close login window
                    showMainMenu(); // Show main menu
                } else {
                    JOptionPane.showMessageDialog(MainGUI.this, "Invalid username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);

        getContentPane().add(panel);

        setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        // Replace this method with your authentication logic
        // For demonstration, we'll simply check if username and password are not empty
        return !username.isEmpty() && !password.isEmpty();
    }

    private void showMainMenuUser() {
        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(300, 200);
        mainMenuFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome " + usernameLabel + "!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JButton option1Button = new JButton("Option 1");
        option1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action for option 1
                JOptionPane.showMessageDialog(mainMenuFrame, "Option 1 clicked!");
            }
        });
        panel.add(option1Button);

        JButton option2Button = new JButton("Option 2");
        option2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action for option 2
                JOptionPane.showMessageDialog(mainMenuFrame, "Option 2 clicked!");
            }
        });
        panel.add(option2Button);

        mainMenuFrame.getContentPane().add(panel);

        mainMenuFrame.setVisible(true);
    }

    private void showMainMenuAdmin() {
        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(300, 200);
        mainMenuFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome Admin!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JButton option1Button = new JButton("Option 1");
        option1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action for option 1
                JOptionPane.showMessageDialog(mainMenuFrame, "Option 1 clicked!");
            }
        });
        panel.add(option1Button);

        JButton option2Button = new JButton("Option 2");
        option2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action for option 2
                JOptionPane.showMessageDialog(mainMenuFrame, "Option 2 clicked!");
            }
        });
        panel.add(option2Button);

        mainMenuFrame.getContentPane().add(panel);

        mainMenuFrame.setVisible(true);
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
