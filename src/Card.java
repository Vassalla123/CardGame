import java.util.ArrayList;
import java.util.Arrays;

public class Card implements Comparable<Card> {
	String suit = new String();
	String value = new String();
	int rank;
	boolean isJoker;

	final String[] suits = { "Diamond", "Heart", "Spade", "Clubs" };
	final int[] ranks = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	final ArrayList<String> values = new ArrayList<>(
			Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));

	Card(String suit, String value) {
		this.suit = suit;
		this.value = value;
		this.rank = calcRank(value);
	}

	public int calcRank(String value) {
		return ranks[values.indexOf(value)];
	}

	public int getRank() {
		return rank;
	}

	public void setJoker(boolean isJoker) {
		this.isJoker = isJoker;
	}

	public boolean isJoker() {
		return isJoker;
	}

	public String getSuit() {
		return suit;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return (this.rank - o.rank);

	}

	public boolean isSameSuit(Card a, Card b) {
		return a.getSuit() == b.getSuit();

	}
}