package rockpaperscissors.logic;

import java.util.*;

//The game's logic

public class RPSLogic {
	private int round;
	private Random random;
	private int playerPoints;
	private int computerPoints;
	private String computerHand;
	
	public RPSLogic() {
		this.round = 0;
		this.random = new Random();
		this.playerPoints = 0;
		this.computerPoints = 0;
		this.computerHand = "";
	}
	
	//Returns the computer's hand and implements the getComputerRPS method in order to set a value for the this.computerHand object.
	public String getComputerHand() {
		
		getComputerRPS();
		
		return this.computerHand;
	}
	
	//Gets the computers points
	//returns 0 if the round is 1;
	public int getComputerPoints() {
		
		return this.computerPoints;
	}
	
	//Returns player points, and if it's round 1, returns 0, instead.
	public int getPlayerPoints() {
		
		return this.playerPoints;
	}
	
	//A single round. Increments each time it's called.
	public int getRound() {
		
		this.round++;
		
		return this.round;
	}
	
	//Returns the computers hand - determined by a random integer.
	public void getComputerRPS() {
		
		int hand = this.random.nextInt(3);
		
		if(hand == 0) {
			
			this.computerHand = RPS.ROCK.toString();
			
		}else if(hand == 1) {
			
			this.computerHand = RPS.PAPER.toString();
			
		}else {
			
			this.computerHand = RPS.SCISSORS.toString();
			
		}
	}
	
	//If player wins then return 1;
	//return 0 if player loses;
	//return -1 if it is a draw;
	public int match(String hand) {
		
		if(hand.matches("ROCK") && this.computerHand.equals("SCISSORS")
		|| hand.matches("SCISSORS") && this.computerHand.equals("PAPER")
		|| hand.matches("PAPER") && this.computerHand.equals("ROCK")
		) {
			this.playerPoints++;
			return 1;
			
		}else if(hand.equals(this.computerHand)){
			return -1;
		}else {
			this.computerPoints++;
			return 0;
		}
	}
	
}
