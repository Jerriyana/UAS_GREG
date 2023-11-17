import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuLogin extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    static DatabaseHandler conn = new DatabaseHandler();

    public MenuLogin() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (authenticateUser(emailField.getText(), String.valueOf(passwordField.getPassword()))) {
                    dispose();                     
                    new MenuListGame();
                } else {
                    JOptionPane.showMessageDialog(MenuLogin.this, "Login failed. Invalid email or password.");
                }
            }
        });

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean authenticateUser(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        conn.connect();

        try {
            String query = "SELECT * FROM users WHERE email=? AND password=?";
            preparedStatement = conn.con.prepareStatement(query); // Use conn.con
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // If there is a row, the user is authenticated
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                // Use conn.disconnect() instead of connection.close()
                conn.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}