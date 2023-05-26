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
import place.Bufferimg;

public class DrawComponent {

    public Bufferimg[] playerImage;
    public Bufferimg[] houseImage;
    private int n = EnterNumberOfPlayers.getNum();
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

        //Player 1 - House 1:

        setupHouse(0, "p1house1_left");
        setupHouse(1,"p1house1_up");
        setupHouse(2,"p1house1_right");
        setupHouse(3,"p1house1_down");

        //Player 1 - House 2:

        setupHouse(4,"p1house2_left");
        setupHouse(5,"p1house2_up");
        setupHouse(6,"p1house2_right");
        setupHouse(7,"p1house2_down");

        //Player 1 - House 3:
        setupHouse(8,"p1house3_left");
        setupHouse(9,"p1house3_up");
        setupHouse(10,"p1house3_right");
        setupHouse(11,"p1house3_down");

        //Player 1 - Hotel:
        setupHouse(12,"p1hotel_left");
        setupHouse(13,"p1hotel_up");
        setupHouse(14,"p1hotel_right");
        setupHouse(15,"p1hotel_down");
        
        //Player 2 - House 1:
        setupHouse(16, "p2house1_left");
        setupHouse(17,"p2house1_up");
        setupHouse(18,"p2house1_right");
        setupHouse(19,"p2house1_down");
        
        //Player 2 - House 2:
        setupHouse(20,"p2house2_left");
        setupHouse(21,"p2house2_up");
        setupHouse(22,"p2house2_right");
        setupHouse(23,"p2house2_down");

        //Player 2 - House 3:
        setupHouse(24,"p2house3_left");
        setupHouse(25,"p2house3_up");
        setupHouse(26,"p2house3_right");
        setupHouse(27,"p2house3_down");
        
        //Player 2 - Hotel:
        setupHouse(28,"p2hotel_left");
        setupHouse(29,"p2hotel_up");
        setupHouse(30,"p2hotel_right");
        setupHouse(31,"p2hotel_down");

       //Player 3 - House 1:
       setupHouse(32, "p3house1_left");
       setupHouse(33,"p3house1_up");
       setupHouse(34,"p3house1_right");
       setupHouse(35,"p3house1_down");
       
       //Player 3 - House 2:
       setupHouse(36,"p3house2_left");
       setupHouse(37,"p3house2_up");
       setupHouse(38,"p3house2_right");
       setupHouse(39,"p3house2_down");

       //Player 3 - House 3:
       setupHouse(40,"p3house3_left");
       setupHouse(41,"p3house3_up");
       setupHouse(42,"p3house3_right");
       setupHouse(43,"p3house3_down");
       
       //Player 3 - Hotel:
       setupHouse(44,"p3hotel_left");
       setupHouse(45,"p3hotel_up");
       setupHouse(46,"p3hotel_right");
       setupHouse(47,"p3hotel_down");

       //Player 4 - House 1:
        setupHouse(48, "p4house1_left");
        setupHouse(49,"p4house1_up");
        setupHouse(50,"p4house1_right");
        setupHouse(51,"p4house1_down");
        
        //Player 4 - House 2:
        setupHouse(52,"p4house2_left");
        setupHouse(53,"p4house2_up");
        setupHouse(54,"p4house2_right");
        setupHouse(55,"p4house2_down");

        //Player 4 - House 3:
        setupHouse(56,"p4house3_left");
        setupHouse(57,"p4house3_up");
        setupHouse(58,"p4house3_right");
        setupHouse(59,"p4house3_down");
        
        //Player 4 - Hotel:
        setupHouse(60,"p4hotel_left");
        setupHouse(61,"p4hotel_up");
        setupHouse(62,"p4hotel_right");
        setupHouse(63,"p4hotel_down");
        //Player 1 - Land :
        setupHouse(64, "p1land");
        //Player 2 - Land:
        setupHouse(65, "p2land");
        //Player 3 - Land:
        setupHouse(66, "p3land");
        //Player 4 - Land:
        setupHouse(67, "p4land");
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
            houseImage[index].image = uTool.scaleImage(houseImage[index].image, 40, 40);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Draw(Graphics2D g2) {

        for(int i = 0; i < n; i++){

            int x = gp.monopoly.player[i].getPlayerX();
            int y = gp.monopoly.player[i].getPlayerY();
            int imageId = i * 4 + gp.monopoly.player[i].getPosition() / 9;

            g2.drawImage(playerImage[imageId].image, x, y, 32, 32, null);

            ArrayList<ActiveButton>  playerHouse = gp.monopoly.player[i].getProperties();
            
            for(ActiveButton land: playerHouse) {
                System.out.println("ok");
                int num= ((LandButton) land).getNumHouse();


              switch(land.getId() /9){
                case 0:
                x = land.getLandX(); 
                y = land.getLandY();
                
                break;
                case 1:
                x = land.getLandX() + 95;
                y = land.getLandY();
                break;
                case 2:
                x = land.getLandX();
                y = land.getLandY() + 95;
                break;
                case 3:
                x= land.getLandX();
                y = land.getLandY();
                break;
              }
             imageId = i * 16 + num* 4 + land.getId() / 9;
                g2.drawImage(houseImage[imageId].image,x,y,32,32,null);
             
            }
        }
    }



}