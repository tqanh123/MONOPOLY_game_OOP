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
