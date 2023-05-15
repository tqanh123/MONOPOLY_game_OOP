<<<<<<< HEAD
<<<<<<< HEAD
package button;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.GamePanel;

public class ButtonHandler implements ActionListener {
    private int boxX, boxY, boxWidth, boxHeight;
    GamePanel gp;
    public boolean ok = false;
    
    public ButtonHandler(GamePanel gp, int boxX, int boxY, int boxWidth, int boxHeight) {
        this.gp = gp;
        this.boxHeight = boxHeight;
        this.boxWidth = boxWidth;
        this.boxX = boxX;
        this.boxY = boxY;
        System.out.println("ok");
    }

    public int getBoxX () {
        return boxX;
    }

    public int getBoxY () {
        return boxY;
    }

    public int getBoxWidth () {
        return boxWidth;
    }

    public int getBoxHeight () {
        return boxHeight;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String Actioncode = e.getActionCommand();
        if (Actioncode.equals("hello")) ok = true;
    }    
    
    public void drawBox(Graphics2D g2) {

        g2.setColor(Color.MAGENTA);
        g2.fillRect(this.getBoxX(), this.getBoxY(), this.getBoxWidth(), this.getBoxHeight());
        
    }
}
=======
=======
>>>>>>> ed1c4d7ce03455f050cc296aa30cc6c962bbdf9c
package button;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.GamePanel;

public class ButtonHandler implements ActionListener {
    private int boxX, boxY, boxWidth, boxHeight;
    GamePanel gp;
    public boolean ok = false;
    
    public ButtonHandler(GamePanel gp, int boxX, int boxY, int boxWidth, int boxHeight) {
        this.gp = gp;
        this.boxHeight = boxHeight;
        this.boxWidth = boxWidth;
        this.boxX = boxX;
        this.boxY = boxY;
        System.out.println("ok");
    }

    public int getBoxX () {
        return boxX;
    }

    public int getBoxY () {
        return boxY;
    }

    public int getBoxWidth () {
        return boxWidth;
    }

    public int getBoxHeight () {
        return boxHeight;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String Actioncode = e.getActionCommand();
        if (Actioncode.equals("hello")) ok = true;
    }    
    
    public void drawBox(Graphics2D g2) {

        g2.setColor(Color.MAGENTA);
        g2.fillRect(this.getBoxX(), this.getBoxY(), this.getBoxWidth(), this.getBoxHeight());
        
    }
}
<<<<<<< HEAD
>>>>>>> 8d4a1e784d780a131724a1ab29a4ce85172059a5
=======
>>>>>>> ed1c4d7ce03455f050cc296aa30cc6c962bbdf9c
