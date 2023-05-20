package button;

import Main.GamePanel;

public class Jail extends Button {
    public final int visitedAmount = 50;

    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;
    private boolean isJial; 

    public Jail(GamePanel gp, String landName, int landX, int landY, int landWidth, int landHeight){
        super(gp, "Jail", landX, landY, landWidth, landHeight);
    }


}
