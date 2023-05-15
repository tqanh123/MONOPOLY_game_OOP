package place;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Main.GamePanel;
import button.Button;
import button.LandButton;
import button.StationButton;
import Main.Main;

public class Places {
    GamePanel gp;
    Place[] place;
    Button[] lands;
    Main m;

    public Places (GamePanel gp) {
        
        this.gp = gp;

        place = new Place[10];
        lands = new Button[40];

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
        
        int height = 2 * gp.place * gp.originalTileSize;
        int width = gp.place * gp.originalTileSize;

        int r[] = {12, 40, 90, 280, 550, 800};
        lands[0] = new LandButton(gp, "a", 0, 0, r, 120, 240, gp.originalTileSize*8, 0, width, height);

        int r2[] = {14, 50, 100, 300};
        lands[1] = new StationButton(gp, "b", 0, r2, 140, 280, gp.originalTileSize*12, 0, width, height);

    }
}
