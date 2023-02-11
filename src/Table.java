import java.util.Collections;
import java.util.Stack;

public class Table {
    private final Stack<Card> cardsOnTable = new Stack<>();
    private final Player[] players = new Player[2];


    public Player getPlayer(int player){
        return players[player-1];
    }
    public void setPlayer(Player player,int playerNumber){
        players[playerNumber-1] = player;
    }

    public void runThisShit(){
        if (players[0].peekCard().getValue()==players[1].peekCard().getValue()) {
            goToWar();
        } else {
            playGame();
        }
    }

    public void playGame(){

        if (players[0].peekCard().getValue() > players[1].peekCard().getValue()) {
            getWinner(0);
        }else if(players[0].peekCard().getValue() < players[1].peekCard().getValue()){
            getWinner(1);
        }
    }

    public void getWinner(int winner) {
            System.out.print(players[0] + " played " + players[0].peekCard());
            System.out.println(players[1] + " played " + players[1].peekCard());
            addToWarPile();
            Collections.shuffle(cardsOnTable);

            while (!cardsOnTable.isEmpty()) {
                players[winner].addWonCards(cardsOnTable.pop());
            }
            System.out.println(players[winner] + " Won, New card count: " + players[winner].getCardCount());
    }

    public void goToWar () {
        System.out.println();
        System.out.println("***************************************************************");
        System.out.print(players[0]+" played "+players[0].peekCard());
        System.out.println(players[1]+" played "+players[1].peekCard());
        System.out.println("War Begins: ");

        if (players[0].getCardCount() >= 4 && players[1].getCardCount() >= 4) {
            for (int i = 0; i <= 2; i++) {
                addToWarPile();
            }
            if (players[0].peekCard().getValue() > players[1].peekCard().getValue()) {
                getWinner(0);
            } else if (players[0].peekCard().getValue() < players[1].peekCard().getValue()) {
                getWinner(1);
            } else {
                goToWar();
            }
        } else {
            resolve();
        }
        System.out.println();
    }

    public void resolve(){
        if ((players[0].getCardCount() > players[1].getCardCount())){
            System.out.println(players[1]+" cant go to war and forfeits the round");
            addToWarPile();
            emptyCards(0);
        }else {
            System.out.println(players[0]+" cant go to war and forfeits the round");
            addToWarPile();
            emptyCards(1);
        }

    }

    public void emptyCards(int winner){
        while (!cardsOnTable.isEmpty()) {
            players[winner].addWonCards(cardsOnTable.pop());
        }
    }

    public void addToWarPile(){
        cardsOnTable.push(players[0].playCard());
        cardsOnTable.push(players[1].playCard());

    }
    public int getGameWinner(){
        if (players[1].playerCardIsEmpty()){
            return 1;
        }else{
            return 2;
        }
    }
}

