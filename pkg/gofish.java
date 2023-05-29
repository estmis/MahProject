package pkg;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class gofish {
    ArrayList <Integer> deck;
    ArrayList <Integer> hand;
    Scanner sc = new Scanner(System.in);
    int money = 0;
    
    public gofish(int cash){
        money = cash;
    }
    
    public void Rules(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Welome to Go Fish! Here are the rules:");
        System.out.println("1. You start with 5 cards");
        System.out.println("2. The goal is to get rid of all of your cards");
        System.out.println("3. This is done by matching your cards with the computers");
        System.out.println("4. You get 5 chances to get a match. If you are unable too, you have to \"Go fish\"!");
        System.out.println("5. Each round you don't get a match costs $5. If you win, you get your money back, plus a lil extra");
        System.out.println("6. You can choose to leave after every round you don't win, but you loose your money as well :(");
        System.out.println("6. Aces are 1, Jacks are 11, Queens are 12, Kings are 13");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }
    public void fillDeck(){
    for(int i = 1; i < 14; i++) {
            deck.add(i);
            deck.add(i);
            deck.add(i);
            deck.add(i);
        }
    }
    public void printHand(){
        for(int i = 0; i<hand.size(); i++){
            System.out.print("["+hand.get(i)+"] ");
        }
    }
    
    public int setCash(){
        return money;
    }
    public void Deal(){
        System.out.print("Your cards are: ");
        for(int i = 0; i<5; i++){
            int rando = (int)(Math.random()*deck.size()-1);
            hand.add(deck.get(rando));
            System.out.print("["+deck.get(rando)+"] ");
            deck.remove(rando);
        }
        System.out.println("");
    }
    
    public boolean isInHand(int a){
        for(int i = 0; i<hand.size(); i++){
            if(hand.get(i)==a){
                return true;
            }
        }
        return false;
    }
    public void Play(){
        int numPlays = 1;
        deck = new ArrayList<Integer>();
        hand = new ArrayList<Integer>();
        Rules();
        fillDeck();
        Deal();
        while(true){
            if(money<0){
                System.out.println("Sorry buddy. Yer broke");
                return;
            }
            else{
                money = money - 5;
                System.out.println("You have $"+money+" left.");
                int i = 0;
                while(i<5){
                    int match = (int)(Math.random()*13+1);
                    System.out.println("Do you have a ["+match+"]? (y/n)");
                    String answer = sc.nextLine();
                    if(answer.equals("y")&&isInHand(match)){
                        for(int a = 0; a<hand.size(); a++){
                            if(match==hand.get(a)){
                                System.out.println("Match found! Your cards are:");
                                hand.remove(a);
                                a--;
                                printHand();
                                i=10;
                                numPlays++;
                                System.out.println("\nRound "+numPlays+":");
                            }
                        }
                    }
                    else if(answer.equals("n")&&!isInHand(match)){
                        System.out.println("That's a shame.");
                        i++;
                    }
                    else{
                        System.out.println("Wrong input buddy. You just lost $5. Nice");
                        money = money - 5;
                        i++;
                    }
                    if(hand.size()==0){
                        int winnings = 5*numPlays + 200;
                        money+=winnings;
                        System.out.println("YOU WON!! Congradulations! You win $"+winnings+" ( "+numPlays+" rounds + $200). Your total is: $"+money);
                        return;
                    }
                    if(deck.size()==0){
                        System.out.println("Dang bro you lost.");
                        return;
                    }
                }
                if(i==5){
                    System.out.println("Go fish! Draw another card\nYour Cards are:");
                    int temp = (int)(Math.random()*deck.size());
                    hand.add(deck.get(temp));
                    deck.remove(temp);
                    printHand();
                    numPlays++;
                    System.out.println("\nWould you like to go on to round "+numPlays+"?(y/n)");
                    String ans = sc.nextLine();
                    if(ans.equals("n")){
                        System.out.println("See ya later! You ended with a balence of: "+money);
                        return;
                    }
                }
            }
        }
    }
}