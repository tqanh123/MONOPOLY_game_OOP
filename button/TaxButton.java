package button;

import Main.GamePanel;

public class TaxButton extends Button {
    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;

    public TaxButton(GamePanel gp, int id, String landName, int landX, int landY, int landWidth, int landHeight){
        super(gp, id, landName, landX, landY, landWidth, landHeight);
    }

    @Override
    public String toString() {
        if (super.getId() == 3) return "Pay 20% of your income/n Or\n $200m";
        
        return "It's force to pay $120m";
    }
}
