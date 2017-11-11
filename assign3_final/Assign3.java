import java.util.*;
import java.io.*;
import java.lang.*;

public class Assign3{
	

public static void main (String [] args){
	
	Scanner inScan = new Scanner(System.in);

	// load all player info from players.txt into PlayerList object
	PlayerList allPlayers = new PlayerList("players.txt");


	System.out.println("Welcome to the Scrambler!");


boolean nextUser = true;



	while(nextUser){




		// load all player info from players.txt into PlayerList object
		//PlayerList allPlayers = new PlayerList("players.txt");


		System.out.print("Please enter your name to play (HIT <ENTER> TO EXIT): ");
	
		//String file = "words.txt";

		//	String 

		// when saving different users/ need a remember me place and create new account section here
		inScan = new Scanner(System.in);
		String userName = inScan.nextLine();

		//String userName3 = userName;

		userName = userName.toLowerCase();

		if (userName.equals("")){

			nextUser = false;
			System.out.println("Game over!");
			System.out.println("Here are the player stats:");
			System.out.println(allPlayers.toString());
			return;
		}

	


////// if username matches list bonus stuff ////////
////// first 5 users are given passwords in adminList.txt /////////

	//System.out.println("Hello " + userName);

	//check if userName exists in MasterList.txt and return either password
	// or null
	String hasPassword = checkMaster(userName);




	
	Player currentPlayer = null;

// create new user if they don't exist in master and set them to currentUser
	if(hasPassword==null){
		System.out.println("Would you like to create a new account? (y/n) ");
		String newAccount = inScan.nextLine();
		if(newAccount.toLowerCase().equals("y")){
			

			System.out.println("(New user: " + userName +  ")");
			currentPlayer = new Player(userName);


			// add currentplayer to all players
			allPlayers.addPlayer(currentPlayer);
			allPlayers.saveList();

			// save password
			System.out.print("Password: ");
			String newPassword = inScan.nextLine();
			savePassword(userName,newPassword);
			System.out.println("(Password saved)");
		}
		if(!newAccount.toLowerCase().equals("y")){
			// IF NO USER FOUND RETURN and leave program

			System.out.println("Ok, have a nice day!");
			//nextUser = false;

			continue;
			// needs to start back at top of loop
			//return nextUser;

			//return nextUser = false;
		}

		//	System.out.println("dix 1");
	}
	// return user data into currentUser
	else{
		System.out.println("Welcome back " + userName + "!");
		//System.out.println(hasPassword);
		System.out.println("Please enter your password:");
		String userPWDentry= inScan.nextLine();
		if (userPWDentry.equals(hasPassword)){
			System.out.println("Correct Password");
			//currentPlayer = new Player(userName);
			currentPlayer = allPlayers.getPlayer(userName);
		}

		else {
			System.out.println("Please enter the correct password:");
			userPWDentry= inScan.nextLine();


			if (userPWDentry.equals(hasPassword)) {
				System.out.println("Correct Password");
				//currentPlayer = new Player(userName);
				currentPlayer = allPlayers.getPlayer(userName);
			}


			// maybe setNext user???
			System.out.println("#######################################");
			System.out.println("####  POSSIBLE INTRUDER DETECTED   ####");
			System.out.println("#### EXITING FOR SECURITY PURPOSES ####");
			System.out.println("#######################################");
			nextUser = true;
			return;

		}

			// maybe setNext user???
			//System.out.println("I'm sorry, that is not correct.");
			//return;
	/// IF CURRENT PLAYER = NULL THEN THEY ARE JUST A GUEST???
	/// 


	//System.out.println("LAST CHECK BEFORE THE GAME BEGINS!");


////////////// THIS JUST SHOWS THAT THE CURRENT PLAYER OBJECT 
		/////// IS WORKING CORRECTLY AND THAT THE PLAYLIST OBJECT
		/////// IS WORKING CORRECTLY, IF CURRENT PLAYER IS NULL
		//////// USE FOR BREAKING MASTER WHILE LOOP? FIRST CONDITION?
	//if(currentPlayer!=null){


	//	System.out.println(currentPlayer.toString());


	//	System.out.println(allPlayers.toString());

	}






	// word file
	String fileWords = "words.txt";

	//boolean gameOver = false;
	boolean nextWord = true;
	//int guessCount = 3;

	Scramble2 theScramble = new Scramble2(fileWords);

	// local values for displaying current game results
	int currentWin = 0;
	int currentLost = 0;
	int currentRounds = 0;


	while(nextWord){
		boolean gameOver = false;

		int guessCount = 3;

	//	Scramble theScramble = new Scramble(file);
	// grab a word from txt
		String word = theScramble.getRealWord();

// if file empty returns a null value for word and will exit
		if(word == null){
			nextWord = false;
			gameOver = true;
		}
	// grab scrambledword from class
		String wordScrambled = theScramble.getScrambledWord();
	
	// initialize guess constructor so it knows the word and scrambledword
		Guess guess = new Guess(word, wordScrambled);


		System.out.println(userName + ", you have 3 guesses to get the Scramble");
			System.out.println("Good luck!");

		while(!gameOver){
	
			//int guessCount = 3;

			//System.out.println(userName + ", you have 3 guesses to get the Scramble");
			//System.out.println("Good luck!");
			System.out.println("You have " + guessCount + " guesses remaining");
			System.out.println("Scrambled Word: " + wordScrambled.toUpperCase());	
			System.out.print("Your guess: ");
			inScan = new Scanner(System.in);
			String userGuesses = inScan.nextLine();
			
			// make sure guess is proper length
			while(userGuesses.length()>word.length()){
				System.out.println("You guesssed too many letters");
				System.out.print("Guess again: ");		
				userGuesses = inScan.nextLine();
				}

			String isRight = guess.userGuess(userGuesses);

			// if userGuess returns word equal to word
			if(isRight.toLowerCase().equals(word.toLowerCase())){
				System.out.println("Great job " + userName + "! You got it!");
				// add to results won counter
				
				//// SUPER DANGEROUS WAY TO INCREASE COUNT???
				// SAME LOGIC FROM ASSIGN2 RESULTS.WON
				currentPlayer.won += 1;
				currentPlayer.rounds += 1;

				currentWin ++;
				currentRounds++;
				//results.won();
				gameOver = true;
			}
			else{
				System.out.println("Sorry, " + userName + " that is not correct");
				System.out.println("Here are the letters you got correct");
				System.out.println(isRight.toLowerCase());	
				guessCount--;
			}
			//gameOver = false;	
			if (guessCount==0){
				System.out.println("You have " + guessCount + " guesses remaining");
				System.out.println("Round over! Better luck next time " + userName);
				System.out.println("The actual word is "+ word);
				// add to results lost counter
				
				// NEED TO REPLACE RESULTS.LOST WITH NEW METHOD IN PLAYER TO INCREASE COUNT
				// OR JUST CALL PUBLIC VARIABLE METHODS IN PLAYER CLASS... COULD BE DANGEROUS? 

				// SAME LOGIC FROM ASSIGN2 RESULTS.LOST
				if (currentPlayer != null){
					currentPlayer.lost += 1;
					currentPlayer.rounds += 1;	
				}
				//currentPlayer.lost += 1;
				//currentPlayer.rounds += 1;

				currentLost++;
				currentRounds++;

				//results.lost();
				gameOver = true;
			}		

		}

		// after 3 rounds of guesses

		if(gameOver && word!=null){
			System.out.println("Would you like to play another round (Y/N)");
			String nextRound = inScan.nextLine();

			if(nextRound.toLowerCase().equals("y")){
				nextWord = true;	
			}
			else{
				nextWord = false;
			}

		}
		else{
			System.out.println("No more words");
		}
	


		System.out.println("Thanks for playing " + userName + "!");

		System.out.println(userName + ", in today's game you had the following results:");

		System.out.println("	Rounds played: " + currentRounds);
		System.out.println("	Wins: " + currentWin);
		System.out.println("	Losses: " + currentLost);

		System.out.println("Here are your cumulative stats:");

		if(currentPlayer!=null){
			System.out.println(currentPlayer.toString());	
		}
		//System.out.println(currentPlayer.toString());




		allPlayers.saveList();

		System.out.println("GAME ENDED DID OBJECTS UPDATE CORRECTLY (SAVED)");

		}
		/// end of while loop for current player game


/*		System.out.print("Please enter your name to play: ");

		userName = inScan.nextLine();

		hasPassword = checkMaster(userName);

		currentPlayer = null;


		if(hasPassword==null){
		System.out.println("Would you like to create a new account? (y/n) ");
		String newAccount = inScan.nextLine();
		if(!newAccount.toLowerCase().equals("y")){

			nextUser = false;
		}
		if(newAccount.toLowerCase().equals("y")){
			

			System.out.println("(New user: " + userName +  ")");
			currentPlayer = new Player(userName);


			// add currentplayer to all players
			allPlayers.addPlayer(currentPlayer);
			allPlayers.saveList();

			// save password
			System.out.print("Password: ");
			String newPassword = inScan.next();
			savePassword(userName,newPassword);
			System.out.println("(Password saved)");

		}

//		else{
//			nextUser = true;
//		}

	}

	*/

}
/// end of while loop





//	loop control for next player to get back into while loop or exit 
		



/* System.out.print("Please enter your name to play: ");

		userName = inScan.nextLine();

		hasPassword = checkMaster(userName);

		currentPlayer = null;


		if(hasPassword==null){
		System.out.println("Would you like to create a new account? (y/n) ");
		String newAccount = inScan.nextLine();
		if(newAccount.toLowerCase().equals("y")){
			

			System.out.println("(New user: " + userName +  ")");
			currentPlayer = new Player(userName);


			// add currentplayer to all players
			allPlayers.addPlayer(currentPlayer);
			allPlayers.saveList();

			// save password
			System.out.print("Password: ");
			String newPassword = inScan.next();
			savePassword(userName,newPassword);
			System.out.println("(Password saved)");
		}
		else{
			// IF NO USER FOUND RETURN and leave program
			System.out.println("Ok, have a nice day!");
			return;
		}
	}
	// return user data into currentUser
	else{
		System.out.println("Welcome back " + userName + "!");
		//System.out.println(hasPassword);
		System.out.println("Please enter your password:");
		userPWDentry= inScan.nextLine();
		if (userPWDentry.equals(hasPassword)){
			System.out.println("Correct Password");
			//currentPlayer = new Player(userName);
			currentPlayer = allPlayers.getPlayer(userName);


		}
		else{
			System.out.println("Please enter the correct password:");
			userPWDentry= inScan.nextLine();
			if (userPWDentry.equals(hasPassword)) {
			System.out.println("Correct Password");
			//currentPlayer = new Player(userName);
			currentPlayer = allPlayers.getPlayer(userName);

			}
			// maybe setNext user???
			System.out.println("I'm sorry, that is not correct.");
			return;

			}
	

		}

		//should break loop?
		//nextUser = false;


		// next user
		//if nextuser doesn't want to player, return nextUser = false

	//}



	System.out.println("Game over!");
	System.out.println("Here are the player stats:");
	System.out.println(allPlayers.toString());



//} this should be outside the loop
	//nextUser = true;


*/

//// END OF MAIN

		}


//// END OF MAIN
	

