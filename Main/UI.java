package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

    GamePanel gp;
    Font arial_80;
    Graphics2D g2;
    public String message = "";
    public boolean messageOn = false;
    private int messageCount = 0;
    private Color c = new Color(50, 50, 50, 200);

    public UI (GamePanel gp) {
        this.gp = gp;

        arial_80 = new Font("Arial", Font.PLAIN, 80);
    }

    public void showMessage(String text){

        message = text;
        messageOn = true;
        messageCount = 0;
        // gp.gameState = gp.pauseState;

    }

    public void draw(Graphics2D g2) {
        
        this.g2 = g2;

        if (messageOn) {

            g2.setColor(c);
            g2.fillRect(0, 0, gp.boardsize, gp.boardsize);

            g2.setColor(Color.WHITE);
            g2.setFont(arial_80);
            g2.drawString(message, getXforCenteredText(message), gp.boardsize/2);

            messageCount++;
            if (messageCount > 60) {
                messageOn = false;
                // gp.gameState = gp.playState;
            } 
        }

    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        return (gp.boardsize/2 - length/2);
    }
}
