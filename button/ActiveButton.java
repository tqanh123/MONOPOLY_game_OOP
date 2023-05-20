package button;

import Main.GamePanel;

public class ActiveButton extends Button {
    public int purchaseAmount;
    public int saleAmount;

    public ActiveButton(GamePanel gp, int id, String landName, int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight) {
        super(gp, id, landName, landX, landY, landWidth, landHeight);
        this.purchaseAmount = purchaseAmount;
        this.saleAmount = saleAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getSaleAmount() {
        return saleAmount;
    }
    
}
