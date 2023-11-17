import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuListGame extends JFrame {
    private JButton transactionsButton;
    private List<Games> games;

    public MenuListGame() {
        setTitle("Game List");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top Panel
        JPanel topPanel = new JPanel();
        transactionsButton = new JButton("Transactions");
        topPanel.add(transactionsButton);

        transactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTransactionsFrame();
            }
        });

        // Center Panel
        JPanel centerPanel = new JPanel(new GridLayout(0, 3, 10, 10));

        // ArrayList<Games> games = loadGame();
        loadGames();
     

        for (Games game : games) {
            centerPanel.add(createGamePanel(game));
        }

        // ScrollPane for Center Panel
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createGamePanel(Games game) {
        JPanel gamePanel = new JPanel(new BorderLayout());

        // Labels for Game Info
        JLabel nameLabel = new JLabel("Name: " + game.getName());
        JLabel genreLabel = new JLabel("Genre: " + game.getGenre());
        JLabel priceLabel = new JLabel("Price: $" + game.getPrice());

        // Image (Placeholder for now)
        JLabel imageLabel = new JLabel(new ImageIcon("path_to_your_image.jpg")); // Update with the actual path

        // Buy Button
        JButton buyButton = new JButton("Buy Game");
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyGame(game);
            }
        });

        // Info Panel
        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        infoPanel.add(nameLabel);
        infoPanel.add(genreLabel);
        infoPanel.add(priceLabel);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buyButton);

        // Game Panel
        gamePanel.add(imageLabel, BorderLayout.NORTH);
        gamePanel.add(infoPanel, BorderLayout.CENTER);
        gamePanel.add(buttonPanel, BorderLayout.SOUTH);

        return gamePanel;
    }

    private void loadGames() {
        // Fetch games from the database (query implementation needed)
        games = new ArrayList<>();

        // Sample Data (Replace with database query)
        games.add(new Games(1, "Game 1", "Action", 29));
        games.add(new Games(2, "Game 2", "Adventure", 39));
        games.add(new Games(3, "Game 3", "Strategy", 49));
        // ...

    }

    private void buyGame(Games game) {
        JOptionPane.showMessageDialog(this, "Game purchased successfully!");
    }

    private void openTransactionsFrame() {
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuListGame());
    }
}
