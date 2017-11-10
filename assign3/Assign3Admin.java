import java.util.Scanner;


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
				System.out.println("3) Update A Player's Score");
				// ask for how many wins and losses they want and recaluclate rounds
				System.out.println("4) Update a Player's Password");
				System.out.println("5) Remove Player");
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
					
					System.out.println("What would you like to change " + editPlayer + "'s name to?");

					String newName = inScan.nextLine();

					// still need to finish
					editPlayerName(allPlayers1, editPlayer, newName);
					break;
				case 3:
					System.out.println("You pressesed option 3");

					break;
				case 4:
					System.out.println("You pressesed option 4");

					break;
				case 5:
					System.out.println("Your total bill is: ");
					break;
				case 6:
					break;	
			}



		} while (menuChoice != 6);

			System.out.println("EXITING PROGRAM!");
			System.out.println("Print AdminName: " + adminName); 
			System.out.println("Print AdminPassword: " + adminPassword);

	}


	public static void editPlayerName(PlayerList allPlayers, String playerName, String nameNew){
		//PlayerList allPlayers = new PlayerList("players.txt");


		Player currentPlayer = null;

		currentPlayer = allPlayers.getPlayer(playerName);

		currentPlayer.name = nameNew;

		if(currentPlayer!= null){
			System.out.println(currentPlayer.toString());
		}

		allPlayers.saveList();
		
	}

}
