package button;

import Main.GamePanel;

public class FreePark extends Button{
    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;

    public FreePark(GamePanel gp, int id, String landName, int landX, int landY, int landWidth, int landHeight){
        super(gp, id, landName, landX, landY, landWidth, landHeight);
    }

    @Override
    public String toString() {
        return "Feel FREE to have a break here!!";
    }
}
