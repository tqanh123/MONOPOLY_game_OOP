package PlayGame;

import Main.GamePanel;
import Select.EnterNumberOfPlayers;
import button.ActiveButton;
import button.DiceButton;
import button.Jail;
import button.LandButton;
import button.StationButton;
import place.Bufferimg;
import player.Player;

public class Monopoly {

    GamePanel gp;
    public Bufferimg[] playerImage;
    DiceButton dice;
    private int playerId;
    public Player[] player;
    private int count = 0;
    public final int[] stationId ={4, 14, 23, 32};
    private int LandId;
    private ActiveButton land;
    public final static int numPlayer = EnterNumberOfPlayers.getNum();
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

        player[0] = new Player(gp, "Player1", 0, 0, 740, 740);
        player[1] = new Player(gp, "Player2", 1, 0, 775, 742);
        player[2] = new Player(gp, "Player3", 2, 0, 740, 775);
        player[3] = new Player(gp, "Player4", 3, 0, 775, 775);

    }

    public void setup(int ID){
        player[0] = new Player(gp, "QAnh", 0, 0, 740, 740);
    } 

    public void check() {
        gp.ui.showMessage(String.format("It's " + player[playerId].getName() + "turn"));

        if (player[playerId].isInJail()) {
            gp.ui.showMessage( String.format("Need %d turns to escape the Jail", player[playerId].getTurnInJail()));
        }        
    }

    //AFTER ROLL 
    public void PlayGame(){
        count++;
        
        if (gp.diceButton.isDouble()){
            if (player[playerId].isInJail() == true) player[playerId].escape();
            else if (count == 3) {

                gotoJail();
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
        
        // player[playerId].move((player[playerId].getPosition() + gp.diceButton.getTotalDice()) % 36);
        player[playerId].move((player[playerId].getPosition() + 12) % 36);
        // if (playerId == 1) player[playerId].move(7);
        // else player[playerId].move(8);
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
                land = ( (ActiveButton) gp.boardPlaces.button[LandId]);
                if ( !land.isOwn() && land.getPurchaseAmount() <= player[playerId].getMoney() ) gp.confirmDialog.showOption(gp.boardPlaces.button[LandId], playerId, gp);
                else {
                    if (land.getHostId() != playerId) player[playerId].pay(player[land.getHostId()], ((StationButton)land).getTotalrent());
                }
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
                player[playerId].addMoney(-200);
                gp.ui.showMessage("Super tax");
                break;

            case 27: 
                player[playerId].setContinueRoll(false);
                gotoJail();
                break;
            
            default :
                land = ( (ActiveButton) gp.boardPlaces.button[LandId]);
                if ( land.isOwn() == false ){
                    if (land.getPurchaseAmount() < player[playerId].getMoney())
                        gp.confirmDialog.showOption(gp.boardPlaces.button[LandId], playerId, gp);
                }
                else {
                    if (land.getHostId() == playerId && ((LandButton) land).getNumHouse() != 4) {
                        if (player[playerId].getMoney() >= ( (land.getId() / 9 + 1) * 50 ))
                        gp.confirmDialog.showOption(gp.boardPlaces.button[LandId], playerId, gp);
                    }
                    else player[playerId].pay(player[land.getHostId()], ((LandButton) land).getTotalrent());
                }
                break;
        }
        
        endTurn();
    }

    // END STAGE
    public void endTurn() {
        if(numPlayer - Player.bankRuptPlayer ==  1){
            for (int i = 0; i < numPlayer; i++) 
            if (player[i].getIsBankrupt() == false) {
                    System.out.println("endgame" + Player.bankRuptPlayer + "==" + (numPlayer -1));
                    System.out.println(i);
                    player[i].endGame();
                }
        }
        if (player[playerId].isContinueRoll() == false) {
            count = 0;
            playerId++;
            if (playerId == numPlayer) playerId = 0;
            while (player[playerId].getIsBankrupt()) {
                playerId++;
                if (playerId == numPlayer) playerId = 0;
            } 
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
                player[playerId].move(0);
                break;
            
            case 1:
            System.out.print("case 1");
                for (int i: stationId) {
                    if (i > location) {
                        player[playerId].move(i);
                        break;
                    }
                }
                if (location > 32) player[playerId].move(4);
                Dealing();
                break;

            case 2:
            System.out.print("case 2");
                player[playerId].addMoney(50);
                break;

            case 3:
            System.out.print("case 3");
                player[playerId].moveDirect(location - 3);
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
                gotoJail();
                break;
            
            case 9:
            System.out.print("case 9");
                player[playerId].setOutOfJailCards(1);
                break;
        }
    }
    
    private void gotoJail(){        
        player[playerId].setInJail();
        player[playerId].moveDirect(9);
    }

    private void visitedJail() {
        if (((Jail)gp.boardPlaces.button[9]).isJial() == true) {
            
            gp.ui.showMessage(String.format("you must pay $%d\nto visiting %d player", Jail.amount(), Jail.getnumPlayer()));
            player[playerId].pay(Jail.amount());    

        }
    }
}