	// check masterList of usernames and return password or null
	public static String checkMaster(String name){


		// do i need to load all the players into my admin? or
		// can i just assign them my own password and 
		//PlayerList allPlayers = new PlayerList("players.txt");

		String adminFileName = "adminList.txt";
		File adminFile;

		boolean isFound = false;

		try{
			adminFile = new File(adminFileName);
			Scanner newScan = new Scanner(adminFile);

			// loop through the file until it either finds it or has no more
			while(newScan.hasNext() && !isFound){
				String username1 = newScan.next();
				String password1 = newScan.next();

				if(username1.equals(name)){
					isFound = true;
					return password1;
					
				}
				else{
					isFound = false;
				}
			}
		}
		catch(IOException e) {
            System.out.println(e);
        } 
		return null;
	}




	public static void savePassword(String userNAME1, String password2){
		String adminFileName1 = "adminList.txt";
		//File adminFile1;

		try{

		FileWriter wr = new FileWriter(adminFileName1, true);
	
		String results = "\n" + userNAME1.toLowerCase() + " " + password2;

		wr.write(results);

		wr.close();
		}
		catch (Exception ex) {
            ex.printStackTrace();

		}

	}
}


// add to userName_results.txt

// check if userName exists in directory of results



/// at beggining of program, all known userNames will be loaded into an array.


/// bonus
// userName 

//	if userName is new - created password
		//after new password is created auto sign in for now maybe add a break and make them re sign in?
	// else ask for a password



// idea for additional bonus - history of all plays on one file (by my design)
