import java.util.*;

public class Deck extends Chinese_Poker{
  // 1= ace, 11-13= Jack, Queen & King, 14= Joker
  private int[] cardValues = {1,2,3,4,5,6,7,8,9,10,11,12,13,14}; 
  private int[] suitValues = {1,2,3,4,5}; 
  private int deckNum;
  private int[][] deck;

  Deck(int deckNum){
    super();
    this.deckNum = deckNum;
  }

  //Sets deck
  public void createDecks(){
    while (true){
      if (deckNum > 0){
        System.out.println("Successfully updated deck value!");
        break;
      }
      else{
        Scanner console = new Scanner(System.in);
        System.out.println("The deck size cannot be less than one!");
        deckNum = console.nextInt();
      }
    }

    //Deck setup [Cards-Suits]
    int[][] deckOfCards = new int[2][deckNum * 54];
    int count = 0;
    for (int i = 0; i < deckNum; i++){ //Times the deck by the deckNum.
      for (int x = 0; x < 13; x++){  //13 different cards with an exception of Joker.
        //Cards have a frequency of 4 with an exception of joker.
        for (int y = 0; y < 4; y++){
          deckOfCards[0][count] = cardValues[x];
          deckOfCards[1][count] = suitValues[y];
          count++;
        }
      }
    }

    //Adding Jokers to the end since there are only two per deck.
    for (int w = 0; w < deckNum; w++){
      for (int z = 0; z < 2; z++){
        deckOfCards[0][count] = 14;
        deckOfCards[1][count] = 5;
        count++;
      }
    }

    this.deck = deckOfCards;
    //System.out.println(Arrays.toString(deckOfCards));
  }

  public void shuffle(int num){
    for (int i = 0; i < num; i++){
      int counter = 0;
      while (true) {
        if (counter == deck[0].length-1){
          break;
        }
        //Shuffling by "holding on to, remove, change & add".
        int randPos = (int) (Math.random() * (deckNum * 54)); 
        int cardHolder = deck[0][counter]; 
        int suitHolder = deck[1][counter];
      
        deck[0][counter] = deck[0][randPos];
        deck[0][randPos] = cardHolder;

        deck[1][counter] = deck[1][randPos];
        deck[1][randPos] = suitHolder;

        counter++;
      }
    }

  }

  //Setters & getters.
  public void setDeckNum(int num){
    deckNum = num;
  }

  public int getDeckNum(){
    return deckNum;
  }

  public int[][] getDeckArray(){
    return deck;
  }
}