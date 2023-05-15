package button;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.GamePanel;
import place.Bufferimg;

public class Chance extends Button {
    public String landName;
    public int landX, landY;
    public int landWidth, landHeight;

    Bufferimg[] card;
    private final int numCards = 4;
    private static int[] chanceId;
    private static int chance;
    private int timeChane = 0;
    private String message = "click any where in board play";
    private Font font;
    private static boolean isChance = false;

    public Chance (GamePanel gp, String landName, int landX, int landY, int landWidth, int landHeight, int chance) {
        super(gp, landName, landX, landY, landWidth, landHeight);
        this.chance = chance;

        card = new Bufferimg[10];
        chanceId = new int[10];
        font = new Font("Times New Roman", Font.PLAIN, 40);

        getChanceImage();
        randId();
    }

    public void getChanceImage() {
        try {

            card[0] = new Bufferimg();
            card[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/start.jpg"));
            
            card[1] = new Bufferimg();
            card[1].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/Go_toStation.jpg"));

            card[2] = new Bufferimg();
            card[2].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/get50.jpg"));

            card[3] = new Bufferimg();
            card[3].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/GB3S.jpg"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        if (isChance == true) {

            g2.setColor(new Color(0, 0, 50, 200));
            g2.fillRect(0, 0, gp.boardsize, gp.boardsize);
            
            g2.setColor(new Color(250, 200, 200));
            g2.setFont(font);
            g2.drawImage(card[ chanceId[chance] ].image, 166, 200, 500, 300, null);
            g2.drawString(message, gp.boardsize/2 - 240, 600);
            
            JButton okChance = new JButton();
            okChance.setBounds(0, 0,gp.boardsize, gp.boardsize);
            gp.add(okChance);
            
            okChance.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isChance = false;
                    setChance();
                }
            });;

            timeChane++;
            if (timeChane > 80) {
                isChance = false;
                setChance();
            }
            
        }
    }

    public void randId(){
        int i;
        Random rand = new Random();
        chance = 0;

        for ( i = 0; i < numCards; i++) chanceId[i] = i;

        for ( i = 0; i < numCards; i++) {

            int x = rand.nextInt(0, 3);
            int y = rand.nextInt(0, 3);
            
            int k = chanceId[x];
            chanceId[x] = chanceId[y];
            chanceId[y] = k;
            
        }
    }

    @Override
    public String toString() {
        return "you will have a random cards with some benefit or drawback ";
    }

    public final void setChance(){
        timeChane = 0;
        chance++;
        if (chance == numCards) chance = 0;
    }

    public static int active() {

        isChance = true;
        return chanceId[chance];

    }

}
