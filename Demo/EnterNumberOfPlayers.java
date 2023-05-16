
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class EnterNumberOfPlayers extends JFrame {


    public EnterNumberOfPlayers() {
        //     JFrame inputNum = new JFrame("Input number of Player ");
        //     inputNum.setVisible(true);
        showWindowPlayer();
    
    }

    public static void showWindowPlayer() {//GEN-FIRST:event_jButton1ActionPerformed
        final String number = JOptionPane.showInputDialog("number of Player");
        int num = Integer.parseInt(number);

        if(num == 4){
            FourPlayers four = new FourPlayers();
            four.setVisible(true);
        } else if(num == 3){
            ThreePlayers three = new ThreePlayers();
            three.setVisible(true);
        } else if(num == 2){
            TwoPlayers two = new TwoPlayers();
            two.setVisible(true);
        }else JOptionPane.showMessageDialog(null, "Error!!!");
        
        if (number.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter number of players");
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        showWindowPlayer();
        
    }

}
