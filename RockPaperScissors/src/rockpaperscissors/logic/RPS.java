package rockpaperscissors.logic;

public enum RPS {
	ROCK("ROCK"),
	PAPER("PAPER"),
	SCISSORS("SCISSORS");
	
	private String hand;

	RPS(String hand){
		this.hand = hand;
	}
	
	//toString over a getter method because it calls automatically when calling any of the above variables.
	public String toString() {
		return this.hand;
	}
}
