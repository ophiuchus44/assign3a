import java.util.*;

public class Guess{
	
	private String word;
	private String scrambledWord;
	private String userGuessVSReal;
	private boolean userCorrectGuess;

	private int guessCount =0;

	private String space = "_";
	// constructor takes 2 arguments the original word and the scarmbled word
	// and sets them into local private variables
	public Guess(String wordOP, String wordScrambled){
		word = wordOP;
		scrambledWord = wordScrambled;

	}

	// accessor takes userGuess
//	public boolean userGuess(String userGuess) {
//		if (userGuess.toLowerCase().equals(word.toLowerCase())){
//
//			return userCorrectGuess = true;
//		}
//		else{
//			return userCorrectGuess = false;
//		}
//
//	}


	public String userGuess(String userGuess) {		

			if (userGuess.toUpperCase().equals(word.toUpperCase())){
				return userGuess;
			}

			

			else{

				StringBuilder sbGuess = new StringBuilder(userGuess.toUpperCase());
				// newString will display the guess vs correctword
				StringBuilder newString = new StringBuilder();

				StringBuilder sbWord = new StringBuilder(word.toUpperCase());



				for (int i =0; i<userGuess.length(); i++){

					if (sbWord.charAt(i) == (sbGuess.charAt(i))){
				//		System.out.println("Matches:" + sbGuess.charAt(i));
						newString.append(sbGuess.charAt(i));
					}
					else{
				//		System.out.println("Not Matches:" + sbGuess.charAt(i));
						newString.append(space);
					}

				}

				if (newString.length()<sbWord.length()){
					int difference = 0;

					int lenNew = newString.length();
					int lenWord = sbWord.length();

					difference = lenWord-lenNew;
					// add the number of missing _ needed to end the word
					for (int a=0; a<difference; a++){
						newString.append(space);
					}
					
				}


				userGuessVSReal = newString.toString();
			//	guessCount ++;	
			}
			
		//guessCount ++;
		return userGuessVSReal;

	}


	//need a stringbuilder 

/*	public String guessVSreal(String userGuess){

		//private StringBuilder sbWord = new StringBuilder(word);
		//private StringBuilder sbWordScrambled = new StringBuilder(scrambledWord);
	
	///private StringBuilder sbWord = new StringBuilder(word);

		//private StringBuilder sbUserGuess = new StringBuilder();

		if (userCorrectGuess = true){
				return userGuess;
			}



		for (int i = 0; i<userGuess.length(); i++){

			char c1 = userGuess.charAt(i);
			char c2 = word.charAt(i);

			//System.out.println(c1);
			System.out.println(c2);
			System.out.println(word);

			//char c2 = word.charAt(i);

			//if (c1.equals(c2)){
				//sbUserGuesses.append(c1);
			//}
			//else{
			//	sbUserGuesses.append("_");
			//}

		//	//for (int x = 0; x<word.length; x++){
		//		char c = userGuess.charAt(i);
		//		char w = word.charAt(i);

				//if(sbTmpUserGuess.charAt(i).equals(word.charAt(i))){
					//sbUserGuesses.append(w);
				//}
				//else{
				//	sbUserGuesses.append("_")
				//}

			//}

		}


		//userGuessVSReal = sbUserGuesses.toString();
		return userGuessVSReal;


	}
	
*/
}
