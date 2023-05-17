package Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import Main.Main;
import Main.GamePanel;
public class LaunchPage implements ActionListener{
JFrame frame = new JFrame();
JButton myButton = new JButton("Play");
JButton myButton1 = new JButton("Options");
JButton myButton2 = new JButton("Rule");
JButton myButton3 = new JButton("Quit");
    LaunchPage(){

    myButton.setBounds(100, 80, 200, 40);
    myButton.setFocusable(false);
    myButton.addActionListener(this);

    frame.add(myButton);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLayout(null);
    frame.setVisible(true);
   
    Main main = new Main();
    main.showWindow();
    dispose();

    myButton1.setBounds(100 , 120, 200, 40);
    myButton1.setFocusable(false);
    myButton1.addActionListener(this);

    frame.add(myButton1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLayout(null);
    frame.setVisible(true);


     myButton2.setBounds(100, 160, 200, 40);
    myButton2.setFocusable(false);
    myButton2.addActionListener(this);

    frame.add(myButton2);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLayout(null);
    frame.setVisible(true);

    myButton3.setBounds(100 , 200, 200, 40);
    myButton3.setFocusable(false);
    myButton3.addActionListener(this);

    frame.add(myButton3);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLayout(null);
    frame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton  ){
            Main w2 = new Main();
            w2.showWindow();
            this.dispose();
           
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    private void dispose() {
    }
}
