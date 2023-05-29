package player;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Main.GamePanel;
import PlayGame.Monopoly;
import Select.EnterNumberOfPlayers;
import button.ActiveButton;
import button.Button;
import button.Jail;
import button.LandButton;
import button.StationButton;

public class Player {
    private ArrayList<ActiveButton> properties = new ArrayList<ActiveButton>();
    private final String name;
    private int position;
    private int money = 500;
    private int playerX;
    private int playerY;
    private int id;
    private boolean isBankrupt = false;
    private int amount;
    private int numStation = 0;
    private int numProperty = 0;

    GamePanel gp;
    public static int bankRuptPlayer = 0;
    public boolean inJail = false;
    public int outOfJailCards = 0;
    public int turnsInJail = 0;
    
    // IN GAME
    private boolean continueRoll;
    private int[] dx = {4, 20, 4, 40};
    private int[] dy = {40, 4, 20, 4};
    private int[] px = {0, 0, 32, 32};
    private int[] py = {0, 32, 0, 32};

    public Player(GamePanel gp, String name, int id, int position, int playerX, int playerY){
        this.gp = gp;
        this.name = name;
        this.position = position;
        this.playerX = playerX;
        this.playerY = playerY;
        this.id = id;
    }

    public void buy(ActiveButton lands){
        gp.playSE(2);
        addMoney(-lands.getPurchaseAmount());
        lands.setOwn(true);
        if (lands instanceof StationButton) {
            numStation ++;
            if (numStation == 4) endGame();
            ((StationButton)lands).setNumStation(numStation);
            if (numStation > 1)
            for (int i : gp.monopoly.stationId){
                if (((ActiveButton)gp.boardPlaces.button[i]).getHostId() == id)
                    ((StationButton)gp.boardPlaces.button[i]).setNumStation(numStation);
            }
        }

        numProperty++;
        lands.setHostId(id);
        properties.add(lands);
    }

    public void buy(ActiveButton lands, int numLand){
        gp.playSE(2);
        amount = (lands.getId() / 9 + 1) * 50;
        lands.setNumHouse(numLand);
        pay(amount);
    }

    public void sell(ActiveButton property){
        amount = property.getSaleAmount();
        if (property instanceof LandButton) {
            amount += ((LandButton) property).getValue();
            ((LandButton) property).setNumHouse(0);
        } 
        else {
            numStation --;
            for (int i : gp.monopoly.stationId){
                if (((ActiveButton)gp.boardPlaces.button[i]).getHostId() == id) 
                ((StationButton)gp.boardPlaces.button[i]).setNumStation(numStation);
            }
        }
        properties.remove(property);
        numProperty--;
        addMoney(amount);
        property.setOwn(false);
    }

    public int getWorth(){
        int total = 0;

        for(ActiveButton p : properties){
            if(p instanceof LandButton){
                total += ((LandButton) p).getValue();
            }

            total += ((StationButton) p).getTotalrent();
        }

        return total + money;
    }

    public void addMoney(int addMoney){
        if(money < -addMoney){
            broke(-addMoney);
        }

        this.money += addMoney;
    }

    private void broke(int amountNeeded){
        gp.gameState = gp.brokenState + getId();
        while (gp.gameState >= gp.brokenState) {
            gp.ui.brokenMessage(id, amountNeeded);
            if (getMoney() >= amountNeeded) gp.gameState = gp.playState;
            // System.out.println("GameState : " + gp.gameState);
            if (numProperty == 0 && money < amountNeeded){
                setIsBankrupt();
                gp.gameState = gp.playState;
            } 
        }

    }

    public void pay(int amount){
        addMoney(-amount);
    }

    public int Repairs() {
        int repairsAmount = 0;
        for (ActiveButton land: properties) 
            if (land instanceof LandButton){
                repairsAmount += ((LandButton)land).getNumHouse() * 25;
                if (((LandButton)land).getNumHouse() == 4) repairsAmount += 75;
            }

        return repairsAmount;
    }

    public void pay(Player receiving, int amount){
        addMoney(-amount);
        receiving.addMoney(amount);
    }

    public void moveDirect(int numSquares) {
        position = numSquares;
        update();
    }

    public void move(int numSquares) {
        while (position != numSquares) moving();
        // System.out.println("player" + id + ": " + position);
    }

    public void moving(){

        position++;

        if(position >= 36 ){
            // gp.ui.showMessage(String.format(name + " passed GO and collected $200m"));
            money += 200;
            position %= 36;
        }

        update();
    }

    public void update() {
       
        setPlayerX(gp.boardPlaces.button[getPosition()].getLandX() + dx[getPosition() / 9] + px[getId()]);
        setPlayerY(gp.boardPlaces.button[getPosition()].getLandY() + dy[getPosition() / 9] + py[getId()]);

    }

    public void endGame() {
        // gp.ui.showMessage("The Winnwe is player" + id);
        gp.gameState = gp.winState;
        while (gp.gameState == gp.winState)
        gp.ui.winMessage(id);
        // gp.stopGameThread();
    }

    public void listProperties(){
        if(properties.isEmpty()){
            System.out.println("You do not own any properties");
        }
        for(ActiveButton property : properties){
            System.out.println(property);
        }
    }

    public ArrayList<ActiveButton> getProperties() {
        return properties;
    }

    public String getName() { return name; }

    public int getPosition() { return position; }

    public int getMoney() { return money; }

    public int getId() { return id; }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail() {
        inJail = true;
        Jail.setJial(true);
        turnsInJail = 3;
    }

    public int getTurnInJail() { return turnsInJail; }

    public void escape(){
        inJail = false;
        Jail.setJial(false);
        turnsInJail = 0;
    }

    public void setTurnsInJail() {
        turnsInJail--;
        if (turnsInJail == 0){
            Jail.setJial(false);
            inJail = false;
        }
    }

    public int getOutOfJailCards() {
        return outOfJailCards;
    }

    public void setOutOfJailCards(int num) {
        this.outOfJailCards += num;
    }

    public boolean isContinueRoll() {
        return continueRoll;
    }

    public void setContinueRoll(boolean continueRoll) {
        this.continueRoll = continueRoll;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }
    
    public int getNumStation() {
        return numStation;
    }

    public void setNumStation(int numStation) {
        this.numStation = numStation;
    }

    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    public void setIsBankrupt() {
        // System.out.println("Bank rupt");
        isBankrupt = true;
        bankRuptPlayer++;
         
    }
}

