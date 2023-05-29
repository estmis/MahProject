package pkg;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class blackjack {
    ArrayList <Integer> deck;
    ArrayList <Integer> hand;
    ArrayList <Integer> dealerHand;
    Scanner sc = new Scanner(System.in);
    int money = 0;
    int thePot = 0;
    boolean bust = false;
    boolean dealerBust = false;
    
    public blackjack(int cash){
        money = cash;
        Play();
    }
    public void Rules(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Welcome to BlackJack! Here are the rules:");
        System.out.println("1. You and the dealer both start with 2 cards");
        System.out.println("2. The winner is whoever gets the sum of their cards closest to 21, without going over");
        System.out.println("3. You make your bet before you see your cards and the dealers cards, and if you win you get your bet back, plus your bet");
        System.out.println("4. On your turn, you will get the opportunity to either hit or stay. You can hit (get a new card) as many times are you want, until you bust (go over 21)");
        System.out.println("5. Aces are 1, Jacks, Queens, and Kings are all 10");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        
    }
    public void Play(){
        deck = new ArrayList<Integer>();
        hand = new ArrayList<Integer>();
        dealerHand = new ArrayList<Integer>();
        Rules();
        fillDeck();
        if(money<0){
            System.out.println("Sorry buddy. Yer broke");
            return;
        }
        System.out.println("What will you wager be? (Min 5 max 50)");
        int wager = sc.nextInt();
        if(wager>50||wager<5){
            System.out.println("Bruh");
            return;
        }
        thePot = wager;
        Deal();
        while(true){
            System.out.println("Hit or Stay? (1 for Hit 2 for Stay)");
            int move  = sc.nextInt();
            if(move == 1){
                int rando = (int)(Math.random()*deck.size()-1);
                hand.add(deck.get(rando));
                deck.remove(rando);
                System.out.println("Your cards are now: ");
                printHand(hand);
                System.out.println("");
            }
            else if(move == 2){
                System.out.println("Dealers turn");
                break;
            }
            if(sumHand(hand)>21){
                System.out.println("Bust!");
                bust = true;
                break;
            }
        }
        while(true){
            if(sumHand(dealerHand)<17){
                System.out.println("Dealer hits!");
                int rando = (int)(Math.random()*deck.size()-1);
                dealerHand.add(deck.get(rando));
                deck.remove(rando);
                System.out.println("Dealers cards are now: ");
                printHand(dealerHand);
            }
            else{
                System.out.println("Dealer stays at ");
                printHand(dealerHand);
                break;
            }
            if(sumHand(dealerHand)>21){
                System.out.println("Dealer busts!");
                dealerBust = true;
                break;
            }
        }
        if(bust&&dealerBust){
            System.out.println("It's a draw! You get your money back.");
        }
        else if(bust){
            System.out.println("You busted! You lose your bet :( You now have: $"+money);
            money -= thePot;
        }
        else if(dealerBust){
            money+=thePot*2;
            System.out.println("Dealer busted! You win! You now have: $"+money);
        }
        else if(sumHand(hand)>sumHand(dealerHand)){
            money+=thePot*2;
            System.out.println("You win!! You now have $"+money);
        }
        else if(sumHand(hand)<sumHand(dealerHand)){
            money-=thePot;
            System.out.println("You lost, so you lost your bet :( You now have: $"+money);
        }
    }
    
    
    
    
    
    public int sumHand(ArrayList <Integer> ex){
        int sum = 0;
        for(int i = 0; i<ex.size(); i++){
            sum+=ex.get(i);
        }
        return sum;
    }
    public void fillDeck(){
        for(int i = 1; i < 11; i++) {
            deck.add(i);
            deck.add(i);
            deck.add(i);
            deck.add(i);
        }
        for(int i = 0; i<4; i++){
            deck.add(10);
            deck.add(10);
            deck.add(10);
            deck.add(10);
        }
    }
    public void printHand(ArrayList <Integer> ex){
        for(int i = 0; i<ex.size(); i++){
            System.out.print("["+ex.get(i)+"] ");
        }
    }
    public int setCash(){
        return money;
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
            dealerHand.add(deck.get(rando));
            deck.remove(rando);
        }
        System.out.println("\nThe dealer has: [?]["+dealerHand.get(1)+"]");
    }
    
    
    
    
}