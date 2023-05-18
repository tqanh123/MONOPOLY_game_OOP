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
            place[0].image = ImageIO.read(getClass().getResourceAsStream("/res/BackGround/background1.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D g2) {

        g2.drawImage(place[0].image, 0, 0, gp.boardsize, gp.boardsize, null);
        
        int height = gp.LandHeight;
        int width = gp.LandWidth;

        int r1[] = {5, 20, 40, 130, 270, 400};
        lands[1] = new LandButton(gp, "VINE STREET", 0, 0, r1 , 15, 8, gp.LandWidth*7 + gp.LandHeight, 705, width, height);

        int r2[] = {15, 30, 60, 170, 340, 500};
        lands[2] = new LandButton(gp, "COVENTRY STREET", 0, 0, r2, 57, 28, gp.LandWidth*6 + gp.LandHeight, 705, width, height);

        int r3[] = {20, 40, 80, 230, 450, 600};
        lands[5] = new LandButton(gp, "LEICESTER SQUARE", 0, 0, r3, 68, 34, gp.LandWidth*3 + gp.LandHeight, 705, width, height);

        int r4[] = {25, 50, 100, 290, 560, 700};
        lands[7] = new LandButton(gp, "BOW STREET", 0, 0, r4, 71, 35, gp.LandWidth + gp.LandHeight, 705, width, height);

        int r5[] = {30, 60, 120, 350, 670, 800};
        lands[8] = new LandButton(gp, "WHITECHAPEL ROAD", 0, 0, r5, 81, 40, gp.LandHeight, 705, width, height);

        int r6[] = {35, 70, 140, 400, 750, 900};
        lands[10] = new LandButton(gp, "THE ANGEL ISLINGTON", 0, 0, r6, 91, 45, 0, 631, height, width);

        int r7[] = {40, 80, 160, 450, 870, 1000};
        lands[12] = new LandButton(gp, "TRAFALGAR SQUARE", 0, 0, r7, 97, 50, 0, 487, height, width);

        int r8[] = {45, 90, 180, 520, 950, 1100};
        lands[13] = new LandButton(gp, "NORTHUMRL'D AVENUE", 0, 0, r8, 112, 56, 0, 415, height, width);
        
        int r9[] = {50, 100, 200, 580, 1100, 1200};
        lands[15] = new LandButton(gp, "M'BOROUGH STREET", 0, 0, r9, 125, 62, 0, 271, height, width);
        
        int r10[] = {55, 110, 220, 640, 1200, 1300};
        lands[16] = new LandButton(gp, "FLEET STREET", 0, 0, r10, 148, 74, 0, 199, height, width);
        
        int r11[] = {60, 120, 240, 650, 1300, 1400};
        lands[17] = new LandButton(gp, "OLD KENT ROAD", 0, 0, r11, 208, 104, 0, 127, height, width);
        
        int r12[] = {65, 130, 260, 700, 1400, 1500};
        lands[19] = new LandButton(gp, "WHITEHALL", 0, 0, r12, 211, 105, gp.LandHeight, 0, width, height);
      
        int r13[] = {70, 140, 280, 820, 1500, 1600};
        lands[21] = new LandButton(gp, "PENTONVILLE ROAD", 0, 0, r13, 215, 108, gp.LandWidth*2 + gp.LandHeight, 0, width, height);
       
        int r14[] = {75, 150, 300, 850, 1600, 1700};
        lands[22] = new LandButton(gp, "PALL MALL", 0, 0, r14, 228, 114, gp.LandWidth*3 + gp.LandHeight, 0, width, height);

        int r15[] = {80, 160, 320, 900, 1700, 1800};
        lands[24] = new LandButton(gp, "BOND STREET", 0, 0, r15, 271, 135, gp.LandWidth*5 + gp.LandHeight, 0, width, height);

        int r16[] = {85, 170, 340, 1000, 1800, 1900};
        lands[25] = new LandButton(gp, "STRAND", 0, 0, r16, 320, 160, gp.LandWidth*6 + gp.LandHeight, 0, width, height);

        int r17[] = {90, 180, 360, 1050, 1900, 2000};
        lands[26] = new LandButton(gp, "REGENT STREET", 0, 0, r17, 370, 185, gp.LandWidth*7 + gp.LandHeight, 0, width, height);

        int r18[] = {95, 190, 380, 1100, 2000, 2100};
        lands[28] = new LandButton(gp, "EUSTON ROAD", 0, 0, r18, 404, 202, 705, 127, height, width);

        int r19[] = {100, 200, 400, 1200, 2100, 2200};
        lands[29] = new LandButton(gp, "PICCADILLY", 0, 0, r19, 440, 220, 705, 199, height, width);
       
        int r20[] = {105, 210, 420, 1250, 2200, 2300};
        lands[31] = new LandButton(gp, "OXFORD STREET", 0, 0, r20, 550, 275, 705, 343, height, width);

        int r21[] = {120, 240, 480, 1300, 2500, 2600};
        lands[33] = new LandButton(gp, "PARK LANE", 0, 0, r21, 562, 300, 705, 487, height, width);
       
        int r22[] = {200, 400, 800, 2400, 3000, 3500};
        lands[35] = new LandButton(gp, "MAYFAIR", 0, 0, r22, 1800, 900, 705, 631, height, width);
      
        int r23[] = {50, 100, 200, 400};
        lands[4] = new StationButton(gp, "MARYLEBONE STATION", 0, r23, 500, 250, gp.LandWidth*4 + gp.LandHeight, 705, width, height);

        int r24[] = {50, 100, 200, 400};
        lands[14] = new StationButton(gp, "FENCHURCH STATION", 0, r24, 700, 350, 0, 343, height, width);

        int r25[] = {50, 100, 200, 400};
        lands[23] = new StationButton(gp, "KING CROSS STATION", 0, r25, 1000, 500, 415, 0, width, height);

        int r26[] = {50, 100, 200, 400};
        lands[32] = new StationButton(gp, "LIVERPOOL ST. STATION", 0, r26, 1500, 750, 705, 415, height, width);






    }
}
