package button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Main.GamePanel;

public class ConfirmDialog extends JFrame {
    

    public static void showOption(Button lands, int id, GamePanel gp) {

        ConfirmDialog cdframe = new ConfirmDialog();
        ImageIcon icon = new ImageIcon("/res/House/p1hotel_down.png");
        String[] options = {"update land"};
        int x = JOptionPane.showOptionDialog(cdframe, "Buy the land or building house?",
        "transection", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);

        if (x == 0) {
            if ( !((ActiveButton)lands).isOwn() ) gp.monopoly.player[id].buy((ActiveButton)lands);
            else gp.monopoly.player[id].buy((ActiveButton)lands, ((LandButton)lands).getNumHouse() + 1);
        }
        
        cdframe.dispose();
    }
}
