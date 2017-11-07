import java.util.*;
import java.io.*;
import java.lang.*;

public class Assign2{
	

public static void main (String [] args){
	
	Scanner inScan = new Scanner(System.in);

	System.out.println("Welcome to the Scrambler!");

	System.out.print("What is your name? ");
	String file = "words.txt";

	// when saving different users/ need a remember me place and create new account section here
	String userName = inScan.nextLine();

	// if username matches list bonus stuff//




	String fileInput = "results.txt";
    

    String fileoutput = userName + "_results.txt";  

    File f = new File(fileoutput);

    String password = "";

    String newPassword = "";

    boolean savePassword = false;

    // if the users file exists, load there file into results

    if (f.exists()){

    	//System.out.println(f + " file found!");
    	// ask for password
    	// read from file
    	fileInput = fileoutput;

    	try{
    		Scanner scan = new Scanner(f);
    	// skip first 3 rows and load password
    	scan.nextLine();
    	scan.nextLine();
    	scan.nextLine();
    	password = scan.nextLine();
    	//	System.out.println(password);

    	}
    	

    	catch (Exception ex) {
            ex.printStackTrace();

		}

		System.out.println("Welcome back " + userName + "!");
    	System.out.println("Please enter your password: ");

    	String userPassword = inScan.nextLine();

    	String fileCopy1 =  "Guest_results.txt";

    	if(!userPassword.equals(password)){
			System.out.println("Invalid Password. Please enter your password: ");
			userPassword = inScan.nextLine();

			if(!userPassword.equals(password)){
				System.out.println("Sorry, you will be signed in as a guest");



				System.out.println("*****IGNORE THIS ERROR*****");
				System.out.println("***** -FILE NOT FOUND- *****");
				System.out.println("****DETAILS IN COMMENTS****");
				System.out.println("*****IGNORE THIS ERROR*****");

				// I tried handling this better but ran out of time
				// the code below was supposed to make a copy of the results.txt
				// but only executes if a valid name was found but wrong password is entered
				// So the code below would stop the error but would copy the data from the user
				// who's password was used. However, it would not save it to the users account
				// and would save to the proper guest_results.txt file that gets deleted.
				// i decided to leave the error for now because it's a rare scenrio, you might
				// never get here.

				//String fileCopy1 =  "Guest_results.txt";

			/*	try {
					
        		    FileReader fr=new FileReader(fileInput);
		            FileWriter fw1=new FileWriter(fileCopy1);

            		int c;
            		
            		while((c=fr.read())!=-1) {
                		fw1.write(c);
            			}

            		fr.close();
            		fw1.close();

        			} 

        			catch(IOException e) {
            			System.out.println(e);
        			} 
				*/

				fileInput =  fileCopy1;

				//fileInput =  "Guest_results.txt";  
			}
			//fileInput = "Guest_results.txt";

    	}
    	else{
    		newPassword = password;
    		savePassword = true;
    		fileInput = fileoutput;	
    	}

    	//Results results = new Results(fileoutput);

    }

    else{
    	System.out.print("Would you like to start an account? (Y/N)");
    	String startAccount = inScan.nextLine();

    	// if they want to start a new acount
    	if(startAccount.toLowerCase().equals("y")){

    			// copy the results file to the new users labled file
    		    // if fileexist, continue to results class
			    //else ask if user wants to create account
    			// then ask for password 
    			// first create this file
    			// and we'll save the password somehow... 


    			try {
        		    FileReader fr=new FileReader(fileInput);
		            FileWriter fw=new FileWriter(fileoutput);

            		int c;
            		
            		while((c=fr.read())!=-1) {
                		fw.write(c);
            			}

            		fr.close();
            		fw.close();

        			} 

        			catch(IOException e) {
            			System.out.println(e);
        			} 


				System.out.print("Create a password: ");
				
				// if i have time add another loop here that makes you enter password again to confirm
				// if i really have time, add a check to make sure there is a special character, 1 upper case etc
				newPassword = inScan.nextLine();

				savePassword = true;
	
				System.out.println("Your password has been saved");
				fileInput = fileoutput;
			}
		// if they don't want to start a new account	
		else{
				System.out.println("Ok, welcome guest!!!");

				String fileCopy =  "Guest_results.txt";

				try {
        		    FileReader fr=new FileReader(fileInput);
		            FileWriter fw=new FileWriter(fileCopy);

            		int c;
            		
            		while((c=fr.read())!=-1) {
                		fw.write(c);
            			}

            		fr.close();
            		fw.close();

        			} 

        			catch(IOException e) {
            			System.out.println(e);
        			} 

				fileInput =  fileCopy;

			}


    }




    // no matter what the file is called we turn it back into fileInput
    Results results = new Results(fileInput);

    // this can only save the password the new users file once it has been created and the results class
    // is initiallized, i wrote this quick method for saving new users passwords and maybe updating current
    // users passwords if they 

    // had to make it so it saved the password everytime, even if their password is valid, it still gets saved again
    // because i was doing this without that and it kept deleteing the userspassword after the 2nd time logging in and exiting
    if(savePassword){
    	results.savePassword(newPassword);
    }

   /* String fileoutput = userName + "_results.txt";

    // if fileexist, continue to results class
    //else ask if user wants to create account
    // then ask for password 
    // first create this file
    // and we'll save the password somehow... 

        try {
            FileReader fr=new FileReader(fileInput);
            FileWriter fw=new FileWriter(fileoutput);

            int c;
            while((c=fr.read())!=-1) {
                fw.write(c);
            } 
            fr.close();
            fw.close();

        } 
        catch(IOException e) {
            System.out.println(e);
        } 

		*/





	// results file will concate with userName
	//String fileResults = "results.txt";


	//boolean gameOver = false;
	boolean nextWord = true;
	//int guessCount = 3;

	Scramble theScramble = new Scramble(file);

	//Results results = new Results(fileInput);


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
				results.won();
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
				results.lost();
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
		

		//results.to2String();


		}

		//results.toString();

		//String result = results.cleanResults();
		
		// initialize results private variables into strings ready to save
		results.toString();
		//System.out.println("Results:  \n" + results.toString());

		// save to file 
		System.out.println("Thanks for playing " + userName + "!");
		results.save();



		String guestFile = "Guest_results.txt";

		// if user was a guest delete guest file everytime
		File f1 = new File(guestFile);
		
		if(f1.exists()){
			f1.delete();
			System.out.println("Guess results deleted");
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
