package place;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import Main.GamePanel;
import button.*;

public class Places extends placeDraw {
    GamePanel gp;
    Bufferimg place;
    public final Button[] button;
    public final TaxButton[] tax;

    public final StationButton[] stationButton;
    public final LandButton[] lands;

    // public final LandButton =

    public Places(GamePanel gp) {
        
        this.gp = gp;

        place = new Bufferimg();
        lands = new LandButton[36];
        button = new Button[36];
        tax = new TaxButton[2];
        stationButton = new StationButton[4];
         

        getBackGroundImage();
    }

    public void getBackGroundImage() {
        try {

            place = new Bufferimg();
            place.image = ImageIO.read(getClass().getResourceAsStream("/res/BackGround/background1.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int width = gp.LandWidth;
        int height = gp.LandHeight;

        // Special button
         
        button[0] = new StartLand(gp ,0, "Start Land", 705, 705, 127, 127);
        button[9] = new Jail(gp, 9, "Jail", 0, 705, 127, 127, 0);
        button[18] = new FreePark(gp, 18, "Free Park", 0, 0, 127, 127);
        button[27] = new gotoJail(gp, 27, "go to Jail", 705, 0, 127, 127);
         

        // CHANCE 
        button[6] = new Chance(gp ,6, "Chance", height + width * 2, 705, width, height, false);
        button[11] = new Chance(gp, 11, "Chance", 0, height + width * 6, height, width, false);
        button[20] = new Chance(gp, 20, "Chance", height + width , 0, width, height, false);
        button[30] = new Chance(gp, 30, "Chance", 705, height + width * 2, height, width, false);

        // TAX 
        tax[0] = new TaxButton(gp, 3, "Income Tax", height + width * 5, 705, width, height);
        button[3] = tax[0];
        tax[1] = new TaxButton(gp, 34, "Super Tax", 705, 705 - width * 2, height, width);
        button[34] = tax[1];

        // button
        int r1[] = {5, 20, 40, 130, 270, 400};
        lands[1] = new LandButton(gp, 1,  "VINE STREET", 0, 0, r1 , 15, 8, gp.LandWidth*7 + gp.LandHeight, 705, width, height, false);
        button[1] =lands[1];

        int r2[] = {15, 30, 60, 170, 340, 500};
        lands[2] = new LandButton(gp, 2,  "COVENTRY STREET", 0, 0, r2, 57, 28, gp.LandWidth*6 + gp.LandHeight, 705, width, height, false);
        button[2] =lands[2];

        int r3[] = {20, 40, 80, 230, 450, 600};
        lands[5] = new LandButton(gp, 5,  "LEICESTER SQUARE", 0, 0, r3, 68, 34, gp.LandWidth*3 + gp.LandHeight, 705, width, height, false);
        button[5] =lands[5];

        int r4[] = {25, 50, 100, 290, 560, 700};
        lands[7] = new LandButton(gp, 7,  "BOW STREET", 0, 0, r4, 71, 35, gp.LandWidth + gp.LandHeight, 705, width, height, false);
        button[7] =lands[7];

        int r5[] = {30, 60, 120, 350, 670, 800};
        lands[8] = new LandButton(gp, 8,  "WHITECHAPEL ROAD", 0, 0, r5, 81, 40, gp.LandHeight, 705, width, height, false);
        button[8] =lands[8];

        int r6[] = {35, 70, 140, 400, 750, 900};
        lands[10] = new LandButton(gp, 10, "THE ANGEL ISLINGTON", 0, 0, r6, 91, 45, 0, 631, height, width, false);
        button[10] = lands[10];

        int r7[] = {40, 80, 160, 450, 870, 1000};
        lands[12] = new LandButton(gp, 12, "TRAFALGAR SQUARE", 0, 0, r7, 97, 50, 0, 487, height, width, false);
        button[12] = lands[12];

        int r8[] = {45, 90, 180, 520, 950, 1100};
        lands[13] = new LandButton(gp, 13, "NORTHUMRL'D AVENUE", 0, 0, r8, 112, 56, 0, 415, height, width, false);
        button[13] = lands[13];
        
        int r9[] = {50, 100, 200, 580, 1100, 1200};
        lands[15] = new LandButton(gp, 15, "M'BOROUGH STREET", 0, 0, r9, 125, 62, 0, 271, height, width, false);
        button[15] = lands[15];
        
        int r10[] = {55, 110, 220, 640, 1200, 1300};
        lands[16] = new LandButton(gp, 16, "FLEET STREET", 0, 0, r10, 148, 74, 0, 199, height, width, false);
        button[16] = lands[16];
        
        int r11[] = {60, 120, 240, 650, 1300, 1400};
        lands[17] = new LandButton(gp, 17, "OLD KENT ROAD", 0, 0, r11, 208, 104, 0, 127, height, width, false);
        button[17] = lands[17];
        
        int r12[] = {65, 130, 260, 700, 1400, 1500};
        lands[19] = new LandButton(gp, 19, "WHITEHALL", 0, 0, r12, 211, 105, gp.LandHeight, 0, width, height, false);
        button[19] = lands[19];
      
        int r13[] = {70, 140, 280, 820, 1500, 1600};
        lands[21] = new LandButton(gp, 21, "PENTONVILLE ROAD", 0, 0, r13, 215, 108, gp.LandWidth*2 + gp.LandHeight, 0, width, height, false);
        button[21] = lands[21];
       
        int r14[] = {75, 150, 300, 850, 1600, 1700};
        lands[22] = new LandButton(gp, 22, "PALL MALL", 0, 0, r14, 228, 114, gp.LandWidth*3 + gp.LandHeight, 0, width, height, false);
        button[22] = lands[22];

        int r15[] = {80, 160, 320, 900, 1700, 1800};
        lands[24] = new LandButton(gp, 24, "BOND STREET", 0, 0, r15, 271, 135, gp.LandWidth*5 + gp.LandHeight, 0, width, height, false);
        button[24] = lands[24];

        int r16[] = {85, 170, 340, 1000, 1800, 1900};
        lands[25] = new LandButton(gp, 25, "STRAND", 0, 0, r16, 320, 160, gp.LandWidth*6 + gp.LandHeight, 0, width, height, false);
        button[25] = lands[25];

        int r17[] = {90, 180, 360, 1050, 1900, 2000};
        lands[26] = new LandButton(gp, 26, "REGENT STREET", 0, 0, r17, 370, 185, gp.LandWidth*7 + gp.LandHeight, 0, width, height, false);
        button[26] = lands[26];

        int r18[] = {95, 190, 380, 1100, 2000, 2100};
        lands[28] = new LandButton(gp, 28, "EUSTON ROAD", 0, 0, r18, 404, 202, 705, 127, height, width, false);
        button[28] = lands[28];

        int r19[] = {100, 200, 400, 1200, 2100, 2200};
        lands[29] = new LandButton(gp, 29, "PICCADILLY", 0, 0, r19, 440, 220, 705, 199, height, width, false);
        button[29] = lands[29];
       
        int r20[] = {105, 210, 420, 1250, 2200, 2300};
        lands[31] = new LandButton(gp, 31, "OXFORD STREET", 0, 0, r20, 550, 275, 705, 343, height, width, false);
        button[31] = lands[31];

        int r21[] = {120, 240, 480, 1300, 2500, 2600};
        lands[33] = new LandButton(gp, 33, "PARK LANE", 0, 0, r21, 562, 300, 705, 487, height, width, false);
        button[33] = lands[33];
       
        int r22[] = {200, 400, 800, 2400, 3000, 3500};
        lands[35] = new LandButton(gp, 35, "MAYFAIR", 0, 0, r22, 1800, 900, 705, 631, height, width, false);
        button[35] = lands[35];
      
        //STARTION
        int r23[] = {50, 100, 200, 400};
        stationButton[0] = new StationButton(gp, 4,"MARYLEBONE STATION", 0, r23, 500, 250, gp.LandWidth*4 + gp.LandHeight, 705, width, height, false);
        button[4] = stationButton[0];

        int r24[] = {50, 100, 200, 400};
        stationButton[1] = new StationButton(gp, 14, "FENCHURCH STATION", 0, r24, 700, 350, 0, 343, height, width, false);
        button[14] = stationButton[1]; 

        int r25[] = {50, 100, 200, 400};
        stationButton[2] = new StationButton(gp, 23, "KING CROSS STATION", 0, r25, 1000, 500, 415, 0, width, height, false);
        button[23] = stationButton[2]; 

        int r26[] = {50, 100, 200, 400};
        stationButton[3] = new StationButton(gp, 32, "LIVERPOOL ST. STATION", 0, r26, 1500, 750, 705, 415, height, width, false);
        button[32] = stationButton[3]; 

    }
    
    @Override
    public void draw(Graphics2D g2) {

        g2.drawImage(place.image, 0, 0, gp.boardsize, gp.boardsize, null);

    }
}
