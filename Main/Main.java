package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

        // JLabel boardGame;
        // ImageIcon bg = new ImageIcon("/res/BackGround/background1.png");
        // boardGame = new JLabel("", bg, JLabel.CENTER);
        // boardGame.setBounds(0, 0, 832, 832);
        // window.add(boardGame);

        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startgameThread();
        gamePanel.setupGame();
    }

}
