import java.util.*;

/*
  What I currently have completed:
- shuffle
- "linked" a organized deck of cards to it's suit. Ex a pack of cards goes from 2-Ace in sets of 4. I set it so that the 2d array holds the value of it's suit.
- Setters & getters
- First move based on diamond 3
- deck size to infinity
- Check whether a user has the card in comparision to it's suit.
*/


class Main {
  public static void main(String[] args) {

    System.out.println("-------------------------\nGame: Chinese Poker\n-------------------------\n");

    Chinese_Poker newGame = new Chinese_Poker();
    newGame.setPlayerNum();
    System.out.println();
    newGame.setPlayerNames();

    Scanner deckSize = new Scanner(System.in);
    System.out.print("How many decks? : ");
    int deckLen = deckSize.nextInt();
    deckSize.close();

    System.out.println();

    Deck setup = new Deck(deckLen); //Program can shuffle, organize several decks, b
    setup.createDecks();
    setup.shuffle(2);
  
    //                           Game Code: Here
    //Intializing all the variables for the configuration of the game.
    String[] listOfNames = newGame.getArrayOfNames();
    int playerCount = newGame.getPlayerNum();
    int cardsInDeck = (setup.getDeckNum() * 54);
    int[][] heartOfTheDeck = setup.getDeckArray();
    
    int[][] handOfThePlayers = new int[playerCount * 2][(cardsInDeck)/playerCount];

    int count = 0; 
    for (int i = 0; i < cardsInDeck/playerCount; i++){
      int cycle = (playerCount * 2)-1;
      for (int x = 0; x < playerCount; x++){
        handOfThePlayers[x][i] = heartOfTheDeck[0][count];
        handOfThePlayers[cycle][i] = heartOfTheDeck[1][count];
        count++;
        cycle--;
      }
      
    }

    //Checking seperation of cards, etc.
    CardGame hand = new CardGame(handOfThePlayers, playerCount,  newGame.getArrayOfNames());
    hand.firstPick();
    hand.configureHand();
    hand.displayHand();
    //System.out.println(hand.checkValue()); (Compares card to suit)

    int[][] gameHand = hand.getPlayerHand();
    String[][] gameSuit = hand.getCardSuits();
      
    boolean run = true;
    int[] score = new int[playerCount];
    int counter = 0;

    //Begins the "game".
    while(run){ 
      if (counter == cardsInDeck/playerCount){
        break;
      }
      
      int pos = 0;
      for(int i = 0; i < playerCount-1; i++){
        if (gameHand[i][counter] < gameHand[i+1][counter]){
          pos = i;
        }
        else{
          pos = i+1;
        }
      }
      score[pos]++;
      counter++;
    }
    //Output's the winner.
    int winnerPos = 0;
    String build = "\nScore:\n";
    for (int i = 0; i < score.length-1; i++){
      if (score[i] < score[i+1]){
        winnerPos = i+1;
      }
      else{
        winnerPos = i;
      }
      build += listOfNames[i] + " - " + score[i] + ".\n";
    }
    //Finalizes the string.
    build += listOfNames[score.length-1] + " - " + score[score.length-1] + ".";

    System.out.println(build + "\n\t*The Winner is " + listOfNames[winnerPos] + "!\n ");    
  }
}