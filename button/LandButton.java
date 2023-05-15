<<<<<<< HEAD
<<<<<<< HEAD
package button;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.awt.*;

import Main.GamePanel;

public class LandButton implements ActionListener {
    private String landName;
    private int numHouse, numHotels;
    private int rentAmount[] = new int[6];
    private int landX, landY;
    GamePanel gp;

    public LandButton(GamePanel gp, String landName, int numHouse, int numHotels, int rentAmount[], int landX, int landY) {
        this.landName = landName;
        this.numHotels = numHotels;
        this.numHouse = numHouse;
        this.rentAmount = rentAmount;
        this.landX = landX;
        this.landY = landY;
        this.gp = gp;

        getButtonLand();
    }

    public void getButtonLand() {

        int height = 2 * gp.place * gp.originalTileSize;
        int width = gp.place * gp.originalTileSize;


        JButton b = new JButton("hello");
        Color c = new Color(0, 0, 0, 10);
        b.setBounds(landX, landY, width, height);
        b.setBackground(c);
        b.setForeground(Color.MAGENTA);
        gp.setLayout(null);
        gp.add(b);

        b.addActionListener(this);
        b.setOpaque(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(toString());
        optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);

        JDialog dialog = optionPane.createDialog(null, landName);
        dialog.setVisible(true);

    }  

    public String toString() {
        return String.format("Name: %s\nNumber of house: %d\nNumber of hotel: %d\nRent: %d\nRent for 1 house: %d\nRent for 2 houses: %d\nRent for 3 houses: %d\nRent for 4 houses: %d\nRent for hotel: %d"
        , landName, numHouse, numHotels, rentAmount[0], rentAmount[1], rentAmount[2], rentAmount[3], rentAmount[4], rentAmount[5] );
    }
}
=======
=======
>>>>>>> ed1c4d7ce03455f050cc296aa30cc6c962bbdf9c
package button;

// import javax.swing.JButton;
// import javax.swing.JDialog;
// import javax.swing.JOptionPane;

// import java.awt.event.*;
// import java.awt.*;

import Main.GamePanel;

public class LandButton extends Button {
    private int numHouse, numHotels;
    private int rentAmount[] = new int[6];
    public int mono = 1;

    public LandButton(GamePanel gp, String landName, int numHouse, int numHotels, int rentAmount[], int purchaseAmount, int saleAmount, int landX, int landY) {
        super(gp, landName, purchaseAmount, saleAmount, landX, landY);
        this.numHotels = numHotels;
        this.numHouse = numHouse;
        this.rentAmount = rentAmount;
    }

    public String toString() {
        return String.format("Number of house: %d\nNumber of hotel: %d\nRent: %d\nRent for 1 house: %d\nRent for 2 houses: %d\nRent for 3 houses: %d\nRent for 4 houses: %d\nRent for hotel: %d"
        , numHouse, numHotels, rentAmount[0], rentAmount[1], rentAmount[2], rentAmount[3], rentAmount[4], rentAmount[5] );
    }

    public int getTotalrent() {

        int[] rent = this.getRentAmount();
        if (this.getNumHouse() == 0 && this.getNumHotels() == 0) return rent[0] * mono;      
        else {
            return (rent[this.getNumHouse()] + rent[5] * this.getNumHotels()) * mono;
        }

    }

    public int getNumHouse() {
        return numHouse;
    }

    public int getNumHotels() {
        return numHotels;
    }

    public int[] getRentAmount() {
        return rentAmount;
    }
}
<<<<<<< HEAD
>>>>>>> 8d4a1e784d780a131724a1ab29a4ce85172059a5
=======
>>>>>>> ed1c4d7ce03455f050cc296aa30cc6c962bbdf9c
