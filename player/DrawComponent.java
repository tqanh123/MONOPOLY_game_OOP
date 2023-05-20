package player;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.UtilityTool;
import place.Bufferimg;

public class DrawComponent {

    public Bufferimg[] playerImage;
    GamePanel gp;

    public DrawComponent(GamePanel gp){
        this.gp = gp;
        playerImage = new Bufferimg[16];

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

    public void Draw(Graphics2D g2) {

        for(int i = 0; i < 4; i++){

            int x = gp.monopoly.player[i].getPlayerX();
            int y = gp.monopoly.player[i].getPlayerY();
            int imageId = i * 4 + gp.monopoly.player[i].getPosition() / 9;

            g2.drawImage(playerImage[imageId].image, x, y, 32, 32, null);
        }
    }


}
