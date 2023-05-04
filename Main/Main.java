package Main;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Monopoly");

        GamePanel gamePanel = new GamePanel();
        window.setSize(gamePanel.screenHeight, gamePanel.screenHeight);
        System.out.println(gamePanel.screenHeight+ "  " + gamePanel.screenWidth);
        window.add(gamePanel);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
