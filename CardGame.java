import java.util.*;

public class CardGame{

  private int[][] playersHand;
  private String[] playerNames;
  private int playerNum;
  private String[][] suitNames;



  CardGame(int[][] playersHand, int playerNum, String[] playerNames){
    this.playersHand = playersHand;
    this.playerNames = playerNames;
    this.playerNum = playerNum;
    this.suitNames = new String[playerNum][playersHand[0].length];
    //this.cards = new ArrayList<ArrayList<Integer> >(); 
   // this.suits = new ArrayList<ArrayList<String> >(); 

  }

  

//Find the person who has Diamond 3.
  public int firstPick(){
    int[] freq = new int[playerNum];
    for (int i = 0; i < playersHand[0].length; i++){ //52
      int count = 0;
      for (int x = 0; x < playerNum ; x++){ //2
        if (playersHand[x][i] == 3 && playersHand[(playerNum*2 -1)-count][i] == 4){
          freq[x] += 1;
        }
        count++;
      }
    }
    int playerPos = 0;
    //Min v max on who goes first.
    for (int i = 0; i < freq.length-1; i++){
      if (freq[i] < freq[i+1]){
        playerPos = i+1;
      }
    }
    System.out.println("\n----------------------\n----------------------\n" + playerNames[playerPos] + " gets the first move!");

    return playerPos;
  }

  //Changes suit value 1-5 to suit values.
  public void configureHand(){
    for(int x = 0; x < playerNum; x++){
      int count = 0;
      for (int i= 0; i < playersHand[0].length; i++){
        int num = playersHand[(playersHand.length - 1)-x][count];
        switch (num){
          case 1: suitNames[x][count] = "D"; break; //Diamond
          case 2: suitNames[x][count] = "C"; break; //Club
          case 3: suitNames[x][count] = "H"; break; //Heart
          case 4: suitNames[x][count] = "S"; break; //Spade
          case 5: suitNames[x][count] = "J"; break; //Joker
        }
        count++;
      }
    }
    System.out.println("\nHand Size: " + playersHand[0].length + "\nSuit Size: " + playersHand[playersHand.length - 1].length);
  }

  //Displays hand.
  public void displayHand(){
    for (int i = 0; i < playerNum; i++){
      System.out.println("\n" + playerNames[i] +"'s hand: " + Arrays.toString(playersHand[i]));
      System.out.println("\nSuits: : " + Arrays.toString(suitNames[i]));
    }
  }

  //Shows every card againsts it's suit.
  public String checkValue(){
    String build = "";
    for (int x = 0; x < playerNum; x++){
      for (int i = 0; i < playersHand[0].length; i++){
        build += "[" + playerNames[x] + "]" + ": " + playersHand[x][i] + " - " + suitNames[x][i] + ". \n";
      }
    }
    return build;
  }


  //Checks whether the user has the card linked to the suit.
  public boolean isPlayable(int player, int card, String suit){
    for (int i = 0; i < playersHand[0].length; i++){
      if (playersHand[player][i] == card && suitNames[player][i] == suit){
        return true;
      }
    }
    return false;
  }

  public int[][] getPlayerHand(){
    return playersHand;
  }

  public String[][] getCardSuits(){
    return suitNames;
  }

}