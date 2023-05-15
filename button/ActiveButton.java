package button;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.*;

import Main.GamePanel;

public class ActiveButton extends Button {
    public int purchaseAmount;
    public int saleAmount;

    public ActiveButton(GamePanel gp, String landName, int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight) {
        super(gp, landName, landX, landY, landWidth, landHeight);
        this.purchaseAmount = purchaseAmount;
        this.saleAmount = saleAmount;
        // getButtonLand();
    }

    // public void getButtonLand() {
        
    //     JButton b = new JButton("hello");
    //     b.setBounds(landX, landY, landWidth, landHeight);
    //     // b.setBackground(Color.BLACK);
    //     // b.setForeground(Color.CYAN);
    //     this.getGp().setLayout(null);
    //     this.getGp().add(b);
    
    //     b.addActionListener(this);
    //     // b.setOpaque(true);
    // }

    // @Override
    // public void actionPerformed(ActionEvent e) {

    //     JOptionPane optionPane = new JOptionPane();
    //     optionPane.setMessage(toString());
    //     optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
    
    //     JDialog dialog = optionPane.createDialog(null, landName);
    //     if (gp.gameState == gp.playState) dialog.setVisible(true);
        
    // }

    public String getLandName() {
        return landName;
    }

    public int getLandX() {
        return landX;
    }

    public int getLandY() {
        return landY;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getSaleAmount() {
        return saleAmount;
    }
    
}
