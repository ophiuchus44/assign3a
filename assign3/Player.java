import java.util.*;
import java.io.*;

public class Player{
	
	public String name;
	public int rounds;
	public int won;
	public int lost;

	//public String name;
	//private int rounds;
//	private int won;
//	private int lost;

	public Player(String playerName){
		name = playerName;
		rounds = 0;
		won = 0;
		lost = 0;
	}

	public Player(String playerName, int roundz, int wins, int losses){
		name = playerName;
		rounds = roundz;
		won = wins;
		lost = losses;
	}

	public String getPlayerName(){
		return name;
	}

	public String toString(){

		// convert ints to strings
		String totalRoundz = Integer.toString(rounds);
		String totalWinz = Integer.toString(won);
		String totalLostz = Integer.toString(lost);


		//double winPct = Math.round((double)totalWins/ (double)totalRounds * 100 *10) / 10;
		//double winPct = Math.round((double)totalWins/ (double)totalRounds * 1000) /10;
		//double winPct = (double)totalWins/ (double)totalRounds * 100;

		String newString = "	Name: " + name + "\n	Total Rounds Played: " + totalRoundz + "\n	Total Rounds Won: " + totalWinz + "\n	Total Rounds Lost: " + totalLostz + "\n";
		return newString;


	}



}