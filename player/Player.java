package player;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Main.GamePanel;
import Select.EnterNumberOfPlayers;
import button.ActiveButton;
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

    GamePanel gp;
    public static int numPlayer = 0;
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

    public void buy(ActiveButton property){
        addMoney(-property.getPurchaseAmount());
        property.setOwn(true);
        properties.add(property);
        // sortPropertiesByGroup(properties);
    }

    public void sell(ActiveButton property){
        addMoney(property.getSaleAmount());
        property.setOwn(false);
    }

    public int getWorth(){
        int total = 0;

        for(ActiveButton p : properties){
            if(p instanceof LandButton){
                total += (((LandButton) p).getTotalrent()) / 2;
            }

            total += ((StationButton) p).getTotalrent() / 2;
        }

        return total + money;
    }

    public void addMoney(int addMoney){
        if(money < -addMoney){
            broke(-addMoney - money);
        }

        this.money += addMoney;
    }

    private void broke(int amountNeeded){
        gp.ui.showMessage(String.format("You are missing $" + amountNeeded));
    }

    public void pay(int amount){
        addMoney(-amount);
    }

    public int Repairs() {
        int repairsAmount = 0;
        for (ActiveButton land: properties) 
            repairsAmount += ((LandButton)land).getNumHouse() * 25 + ((LandButton)land).getNumHotels() * 100;

        return repairsAmount;
    }

    public void pay(Player receiving, int amount){
        receiving.addMoney(amount);
        addMoney(-amount);
    }

    public void move(int numSquares){
        position += numSquares;

        //if pass GO
        if(position >= 36 ){
            if (inJail == false) {
                gp.ui.showMessage(String.format(name + " passed GO and collected $200m"));
                money += 200;
            }

            position %= 36;
        }
        System.out.println("player" + id + ": " + position);
        update();

    }

    public void update() {
        int directionID = getPosition() / 9;
        
        setPlayerX(gp.boardPlaces.button[getPosition()].getLandX() + dx[directionID] + px[getId()]);
        setPlayerY(gp.boardPlaces.button[getPosition()].getLandY() + dy[directionID] + py[getId()]);

    }

    public void endGame() {

    }

    // private void sortPropertiesByGroup(ArrayList<ActiveButton> properties){
    //     ArrayList<StationButton> railroads = new ArrayList<>();
    //     ArrayList<ActiveButton> sorted = new ArrayList<>();

    //     for(ActiveButton property : properties){
    //         if(property instanceof StationButton){
    //             railroads.add((StationButton) property);
    //         } else {
    //             sorted.add( property);
    //         }
    //     }
    //     Collections.sort(railroads);
    //     Collections.sort(sorted);

    //     sorted.addAll(railroads);

    //     this.properties = sorted;
    // }

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

    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    public void setIsBankrupt() {
        isBankrupt = true;
        numPlayer++;
        if(numPlayer == EnterNumberOfPlayers.getNum() - 1) endGame();
    }
}

