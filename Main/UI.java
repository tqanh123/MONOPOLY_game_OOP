package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import button.ActiveButton;
import button.LandButton;
import button.StationButton;
import place.Bufferimg;

public class UI {

    GamePanel gp;
    Font arial_80, arial_40, arial_bold;
    Graphics2D g2;
    public String message = "";
    public boolean messageOn = false;
    private int messageCount = 0;
    private Color c = new Color(50, 50, 50, 200);
    private int id, needAmount, x, y, amount;
    Bufferimg win;

    public UI (GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 30);
        arial_80 = new Font("Arial", Font.PLAIN, 70);
        arial_bold = new Font("Arial", Font.BOLD, 40);

        getImage();
    }

    public void getImage() {
            win = new Bufferimg();
            try {
                win.image = ImageIO.read(getClass().getResourceAsStream("/res/BackGround/theWinner.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void showMessage(String text){

        message = text;
        messageOn = true;
        messageCount = 0;
        // gp.gameState = gp.pauseState;

    }

    public void brokenMessage(int id, int needAmount) {
        this.id = id;
        this.needAmount = needAmount;
    }

    public void winMessage(int id){
        this.id = id;
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

        if (gp.gameState >= gp.brokenState && gp.gameState < gp.winState) {

            g2.setColor(c);
            g2.fillRect(0, 0, gp.boardsize, gp.boardsize);

            g2.setColor(new Color(102, 102, 0));
            g2.fillRect(210, 266, 412, 250);

            g2.setColor(Color.ORANGE);
            g2.fillRect(210, 366, 412, 3);
            g2.fillRect(410, 366, 3, 150);

            g2.setColor(Color.YELLOW);
            g2.setFont(arial_bold);
            g2.drawString("Sell Your properties", getXforCenteredText("Sell Your properties"), 325);
            g2.drawString("$" + gp.monopoly.player[id].getMoney(), 220, 480);
            g2.drawString("$" + needAmount, 418, 480);
            g2.drawString("Clink on your land to sell it.", getXforCenteredText("Clink on your land to sell it."), 600);

            g2.setFont(arial_40);
            g2.drawString("Your money", 220, 410);
            g2.drawString("Needed money", 418, 410);

            ArrayList<ActiveButton>  playerHouse = gp.monopoly.player[id].getProperties();
            
            for (ActiveButton property : playerHouse) {
                g2.setColor(Color.darkGray);
                g2.fillRect(property.getLandX(), property.getLandY(), property.getLandWidth(), property.getLandHeight());
                switch(property.getId() /9){
                    
                    case 0:
                    x = property.getLandX() ; 
                    y = property.getLandY() + 70;    
                    break;

                    case 1:
                    x = property.getLandX() + 10;
                    y = property.getLandY() + 30;
                    break;
                    
                    case 2:
                    x = property.getLandX() ;
                    y = property.getLandY() + 70;
                    break;
                    
                    case 3:
                    x = property.getLandX() + 10;
                    y = property.getLandY() + 30;
                    break;

                }
                if (property instanceof LandButton) amount = ((LandButton)property).getTotalrent();
                else amount = ((StationButton)property).getTotalrent();
                g2.setColor(Color.yellow);
                g2.drawString("$" + amount, x, y);
            }
        }
    
        if (gp.gameState == gp.winState) {
            g2.setColor(c);
            g2.fillRect(0, 0, gp.boardsize, gp.boardsize);

            g2.drawImage(win.image, 216, 166, 400, 600, null);
            g2.setFont(arial_bold);
            g2.setColor(Color.RED);
            g2.drawString("Player" + (id + 1), getXforCenteredText("Player" + id), 420);
            g2.drawImage(gp.component.playerImage[gp.playerInfo.playerImgId[id]*4].image, 384, 440, 64, 64, null);
        }
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        return (gp.boardsize/2 - length/2);
    }
}
