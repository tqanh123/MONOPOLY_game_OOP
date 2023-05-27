package button;

import java.io.IOException;
import java.util.Random;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    int rollCount;
    private boolean isRoll;
    private int playerid;
    
    public DiceButton (GamePanel gp) {

        this.gp = gp;

        dices = new Dice[6];

        getDiceImage();
        getRollButton();
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

    public void setup(int index, String filePath) {

        UtilityTool uTool = new UtilityTool();

        try {
            
            dices[index] = new Dice();
            dices[index].image = ImageIO.read(getClass().getResourceAsStream("/res/Dice/" + filePath + ".png"));
            dices[index].image = uTool.scaleImage(dices[index].image, 100, 100);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isDouble(){
        if (getNumDice1() == getNumDice2()) return true;
        return false;
    }

    public void getRollButton(){
        int x = gp.boardsize / 2 - 100;
        int y = gp.boardsize / 2 - 100;
        
        gp.setLayout(null);
        rollButton = new JButton();
        gp.add(rollButton);

        rollButton.setBounds(x, y, 200, 100);
        rollButton.setOpaque(false);
        
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
            if (gp.gameState == gp.initialState) {
                
                gp.gameState = gp.rollState;
                gp.playSE(1);
                rollButton.setEnabled(false);

                // roll for 2 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        try{
                            while((endTime - startTime)/1000F < 1){
                                // roll dice
                                gp.update();
                                gp.repaint();
                                
                                // sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();

                            }

                            gp.gameState = gp.playState;
                            rollButton.setEnabled(true);
                            gp.monopoly.PlayGame();

                        }catch(InterruptedException e){
                            System.out.println("Threading Error: " + e);
                        }
                    }
                });
                rollThread.start();
            }
        }
        
        });
    }
    
    public void Draw(Graphics2D g2) {
        int x = gp.boardsize / 2 - 100;
        int y = gp.boardsize / 2 - 100;
        
        g2.drawImage(dices[numDice1].image, x, y, 100, 100, null);
        
        g2.drawImage(dices[numDice2].image, x + 100, y , 100, 100, null);
        
    }
    
    public void update() {
        Random rand = new Random();

        numDice1 = rand.nextInt( 6);
        numDice2 = rand.nextInt( 6);
    }

    public int getNumDice1() {
        return numDice1;
    }

    public int getNumDice2() {
        return numDice2;
    }

    public int getTotalDice() {
        return getNumDice1() + getNumDice2() + 2;   
    }
}
