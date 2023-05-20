package Menu;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Main.Main;
import Main.GamePanel;
public class LaunchPage implements ActionListener{
    private JLabel myLabel;
    private JFrame frame;
    private JLabel backGround;
    private JButton playButton;
    private int width;
    private int height;
    private String backgroundFilePath;


    LaunchPage(int w, int h, String backgroundFilePath){
        this.width = w;
        this.height = h;
        this.backgroundFilePath = backgroundFilePath;
    }
    public void run() throws IOException{
        frame = new JFrame("MONOPOLY");
        playButton = new JButton("Play");
        JButton optionsButton = new JButton("Options");
        JButton ruleButton = new JButton("Rule");
        JButton quitButton = new JButton("Quit");
        File file = new File(backgroundFilePath);
        System.out.println(file.exists());
        BufferedImage image = ImageIO.read(new FileInputStream("res/BackGround/monopoly_background.png"));
        frame.setContentPane(new ImagePanel(image, width, height));

        playButton.setBounds(100, 80, 200, 40);
        playButton.setFocusable(false);
        playButton.addActionListener(this);

        frame.add(playButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(this.width, this.height);
        frame.setLayout(null);
        frame.setVisible(true);
        optionsButton.setBounds(100 , 120, 200, 40);
        optionsButton.setFocusable(false);
        optionsButton.addActionListener(this);

        frame.add(optionsButton);

        ruleButton.setBounds(100, 160, 200, 40);
        ruleButton.setFocusable(false);
        ruleButton.addActionListener(this);

        frame.add(ruleButton);

        quitButton.setBounds(100 , 200, 200, 40);
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        frame.add(quitButton);
        //Quit 
        
        quitButton.addActionListener(e -> {
            frame.dispose();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== playButton  ){

            Main.showWindow();
            frame.setVisible(false);
            this.dispose();
           
        }
        
    }
    
    private void dispose() {
    }
}
