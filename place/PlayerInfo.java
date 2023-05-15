package place;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Main.GamePanel;

public class PlayerInfo extends Bufferimg{

    GamePanel gp;
    Bufferimg[] playerInfo;

    public PlayerInfo (GamePanel gp) {
        
        this.gp = gp;

        playerInfo = new Bufferimg[10];

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

    public void draw(Graphics2D g2) {

           g2.drawImage(playerInfo[0].image, gp.boardsize, 0, gp.boardsize, gp.boardsize, null);
        
    }
}

