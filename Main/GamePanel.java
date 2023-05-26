package Main;


import PlayGame.Monopoly;
import button.Chance;
import button.ConfirmDialog;
import button.DiceButton;
import place.*;
import player.DrawComponent;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class GamePanel extends JPanel implements Runnable {

    public final Color[] color = {Color.RED, Color.BLUE, Color.ORANGE, Color.CYAN};
    public final int originalTileSize = 16;
    public final int building = 2;
    public final int LandWidth = 72;
    public final int LandHeight = 127;
    public final int infoPlayer = 16;
    public final int Menuheight = 3;
    // SCREEN 
    public final int boardsize = 832;
    public final int screenWidth = 832 + infoPlayer * originalTileSize;
    public final int screenHeight = boardsize;

    int FPS = 60;

    // SYSTEM 
    public UI ui = new UI(this);
    public final ConfirmDialog confirmDialog = new ConfirmDialog();
    public final Chance chance = new Chance(this, 0, "Chance", 0, 0, 0, 0, false);
    Sound sound = new Sound();
    public PlayerInfo playerInfo = new PlayerInfo(this);
    placeDraw placed;
    public final Places boardPlaces = new Places(this);
    Menu menuPlace = new Menu(this);
    DrawComponent component = new DrawComponent(this);
    public final Monopoly monopoly = new Monopoly(this);
    public final DiceButton diceButton = new DiceButton(this);

    Thread gameThread;

    // GAME STATE 
    public final int pauseState = -1;
    public final int initialState = 0;
    public final int playState = 1;
    public final int rollState = 2;
    public int gameState = 0;

    public GamePanel() {

        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setDoubleBuffered(true);
        
    }

    public void setupGame() {
    
        playMusic(0);
        monopoly.MonopolyInitial();
        ui.showMessage(String.format("It's " + monopoly.player[0].getName() + "turn"));
        chance.initialChance();

    }

    public void startgameThread() {
        
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override 
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        long timer = 0;
        long timeRoll = 0;
        int drawCount = 0;
        
        while (gameThread != null) {
            
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            // timer += (currentTime - lastTime);
            
            if (gameState == rollState) timeRoll += (currentTime - lastTime);
            lastTime = currentTime;
            
            if (delta >= 1) {
                update();
                repaint();
                // System.out.println("thread");
                delta--;
                drawCount++;
            }
            
            if (timeRoll >= 1000000000) {
                    
                // System.out.println(diceButton.getTotalDice());
                // gameState = playState;
                timeRoll = 0;
                drawCount = 0;
            
            }
        }
    }
    
    public void update() {
        // menuPlace.update();
        // if (gameState == initialState) monopoly.PlayGame();
        if (gameState == rollState) diceButton.update();
    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        boardPlaces.draw(g2);
        playerInfo.draw(g2);
        // if (gameState == rollState) 
        diceButton.Draw(g2);
        component.Draw(g2);
        chance.draw(g2);

        ui.draw(g2);

        g2.dispose();

    }    
    
    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i) {

        sound.setFile(i);
        sound.play();
    }
}
