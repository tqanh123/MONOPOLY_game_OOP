package button;

import Main.GamePanel;

public class LandButton extends ActiveButton {
    private int numHouse = 0, numHotels;
    private int rentAmount[] = new int[6];

    public int getValue() {
        return super.getSaleAmount() + (super.getId() / 9  + 1) * 50 * getNumHouse();
    }

    public int mono = 1;

    public LandButton(GamePanel gp, int id, String landName, int numHouse, int numHotels, int rentAmount[], int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight, boolean isOwn) {
        super(gp, id, landName, purchaseAmount, saleAmount, landX, landY, landWidth, landHeight, isOwn);
        this.numHotels = numHotels;
        this.numHouse = numHouse;
        this.rentAmount = rentAmount;
    }

    public String toString() {
        return String.format("Number of house: %d\nNumber of hotel: %d\nRent: %d\nRent for 1 house: %d\nRent for 2 houses: %d\nRent for 3 houses: %d\nRent for hotel: %d \n\nPurchase prices: %d\nSale prices: %d\nRecent rent amount: %d"
        , numHouse, numHotels, rentAmount[0], rentAmount[1], rentAmount[2], rentAmount[3], rentAmount[4], super.getPurchaseAmount(), super.getSaleAmount(), getTotalrent());
    }

    public int getTotalrent() {

        int[] rent = this.getRentAmount();
        return rent[getNumHouse()];

    }

    public int getNumHouse() {
        return numHouse;
    }

    public int[] getRentAmount() {
        return rentAmount;
    }

    public void setNumHouse(int numHouse){
        this.numHouse = numHouse;
    }

}
