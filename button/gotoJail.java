package button;

import Main.GamePanel;

public class gotoJail extends Button {
    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;

    public gotoJail(GamePanel gp, int id, String landName, int landX, int landY, int landWidth, int landHeight){
        super(gp, id, landName, landX, landY, landWidth, landHeight);
    }

    @Override
    public String toString() {
        return "Go direct to the Jail and not arrive to Start Land";
    }
}
