import java.util.*;

public class Card{
  //Suit rankings.
  private int spades = 4;
  private int hearts = 3;
  private int clubs = 2;
  private int diamonds = 1;
  private int jokerSuit = 5;


  //2-10 is just 2-10.
  private int Ace = 1;
  private int Jack = 12;
  private int Queen = 12;
  private int King = 13;
  private int Joker = 14;


  //Constructor vars.
  private int[] suit;
  private int rankings;

  Card(int[] suit, int  ranking){
    this.suit = suit;
    this.rankings = rankings;
  }


}