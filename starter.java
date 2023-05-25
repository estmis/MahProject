import java.util.Scanner;
import pkg.*;

class starter {
    public static void main(String args[]){
    int cash = 100;
    System.out.println("Welcome to Nathan's epic Casino! You start with $100. What game would you like to play? ");
    //blackjack, slots, HighLow, go fish?, 
    gofish game = new gofish(cash);
    cash = game.setCash();
    
    }
}