package edu.umb.cs681.hw04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tennis {

	private String player;
	private int match_score;
	private int number_of_matches_won, number_of_matches_lost;
	private int number_of_matches_played;
	private double totalScoreRate;
	
	public Tennis(String player, int match_score, int number_of_matches_won, int number_of_matches_lost,
			int number_of_matches_played, double totalScoreRate) {
		
		this.player = player;
		this.match_score = match_score;
		this.number_of_matches_won = number_of_matches_won;
		this.number_of_matches_lost = number_of_matches_lost;
		this.number_of_matches_played = number_of_matches_played;
		this.totalScoreRate = totalScoreRate;
	}

	public String getPlayer() {
		return player;
	}

	public int getMatch_score() {
		return match_score;
	}

	public int getNumber_of_matches_won() {
		return number_of_matches_won;
	}

	public int getNumber_of_matches_lost() {
		return number_of_matches_lost;
	}

	public int getNumber_of_matches_played() {
		return number_of_matches_played;
	}

	public double gettotalScoreRate() {
		return totalScoreRate;
	}
	
	public static void main(String args[]) {
		
		ArrayList<Tennis> tennis = new ArrayList<>();

		tennis.add(new Tennis("Roger Federer", 		40, 6, 0, 06, +700));
		tennis.add(new Tennis("Serena Williams", 	40, 6, 0, 06, +640));
		tennis.add(new Tennis("Rafael Nadal", 		30, 4, 2, 06, -456));
		tennis.add(new Tennis("Rod Laver", 			15, 3, 3, 06, +100));
		tennis.add(new Tennis("Jimmy Connors", 		30, 4, 2, 06, +380));
		tennis.add(new Tennis("Ivan Lendl", 		00, 0, 6, 06, -700));

		long playersCount = tennis.stream().count();
		
		System.out.println("\nNumber of Players	\t\t: " + playersCount);

		Tennis maxTotalScoreRate = tennis
							.stream()
							.max(Comparator.comparing(Tennis::gettotalScoreRate))
							.get();
		
		System.out.println("\nTennis Player with max Total Sore Rate \t: " 
									+ maxTotalScoreRate.getPlayer()	+	"\t:\t"
									+ maxTotalScoreRate.gettotalScoreRate());

		Tennis minMatchScore = tennis
							.stream()
							.min(Comparator.comparing(Tennis::getMatch_score))
							.get();
		System.out.println("\nTeam that min Match Score \t\t: " 
									+ minMatchScore.getPlayer() +	"\t:\t"
									+ minMatchScore.getMatch_score());

		List<Tennis> sortByPlayer = tennis
							.stream()
							.sorted(Comparator.comparing(Tennis::getPlayer, Comparator.reverseOrder()))
							.collect(Collectors.toList());
		System.out.println("\nSort by Player (Desc)\t: \n");
		
		sortByPlayer.forEach((Tennis Tennis) -> System.out.println(Tennis.getPlayer() + "\t: " + Tennis.gettotalScoreRate()));

		List<Tennis> sortByMatch_Score = tennis
							.stream()
							.sorted(Comparator.comparing(Tennis::getMatch_score, Comparator.naturalOrder()))
							.collect(Collectors.toList());
		System.out.println("\nSort by Match Score \t: \n");
	
		sortByMatch_Score.forEach((Tennis Tennis) -> System.out.println(Tennis.getPlayer() + "\t: " + Tennis.getMatch_score()));

	}
}
