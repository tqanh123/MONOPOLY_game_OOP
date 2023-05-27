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
    public int[] playerImgId;

    public PlayerInfo (GamePanel gp) {
        
        this.gp = gp;

        playerInfo = new Bufferimg[10];
        font = new Font("Times New Roman", Font.BOLD, 30);
        playerImgId = new int[4];

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
        
        if (!gp.monopoly.player[0].getIsBankrupt()) {
            p1.drawString("$" + gp.monopoly.player[0].getMoney(), gp.boardsize +160, (gp.Menuheight*16) + 130);
            
            //Check player 1
            if(FourPlayers.getID1() == 1){
                p1.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                playerImgId[0] = 0;
            } else if(FourPlayers.getID1() == 2){
                p1.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                playerImgId[0] = 2;
            } else if(FourPlayers.getID1() == 3){
                p1.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                playerImgId[0] = 1;
            } else if(FourPlayers.getID1() == 4) {
                p1.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                playerImgId[0] = 3;
            }
            
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
        if (!gp.monopoly.player[1].getIsBankrupt()) {
            p1.drawString("$" + gp.monopoly.player[1].getMoney(),gp.boardsize  +160,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/4))+30+100);        
    
            //Check player 2
            if(FourPlayers.getID2() == 1){
                p1.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+255, 80, 80, null);
                playerImgId[1] = 0;
            } else if(FourPlayers.getID2() == 2){
                p1.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+255, 80, 80, null);           
                playerImgId[1] = 2;
            } else if (FourPlayers.getID2() == 3){
                p1.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+255, 80, 80, null);
                playerImgId[1] = 1;
            } else if (FourPlayers.getID2() == 4){
                p1.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+255, 80, 80, null);
                playerImgId[1] = 3;
            }
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
        if (!gp.monopoly.player[2].getIsBankrupt()) {
            p1.drawString("$"+ gp.monopoly.player[2].getMoney(),gp.boardsize +160,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*2)+30+100);
            
            //Check player 3
            if(FourPlayers.getID3() == 1){
                p1.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+450, 80, 80, null);
                playerImgId[2] = 0;
            } else if(FourPlayers.getID3() == 2){
                p1.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+450, 80, 80, null);
                playerImgId[2] = 2;
            } else if(FourPlayers.getID3() == 3){
                p1.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+450, 80, 80, null);
                playerImgId[2] = 1;
            } else if (FourPlayers.getID3() == 4){
                p1.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+450, 80, 80, null);
                playerImgId[2] = 3;
            }
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
        
        if (!gp.monopoly.player[3].getIsBankrupt()) {
        
            p1.drawString("$"+ gp.monopoly.player[3].getMoney(),gp.boardsize +160,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/4)*3)+30+100);
            
            //Check player 4
            if(FourPlayers.getID4() == 1){
                p1.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+650, 80, 80, null);
                playerImgId[3] = 0;
            } else if(FourPlayers.getID4() == 2){
                p1.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+650, 80, 80, null);
                playerImgId[3] = 2;
            } else if(FourPlayers.getID4() == 3){
                p1.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+650, 80, 80, null);
                playerImgId[3] = 1;
            } else if(FourPlayers.getID4() == 4){
                p1.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+650, 80, 80, null);
                playerImgId[3] = 3;
            }

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
        
        if (!gp.monopoly.player[0].getIsBankrupt()) {
            p2.drawString("$" + gp.monopoly.player[0].getMoney(), gp.boardsize +160, (gp.Menuheight*16) + 130);
            
            //Check player 1
            if(ThreePlayers.getID1() == 1){
                p2.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                playerImgId[0] = 0;
            } else if(ThreePlayers.getID1() == 2){
                p2.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                playerImgId[0] = 2;
            } else if(ThreePlayers.getID1() == 3){
                p2.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                playerImgId[0] = 1;
            } else if(ThreePlayers.getID1() == 4) {
                p2.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                playerImgId[0] = 3;
            }
            
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
        if (!gp.monopoly.player[1].getIsBankrupt()) {
            p2.drawString("$" + gp.monopoly.player[1].getMoney(),gp.boardsize  +160,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/3))+30+100); 
    
            //Check player 2
            if(ThreePlayers.getID2() == 1){
                p2.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+330, 80, 80, null);
                playerImgId[1] = 0;
            } else if(ThreePlayers.getID2() == 2){
                p2.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+330, 80, 80, null);           
                playerImgId[1] = 2;
            } else if (ThreePlayers.getID2() == 3){
                p2.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+330, 80, 80, null);
                playerImgId[1] = 1;
            } else if (ThreePlayers.getID2() == 4){
                p2.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+330, 80, 80, null);
                playerImgId[1] = 3;
            }
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
        if (!gp.monopoly.player[2].getIsBankrupt()) {
            p2.drawString("$"+ gp.monopoly.player[2].getMoney(),gp.boardsize +160,(gp.Menuheight*16 + ((832- gp.Menuheight*16)/3)*2)+30+100);
        
            //Check player 3
            if(ThreePlayers.getID3() == 1){
                p2.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+590, 80, 80, null);
                playerImgId[2] = 0;
            } else if(ThreePlayers.getID3() == 2){
                p2.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+590, 80, 80, null);
                playerImgId[2] = 2;
            } else if(ThreePlayers.getID3() == 3){
                p2.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+590, 80, 80, null);
                playerImgId[2] = 1;
            } else if (ThreePlayers.getID3() == 4){
                p2.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+590, 80, 80, null);
                playerImgId[2] = 3;
            }
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
        
        if (!gp.monopoly.player[0].getIsBankrupt()) {
            p3.drawString("$" + gp.monopoly.player[0].getMoney(), gp.boardsize +160, (gp.Menuheight*16) + 130);
                
                //Check player 1
                if(TwoPlayers.getID1() == 1){
                    p3.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                    playerImgId[0] = 0;
                } else if(TwoPlayers.getID1() == 2){
                    p3.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                    playerImgId[0] = 2;
                } else if(TwoPlayers.getID1() == 3){
                    p3.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                    playerImgId[0] = 1;
                } else if(TwoPlayers.getID1() == 4) {
                    p3.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+60, 80, 80, null);
                    playerImgId[0] = 3;
                }
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

        if (!gp.monopoly.player[1].getIsBankrupt()) {
            p3.drawString("$" + gp.monopoly.player[1].getMoney(),gp.boardsize  +160,(gp.Menuheight*16+ ((832- gp.Menuheight*16)/2))+30+100);
            
            //Check player 2
            if(TwoPlayers.getID2() == 1){
                p3.drawImage(avatar[0].image, gp.boardsize, gp.Menuheight*16+445, 80, 80, null);
                playerImgId[1] = 0;
            } else if(TwoPlayers.getID2() == 2){
                p3.drawImage(avatar[1].image, gp.boardsize, gp.Menuheight*16+445, 80, 80, null);
                playerImgId[1] = 2;
            } else if(TwoPlayers.getID2() == 3){
                p3.drawImage(avatar[2].image, gp.boardsize, gp.Menuheight*16+445, 80, 80, null);
                playerImgId[1] = 1;
            } else if(TwoPlayers.getID2() == 4) {
                p3.drawImage(avatar[3].image, gp.boardsize, gp.Menuheight*16+445, 80, 80, null);
                playerImgId[1] = 3;
            }        
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