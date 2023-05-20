package button;

import Main.GamePanel;

public class Jail extends Button {
    public final int visitedAmount = 25;
    private static int numPlayer = 0;
    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;
    private static boolean isJial; 

    public boolean isJial() {
        return isJial;
    }

    public static int amount() {
        return numPlayer * 25;
    }

    public static void setJial(boolean is) {
        isJial = is;
        if (isJial == true) numPlayer++;
        else numPlayer--;
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
