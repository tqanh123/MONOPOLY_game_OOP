package button;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.event.*;

import Main.GamePanel;

public class Button implements ActionListener{

    GamePanel gp;

    private String landName;
    private int landX, landY;
    private int landWidth, landHeight;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Button (GamePanel gp, int id, String landName, int landX, int landY, int landWidth, int landHeight) {
        this.gp = gp;
        this.id = id;
        this.landName = landName;
        this.landX = landX;
        this.landY = landY;
        this.landWidth = landWidth;
        this.landHeight = landHeight;
        getButton();
    }

    // public void active(){
        
    // }

    public void getButton() {
        
        JButton b = new JButton("hello");
        b.setBounds(landX, landY, landWidth, landHeight);
        this.getGp().setLayout(null);
        this.getGp().add(b);
    
        b.addActionListener(this);
        b.setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(toString());
        optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
    
        JDialog dialog = optionPane.createDialog(null, getLandName());
        if (gp.gameState != gp.rollState) dialog.setVisible(true);
        
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