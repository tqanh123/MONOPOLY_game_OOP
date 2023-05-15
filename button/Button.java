package button;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.*;

import Main.GamePanel;

public class Button implements ActionListener{

    GamePanel gp;

    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;

    public Button (GamePanel gp, String landName, int landX, int landY, int landWidth, int landHeight) {
        this.gp = gp;
        this.landName = landName;
        this.landX = landX;
        this.landY = landY;
        this.landWidth = landWidth;
        this.landHeight = landHeight;
        getButton();
    }

    public void getButton() {
        
        JButton b = new JButton("hello");
        b.setBounds(landX, landY, landWidth, landHeight);
        System.out.print(getLandName());
        // b.setBackground(Color.BLACK);
        // b.setForeground(Color.CYAN);
        this.getGp().setLayout(null);
        this.getGp().add(b);
    
        b.addActionListener(this);
        // b.setOpaque(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(toString());
        optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
    
        JDialog dialog = optionPane.createDialog(null, getLandName());
        if (gp.gameState == gp.playState) dialog.setVisible(true);
        
    }

    public GamePanel getGp() {
        return gp;
    }

    public String getLandName() {
        return landName;
    }

    public int getLandX() {
        return landX;
    }

    public int getLandY() {
        return landY;
    }

    public int getLandWidth() {
        return landWidth;
    }

    public int getLandHeight() {
        return landHeight;
    }
}