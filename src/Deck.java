import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cards = new Stack<>();

    public Deck() {
        for(int suitsIndex = 0; suitsIndex< Card.suits.length; suitsIndex++){
            for(int nameIndex = 0; nameIndex< Card.names.length; nameIndex++){
                Card card = new Card(Card.suits[suitsIndex],
                        Card.names[nameIndex], Card.values[nameIndex]);
                cards.push(card);
            }
        }
    }

    public void shuffle(int times){
        for (int i = 0; i < times; i++) {
            Collections.shuffle(cards);
        }
        System.out.println("Shuffled Deck: "+ cards);
    }

    public Card draw(){
        return cards.pop();
    }

    public boolean emptyIsit(){
        return cards.isEmpty();
    }

    @Override
    public String toString(){
        return cards.toString();
    }

}
