package Menu;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import Main.GamePanel;

public class MenuBackSide extends JComponent implements ActionListener {   
    private JFrame frame;
    private int width;
    private int height;
    private JButton menuButton;
    private GamePanel gamePanel;

    public MenuBackSide(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        gamePanel.add(this);
    }
    public void run() throws IOException{
        menuButton = new JButton("Menu");
        menuButton.setBounds(832, 0, gamePanel.infoPlayer * 16, gamePanel.Menuheight);
        menuButton.setFocusable(false);
        menuButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.stopGameThread();
    }
}
