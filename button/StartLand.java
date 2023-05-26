package button;

import Main.GamePanel;

public class StartLand extends Button{
    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;

    public StartLand(GamePanel gp, int id, String landName, int landX, int landY, int landWidth, int landHeight){
        super(gp, id, landName, landX, landY, landWidth, landHeight);
    }

    @Override
    public String toString() {
        return "Get $200m when arrive here!!";
    }
}
