package PlayGame;

import Main.GamePanel;
import Select.EnterNumberOfPlayers;
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
    private int numPlayer = EnterNumberOfPlayers.getNum();
    private int[] dx = {0, 35, 0, 35}, dy = {0, 0, 35, 35};
        

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
        dice = new DiceButton(gp);
        player = new Player[4];

        player[0] = new Player(gp, "QAnh", 0, 0, 740, 740);
        player[1] = new Player(gp, "Dat", 1, 0, 775, 742);
        player[2] = new Player(gp, "Khanh", 2, 0, 740, 775);
        player[3] = new Player(gp, "Khiem", 3, 0, 775, 775);

    }

    public void setup(int ID){
        player[0] = new Player(gp, "QAnh", 0, 0, 740, 740);
    } 

    public void check() {
        gp.ui.showMessage(String.format("It's " + player[playerId].getName() + "turn"));

        if (player[playerId].isInJail()) {
            gp.ui.showMessage( String.format("Take %d turns\nto escape the Jail", player[playerId].getTurnInJail() ));
        }        
    }

    //AFTER ROLL 
    public void PlayGame(){
        count++;
        
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
        
        // player[playerId].move(gp.diceButton.getTotalDice());
        player[playerId].move(3);
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
                System.out.println(Amount);
                gp.ui.showMessage("Income Tax");
                Amount = Amount * 2 / 10;
                player[playerId].pay(Amount);
                break;

            case 34:
                player[playerId].addMoney(-100);
                gp.ui.showMessage("Super tax");
                break;

            case 27: 
                player[playerId].setContinueRoll(false);
                gotoJail(LandId);
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
                player[playerId].setContinueRoll(false);
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
        if (((Jail)gp.boardPlaces.button[9]).isJial() == true) {
            
            gp.ui.showMessage(String.format("you must pay $%d\nto visiting %d player", Jail.amount(), Jail.getnumPlayer()));
            player[playerId].pay(Jail.amount());    

        }
    }
}