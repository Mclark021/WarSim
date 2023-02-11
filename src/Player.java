import java.util.Stack;

public class Player {
    private final String name;
    private final Stack<Card> currentPlayerCards = new Stack<>();
    private final Stack<Card> tempCards = new Stack<>();

    private int cardCount = 0;

    public Player(String name){
        this.name = name;

    }
    public void addCard(Card daCard) {
        ++cardCount;
        currentPlayerCards.push(daCard);
    }
    public boolean playerCardIsEmpty(){
        return currentPlayerCards.isEmpty();
    }

    public Card playCard(){
        --cardCount;
        return currentPlayerCards.pop();
    }

    public void addWonCards(Card daCard1) {
        while (!currentPlayerCards.isEmpty()) {
            tempCards.push(currentPlayerCards.pop());
        }
        cardCount++;
        currentPlayerCards.push(daCard1);
        while (!tempCards.isEmpty()) {
            currentPlayerCards.push(tempCards.pop());
        }
    }

    public Stack<Card> getDeck(){
        return currentPlayerCards;
    }

    public int getCardCount(){
        return cardCount;
    }
    public Card peekCard(){
        return currentPlayerCards.peek();
    }
    @Override
    public String toString() {
            return name;
    }

}
