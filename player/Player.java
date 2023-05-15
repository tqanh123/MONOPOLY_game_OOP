// package player;

// import button.DiceButton;

// public class Player {
//     int totalWalk = 0;
// 	int position = 0;
// 	int id;
// 	String name;
// 	boolean brokeout = false;
// 	Money playerMoney;
// 	int doubleCounter=0;
	
// 	public Player(int id, String name) {
// 		this.id = id;
// 		this.name = name;
// 		this.playerMoney = new Money(5000);
// 	}
	
// 	public int getTotalWalk() {
// 		return totalWalk;
// 	}
	
// 	public int tossDie(DiceButton die1,DiceButton die2) {
// 		int face1 = die1.getFace();
// 		int face2 = die2.getFace();
// 		if(face1%2==0 && face2%2==0 && face1==face2) {
// 			doubleCounter++;
// 		}else {
// 			doubleCounter=0;
// 		}
// 		System.out.println("\nTurn : "+(getTotalWalk() + 1)+ " - "+name+"\n");
// 		System.out.println("[Position: " + (getCurrentPosition()+1) + "] [Total Money: $" + getMoney().getMoney() + "] " + getName() + " toss a die... Faces are [" + face1+","+face2+"] = "+(face1+face2));
		
// 		return (face1+face2);
// 	}
	
// 	public int getCurrentPosition() {
// 		return position;
// 	}
	
// 	public void setPosition(int position) {
// 		this.position = position;
// 	}
	
// 	public void nextTurn() {
// 		totalWalk++;
// 	}
	
// 	public String getName() {
// 		return name;
// 	}
	
// 	public Money getMoney() {
// 		return playerMoney;
// 	}
	
// 	public int getID() {
// 		return id;
// 	}
	
// 	public void setBrokeOut(boolean brokeout) {
// 		this.brokeout = brokeout;
// 	}
	
// 	public boolean isBrokeOut() {
// 		return brokeout;
// 	}
// }
