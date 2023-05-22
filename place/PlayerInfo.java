package place;

import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Main.GamePanel;
import Select.EnterNumberOfPlayers;
import player.Player;

public class PlayerInfo extends Bufferimg{

    GamePanel gp;
    Bufferimg[] playerInfo;
    Font font;
    Bufferimg[]avatar;

    public PlayerInfo (GamePanel gp) {
        
        this.gp = gp;

        playerInfo = new Bufferimg[10];
        font = new Font("Times New Roman", Font.BOLD, 30);

        getBackGroundImage();
        Avatar();
    }

    public void Avatar(){
        avatar = new Bufferimg[4];

        try {
            avatar[0] = new Bufferimg();
            avatar[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Picture/c1.png"));

            avatar[1] = new Bufferimg();
            avatar[1].image = ImageIO.read(getClass().getResourceAsStream("/res/Picture/c2.png"));

            avatar[2] = new Bufferimg();
            avatar[2].image = ImageIO.read(getClass().getResourceAsStream("/res/Picture/c3.png"));

            avatar[3] = new Bufferimg();
            avatar[3].image = ImageIO.read(getClass().getResourceAsStream("/res/Picture/c4.png"));
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void getBackGroundImage() {
        try {
            playerInfo[0] = new Bufferimg();
            playerInfo[0].image = ImageIO.read(getClass().getResourceAsStream("/res/BackGround/background1.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

Player money = new Player(gp, null, 0, 0, 0, 0);

    public void draw1(Graphics2D p1){
        p1.setFont(font);
        p1.setColor(Color.GREEN);
        p1.fillRect(gp.boardsize, gp.Menuheight*16, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p1.setColor(Color.MAGENTA);
        p1.drawString("Player 1: " + money.getMoney(),gp.boardsize , gp.Menuheight*16+30);
        p1.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+40, 65, 65, null);

        p1.setFont(font);
        p1.setColor(Color.BLUE);
        p1.fillRect(gp.boardsize,gp.Menuheight*16+ (832- gp.Menuheight*16)/4, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p1.setColor(Color.CYAN);
        p1.drawString("Player 2: "+ money.getMoney(),gp.boardsize ,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/4))+30);
        p1.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+235, 65, 65, null);

        p1.setFont(font);
        p1.setColor(Color.YELLOW);
        p1.fillRect(gp.boardsize,gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*2, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p1.setColor(Color.MAGENTA);
        p1.drawString("Player 3: "+ money.getMoney(),gp.boardsize ,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*2)+30);
        p1.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+430, 65, 65, null);

        p1.setFont(font);
        p1.setColor(Color.RED);
        p1.fillRect(gp.boardsize,gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*3, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p1.setColor(Color.CYAN);
        p1.drawString("Player 4: " + money.getMoney(),gp.boardsize ,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*3)+30);
        p1.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+630, 65, 65, null);
    }
    
    public void draw2(Graphics2D p2){
        p2.setFont(font);
        p2.setColor(Color.GREEN);
        p2.fillRect(gp.boardsize, gp.Menuheight*16, gp.infoPlayer*16,(832- gp.Menuheight*16)/3);
        p2.setColor(Color.MAGENTA);
        p2.drawString("Player 1: " + money.getMoney(),gp.boardsize , gp.Menuheight*16+30);
        p2.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+40, 65, 65, null);

        p2.setFont(font);
        p2.setColor(Color.BLUE);
        p2.fillRect(gp.boardsize,gp.Menuheight*16+ (832- gp.Menuheight*16)/3, gp.infoPlayer*16,(832- gp.Menuheight*16)/3);
        p2.setColor(Color.CYAN);
        p2.drawString("Player 2: "+ money.getMoney(),gp.boardsize ,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/3))+30);
        p2.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+295, 80, 80, null);

        p2.setFont(font);
        p2.setColor(Color.YELLOW);
        p2.fillRect(gp.boardsize,gp.Menuheight*16+ ((832- gp.Menuheight*16)/3)*2, gp.infoPlayer*16,(832- gp.Menuheight*16)/3);
        p2.setColor(Color.MAGENTA);
        p2.drawString("Player 3: "+ money.getMoney(),gp.boardsize ,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/3)*2)+30);
        p2.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+560, 65, 65, null);
    }
    
    public void draw3(Graphics2D p3){
        p3.setFont(font);
        p3.setColor(Color.GREEN);
        p3.fillRect(gp.boardsize, gp.Menuheight*16, gp.infoPlayer*16,(832- gp.Menuheight*16)/2);
        p3.setColor(Color.MAGENTA);
        p3.drawString("Player 1: " + money.getMoney(),gp.boardsize , gp.Menuheight*16+30);
        p3.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+40, 65, 65, null);

        p3.setFont(font);
        p3.setColor(Color.BLUE);
        p3.fillRect(gp.boardsize,gp.Menuheight*16+ (832- gp.Menuheight*16)/2, gp.infoPlayer*16,(832- gp.Menuheight*16)/2);
        p3.setColor(Color.CYAN);
        p3.drawString("Player 2: "+ money.getMoney(),gp.boardsize ,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/2))+30);
        p3.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+425, 80, 80, null);

    }

    public void draw(Graphics2D g2) {
        EnterNumberOfPlayers enter = new EnterNumberOfPlayers();
        if(enter.getNum() == 4){
            draw1(g2);
        } else if(enter.getNum() == 3){
            draw2(g2);
        } else {
            draw3(g2);
        }      
    }
}