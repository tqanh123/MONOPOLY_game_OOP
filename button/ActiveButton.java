package button;

import Main.GamePanel;
import place.placeDraw;

public class ActiveButton extends Button {
    private int purchaseAmount, saleAmount;
    private boolean isOwn;
    private int hostId;

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

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
