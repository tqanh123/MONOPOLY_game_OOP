package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

import Main.GamePanel;
import Main.GameRule;
import Select.EnterNumberOfPlayers;
public class LaunchPage implements ActionListener{
    private JFrame frame;
    private JButton playButton;
    private JButton ruleButton;
    private JButton quitButton;
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
        ruleButton = new JButton("Rule");
        quitButton = new JButton("Quit");
        File file = new File(backgroundFilePath);
        System.out.println(file.exists());
        BufferedImage image = ImageIO.read(new FileInputStream("res/BackGround/monopoly_background.png"));
        frame.setContentPane(new ImagePanel(image, width, height));

        playButton.setBounds(100, 110, 200, 40);
        playButton.setFocusable(false);
        playButton.addActionListener(this);

        frame.add(playButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(this.width, this.height);
        frame.setLayout(null);
        frame.setVisible(true);

        ruleButton.setBounds(100, 150, 200, 40);
        ruleButton.setFocusable(false);
        ruleButton.addActionListener(this);

        frame.add(ruleButton);

        quitButton.setBounds(100 , 190, 200, 40);
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
            EnterNumberOfPlayers enterNumberOfPlayers = new EnterNumberOfPlayers();
            enterNumberOfPlayers.setVisible(true);
            frame.setVisible(false);
           
        }
        if(e.getSource()== ruleButton  ){
            GameRule gameRule = new GameRule();
           gameRule.setVisible(true);
            frame.setVisible(false);
           
        }
        
    }   

    private void dispose() {
    }
}
