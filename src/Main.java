public class Main {
    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle(150);

        Player player1 = new Player("Boog");
        Player player2 = new Player("Elliot");

        while(!deck.emptyIsit()){
            player1.addCard(deck.draw());
            player2.addCard(deck.draw());
        }

        Table table = new Table();
        table.setPlayer(player1,1);
        table.setPlayer(player2,2);

            while (!player1.playerCardIsEmpty() && !player2.playerCardIsEmpty()) {
                table.runThisShit();
            }

        Player winner = table.getPlayer(table.getGameWinner());

        System.out.println("Congrats to our winner: "+winner+" Card count: " + winner.getCardCount()+" \n"+winner.getDeck());
    }


}