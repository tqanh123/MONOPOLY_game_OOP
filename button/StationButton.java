package button;

import Main.GamePanel;

public class StationButton extends Button {

    private int numStation;
    private int[] rentAmount = new int[4];

    public StationButton(GamePanel gp, String landName, int numStation, int[] rentAmount, int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight) {
        super(gp, landName, purchaseAmount, saleAmount, landX, landY, landWidth, landHeight);
        this.numStation = numStation;
        this.rentAmount = rentAmount;
    }

    public String toString() {
        return String.format("Rent for 1 Station: %d\nRent for 2 Stations: %d\nRent for 3 Stations: %d\nRent for 4 Stations: %d"
        , rentAmount[0], rentAmount[1], rentAmount[2], rentAmount[3]);
    }

    public int getTotalrent() {
        int[] rent = this.getRentAmount();
        return rent[this.getNumStation() - 1];
    }

    public int getNumStation() {
        return numStation;
    }

    public void setNumStation(int numStation) {
        this.numStation = numStation;
    }

    public int[] getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(int[] rentAmount) {
        this.rentAmount = rentAmount;
    }


    
    
}
