import java.util.*;
import java.io.*;
import java.lang.*;

public class Scramble2{
	
	private String currentWord;
	private String scrambledWord;
	private Scanner inputFile;
	private FileReader inputF;
	private BufferedReader inputFb;
	private File file;
	private char [] characters;

	private boolean isScrambled;
	private boolean canRead = true;

	public Scramble2(String filePath){

		try{
			file = new File(filePath);
			//Scanner inputFile = new Scanner(file);
			inputF = new FileReader(file);
			inputFb = new BufferedReader(inputF);
		//	System.out.println("File Opened!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Exit Scramble Constructor");
	}

 
	public String getRealWord(){
		// canRead
		if(inputFb != null && canRead){
			try {
				currentWord = inputFb.readLine();
			}
			catch(Exception e) {
			e.printStackTrace();
			}
		}
		
		isScrambled = false;
		canRead = false;
		return currentWord;
		}


	public String getScrambledWord(){
// uses CharArray // need to find different emethod
//		System.out.println(currentWord);

		// check if has been scrambled already and not null
		// if method is called again it returns the same scrambled version
		// NOTE ***** will use for matching the guesses ??? this is like a
		// mini constructor because if its been scrambled i can call it multiple
		// times to get the scrambledWord??? //
		if (isScrambled && scrambledWord != null){
			return scrambledWord;
		}



		// if currentWord is null, then scrambleWord is null
		if(currentWord==null){
			scrambledWord = null;	
    		}
		



// where the shuffle happenes
    	else{
    		// need a couple stringbuilders for my shuffler
    		StringBuilder sb = new StringBuilder(currentWord);

    		// length of new stringbuilder object with currentWord
			int len = sb.length();
	
			// using the random ints, a new string is created
			StringBuilder newString = new StringBuilder();

			// string of random ints
			StringBuilder intString = new StringBuilder();


		// create a stringbuilder of randoms ints 0-length of word
		while(intString.length()<len){
			for (int i = 0; i<len; i++){
				// given the length of the intString which is based on the 
				// length of the currentWord 
				Random r = new Random();
				int x = r.nextInt(len);
				String newX = Integer.toString(x);
				if (intString.toString().contains(newX)){
					break;	
					}
				else{
					intString.append(x);	
					}
				}
		
			}

	//System.out.println(intString);

	for (int a = 0; a<len; a++){

			// temp index number of the intString is converted to int
			// while creating the new word, it finds the index number
			int temp = Character.getNumericValue(intString.charAt(a));
			
			// the new string is built by looping through and grab characters at
			// at the temp int index number
			newString.append(sb.charAt(temp));
		}

	//		System.out.println(newString);
			scrambledWord = newString.toString();

    	}

    	// lets program know next word can be called
    	// and the word has been scrambled which if method is called again should 
    	// be caught by the above conditional that returns the same currentscrambled word
    	canRead = true;
    	isScrambled = true;
    	return scrambledWord;
	}

	//return scrambledWord;

	//inputF.close();

/// end of class ///
}
/// end of class ///




////// major bugs

// getWord condition either makes the normal use cases work or the special cases but not both



////// next 

// need to ask prof ramirez about data structure for file. bonus. either need to do columns name/w/l/tries
// or i need to name every file after the user but store additional information like a password or their 
// history of games played



/////// if i have time

// bonus - save players games 
// login - take a username and a password
// 