package BlackRock;

import java.util.Random;

public class shuffleCardDeck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] shuffledDeck = shuffleDeck();
		for(int i:shuffledDeck){
			System.out.print(i+" ");
		}

	}

	private static int[] shuffleDeck() {
		// TODO Auto-generated method stub
		int[] deck = new int[52];
		for(int i = 0;i<deck.length;i++)
			deck[i]=i;
		int tempIndex = 0,temp=0;
		Random rand = new Random();
		for(int i=0;i<deck.length;i++){
			tempIndex = rand.nextInt(51);
			temp = deck[i];
			deck[i] = deck[tempIndex];
			deck[tempIndex] = temp;
		}
		return deck;
	}

}