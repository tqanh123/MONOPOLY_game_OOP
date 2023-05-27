package button;

import Main.GamePanel;

public class StationButton extends ActiveButton {

    private int numStation;
    private int[] rentAmount = new int[5];

    public StationButton(GamePanel gp, int id, String landName, int numStation, int[] rentAmount, int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight, boolean isOwn) {
        super(gp, id, landName, purchaseAmount, saleAmount, landX, landY, landWidth, landHeight, isOwn);
        this.numStation = numStation;
        this.rentAmount = rentAmount;
    }

    public int getTotalrent() {
        int[] rent = this.getRentAmount();
        return rent[this.getNumStation()];
    }

    public int getNumStation() {
        return numStation;
    }

    public void setNumStation(int numStation) {
        this.numStation = numStation;
        // System.out.print("numStation : " + numStation);
    }

    public int[] getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(int[] rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String toString() {
        return String.format("Rent for 1 Station: %d\nRent for 2 Stations: %d\nRent for 3 Stations: %d\nRent for 4 Stations: %d\n\n Purchase amount: %d\nSale amount: %d\nRecent rents amount: %d"
        , rentAmount[1], rentAmount[2], rentAmount[3], rentAmount[4], super.getPurchaseAmount(), super.getSaleAmount(), getNumStation());
    }
    
    
}