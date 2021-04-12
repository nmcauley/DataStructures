import java.lang.reflect.Array;
import java.util.ArrayList;

public interface DeckADT {
    //  create a full set of cards (with 52 cards; no Jokers)
    public void initialize();

    //  draw a card, and return the card as string. for example "2S" (2 of Spades)
    //  using single-letter representations for suits:
    //  S (spades), C (clubs), H (hearts) and D (diamonds)
    public String drawRandomCard();

    // draws the current card at the [51] position of the deck of cards. Because 0 is the first 52 would
    // be the last and the top of the deck.
    public String drawTopCardFromDeck();

    // draws a random card and places it on the top of the deck
    public void placeCardOnTopOfDeck();

}
