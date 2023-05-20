package player;

import button.DiceButton;

public abstract class PlayerOption {
    String message;

    public PlayerOption(String message){
        this.message = message;
    }

    abstract public void action();

    public String toString(){
        return message;
    }
}

// class ListPropertiesOption extends PlayerOption{
//     Player player;

//     public ListPropertiesOption(Player currentPlayer){
//         super("List Properties");
//         player = currentPlayer;
//     }

//     public void action(){
//         player.listProperties();
//     }
// }

// class BuyHouseOption extends PlayerOption{
//     Player player;

//     public BuyHouseOption(Player currentPlayer){
//         super("Buy Houses");
//         player = currentPlayer;
//     }

//     public void action(){
//         ColorProperty houseProperty = (ColorProperty) Input.selectOptions(player.getHouseableProperties(), "Select property to purchase house on: ");

//         if(houseProperty == null){
//             System.out.println("You do not have any properties to place a house on");
//         } else {
//             houseProperty.addHouse();
//         }
//     }
// }

// class MortgageOption extends PlayerOption {
//     Player player;

//     public MortgageOption(Player currentPlayer){
//         super("Mortgage Properties");
//         player = currentPlayer;
//     }

//     public void action(){
//         Property mortgageProperty = (Property) Input.selectOptions(player.getUnimprovedProperties(), "Select an unimproved property");

//         if(mortgageProperty == null){
//             System.out.println("You do not have any unimproved properties to mortgage");
//         } else {
//             player.mortgage(mortgageProperty);
//         }
//     }
// }

// class PayMortgageOption extends PlayerOption {
//     Player player;

//     public PayMortgageOption(Player currentPlayer){
//         super("Pay Mortgage");
//         player = currentPlayer;
//     }

//     public void action(){
//         Property payMortProperty = (Property) Input.selectOptions(player.getMortgagedProperties(), "Select a property to pay off mortgage");

//         if(payMortProperty == null){
//             System.out.println("You do not have any mortgaged properties");
//         } else {
//             player.payMortgage(payMortProperty);
//         }
//     }
// }

// class SellPropertyOption extends PlayerOption {
//     Player player;

//     public SellPropertyOption(Player currentPlayer){
//         super("Sell Unimproved Properties");
//         player = currentPlayer;
//     }

//     public void action(){
//         Property sellProperty = (Property) Input.selectOptions(player.getUnimprovedProperties(), "Select a property to sell");

//         if(sellProperty == null){
//             System.out.println("You do not have properties to sell.");
//         } else {
//             player.sell(sellProperty);
//         }
//     }
// }

// class EndTurnOption extends PlayerOption{
//     Game game;
//     Player player;

//     public EndTurnOption(Game game, Player currentPlayer){
//         super("End Turn");
//         this.game = game;
//         player = currentPlayer;
//     }

//     public void action(){
//         game.endTurn(player);
//     }
// }

// class PayBailOption extends PlayerOption{
//     Dice dice;
//     Player player;
//     Board board;

//     public PayBailOption(Dice dice, Player currentPlayer, Board board){
//         super("Pay $50");
//         this.dice = dice;
//         player = currentPlayer;
//         this.board = board;
//     }

//     public void action(){
//         player.addMoney(-50);
//         player.inJail = false;
//         player.move(dice.roll(), board);
//     }
// }

// class RollOptionJail extends PlayerOption{
//     DiceButton dice;
//     Player player;
//     Board board;

//     public RollOptionJail(Dice dice, Player currentPlayer, Board board){
//         super("Roll");
//         this.dice = dice;
//         player = currentPlayer;
//         this.board = board;
//     }

//     public void action(){
//         int roll = dice.roll();

//         if(dice.isDouble()){
//             player.inJail = false;
//             player.move(roll, board);
//         }
//     }
// }