
public class Card {
    public static final String[] suits = {"Spades","Hearts","Clubs","Diamonds"};
    public static final String[] names = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    public static final int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};

    private final String suit;
    private final String name;
    private final int value;

    public Card(String suit, String name, int value){
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return String.format("%-1s of %-8s", name, suit );
    }
}