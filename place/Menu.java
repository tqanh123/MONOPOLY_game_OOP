package place;

import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Main.GamePanel;

public class Menu extends placeDraw {

    GamePanel gp;
    Bufferimg[] menu;

    public Menu (GamePanel gp) {
        
        this.gp = gp;

        menu = new Bufferimg[10];

        getBackGroundImage();
    }

    public void getBackGroundImage() {
        try {
<<<<<<< HEAD
            menu[0] = new Place();
=======
            menu[0] = new Bufferimg();
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
            menu[0].image = ImageIO.read(getClass().getResourceAsStream("/res/BackGround/background1.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update(){
        
    }

    @Override
    public void draw(Graphics2D g2) {

        //    g2.drawImage(menu[0].image, 0, 0, gp.boardsize, gp.boardsize, null);
        g2.setColor(Color.MAGENTA);
        g2.fillRect(gp.boardsize, 0, gp.infoPlayer*16, gp.Menuheight*16);
    }
}


