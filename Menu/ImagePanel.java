package Menu;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class ImagePanel extends JComponent{
    private Image image;
    private int targetWidth;
    private int targetHeight;

    public ImagePanel(Image image, int targetWidth, int targetHeight) {
        this.targetHeight = targetHeight;
        this.targetWidth = targetWidth;

        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,targetWidth,targetHeight, this);
    }
}
