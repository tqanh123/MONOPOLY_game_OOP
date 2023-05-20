package button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ConfirmDialog extends JFrame {

    public ConfirmDialog() {

        getContentPane().setBackground(new Color(238, 232, 170));
        getContentPane().setLayout(null);
        setTitle("Confirm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(450, 300);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

        
    }

    // public JPanel panel() {

    //     JPanel panel = new JPanel();
    //     panel.setBounds(0, 0, 444, 271);
    //     panel.setBackground(new Color(176, 224, 230));
    //     getContentPane().add(panel);
    //     panel.setLayout(null);

    //     JLabel lblIcon = new JLabel("");
    //     lblIcon.setBounds(30, 30, 200, 200);
    //     lblIcon.setIcon(new ImageIcon("trasure.jpg"));
    //     panel.add(lblIcon);

    //     JLabel lblText2 = new JLabel("Lauren is the 4th daughter!");
    //     lblText2.setVerticalAlignment(SwingConstants.TOP);
    //     lblText2.setFont(new Font("Tahoma", Font.ITALIC, 14));
    //     lblText2.setHorizontalAlignment(SwingConstants.CENTER);
    //     lblText2.setBounds(240, 130, 175, 100);
    //     panel.add(lblText2);

    //     JLabel lblText1 = new JLabel("Yaaaay!");
    //     lblText1.setHorizontalAlignment(SwingConstants.CENTER);
    //     lblText1.setFont(new Font("Tahoma", Font.ITALIC, 14));
    //     lblText1.setBounds(240, 30, 175, 100);
    //     panel.add(lblText1);

    //     return panel;

    // }

    public static void showOption(LandButton land) {

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
