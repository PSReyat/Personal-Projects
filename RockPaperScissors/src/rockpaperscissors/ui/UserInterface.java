package rockpaperscissors.ui;

import java.util.*;

import rockpaperscissors.logic.RPSLogic;

//Handles printing

public class UserInterface {
	private String p1;
	private Scanner reader;
	private RPSLogic rl;
	private String hand;
	
	public UserInterface() {
		this.p1 = "";
		this.reader = new Scanner(System.in);
		this.rl = new RPSLogic();
		this.hand = "";
	}
	
	//Starts the game.
	//Contains the round logic.
	public void start() throws InterruptedException {
		
		gameIntro();
		int winner;
		
		do {
			
			displayPoints();
			
			System.out.print("\nWhat hand will you choose? ");
			this.hand = this.reader.nextLine().toUpperCase();
			
			while(!this.hand.matches("ROCK|R|SCISSORS|S|PAPER|P")) {
				System.out.print("Invalid entry. Re-enter your input: ");
				this.hand = this.reader.nextLine().toUpperCase();
			}
			
			printRound();
			delayPrintRPS();
			printHands();
			
			winner = this.rl.match(this.hand);
			
			getWinnerOfRound(winner);
			
			if(this.rl.getPlayerPoints() == 2 || this.rl.getComputerPoints() == 2) {
				break;
			}
			
		} while(true);	
		
		System.out.println();
		
		getWinner(this.rl.getPlayerPoints());
		
		
	}
	
	//Prints out the choices of the player and the computer.
	public void printHands() {
		System.out.println(this.p1 + ": " + this.hand + " || Computer: " + this.rl.getComputerHand());
	}
	
	//Introduction messages to the game. Also takes the users name.
	public void gameIntro() {

		System.out.println("<||==|| WELCOME TO ROCK, PAPER, SCISSORS!!! ||==||>\n");
		
		System.out.print("What is your name, player? ");
		this.p1 = this.reader.nextLine();
		
		System.out.println("\nHello, " + this.p1 + "!");
		System.out.println("Best two out of three wins!\n");
		System.out.println("Get ready for the first round!");
		
	}
	
	//RPS functionality. It will print out rock, paper, scissors every 500ms.
	public void delayPrintRPS() throws InterruptedException {
		Thread.sleep(500);
		System.out.println("Rock");
		Thread.sleep(500);
		System.out.println("Paper");
		Thread.sleep(500);
		System.out.println("Scissors");
		Thread.sleep(500);
		System.out.println("SHOOT!\n");
	}
	
	//Prints rounds.
	public void printRound() {
		System.out.println("\nRound " + this.rl.getRound());
		System.out.println("------");
	}
	
	//Prints out messages according to who won the round.
	public void getWinnerOfRound(int winner) {
		
		if(winner == 1) {
			System.out.println("You get one point!");
		}else if(winner == 0) {
			System.out.println("You lost the round.");
		}
		else {
			System.out.println("It's a draw.");
		}
		
		System.out.println();
	}
	
	//Displays the player's and computer's points on the console.
	public void displayPoints() {
		System.out.println(this.p1 + "'s points: " + this.rl.getPlayerPoints() 
		+ " || " + "Computer's points: " + this.rl.getComputerPoints());
	}
	
	//Determines the winner of the game.
	public void getWinner(int winner) {
		if(winner == 2) {
			System.out.println("Congratulations, you won!");
		}else {
			System.out.println("Too bad, you lost. Better luck next time.");
		}
		
	}
	
}
