package button;

import Main.GamePanel;

<<<<<<< HEAD
public class StationButton extends Button {
=======
public class StationButton extends ActiveButton {
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a

    private int numStation;
    private int[] rentAmount = new int[4];

    public StationButton(GamePanel gp, String landName, int numStation, int[] rentAmount, int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight) {
        super(gp, landName, purchaseAmount, saleAmount, landX, landY, landWidth, landHeight);
        this.numStation = numStation;
        this.rentAmount = rentAmount;
    }

<<<<<<< HEAD
    public String toString() {
        return String.format("Rent for 1 Station: %d\nRent for 2 Stations: %d\nRent for 3 Stations: %d\nRent for 4 Stations: %d"
        , rentAmount[0], rentAmount[1], rentAmount[2], rentAmount[3]);
    }

=======
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
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

<<<<<<< HEAD

=======
    public String toString() {
        return String.format("Rent for 1 Station: %d\nRent for 2 Stations: %d\nRent for 3 Stations: %d\nRent for 4 Stations: %d"
        , rentAmount[0], rentAmount[1], rentAmount[2], rentAmount[3]);
    }
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
    
    
}
