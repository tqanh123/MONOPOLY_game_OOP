package place;

import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Main.GamePanel;
import Select.EnterNumberOfPlayers;
import Select.FourPlayers;
import Select.ThreePlayers;
import Select.TwoPlayers;
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
    FourPlayers check4Players = new FourPlayers();
    ThreePlayers check3Players = new ThreePlayers();
    TwoPlayers check2Players = new TwoPlayers();

    public void draw1(Graphics2D p1){
        //Draw Area p1
        p1.setFont(font);
        p1.setColor(new Color(255, 204, 204)); 
        p1.fillRect(gp.boardsize, gp.Menuheight*16, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p1.setColor(new Color(255, 102, 102));
        p1.fillRect(gp.boardsize, gp.Menuheight*16+50, gp.boardsize*16, 4);
        p1.fillRect(gp.boardsize +130, gp.Menuheight*16+50, 4, gp.Menuheight*16+ (832- gp.Menuheight*16)/4);
        p1.setColor(new Color(255, 153, 51));
        p1.drawString("Player 1",gp.boardsize +75 , gp.Menuheight*16+30);
        p1.drawString("$" + money.getMoney(), gp.boardsize +160, (gp.Menuheight*16) + 130);

        //Check player 1
        if(check4Players.getID1() == 1){
            p1.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+60, 65, 65, null);
        } else if(check4Players.getID1() == 2){
            p1.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+60, 65, 65, null);
        } else if(check4Players.getID1() == 3){
            p1.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+60, 65, 65, null);
        } else if(check4Players.getID1() == 4) {
            p1.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+60, 65, 65, null);
        }

        //Draw Area p2
        p1.setFont(font);
        p1.setColor(new Color(255, 204, 153));
        p1.fillRect(gp.boardsize,gp.Menuheight*16+ (832- gp.Menuheight*16)/4, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p1.setColor(new Color(0, 51, 102));
        p1.fillRect(gp.boardsize, gp.Menuheight*16+ (832- gp.Menuheight*16)/4 +50,gp.boardsize*16 , 4);
        p1.fillRect(gp.boardsize +130, gp.Menuheight*16+ (832- gp.Menuheight*16)/4 +50, 4, gp.Menuheight*16+ (832- gp.Menuheight*16)/4);
        p1.setColor(new Color(0, 102, 102));
        p1.drawString("Player 2",gp.boardsize +75,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/4))+30);
        p1.drawString("$" + money.getMoney(),gp.boardsize  +160,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/4))+30+100);        

        //Check player 2
        if(check4Players.getID2() == 1){
            p1.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+255, 65, 65, null);
        } else if(check4Players.getID2() == 2){
            p1.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+255, 65, 65, null);           
        } else if (check4Players.getID2() == 3){
            p1.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+255, 65, 65, null);
        } else if (check4Players.getID2() == 4){
            p1.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+255, 65, 65, null);
        }
        
        //Draw Area p3
        p1.setFont(font);
        p1.setColor(new Color(135, 206, 235));
        p1.fillRect(gp.boardsize,gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*2, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p1.setColor(new Color(128, 0, 128));
        p1.fillRect(gp.boardsize, gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*2 +50,gp.boardsize*16 , 4);
        p1.fillRect(gp.boardsize +130, gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*2 +50, 4, gp.Menuheight*16+ (832- gp.Menuheight*16)/4);
        p1.setColor(Color.MAGENTA);
        p1.drawString("Player 3",gp.boardsize +75,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*2)+30);
        p1.drawString("$"+ money.getMoney(),gp.boardsize +160,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*2)+30+100);
        
        //Check player 3
        if(check4Players.getID3() == 1){
            p1.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+450, 65, 65, null);
        } else if(check4Players.getID3() == 2){
            p1.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+450, 65, 65, null);
        } else if(check4Players.getID3() == 3){
            p1.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+450, 65, 65, null);
        } else if (check4Players.getID3() == 4){
            p1.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+450, 65, 65, null);
        }
        
        //Draw area p4
        p1.setFont(font);
        p1.setColor(new Color(119,136,153));
        p1.fillRect(gp.boardsize,gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*3, gp.infoPlayer*16,(832- gp.Menuheight*16)/4);
        p1.setColor(new Color(255, 229, 204));
        p1.fillRect(gp.boardsize, gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*3 +50,gp.boardsize*16 , 4);
        p1.fillRect(gp.boardsize +130, gp.Menuheight*16+ ((832- gp.Menuheight*16)/4)*3 +50, 4, gp.Menuheight*16+ (832- gp.Menuheight*16)/4);
        p1.setColor(new Color(0,255,0));
        p1.drawString("Player 4",gp.boardsize +75,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*3)+30);
        p1.drawString("$"+ money.getMoney(),gp.boardsize +160,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*3)+30+100);
        
        //Check player 4
        if(check4Players.getID4() == 1){
            p1.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+650, 65, 65, null);
        } else if(check4Players.getID4() == 2){
            p1.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+650, 65, 65, null);
        } else if(check4Players.getID4() == 3){
            p1.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+650, 65, 65, null);
        } else if(check4Players.getID4() == 4){
            p1.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+650, 65, 65, null);
        }
    }
    
    public void draw2(Graphics2D p2){
        //Draw area p1
        p2.setFont(font);
        p2.setColor(new Color(255, 204, 204));
        p2.fillRect(gp.boardsize, gp.Menuheight*16, gp.infoPlayer*16,(832- gp.Menuheight*16)/3);
        p2.setColor(new Color(255, 102, 102));
        p2.fillRect(gp.boardsize, gp.Menuheight*16+50, gp.boardsize*16, 4);
        p2.fillRect(gp.boardsize +130, gp.Menuheight*16+50, 4, gp.Menuheight*16+ (832- gp.Menuheight*16)/4);
        p2.setColor(new Color(255, 153, 51));
        p2.drawString("Player 1",gp.boardsize +75 , gp.Menuheight*16+30);
        p2.drawString("$" + money.getMoney(), gp.boardsize +160, (gp.Menuheight*16) + 130);
        
        //Check player 1
        if(check3Players.getID1() == 1){
            p2.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+60, 65, 65, null);
        } else if(check3Players.getID1() == 2){
            p2.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+60, 65, 65, null);
        } else if(check3Players.getID1() == 3){
            p2.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+60, 65, 65, null);
        } else if(check3Players.getID1() == 4) {
            p2.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+60, 65, 65, null);
        }

        //Draw Area p2
        p2.setFont(font);
        p2.setColor(new Color(255, 204, 153));
        p2.fillRect(gp.boardsize,gp.Menuheight*16+ (832- gp.Menuheight*16)/3, gp.infoPlayer*16,(832- gp.Menuheight*16)/3);
        p2.setColor(new Color(0, 51, 102));
        p2.fillRect(gp.boardsize, gp.Menuheight*16+ (832- gp.Menuheight*16)/3 +50,gp.boardsize*16 , 4);
        p2.fillRect(gp.boardsize +130, gp.Menuheight*16+ (832- gp.Menuheight*16)/3 +50, 4, gp.Menuheight*16+ (832- gp.Menuheight*16)/3);
        p2.setColor(new Color(0, 102, 102));
        p2.drawString("Player 2",gp.boardsize +75,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/3))+30);
        p2.drawString("$" + money.getMoney(),gp.boardsize  +160,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/3))+30+100); 

        //Check player 2
        if(check3Players.getID2() == 1){
            p2.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+330, 65, 65, null);
        } else if(check3Players.getID2() == 2){
            p2.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+330, 65, 65, null);           
        } else if (check3Players.getID2() == 3){
            p2.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+330, 65, 65, null);
        } else if (check3Players.getID2() == 4){
            p2.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+330, 65, 65, null);
        }

        //Draw Area 3
        p2.setFont(font);
        p2.setColor(new Color(135, 206, 235));
        p2.fillRect(gp.boardsize,gp.Menuheight*16+ ((832- gp.Menuheight*16)/3)*2, gp.infoPlayer*16,(832- gp.Menuheight*16)/3);
        p2.setColor(new Color(128, 0, 128));
        p2.fillRect(gp.boardsize, gp.Menuheight*16+ ((832- gp.Menuheight*16)/3)*2 +50,gp.boardsize*16 , 4);
        p2.fillRect(gp.boardsize +130, gp.Menuheight*16+ ((832- gp.Menuheight*16)/3)*2 +50, 4, gp.Menuheight*16+ (832- gp.Menuheight*16)/3);
        p2.setColor(Color.MAGENTA);
        p2.drawString("Player 3",gp.boardsize +75,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/3)*2)+30);
        p2.drawString("$"+ money.getMoney(),gp.boardsize +160,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/3)*2)+30+100);
    
        //Check player 3
        if(check3Players.getID3() == 1){
            p2.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+590, 65, 65, null);
        } else if(check3Players.getID3() == 2){
            p2.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+590, 65, 65, null);
        } else if(check3Players.getID3() == 3){
            p2.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+590, 65, 65, null);
        } else if (check3Players.getID3() == 4){
            p2.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+590, 65, 65, null);
        }
    }

    public void draw3(Graphics2D p3){
        //Draw area p1
        p3.setFont(font);
        p3.setColor(new Color(255, 204, 204));
        p3.fillRect(gp.boardsize, gp.Menuheight*16, gp.infoPlayer*16,(832- gp.Menuheight*16)/2);
        p3.setColor(new Color(255, 102, 102));
        p3.fillRect(gp.boardsize, gp.Menuheight*16+50, gp.boardsize*16, 4);
        p3.fillRect(gp.boardsize +130, gp.Menuheight*16+50, 4, gp.Menuheight*16+ (832- gp.Menuheight*16)/2);
        p3.setColor(new Color(255, 153, 51));
        p3.drawString("Player 1",gp.boardsize +75 , gp.Menuheight*16+30);
        p3.drawString("$" + money.getMoney(), gp.boardsize +160, (gp.Menuheight*16) + 130);
        
        //Check player 1
        if(check2Players.getID1() == 1){
            p3.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
        } else if(check2Players.getID1() == 2){
            p3.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
        } else if(check2Players.getID1() == 3){
            p3.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
        } else if(check2Players.getID1() == 4) {
            p3.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
        }

        //Draw area p2
        p3.setFont(font);
        p3.setColor(new Color(255, 204, 153));
        p3.fillRect(gp.boardsize,gp.Menuheight*16+ (832- gp.Menuheight*16)/2, gp.infoPlayer*16,(832- gp.Menuheight*16)/2);
        p3.setColor(new Color(0, 51, 102));
        p3.fillRect(gp.boardsize, gp.Menuheight*16+ (832- gp.Menuheight*16)/2 +50,gp.boardsize*16 , 4);
        p3.fillRect(gp.boardsize +130, gp.Menuheight*16+ (832- gp.Menuheight*16)/2 +50, 4, gp.Menuheight*16+ (832- gp.Menuheight*16)/2);
        p3.setColor(new Color(0, 102, 102));
        p3.drawString("Player 2",gp.boardsize +75,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/2))+30);
        p3.drawString("$" + money.getMoney(),gp.boardsize  +160,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/2))+30+100);
        p3.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+445, 80, 80, null);

        //Check player 2
        if(check2Players.getID2() == 1){
            p3.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+445, 80, 80, null);
        } else if(check2Players.getID2() == 2){
            p3.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+445, 80, 80, null);
        } else if(check2Players.getID2() == 3){
            p3.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+445, 80, 80, null);
        } else if(check2Players.getID2() == 4) {
            p3.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+445, 80, 80, null);
        }
    }

    public void draw(Graphics2D g2) {
        if(EnterNumberOfPlayers.getNum() == 4){
            draw1(g2);
        } else if(EnterNumberOfPlayers.getNum() == 3){
            draw2(g2);
        } else {
            draw3(g2);
        }      
    }
}