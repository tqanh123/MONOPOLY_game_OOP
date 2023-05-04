package place;

import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Main.GamePanel;

public class Menu extends Place {

    GamePanel gp;
    Place[] menu;

    public Menu (GamePanel gp) {
        
        this.gp = gp;

        menu = new Place[10];

        getBackGroundImage();
    }

    public void getBackGroundImage() {
        try {
            menu[0] = new Place();
            menu[0].image = ImageIO.read(getClass().getResourceAsStream("/res/BackGround/background1.jpg"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update(){
        
    }

    public void draw(Graphics2D g2) {

        //    g2.drawImage(menu[0].image, 0, 0, gp.boardsize, gp.boardsize, null);
                g2.setColor(Color.MAGENTA);
        g2.fillRect(gp.boardsize, 0, gp.infoPlayer*16, gp.Menuheight*16);
    }
}


