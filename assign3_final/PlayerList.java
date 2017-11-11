import java.util.*;
import java.io.*;

public class PlayerList{
	
	private File file;
	private Scanner inScan;
	private int numPlayers=0;
	private ArrayList<Player> playerMaster = new ArrayList<Player>();
	private int totalRounds=0;
	private int totalWins=0;
	private int totalLost=0;

	private String fileNAME;

	public PlayerList(String fileName){

		// store name locally for save method
		fileNAME = fileName;


		try{
			file = new File(fileName);
			Scanner inScan = new Scanner(file);
			
			while(inScan.hasNext()){
				String name = inScan.next();
				int rounds = inScan.nextInt();
				// add up rounds
				totalRounds+= rounds;
				int wins = inScan.nextInt();
				// add up wins
				totalWins+= wins;
				int losses = inScan.nextInt();
				//add up losses
				totalLost+= losses;
				numPlayers++;
				//inScan.nextLine();
				Player player = new Player(name,rounds,wins,losses);
				playerMaster.add(player);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public Player getPlayer(String playerName){

		// returns null if player not found
		for (int i =0; i<playerMaster.size(); i++){
			if (playerMaster.get(i).getPlayerName().equals(playerName)){
				return playerMaster.get(i);
			}
		}

		return null;


	}

	public void addPlayer(Player S){
		// add to count of total players if method is called
		numPlayers++;
		playerMaster.add(S);
	}

	public String toString(){

		// convert ints to strings
		String numsPlayers = Integer.toString(numPlayers);
		String totalRoundz = Integer.toString(totalRounds);
		String totalWinz = Integer.toString(totalWins);
		String totalLostz = Integer.toString(totalLost);


		//double winPct = Math.round((double)totalWins/ (double)totalRounds * 100 *10) / 10;
		//double winPct = Math.round((double)totalWins/ (double)totalRounds * 1000) /10;
		double winPct = (double)totalWins/ (double)totalRounds * 100;
		winPct = Math.round(winPct *10 ) / 10.0;

		String newString = "Total Players: " + numsPlayers + "\n	Total Rounds Played: " + totalRoundz + "\n	Total Rounds Won: " + totalWinz + "\n	Total Rounds Lost: " + totalLostz + "\n	   Pct of Rounds Won: " + winPct;
		return newString;


	}

	public String toStringAdmin(){

		/////////// FROM TO STRING ///////////////////
		// SHOULD ALSO BE PRINTING ALL TOTAL INFO ON PLAYERS ??
		String numsPlayers = Integer.toString(numPlayers);
		String totalRoundz = Integer.toString(totalRounds);
		String totalWinz = Integer.toString(totalWins);
		String totalLostz = Integer.toString(totalLost);


		//double winPct = Math.round((double)totalWins/ (double)totalRounds * 100 *10) / 10;
		//double winPct = Math.round((double)totalWins/ (double)totalRounds * 1000) /10;
		double winPct = (double)totalWins/ (double)totalRounds * 100;
		winPct = Math.round(winPct *10 ) / 10.0;

		String newString = "Total Players: " + numsPlayers + "\n	Total Rounds Played: " + totalRoundz + "\n	Total Rounds Won: " + totalWinz + "\n	Total Rounds Lost: " + totalLostz + "\n	   Pct of Rounds Won: " + winPct;
		////////// FROM TO STRING ///////////////





		// add newString (from toString) before adding all the players info
		String finalString = newString + "\nPlayers: \n";

		// loop through master list and add each player object to final string
		for (int i =0; i<playerMaster.size(); i++){
				//finalString += PlayerList().toString() + "\n" + playerMaster.get(i).toString() + "\n";
				//finalString += "PUT TOTAL TO STRING HERE?" + "\n" + playerMaster.get(i).toString() + "\n";
				finalString += playerMaster.get(i).toString() + "\n";
		}
		return finalString;
	}


	public Player removePlayer(String removePlayer){
		
		// call getPlayer method with player name and set to temp player object
		Player temp = getPlayer(removePlayer);

		if(temp!=null){
			playerMaster.remove(temp);
			return temp;
		}
		return null;

	}

	public void saveList(){

		try{

			//System.out.println("SAVE LOCATION: " + fileNAME);

			FileWriter wr = new FileWriter(fileNAME);
		

			for (int i=0; i<playerMaster.size(); i++){
				//playerMaster.get(i).name;

//				playerMaster.get(i).name;
//				playerMaster.get(i).rounds;
//				playerMaster.get(i).won;
//				playerMaster.get(i).lost;

				wr.write(playerMaster.get(i).name.toLowerCase() + " " + playerMaster.get(i).rounds  + " " + playerMaster.get(i).won  + " " + playerMaster.get(i).lost + "\n");
			}
			

			wr.close();
		}
		catch (Exception ex) {
            ex.printStackTrace();

		}

	}


}