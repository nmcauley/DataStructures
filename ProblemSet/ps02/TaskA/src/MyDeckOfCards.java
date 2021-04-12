import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyDeckOfCards implements DeckADT{
    private String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String[] suits = {"H", "D", "S", "C"};
    public List deck = new ArrayList<String>(52);

    public static void main(String[] args){
        for(int i = 1; i <= 3; i++){
            MyDeckOfCards d = new MyDeckOfCards();
            System.out.println("Deck " + i + ":");
            System.out.println("Before initialize(): " + d.deck.toString());

            d.initialize();
            List deck = d.deck;
            System.out.println("After (and before the other methods): ");
            System.out.println(deck.toString());

            System.out.println("After drawTopCardFromDeck(): " + d.drawTopCardFromDeck());
            System.out.println(deck.toString());

            System.out.println("After drawRandomCard(): " + d.drawRandomCard() + "\n" + deck.toString());

            d.placeCardOnTopOfDeck();
            System.out.println("After placing a randomly drawn card on the top: \n" + deck.toString() + "\n");
        }


    }

    public void initialize() {
        // acts as the format for the current card in one string; iterates through one loop for all 13
        // values (1-K) and then a nested loop for the 4 possible suits for each value.
        String currCard;
        for(int i= 0; i < values.length; i++){
            for(int j =0; j<suits.length; j++){
                currCard = values[i] + suits[j];
                deck.add(currCard);
            }
        }
    }

    public String drawRandomCard() {
        int sizeMinus = deck.size() - 1;
        Random generator = new Random();
        int cardPos = generator.nextInt(sizeMinus);
        String card = deck.get(cardPos).toString();
        deck.remove(cardPos);
        return card;
    }

    public String drawTopCardFromDeck() {
        int sizeMinus = deck.size() - 1;
        String card = deck.get(sizeMinus).toString();
        deck.remove(sizeMinus);
        return card;
    }

    public void placeCardOnTopOfDeck(){
        String card = this.drawRandomCard();
        deck.add(deck.size(),card);
    }

}