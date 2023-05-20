package place;

import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Main.GamePanel;
import Select.EnterNumberOfPlayers;

public class PlayerInfo extends Bufferimg{

    GamePanel gp;
    Bufferimg[] playerInfo;
    Font font;

    public PlayerInfo (GamePanel gp) {
        
        this.gp = gp;

        playerInfo = new Bufferimg[10];
        font = new Font("Times New Roman", Font.BOLD, 30);

        getBackGroundImage();
    }

    public void getBackGroundImage() {
        try {
            playerInfo[0] = new Bufferimg();
            playerInfo[0].image = ImageIO.read(getClass().getResourceAsStream("/res/BackGround/background1.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw1(Graphics2D p1){
        p1.setFont(font);
        p1.setColor(Color.GREEN);
        p1.fillRect(gp.boardsize, gp.Menuheight*16, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p1.setColor(Color.BLACK);
        p1.drawString("Player 1",gp.boardsize , gp.Menuheight*16+30);
    }
    
    public void draw2(Graphics2D p2){
        p2.setFont(font);
        p2.setColor(Color.BLUE);
        p2.fillRect(gp.boardsize,gp.Menuheight*16+ (832- gp.Menuheight*16)/4, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p2.setColor(Color.BLACK);
        p2.drawString("Player 2",gp.boardsize ,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/4))+30);
    }
    
    public void draw3(Graphics2D p3){
        p3.setFont(font);
        p3.setColor(Color.YELLOW);
        p3.fillRect(gp.boardsize,gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*2, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p3.setColor(Color.BLACK);
        p3.drawString("Player 3",gp.boardsize ,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*2)+30);
    }

    public void draw4(Graphics2D p4){
        p4.setFont(font);
        p4.setColor(Color.RED);
        p4.fillRect(gp.boardsize,gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*3, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p4.setColor(Color.BLACK);
        p4.drawString("Player 4",gp.boardsize ,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*3)+30);
    }

    

    public void draw(Graphics2D g2) {
        draw1(g2);
        draw2(g2);
        draw3(g2);
        draw4(g2);
          
    }
}