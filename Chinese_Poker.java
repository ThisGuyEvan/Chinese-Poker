import java.util.*;

public class Chinese_Poker{

  private int playerNum;
  private String[] playerNames;

  Chinese_Poker(){
    
  }
  
  //Setters.
    //Problem: Scanners would output a NoElementException due to the closing of it, so I had to remove <name>.close(); in order for it to pickup System.in.
  public void setPlayerNum(){
    Scanner console = new Scanner(System.in);
    System.out.print("How many players? ");
    this.playerNum = console.nextInt();
    while (true){ //Tests whether there are 1 or more players.
      if (playerNum < 2){
        System.out.print("\nYou cannot play Chinese poker by yourself...that's just sad.\n\tEnter number of players: ");
        this.playerNum = console.nextInt();
      }
      else{
        System.out.println("Successfully updated the count of players!");
        break;
      }
    }
  }


  public void setPlayerNames(){
    Scanner name = new Scanner(System.in);
    playerNames = new String[playerNum]; //Creates brand new incase of playerNum change.
    
      //Adding a string val to array.
    System.out.println("\t*Enter the names of the players: ");
    for (int i = 0; i < playerNum; i++){
      System.out.print((i+1) + ". ");
      playerNames[i] = name.next();
    }
    System.out.println("Successfully updated player names!");
  }

  //Getters.
  public int getPlayerNum(){
    return this.playerNum;
  }

  public String getPlayerNames(){
    //Outputs a string listed vertically.
    String build = "";
    for (int i = 0; i < playerNames.length; i++){
      build += (i+1) + ". " + playerNames[i] + ".\n";
    }
    return build;
  }

  //Utilized for other sub classes.
  public String[] getArrayOfNames(){
    return playerNames;
  }


}