package player;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.Graphics2D;

import Main.GamePanel;
import button.Jail;
import button.LandButton;

public class Player {
    private ArrayList<LandButton> properties = new ArrayList<LandButton>();
    private final String name;
    private int position;
    private int money = 500;
    private int playerX;
    private int playerY;
    private int id;

    
    GamePanel gp;
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

    // public void getImage(int getId()){

    // }
    public void addMoney(int addMoney){
        // if(money < -addMoney){
        //     broke(-addMoney - money);
        // }

        this.money += addMoney;
    }

    // private void broke(int amountNeeded){
    //     System.out.println("You are missing $" + amountNeeded);
    //     List<PlayerOption> options = Arrays.asList(
    //             new MortgageOption(this)
    //     );
    // }

    public void pay(int amount){
        addMoney(-amount);
    }

    public int Repairs() {
        int repairsAmount = 0;
        for (LandButton land: properties) 
            repairsAmount += land.getNumHouse() * 25 + land.getNumHotels() * 100;

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
                System.out.println(name + " passed GO and collected $200");
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

    public ArrayList<LandButton> getProperties() {
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

}