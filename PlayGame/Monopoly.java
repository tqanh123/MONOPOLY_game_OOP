package PlayGame;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;

import Main.GamePanel;
import button.DiceButton;
import button.Jail;
import place.Bufferimg;
import player.Player;

public class Monopoly {

    GamePanel gp;
    public Bufferimg[] playerImage;
    DiceButton dice;
    private int playerId;
    public Player[] player;
    private int count = 0;
    private int[] stationId ={4, 14, 23, 32, 40};
    private int LandId;
    private int numPlayer = 4;
        

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Monopoly(GamePanel gp) {
        this.gp =gp;
        MonopolyInitial();
    }

    public void MonopolyInitial(){
        playerImage = new Bufferimg[numPlayer];
        dice = new DiceButton(gp);

        try {

            playerImage[0] = new Bufferimg();
            playerImage[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Player/right1.png"));
            
            playerImage[1] = new Bufferimg();           
            playerImage[1].image = ImageIO.read(getClass().getResourceAsStream("/res/Player/right2.png"));

            playerImage[2] = new Bufferimg();           
            playerImage[2].image = ImageIO.read(getClass().getResourceAsStream("/res/Player/right3.png"));

            playerImage[3] = new Bufferimg();           
            playerImage[3].image = ImageIO.read(getClass().getResourceAsStream("/res/Player/left4.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        player = new Player[numPlayer];

        player[0] = new Player(gp, "QAnh", 0, 0, 740, 740);
        player[1] = new Player(gp, "Dat", 1, 0, 775, 742);
        player[2] = new Player(gp, "Khanh", 2, 0, 740, 775);
        player[3] = new Player(gp, "Khiem", 3, 0, 775, 775);

    }

    public void check() {
        gp.ui.showMessage(String.format("It's " + player[playerId].getName() + "turn"));

        if (player[playerId].isInJail()) {
            gp.ui.showMessage( String.format("Take %d turns to escape the Jail", player[playerId].getTurnInJail() ));
        }        
    }

    //AFTER ROLL 
    public void PlayGame(){
        count++;
        // player[playerId].move(gp.diceButton.getTotalDice());
        
        if (gp.diceButton.isDouble()){
            if (player[playerId].isInJail() == true) player[playerId].escape();
            else if (count == 3) {

                gotoJail(player[playerId].getPosition());
                player[playerId].setContinueRoll(false);
                endTurn();
                return;

            } 
            
            player[playerId].setContinueRoll(true);
        }

        if (player[playerId].isInJail() == true) {
            player[playerId].setTurnsInJail();
            endTurn();
            return;
        }
        
        player[playerId].move(9);
        //Next stages
        Dealing();       
    }

    // DEALING STAGE 
    public void Dealing(){
        
        LandId = player[playerId].getPosition();

        switch(LandId) {
            case 6, 11, 20, 30:
                TakeChance(gp.chance.active());
                break;
            case 4, 14, 23, 32:
                gp.confirmDialog.showOption(gp.boardPlaces.button[LandId]);
                break;

            case 0, 18: 

                break;
            
            case 9:
                visitedJail();
                break;
            
            case 3:
                int Amount = player[playerId].getWorth();
                player[playerId].addMoney(Amount * 8 / 10);
                break;

            case 27: 
                gotoJail(LandId);
                player[playerId].setContinueRoll(false);
                break;
            
            default :
                gp.confirmDialog.showOption(gp.boardPlaces.button[LandId]);
                break;

        }
        
        endTurn();
    }

    // END STAGE
    public void endTurn() {
        if (player[playerId].isContinueRoll() == false) {
            count = 0;
            playerId++;
            if (playerId == numPlayer) playerId = 0;
        }
        player[playerId].setContinueRoll(false);
        gp.gameState = gp.initialState;
        check();
    }

    public void TakeChance(int id) {
        int location = player[playerId].getPosition();
        switch (id) {
            case 0:
                System.out.print("case 0");
                player[playerId].move(36 - location);
                break;
            
            case 1:
            System.out.print("case 1");
                for (int i: stationId) {
                    if (i > location) {
                        player[playerId].move(i - location);
                        break;
                    }
                }
                Dealing();
                break;

            case 2:
            System.out.print("case 2");
                player[playerId].addMoney(50);
                break;

            case 3:
            System.out.print("case 3");
                player[playerId].move(-3);
                Dealing();
                break;

            case 4:
            System.out.print("case 4");
                for (Player person : player) {
                    if (person.getId() != playerId) player[playerId].pay(person, 50);
                }
                break;

            case 5:
            System.out.print("case 5");
                player[playerId].addMoney(150);
                break;

            case 6:
            System.out.print("case 6");
                player[playerId].pay(15);
                break;

            case 7:
            System.out.print("case 7");
                player[playerId].pay(player[playerId].Repairs());;
                break;

            case 8:
            System.out.print("case 8");
                gotoJail(location);
                break;
            
            case 9:
            System.out.print("case 9");
                player[playerId].setOutOfJailCards(1);
                break;
            
        }
    }
    
    private void gotoJail(int location){
        int length = 9 - location;
        if (length < 0) length +=36;
        
        player[playerId].setInJail();
        player[playerId].move(length);
    }

    private void visitedJail() {
        player[playerId].pay(Jail.amount());       
    }
}
