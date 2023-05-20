package Main;

import javax.swing.JPanel;

<<<<<<< HEAD

import button.DiceButton;
import place.Menu;
import place.Places;
import place.PlayerInfo;
=======
import button.Chance;
import button.ConfirmDialog;
import button.DiceButton;
import place.*;
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements Runnable,MouseListener, MouseMotionListener,KeyListener{

    public final Color[] color = {Color.RED, Color.BLUE, Color.ORANGE, Color.CYAN};
    public final int originalTileSize = 16;
    public final int building = 2;
    public final int LandWidth = 72;
    public final int LandHeight = 127;
    public final int infoPlayer = 16;
    public final int Menuheight = 3;

<<<<<<< HEAD
    public final int LandWidth = 72;
    public final int LandHeight = 127;
  
 
    public final int boardsize =832;
    final int screenWidth = originalTileSize * ( infoPlayer )+ 832;
    final int screenHeight = 832;

    int FPS = 60;

=======
    // SCREEN 
    public final int boardsize = 832;
    final int screenWidth = 832 + infoPlayer * originalTileSize;
    final int screenHeight = boardsize;

    int FPS = 60;

    // SYSTEM 
    ConfirmDialog confirmDialog = new ConfirmDialog();
    Sound sound = new Sound();
    placeDraw placed;
    // Chance chance = new Chance(this, 0);
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
    Places boardPlaces = new Places(this);
    Menu menuPlace = new Menu(this);
    DiceButton diceButton = new DiceButton(this);
<<<<<<< HEAD
    PlayerInfo playerInfo = new PlayerInfo(this);
=======
    Thread gameThread;

>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
    // GAME STATE 
    public final int initialState = 0;
    public final int playState = 1;
    public final int rollState = 2;
    public int gameState = 0;

    private enum STATE{
        MENU, GAME
    };
    private STATE state = STATE.MENU;

    public GamePanel() {
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setDoubleBuffered(true);
       
    }

    public void setupGame() {
        
        playMusic(0);      
        // chance.active();
        // ConfirmDialog.showOption();

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
        int drawCount = 0;
        
        while (gameThread != null) {
            
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            if (gameState == rollState) timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if (timer >= 1000000000) {
                
                System.out.println(drawCount);
                gameState = playState;
                timer = 0;
                drawCount = 0;

            }
        }
    }
    
    public void update() {
<<<<<<< HEAD
        // menuPlace.update();
       
=======
>>>>>>> b79656182be9b81a5677b7492b0f9e54e0890f2a
        if (gameState == rollState) diceButton.update();
    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (gameState == initialState) {
            gameState = playState;
            diceButton.Draw(g2);
            boardPlaces.draw(g2);
        }

        boardPlaces.draw(g2);
        // if (gameState == rollState) 
        diceButton.Draw(g2);
        playerInfo.draw(g2);
        
        // chance.draw(g2);
        
        g2.dispose();
        // buttonH.drawBox(g2);
        // g2.setColor(Color.white);
        // g2.fillRect(0, 0, boardsize, boardsize);
        

    }
   
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
     
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
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
