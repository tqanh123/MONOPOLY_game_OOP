package Main;

import javax.swing.*;

public class GameRule extends JFrame {

    public GameRule() {
        setTitle("Monopoly Game Rules");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("Monopoly Game Rules:\n\n"
                + "1. Setup: Each player starts with a set amount of money...\n\n"
                + "2. Turn Sequence: Players take turns in clockwise order...\n\n"
                + "3. Property Ownership: If a player lands on an unowned property...\n\n"
                + "4. Rent: When a player lands on a property owned by another player...\n\n"
                + "5. Building Houses and Hotels: Players can buy houses and hotels...\n\n"
                + "6. Chance and Community Chest Cards: When a player lands on these spaces...\n\n"
                + "7. Jail: If a player lands on the \"Go to Jail\" space...\n\n"
                + "8. Free Parking: This space has no major gameplay effect...\n\n"
                + "9. Bankruptcy: If a player cannot afford to pay rent, fines, or other expenses...\n\n"
                + "10. Winning the Game: The game ends when all players but one are bankrupt...\n\n"
                + "Enjoy playing Monopoly!");

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameRule frame = new GameRule();
            frame.setVisible(true);
        });
    }
}