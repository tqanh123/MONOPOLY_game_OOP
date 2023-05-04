package place;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Main.GamePanel;

public class Places {
    GamePanel gp;
    Place[] place;

    public Places (GamePanel gp) {
        
        this.gp = gp;

        place = new Place[10];

        getBackGroundImage();
    }

    public void getBackGroundImage() {
        try {
            place[0] = new Place();
            place[0].image = ImageIO.read(getClass().getResourceAsStream("/res/BackGround/background1.jpg"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

           g2.drawImage(place[0].image, 0, 0, gp.boardsize, gp.boardsize, null);
        
    }
}
