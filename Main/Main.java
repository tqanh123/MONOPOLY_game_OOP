package Main;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        
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
        
    }

}
