package player;

import java.awt.Graphics2D;

import Main.GamePanel;

public class DrawComponent {

    
    GamePanel gp;

    public DrawComponent(GamePanel gp){
        this.gp = gp;
    }

    public void Draw(Graphics2D g2) {

        for(int i = 0; i < 4; i++){

            int x = gp.monopoly.player[i].getPlayerX();
            int y = gp.monopoly.player[i].getPlayerY();

            g2.drawImage(gp.monopoly.playerImage[i].image, x, y, 32, 32, null);
        }
    }


}
