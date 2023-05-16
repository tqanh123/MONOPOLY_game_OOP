package button;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.*;

import Main.GamePanel;

public abstract class Button implements ActionListener {
    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;
    
    public int purchaseAmount;
    public int saleAmount;
    
    GamePanel gp;

    public Button(GamePanel gp, String landName, int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight) {
        this.landName = landName;
        this.landX = landX;
        this.landY = landY;
        this.landWidth = landWidth;
        this.landHeight = landHeight;
        this.purchaseAmount = purchaseAmount;
        this.saleAmount = saleAmount;
        this.gp = gp;
        getButtonLand();
    }

    public void getButtonLand() {
        
        JButton b = new JButton("hello");
        b.setBackground(Color.LIGHT_GRAY);
        b.setBounds(landX, landY, landWidth, landHeight);
        this.getGp().setLayout(null);
        this.getGp().add(b);
    
        b.addActionListener(this);
        // b.setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(toString());
        optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
    
        JDialog dialog = optionPane.createDialog(null, landName);
        dialog.setVisible(true);
        
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
