package Main.building;

import java.awt.Graphics;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import button.LandButton;


public abstract class Building extends JComponent {
    
    private static final int MAX_LEVEL = 4;
    protected String name;
    private int scaleWidth;
    private int scaleHeight;
    protected int level;
    protected Direction direction;
    protected LandButton land;
    

    public Building(LandButton land, String name, int width, int height, int level, Direction direction) {
        this.name = name;
        this.scaleWidth = width;
        this.scaleHeight = height;
        this.level = level;
        this.land = land;
    }

    public Building(LandButton land, String name, int level, Direction direction) {
        this.name = name;
        this.level = level;
        this.direction = direction;
        this.land = land;
    }

    public boolean isMaxLevel(){
        return level >= MAX_LEVEL;
    }

    public boolean upgrade() {
        if (isMaxLevel()) {
            return false;
        }
        level++;
        return true;
    }

    protected abstract String getImagePath();

    public abstract int getPriceToBuild();

    public abstract int getPriceToUpdateFrom(int oldLevel);

    public abstract int getPurchaseAmount();

    @Override
    public void paintComponent(Graphics g) {
        try {
            if (scaleWidth != 0 && scaleHeight != 0) {
                g.drawImage(ImageIO.read(new URL(getImagePath())), land.getLandX(), land.getLandY(), scaleWidth, scaleHeight, this);
            } else {
                g.drawImage(ImageIO.read(new URL(getImagePath())), land.getLandX(), land.getLandY(), this);
            }
            
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public int getLandId() {
        return land.getId();
    }

    
}
