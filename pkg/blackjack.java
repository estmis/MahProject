package pkg;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class blackjack {
    ArrayList <Integer> deck;
    ArrayList <Integer> hand;
    ArrayList <Integer> dealerHand;
    ArrayList <Integer> bob;
    ArrayList <Integer> jane;
    ArrayList <Integer> joe;
    Scanner sc = new Scanner(System.in);
    int money = 0;
    int thePot = 0;
    
    public blackjack(int cash){
        money = cash;
    }
    public void Rules(){
        return;
    }
    public void Play(){
        deck = new ArrayList<Integer>();
        hand = new ArrayList<Integer>();
        dealerHand = new ArrayList<Integer>();
        bob = new ArrayList<Integer>();
        jane = new ArrayList<Integer>();
        joe = new ArrayList<Integer>();
        Rules();
        fillDeck();
        Deal();
        while(true){
            if(money<0){
                System.out.println("Sorry buddy. Yer broke");
                return;
            }
            System.out.println("What will you wager be?");
            int wager = sc.nextInt();
            if(wager<0){
                System.out.println("Bruh");
                return;
            }
            thePot+=wager;
            
        }
    }
    public void fillDeck(){
        for(int i = 1; i < 14; i++) {
            deck.add(i);
            deck.add(i);
            deck.add(i);
            deck.add(i);
        }
    }
    public void printHand(ArrayList<Integer> ex){
        for(int i = 0; i<ex.size(); i++){
            System.out.print("["+ex.get(i)+"] ");
        }
    }
    public int setCash(){
        return money;
    }
    public boolean isOver(ArrayList <Integer> ex){
        int sum = 0;
        for(int i = 0; i<ex.size(); i++){
            sum+=ex.get(i);
        }
        if(sum>21){
            return true;
        }
        return false;
    }
    public boolean deckCheck(){
        if(deck.size()==0){
            fillDeck();
        }
        return true;
    }
    public boolean botHit(ArrayList<Integer> ex){
        int total = ex.get(1)+ex.get(2);
        if(total<17){
            return false;
        }
        return true;
    }
    public int bobWager(){
        int total = bob.get(1)+bob.get(2);
        if(total>=20){
            return 50;
        }
        else if(total>=10){
            return 25;
        }
        else{
            return 10;
        }
    }
    public int janeWager(){
        int total = jane.get(1)+jane.get(2);
        if(total>=20){
            return 10;
        }
        else if(total>=10){
            return 25;
        }
        else{
            return 50;
        }
        
    }
    public int joeWager(){
        int total = joe.get(1)+joe.get(2);
        if(total==21){
            return 100;
        }
        else{
            return 50;
        }
    }
    public void Deal(){
        System.out.print("Your cards are: ");
        for(int i = 0; i<2; i++){
            int rando = (int)(Math.random()*deck.size()-1);
            hand.add(deck.get(rando));
            System.out.print("["+deck.get(rando)+"]");
            deck.remove(rando);
        }
        for(int i = 0; i<2; i++){
            int rando = (int)(Math.random()*deck.size()-1);
            hand.add(deck.get(rando));
            deck.remove(rando);
        }
        System.out.println("\nThe dealer has: [?]["+hand.get(1)+"]");
        System.out.println("There are 3 players playing with you! Their names are Bob, Jane, and Joe!");
        for(int i = 0; i<2; i++){
            int rando = (int)(Math.random()*deck.size()-1);
            bob.add(deck.get(rando));
            deck.remove(rando);
        }
        System.out.println("Bob has: [?][?]");
        for(int i = 0; i<2; i++){
            int rando = (int)(Math.random()*deck.size()-1);
            jane.add(deck.get(rando));
            deck.remove(rando);
        }
        System.out.println("Jane has: [?][?]");
        for(int i = 0; i<2; i++){
            int rando = (int)(Math.random()*deck.size()-1);
            joe.add(deck.get(rando));
            deck.remove(rando);
        }
        System.out.println("Joe has: [?][?]");
    }
    
    
    
    
}