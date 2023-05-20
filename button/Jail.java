package button;

import Main.GamePanel;

public class Jail extends Button {
    public final int visitedAmount = 25;
    private int numPlayer;
    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;
    private boolean isJial; 

    public boolean isJial() {
        return isJial;
    }

    public void setJial(boolean isJial) {
        this.isJial = isJial;
        if (isJial == true) numPlayer++;
    }

    public Jail(GamePanel gp, int id, String landName, int landX, int landY, int landWidth, int landHeight, int numPlayer){
        super(gp, id, landName, landX, landY, landWidth, landHeight);
        this.numPlayer = numPlayer;
    }

    @Override
    public String toString() {
        return "it's free to you if nobody here, and it's need to pay 25K for each people";
    }
}