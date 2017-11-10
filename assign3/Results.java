import java.util.*;
import java.io.*;

public class Results{
	

	private int rounds;
	private int wins;
	private int losses;

	private String fileLocation;

	private String password;

	private String results;

	//private String rounds ="";
	//private String wins ="";
	//private String losses ="";

public Results(String fileLocation2){
	fileLocation = fileLocation2;

	
	try{

	
	File userFile = new File(fileLocation);

	Scanner scan = new Scanner(userFile);

	rounds = scan.nextInt();

	wins = scan.nextInt();
	losses = scan.nextInt();

	}
	catch (Exception ex) {
            ex.printStackTrace();

	}



	// should read in info from file location and set these values
	// inteads of starting at 0
	//wins = 0;
	//losses = 0;
	//rounds = 0;
}

//public Results(String fileInput){
//	fileLocation = fileInput;
//}


public void won(){
	wins++;
	rounds++;
	//System.out.println("Wins: " + wins);
	}

public void lost(){
	losses++;
	rounds++;
	//System.out.println("Losses: " + losses);

	}

public void save(){

//		String rounds = Integer.toString(rounds);
//		String wins = Integer.toString(wins);
//		String losses = Integer.toString(losses);


		try{

		System.out.println("SAVE LOCATION: " + fileLocation);

		FileWriter wr = new FileWriter(fileLocation);
		
System.out.println("Here are the Results: ");
System.out.println("Rounds: " + rounds);
System.out.println("Wins: " + wins);
System.out.println("Losses: " + losses);

		//String rounds = Integer.toString(rounds);
		//String wins = Integer.toString(wins);
		//String losses = Integer.toString(losses);

		wr.write(results);

//		wr.write(rounds);
//		wr.write("\n");
//		wr.write(wins);
//		wr.write("\n");
//		wr.write(losses);	
		wr.close();
		}
		catch (Exception ex) {
            ex.printStackTrace();

		}

		
	// take file location and create a file object
	//File userFile = new File(fileLocation)

	//Scanner scan = new Scanner(userFile)

	// write to results
}

// need to trun this into a string method
public String toString(){

	StringBuilder sb = new StringBuilder();

	sb.append(rounds + "\n" + wins + "\n" + losses + "\n" + password);

//	if(password!=null){
//		sb.append(rounds + "\n" + wins + "\n" + losses + "\n" + password);		
//	}
//	else{
//		sb.append(rounds + "\n" + wins + "\n" + losses);	
//	}

	//System.out.println("Rounds: " + rounds);
	//System.out.println("Wins: " + wins);
	//System.out.println("Losses: " + losses);

	results = sb.toString();

	return results;
}

/*public String cleanResults(){

	StringBuilder sb = new StringBuilder();

	sb.append(rounds + "\n" + wins + "\n" + losses);	


	//System.out.println("Rounds: " + rounds);
	//System.out.println("Wins: " + wins);
	//System.out.println("Losses: " + losses);

	results = sb.toString();

	return results;
}
*/

// saves password of new users
public void savePassword(String newPassword){
	password = newPassword;
	//System.out.println("Stored Locally and will be saved when toString called");

	}


}


//public void save(){
//	FileWriter fw = new FileWriter(fileLocation, true);
//	BufferedWriter bw = new BufferedWriter(fw);
//	PrintWriter pw = new PrintWriter(bw);

//	pw.prinln(wins);
//	pw.prinln(losses);
//	pw.prinln(rounds);
//}


/// end of class ///

/// end of class ///