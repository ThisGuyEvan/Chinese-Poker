import java.util.*;

class Main {
  public static void main(String[] args) {

    System.out.println("-------------------------\nGame: Chinese Poker\n-------------------------\n");

    Chinese_Poker newGame = new Chinese_Poker();
    newGame.setPlayerNum();
    System.out.println();
    newGame.setPlayerNames();

    Deck setup = new Deck(2);
    setup.createDecks();
    setup.shuffle(2);
    //                  Game Code: Here
    
    int[][] heartOfTheCards = setup.getDeckArray();
    int[] cards = new int[setup.getDeckNum() * 54];
    int[] suits = new int[setup.getDeckNum() * 54];

    //System.out.print(setup.checkValues());


  }
}