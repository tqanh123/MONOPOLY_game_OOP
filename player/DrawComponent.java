package player;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.UtilityTool;
import Select.EnterNumberOfPlayers;
import button.ActiveButton;
import button.LandButton;
import button.StationButton;
import place.Bufferimg;

public class DrawComponent {

    public Bufferimg[] playerImage;
    public Bufferimg[] houseImage;
    private int n = EnterNumberOfPlayers.getNum();
    private int x, y, w, h;
    private int amount;
    GamePanel gp;

    public DrawComponent(GamePanel gp){
        this.gp = gp;
        playerImage = new Bufferimg[16];
        houseImage = new Bufferimg[85];

        getImage();
    }

    public void getImage() {

        // PLAYER 1
        setup(0, "player1_left1");
        setup(1, "player1_up1");
        setup(2, "player1_right1");
        setup(3, "player1_down1");

        //PLAYER 2
        setup(4, "player2_left1");
        setup(5, "player2_up1");
        setup(6, "player2_right1");
        setup(7, "player2_down1");

        //PLAYER 3
        setup(8, "player3_left1");
        setup(9, "player3_up1");
        setup(10, "player3_right1");
        setup(11, "player3_down1");

        //PLAYER 4
        setup(12, "player4_left1");
        setup(13, "player4_up1");
        setup(14, "player4_right1");
        setup(15, "player4_down1");

        //Player 1 - Land:
        
        // houseImage[0] = new Bufferimg();
        //     try {
        //         houseImage[0].image = ImageIO.read(getClass().getResourceAsStream("/res/House/p1_land_left.jpg"));
        //     } catch (IOException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        setupHouse(0, "p1_land_left");
        setupHouse(1, "p1_land_up");
        setupHouse(2, "p1_land_right");
        setupHouse(3, "p1_land_down");
        
        //Player 1 - House 1:
        
        setupHouse(4,"p1_hotel_left");
        setupHouse(5,"p1_hotel_up");
        setupHouse(6,"p1_hotel_right");
        setupHouse(7,"p1_hotel_down");

        //Player 1 - House 2:

        setupHouse(8,"p1_house1_left");
        setupHouse(9,"p1_house1_up");
        setupHouse(10,"p1_house1_right");
        setupHouse(11,"p1_house1_down");

        //Player 1 - House 3:
        setupHouse(12,"p1_house2_left");
        setupHouse(13,"p1_house2_up");
        setupHouse(14,"p1_house2_right");
        setupHouse(15,"p1_house2_down");

        //Player 1 - Hotel:
        setupHouse(16,"p1_house3_left");
        setupHouse(17,"p1_house3_up");
        setupHouse(18,"p1_house3_right");
        setupHouse(19,"p1_house3_down");
        
        //Player 2 - Land:
        
        // setupHouse(20, "p2_land_left");
        // setupHouse(21, "p2_land_up");
        // setupHouse(22, "p2_land_right");
        // setupHouse(23, "p2_land_down");
        
        //Player 2 - House 1:
        
        setupHouse(24,"p2_hotel_left");
        setupHouse(25,"p2_hotel_up");
        setupHouse(26,"p2_hotel_right");
        setupHouse(27,"p2_hotel_down");

        //Player 2 - House 2:

        setupHouse(28,"p2_house1_left");
        setupHouse(29,"p2_house1_up");
        setupHouse(30,"p2_house1_right");
        setupHouse(31,"p2_house1_down");

        //Player 2 - House 3:
        setupHouse(32,"p2_house2_left");
        setupHouse(33,"p2_house2_up");
        setupHouse(34,"p2_house2_right");
        setupHouse(35,"p2_house2_down");

        //Player 2 - Hotel:
        setupHouse(36,"p2_house3_left");
        setupHouse(37,"p2_house3_up");
        setupHouse(38,"p2_house3_right");
        setupHouse(39,"p2_house3_down");

        //Player 3 - Land:
        
        setupHouse(40, "p3_land_left");
        setupHouse(41, "p3_land_up");
        setupHouse(42, "p3_land_right");
        setupHouse(43, "p3_land_down");
        
        //Player 3 - House 1:
        
        setupHouse(44,"p3_hotel_left");
        setupHouse(45,"p3_hotel_up");
        setupHouse(46,"p3_hotel_right");
        setupHouse(47,"p3_hotel_down");

        //Player 3 - House 2:

        setupHouse(48,"p3_house1_left");
        setupHouse(49,"p3_house1_up");
        setupHouse(50,"p3_house1_right");
        setupHouse(51,"p3_house1_down");

        //Player 3 - House 3:
        setupHouse(52,"p3_house2_left");
        setupHouse(53,"p3_house2_up");
        setupHouse(54,"p3_house2_right");
        setupHouse(55,"p3_house2_down");

        //Player 3 - Hotel:
        setupHouse(56,"p3_house3_left");
        setupHouse(57,"p3_house3_up");
        setupHouse(58,"p3_house3_right");
        setupHouse(59,"p3_house3_down");

        //Player 4 - Land:
            houseImage[20] = new Bufferimg();
            houseImage[21] = new Bufferimg();
            houseImage[22] = new Bufferimg();
            houseImage[23] = new Bufferimg();
            houseImage[60] = new Bufferimg();
            houseImage[61] = new Bufferimg();
            houseImage[62] = new Bufferimg();
            houseImage[63] = new Bufferimg();

            try {
                houseImage[20].image = ImageIO.read(getClass().getResourceAsStream("/res/House/p2_land_left.png"));
                houseImage[21].image = ImageIO.read(getClass().getResourceAsStream("/res/House/p2_land_up.png"));
                houseImage[22].image = ImageIO.read(getClass().getResourceAsStream("/res/House/p2_land_right.png"));
                houseImage[23].image = ImageIO.read(getClass().getResourceAsStream("/res/House/p2_land_down.png"));
                houseImage[60].image = ImageIO.read(getClass().getResourceAsStream("/res/House/p4_land_left.png"));
                houseImage[61].image = ImageIO.read(getClass().getResourceAsStream("/res/House/p4_land_up.png"));
                houseImage[62].image = ImageIO.read(getClass().getResourceAsStream("/res/House/p4_land_right.png"));
                houseImage[63].image = ImageIO.read(getClass().getResourceAsStream("/res/House/p4_land_down.png"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        // setupHouse(60, "p4_land_left");
        // setupHouse(61, "p4_land_up");
        // setupHouse(62, "p4_land_right");
        // setupHouse(63, "p4_land_down");
        
        //Player 4 - House 1:
        
        setupHouse(64,"p4_hotel_left");
        setupHouse(65,"p4_hotel_up");
        setupHouse(66,"p4_hotel_right");
        setupHouse(67,"p4_hotel_down");

        //Player 4 - House 2:

        setupHouse(68,"p4_house1_left");
        setupHouse(69,"p4_house1_up");
        setupHouse(70,"p4_house1_right");
        setupHouse(71,"p4_house1_down");

        //Player 4 - House 3:
        setupHouse(72,"p4_house2_left");
        setupHouse(73,"p4_house2_up");
        setupHouse(74,"p4_house2_right");
        setupHouse(75,"p4_house2_down");

        //Player 4 - Hotel:
        setupHouse(76,"p4_house3_left");
        setupHouse(77,"p4_house3_up");
        setupHouse(78,"p4_house3_right");
        setupHouse(79,"p4_house3_down");
    }

    public void setup(int index, String imageName) {

        UtilityTool uTool = new UtilityTool();

        try {
            
            playerImage[index] = new Bufferimg();
            playerImage[index].image = ImageIO.read(getClass().getResourceAsStream("/res/Player/"+ imageName + ".png"));
            playerImage[index].image = uTool.scaleImage(playerImage[index].image, 40, 40);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setupHouse(int index, String imageName) {

        UtilityTool uTool = new UtilityTool();

        try {
            
            houseImage[index] = new Bufferimg();
            houseImage[index].image = ImageIO.read(getClass().getResourceAsStream("/res/House/"+ imageName + ".png"));
            houseImage[index].image = uTool.scaleImage(houseImage[index].image, 38, 38);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Draw(Graphics2D g2) {

        for(int i = 0; i < n; i++){
            if (gp.monopoly.player[i].getIsBankrupt()) continue;

            x = gp.monopoly.player[i].getPlayerX();
            y = gp.monopoly.player[i].getPlayerY();
            int imageId = gp.playerInfo.playerImgId[i] * 4 + gp.monopoly.player[i].getPosition() / 9;

            g2.drawImage(playerImage[imageId].image, x, y, 32, 32, null);

            ArrayList<ActiveButton>  playerHouse = gp.monopoly.player[i].getProperties();
            
            for(ActiveButton land: playerHouse) {
                
                if (land instanceof LandButton) {
                    imageId = ((LandButton) land).getNumHouse() * 4;
                    amount = ((LandButton) land).getTotalrent();
                } 
                else {
                    imageId = 0;
                    amount = ((StationButton) land).getTotalrent();
                } 

                switch(land.getId() /9){
                    
                    case 0:
                    x = land.getLandX(); 
                    y = land.getLandY();    
                    w = 72;
                    h = 38;    
                    // g2.drawString("$" + amount, x + 10, y + 60);

                    break;

                    case 1:
                    x = land.getLandX() + 90;
                    y = land.getLandY();
                    w = 38;
                    h = 72;
                    // g2.drawString("$" + amount, x - 80, y + 10);
                    break;
                    
                    case 2:
                    x = land.getLandX();
                    y = land.getLandY() + 90;
                    w = 72;
                    h = 38;
                    // g2.drawString("$" + amount, x, y + 30);
                    break;
                    
                    case 3:
                    x = land.getLandX();
                    y = land.getLandY();
                    w = 38;
                    h = 72;
                    // g2.drawString("$" + amount, x + 40, y + 30);
                    break;

                }
                
                imageId += i * 20 + land.getId() / 9;
                g2.drawImage(houseImage[imageId].image,x,y,w,h,null);
                
                // System.out.println("imageId : " + imageId + " player+" + i);
             
            }
        }
    }



}