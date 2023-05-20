package button;

<<<<<<< HEAD
=======
import java.awt.event.ActionListener;
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.*;

import Main.GamePanel;

<<<<<<< HEAD
public abstract class Button implements ActionListener {
    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;
    
    public int purchaseAmount;
    public int saleAmount;
    
    GamePanel gp;

    public Button(GamePanel gp, String landName, int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight) {
=======
public class Button implements ActionListener{

    GamePanel gp;

    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;

    public Button (GamePanel gp, String landName, int landX, int landY, int landWidth, int landHeight) {
        this.gp = gp;
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
        this.landName = landName;
        this.landX = landX;
        this.landY = landY;
        this.landWidth = landWidth;
        this.landHeight = landHeight;
<<<<<<< HEAD
        this.purchaseAmount = purchaseAmount;
        this.saleAmount = saleAmount;
        this.gp = gp;
        getButtonLand();
    }

    public void getButtonLand() {
        
        JButton b = new JButton("hello");
        b.setBackground(Color.LIGHT_GRAY);
        b.setBounds(landX, landY, landWidth, landHeight);
=======
        getButton();
    }

    public void getButton() {
        
        JButton b = new JButton("hello");
        b.setBounds(landX, landY, landWidth, landHeight);
        System.out.print(getLandName());
        // b.setBackground(Color.BLACK);
        // b.setForeground(Color.CYAN);
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
        this.getGp().setLayout(null);
        this.getGp().add(b);
    
        b.addActionListener(this);
<<<<<<< HEAD
        // b.setOpaque(false);
=======
        // b.setOpaque(true);
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(toString());
        optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
    
<<<<<<< HEAD
        JDialog dialog = optionPane.createDialog(null, landName);
        dialog.setVisible(true);
        
    }

=======
        JDialog dialog = optionPane.createDialog(null, getLandName());
        if (gp.gameState == gp.playState) dialog.setVisible(true);
        
    }

    public GamePanel getGp() {
        return gp;
    }

>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
    public String getLandName() {
        return landName;
    }

    public int getLandX() {
        return landX;
    }

    public int getLandY() {
        return landY;
    }

<<<<<<< HEAD
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public GamePanel getGp() {
        return gp;
    }
    
}
=======
    public int getLandWidth() {
        return landWidth;
    }

    public int getLandHeight() {
        return landHeight;
    }
}
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
