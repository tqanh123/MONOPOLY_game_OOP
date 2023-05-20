package Main;

import javax.swing.JPanel;


import button.DiceButton;
import place.Menu;
import place.Places;
import place.PlayerInfo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements Runnable,MouseListener, MouseMotionListener,KeyListener{

    public final int originalTileSize = 16;
    public final int building = 2;
    public final int place = 4;
    public final int board = 13;
    public final int infoPlayer = 16;
    public final int Menuheight = 3;

    public final int LandWidth = 72;
    public final int LandHeight = 127;
  
 
    public final int boardsize =832;
    final int screenWidth = originalTileSize * ( infoPlayer )+ 832;
    final int screenHeight = 832;

    int FPS = 60;

    Places boardPlaces = new Places(this);
    Menu menuPlace = new Menu(this);
    Thread gameThread;
    DiceButton diceButton = new DiceButton(this);
    PlayerInfo playerInfo = new PlayerInfo(this);
    // GAME STATE 
    public int gameState = 1;
    public final int playState = 1;
    public final int rollState = 2;

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
            timer += (currentTime - lastTime) ;
            lastTime = currentTime;
            
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
        
            if (timer >= 1000000000) {
                System.out.println("FPS" + drawCount);
                if (gameState == rollState) {
                    gameState = playState;
                    // diceButton.setIsRoll(true);
                }
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update() {
        // menuPlace.update();
       
        if (gameState == rollState) diceButton.update();
    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        boardPlaces.draw(g2);
        menuPlace.draw(g2);
        // diceButton.getRollButton();
        diceButton.Draw(g2);
        playerInfo.draw(g2);
        
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
    
}
