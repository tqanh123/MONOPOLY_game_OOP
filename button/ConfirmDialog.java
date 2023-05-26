package button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConfirmDialog extends JFrame {

    // public ConfirmDialog() {
    //     getContentPane().setLayout(null);
    //     setTitle("Confirm");
    //     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     setVisible(false);
    //     setResizable(false);
    //     setSize(450, 300);

    //     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    //     setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

    // }

    public static void showOption(Button lands) {

        ConfirmDialog cdframe = new ConfirmDialog();
        ImageIcon icon = new ImageIcon("Dice1.gif");
        String[] options = {"land", "1 house", "2 houses", "3 houses", "4 houses"};
        int x = JOptionPane.showOptionDialog(cdframe, "Buy the land or building house?",
        "transection", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);

        if (x == 0) {
            System.out.println("a Land");

        }else if (x == 1) {

            System.out.println("1 house");
        } else if (x == 2) {

            System.out.println("2 house");
        } else if (x == 3) {

            System.out.println("3 house");
        } else if (x == 4) {
            
            System.out.println("4 house");
        }
        
        cdframe.dispose();
    }
}
