package fizzbuzz.logic;

public class FBLogic {
	private static final String FIZZ = "fizz";
	private static final String BUZZ = "buzz";
	
	public FBLogic() {}
	
	public void fizzBuzzRun() {
		
		for(int i = 0; i < 100; i++) {
			
			if( i == 0 ) {
				System.out.println(i);
				continue;
			}
			
			if(i%3 == 0) {
				
				if(i%5 == 0) {
					System.out.println(FIZZ + BUZZ);
					continue;
				}
				
				System.out.println(FIZZ);
				
			}else if(i%5 == 0) {
				
				if(i%3 == 0) {
					System.out.println(FIZZ + BUZZ);
					continue;
				}
				
				System.out.println(BUZZ);
				
			}else {
				
				System.out.println(i);
				
			}
			
		}
		
	}

}
