package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

public class Main {
    JFrame frame = new JFrame();
     
    public static void main(String[] args) {
        
       showWindow();
        
    }

    public static void showWindow() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Monopoly");
        
        GamePanel gamePanel = new GamePanel();
        gamePanel.setBackground(Color.LIGHT_GRAY);
    
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startgameThread();
<<<<<<< HEAD
=======
        gamePanel.setupGame();
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
    }

    public static Font deriveFont(float f) {
        return null;
    }

}
