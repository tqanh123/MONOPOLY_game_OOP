package button;

import java.io.IOException;
import java.util.Random;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import Main.GamePanel;
import Main.UtilityTool;

public class DiceButton {

    GamePanel gp;
    Dice[] dices;
    int numDice1 = 0;
    int numDice2 = 0;
    public JButton rollButton;
    
    public DiceButton (GamePanel gp) {

        this.gp = gp;

        dices = new Dice[6];

        getDiceImage();
        // getRollButton();
    }

    public void getDiceImage(){  
        try {

            dices[0] = new Dice();
            dices[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Dice/Dice1.png"));

            dices[1] = new Dice();
            dices[1].image = ImageIO.read(getClass().getResourceAsStream("/res/Dice/Dice2.png"));

            dices[2] = new Dice();
            dices[2].image = ImageIO.read(getClass().getResourceAsStream("/res/Dice/Dice3.png"));

            dices[3] = new Dice();
            dices[3].image = ImageIO.read(getClass().getResourceAsStream("/res/Dice/Dice4.png"));

            dices[4] = new Dice();
            dices[4].image = ImageIO.read(getClass().getResourceAsStream("/res/Dice/Dice5.png"));

            dices[5] = new Dice();
            dices[5].image = ImageIO.read(getClass().getResourceAsStream("/res/Dice/Dice6.png"));
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public BufferedImage setup(int index, String filePath) {

    //     UtilityTool uTool = new UtilityTool();
    //     BufferedImage image = null;

    //     try {
            
    //         dices[index] = new Dice();
    //         dices[index].image = ImageIO.read(getClass().getResourceAsStream("/res/Dice/Dice" + filePath + ".png"));
    //         dices[index].image = uTool.scaleImage(dices[index].image, 100, 100);

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    public void getRollButton() {
        int x = gp.boardsize * 3 / 4;
        int y = gp.boardsize * 3 / 4;

        JButton rollButton = new JButton("Roll!");
        rollButton.setBounds(x, y, 100, 50);
        
        gp.setLayout(null);
        gp.add(rollButton);
        
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rollButton.setEnabled(false);
                gp.gameState = gp.rollState;
               
            }
        });
    }
    
    public void Draw(Graphics2D g2) {
        int x = gp.boardsize / 2 - 100;
        int y = gp.boardsize / 2 - 100;
        
        gp.setLayout(null);
        JButton rollButton = new JButton();
        gp.add(rollButton);

        rollButton.setBounds(x, y, 200, 100);
        rollButton.setOpaque(false);
        
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // rollButton.setEnabled(false);
                gp.gameState = gp.rollState;
                if (gp.gameState == gp.rollState) 
                    gp.playSE(1);
               
            }
        });
        
        g2.drawImage(dices[numDice1].image, x, y, 100, 100, null);
        
        g2.drawImage(dices[numDice2].image, x + 100, y , 100, 100, null);
        
    }
    
    public void update() {
        Random rand = new Random();

        numDice1 = rand.nextInt(0, 6);
        numDice2 = rand.nextInt(0, 6);
    }

    public int getNumDice1() {
        return numDice1;
    }

    public int getNumDice2() {
        return numDice2;
    }

    public int getTotalDice() {
        return getNumDice1() + getNumDice2();
        
    }
    
    // public void setIsRoll(boolean enable) {
    //     rollButton.setEnabled(enable);
    // }

}
