
import java.util.*;

public class Deck {
	final String[] suite = { "Diamond", "Heart", "Spade", "Clubs" };
	final String[] value = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	ArrayList<Card> cardList = new ArrayList<Card>();
	int deckCount;

	Deck(int n, boolean requireJokers) {
		this.deckCount = n;
		for (int count = 0; count < n; count++) {
			for (int i = 0; i < suite.length; i++) {
				for (int j = 0; j < value.length; j++) {
					cardList.add(new Card(suite[i], value[j]));
				}
			}
		}
		if (requireJokers) {
			cardList.add(new Card("0", "Joker"));
			cardList.add(new Card("0", "Joker"));
		}
	}

	public List<Card> getDeck(List<Card> inHand) {

		for (Card c : inHand) {
			cardList.remove(c);

		}
		return cardList;

	}
	
	public List<Card> shuffle()
	{
		Random rand = new Random();
        
        for (int i = 0; i < cardList.size(); i++)
        {
            // Random for remaining positions.
            int r = i + rand.nextInt(cardList.size() - i);
          
             //swapping the elements
             Card temp = cardList.get(i);
             cardList.set(i, cardList.get(r));
             cardList.set(r, temp);
              
        }
        return cardList;
	}

	public List<Card> getNCards(int n) {

		Random random = new Random();
		List<Card> nCards = new ArrayList<Card>();
		HashSet<Integer> alreadyUsed = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int randomIndex = random.nextInt(cardList.size());
			while (alreadyUsed.contains(randomIndex)) {
				randomIndex = random.nextInt(cardList.size());
			}
			alreadyUsed.add(randomIndex);
			nCards.add(cardList.get(randomIndex));
			cardList.remove(randomIndex);
		}
		return nCards;

	}

	public ArrayList<Card> getCardList() {
		return cardList;
	}

	public void setCardList(ArrayList<Card> cardList) {
		this.cardList = cardList;
	}

	public int getDeckCount() {
		return deckCount;
	}

	public void setDeckCount(int deckCount) {
		this.deckCount = deckCount;
	}
    public static void main(String args[])
    {
    	Deck d=new Deck(1, false);
    	
    	System.out.println(d.cardList.get(0).getValue());
    	d.shuffle();
    	System.out.println(d.cardList.get(0).getValue());
    }
}