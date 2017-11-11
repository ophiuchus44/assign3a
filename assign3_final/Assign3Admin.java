import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;


public class Assign3Admin
{
	public static void main (String [] args)
	{

			PlayerList allPlayers1 = new PlayerList("players.txt");


			String masterPassword = "password";
			String masterAdmin = "admin";

			Scanner inScan = new Scanner(System.in);
			System.out.println("####################");
			System.out.println("(Assign3Admin Login)"); 
			System.out.println("####################"); 


			System.out.print("AdminName: "); 

			String adminName = inScan.next();

			if(!adminName.equals(masterAdmin)){
				System.out.println("##############################################");
				System.out.println("!!!!! Possible intruder, exiting program !!!!!");
				System.out.println("##############################################");
				return;
			}


			System.out.print("AdminPassword: "); 

			String adminPassword = inScan.next();

			if(!adminPassword.equals(masterPassword)){
				System.out.println("##############################################");
				System.out.println("!!!!! Possible intruder, exiting program !!!!!");
				System.out.println("##############################################");
				return;
			}

			inScan.nextLine();

			int menuChoice=0;

			do
				{


				System.out.println("Please Choose an option:");
				System.out.println("1) Display Players");
				System.out.println("2) Update A Player's Name");
				System.out.println("3) Update A Player's Wins");
				// ask for how many wins and losses they want and recaluclate rounds
				System.out.println("4) Update a Player's Loses");
				System.out.println("5) Create New Player");
				System.out.println("6) Exit Admin");

			//menuChoice = inScan.nextLine();

				String temp = inScan.nextLine();
				menuChoice = Integer.parseInt(temp);

			//displayTotal(special);

			switch(menuChoice)
			{
				case 1:
					System.out.println(allPlayers1.toStringAdmin());
					break;
				case 2:
					System.out.println("Update A Player's Name");
					//PlayerList allPlayers = new PlayerList("players.txt");
					String editPlayer=inScan.nextLine();

					//allPlayers1.getPlayer(editPlayer);

					if (allPlayers1.getPlayer(editPlayer) != null){

					System.out.println("What would you like to change " + editPlayer + "'s name to?");

					String newName = inScan.nextLine();

					// still need to finish
					editPlayerName(allPlayers1, editPlayer, newName);
					}
					
					//System.out.println("What would you like to change " + editPlayer + "'s name to?");

					//String newName = inScan.nextLine();

					// still need to finish
					//editPlayerName(allPlayers1, editPlayer, newName);
					break;
				case 3:
					System.out.println("Update A Player's Wins");

					String editPlayer1=inScan.nextLine();
					
					System.out.println("What would you like to change " + editPlayer1 + "'s wins to?");

					// still need to finish
					editPlayerWins(allPlayers1, editPlayer1);

					break;
				case 4:
					System.out.println("Update A Player's Loses");

					String editPlayer2=inScan.nextLine();
					
					System.out.println("What would you like to change " + editPlayer2 + "'s losses to?");

					// still need to finish
					editPlayerLosses(allPlayers1, editPlayer2);

					break;
				case 5:
					System.out.println("Create New Player");
					System.out.println("What would you like to call them?");

					String newUserName = inScan.nextLine();
					
					System.out.println("What should there password be?");

					String newPassword = inScan.nextLine();					

					addNewPlayer(allPlayers1,newUserName, newPassword );
					break;
				case 6:

					break;	
			}



		} while (menuChoice != 6);

			System.out.println("EXITING PROGRAM!");

	}


	public static void editPlayerName(PlayerList allPlayers, String playerName, String nameNew){
		//PlayerList allPlayers = new PlayerList("players.txt");


		Player currentPlayer = null;

		currentPlayer = allPlayers.getPlayer(playerName);



		// NEED TO SAVE USERNAME IN MASTER LIST 
		//savePassword2(playerName4, passwordNew);

		currentPlayer.name = nameNew;

		if(currentPlayer!= null){
			System.out.println(currentPlayer.toString());
		}

		allPlayers.saveList();
		
	}

	public static void editPlayerWins(PlayerList allPlayers2, String playerName2){
		//PlayerList allPlayers = new PlayerList("players.txt");


		Player currentPlayer2 = null;

		currentPlayer2 = allPlayers2.getPlayer(playerName2);

		System.out.println(playerName2 + " has won " + currentPlayer2.won + " times");
		System.out.println("What would you like to change it to?");

		Scanner newScan = new Scanner(System.in);

		int newScore = newScan.nextInt();

		newScan.nextLine();

		int difference = 0;
		
		difference = newScore - currentPlayer2.won;

		currentPlayer2.won = newScore;
		currentPlayer2.rounds = (currentPlayer2.rounds += difference);
				//currentPlayer2.won = newScore;

		



		if(currentPlayer2!= null){
			System.out.println(currentPlayer2.toString());
		}

		allPlayers2.saveList();
		
	}

	public static void editPlayerLosses(PlayerList allPlayers3, String playerName3){
		//PlayerList allPlayers = new PlayerList("players.txt");


		Player currentPlayer3 = null;

		currentPlayer3 = allPlayers3.getPlayer(playerName3);

		System.out.println(playerName3 + " has lost " + currentPlayer3.lost + " times");
		System.out.println("What would you like to change it to?");

		Scanner newScan3 = new Scanner(System.in);

		int newScore3 = newScan3.nextInt();

		newScan3.nextLine();

		int difference3 = 0;
		
		difference3 = newScore3 - currentPlayer3.lost;

		currentPlayer3.lost = newScore3;
		currentPlayer3.rounds = (currentPlayer3.rounds += difference3);
				//currentPlayer2.won = newScore;

		



		if(currentPlayer3!= null){
			System.out.println(currentPlayer3.toString());
		}

		allPlayers3.saveList();
		
	}

	public static void addNewPlayer(PlayerList allPlayers4, String playerName4, String passwordNew){
		//PlayerList allPlayers = new PlayerList("players.txt");


		savePassword2(playerName4, passwordNew);


		Player currentPlayer4 = new Player(playerName4);

		allPlayers4.addPlayer(currentPlayer4);

		if(currentPlayer4!= null){
			System.out.println(currentPlayer4.toString());
		}

		allPlayers4.saveList();
		
	}


		public static void savePassword2(String userNAME1, String password2){
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


/*		public static void saveUpdatedUserName(String userNAME1){
		String adminFileName1 = "adminList.txt";
		//File adminFile1;

		try{

		FileWriter wr = new FileWriter(adminFileName1, true);
	
		String results = "\n" + userNAME1 + " " + password2;

		wr.write(results);

		wr.close();
		}
		catch (Exception ex) {
            ex.printStackTrace();

		}

	}
	*/

}
