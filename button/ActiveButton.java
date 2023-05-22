package button;

import Main.GamePanel;

public class ActiveButton extends Button {
    public int purchaseAmount;
    public int saleAmount;
    private boolean isOwn;

    public boolean isOwn() {
        return isOwn;
    }

    public void setOwn(boolean isOwn) {
        this.isOwn = isOwn;
    }

    public ActiveButton(GamePanel gp, int id, String landName, int purchaseAmount, int saleAmount, int landX, int landY, int landWidth, int landHeight, boolean isOwn) {
        super(gp, id, landName, landX, landY, landWidth, landHeight);
        this.purchaseAmount = purchaseAmount;
        this.isOwn = isOwn;
        this.saleAmount = saleAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getSaleAmount() {
        return saleAmount;
    }
    
}
