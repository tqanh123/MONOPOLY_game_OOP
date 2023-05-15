package place;

import Main.GamePanel;
import button.Button;

public class StationButton extends Button {

    private int numStation;
    private int[] rentAmount = new int[4];

    public StationButton(GamePanel gp, String landName, int numStation, int[] rentAmount, int purchaseAmount, int saleAmount, int landX, int landY) {
        super(gp, landName, purchaseAmount, saleAmount, landX, landY);
        this.numStation = numStation;
        this.rentAmount = rentAmount;
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
