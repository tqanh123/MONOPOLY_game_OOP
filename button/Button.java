package button;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.event.*;

import Main.GamePanel;

public abstract class Button implements ActionListener {
    public String landName;
    public int landX, landY;
    
    public int purchaseAmount;
    public int saleAmount;
    
    GamePanel gp;

    public Button(GamePanel gp, String landName, int purchaseAmount, int saleAmount, int landX, int landY) {
        this.landName = landName;
        this.landX = landX;
        this.landY = landY;
        this.purchaseAmount = purchaseAmount;
        this.saleAmount = saleAmount;
        this.gp = gp;
        getButtonLand();
    }

    public void getButtonLand() {
        int height = 2 * this.getGp().place * this.getGp().originalTileSize;
        int width = this.getGp().place * this.getGp().originalTileSize;
        
        JButton b = new JButton("hello");
        b.setBounds(landX, landY, width, height);
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
