package pkg;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class gofish {
    ArrayList <Integer> cards = new ArrayList<Integer>();
    ArrayList <Integer> hand = new ArrayList<Integer>();
    
    public gofish(){
        fillDeck();
    }
    
    public void fillDeck(){
    for(int i = 1; i < 14; i++) {
            cards.add(i);
            cards.add(i);
            cards.add(i);
            cards.add(i);
        }
    }
    
    public void Deal(){
        System.out.print("Your cards are: ");
        for(int i = 0; i<4; i++){
            int rando = (int)(Math.random()*51);
            hand.add(cards.get(rando));
            System.out.print(cards.get(rando)+" ");
        }
        
    }
    
    
    
    
    
}