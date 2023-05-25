package button;

import java.awt.Graphics2D;

import Main.GamePanel;

public class LandButton extends ActiveButton {
    private int numHouse, numHotels;
    private int rentAmount[] = new int[6];
    private boolean isOwn;
    private int host = 0;
    public int getHost() {
        return host;
    }

    public void setHost(int host) {
        this.host = host;
    }

    public void setOwn(boolean isOwn) {
        this.isOwn = isOwn;
    }

    public boolean isOwn() {
        return isOwn;
    }

    public int mono = 1;

    public LandButton(GamePanel gp, int id, String landName, int numHouse, int numHotels, int rentAmount[], int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight, boolean isOwn) {
        super(gp, id, landName, purchaseAmount, saleAmount, landX, landY, landWidth, landHeight, isOwn);
        this.numHotels = numHotels;
        this.numHouse = numHouse;
        this.rentAmount = rentAmount;
    }

    public String toString() {
        return String.format("Number of house: %d\nNumber of hotel: %d\nRent: %d\nRent for 1 house: %d\nRent for 2 houses: %d\nRent for 3 houses: %d\nRent for 4 houses: %d\nRent for hotel: %d \n\nPurchase prices: %d\nSale prices: %d"
        , numHouse, numHotels, rentAmount[0], rentAmount[1], rentAmount[2], rentAmount[3], rentAmount[4], rentAmount[5], super.getPurchaseAmount(), super.getSaleAmount());
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
