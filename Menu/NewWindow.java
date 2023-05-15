package Menu;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewWindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hello");

    NewWindow(){

        label.setBounds(0, 0, 100, 50);
        
        frame.add(label);
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
