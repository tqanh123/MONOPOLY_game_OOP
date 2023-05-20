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
    private int numCards = 10;
    private int[] chanceId;
    private int chance;
    private int timeChane = 0;
    private String message = "click any where in board play";
    private  Font font;
    private  boolean isChance;

    public Chance (GamePanel gp, int id, String landName, int landX, int landY, int landWidth, int landHeight, boolean isChance) {
        super(gp, id, landName, landX, landY, landWidth, landHeight);
        this.isChance = isChance;
    }

    public  void  initialChance(){
        getChanceImage();
        randId();
        font = new Font("Times New Roman", Font.PLAIN, 40);
    }

    public void getChanceImage() {
        card = new Bufferimg[numCards];
        try {

            card[0] = new Bufferimg();
            card[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/start.jpg"));
            
            card[1] = new Bufferimg();
            card[1].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/Go_toStation.jpg"));

            card[2] = new Bufferimg();
            card[2].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/get50.jpg"));

            card[3] = new Bufferimg();
            card[3].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/GB3S.jpg"));

            card[4] = new Bufferimg();
            card[4].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/PE_50.jpg"));

            card[5] = new Bufferimg();
            card[5].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/Get150.jpg"));

            card[6] = new Bufferimg();
            card[6].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/Pay15.jpg"));

            card[7] = new Bufferimg();
            card[7].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/Repairs_Property.jpg"));

            card[8] = new Bufferimg();
            card[8].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/Jail.jpg"));

            card[9] = new Bufferimg();
            card[9].image = ImageIO.read(getClass().getResourceAsStream("/res/Chance/FreeJail.jpg"));
            
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

            // System.out.println(timeChane);
            timeChane++;
            if (timeChane > 50) {
                isChance = false;
                setChance();
            }
            
        }
    }

    public void randId(){
        int i;
        Random rand = new Random();
        chanceId = new int[numCards];
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

    public int active() {

        isChance = true;
        return chanceId[chance];

    }

}
