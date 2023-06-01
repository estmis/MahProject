package pkg;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class highlow{
    int secret;
    int money;
    boolean guessedRight = false;
    Scanner sc = new Scanner(System.in);
    int i = 0;
    
    public highlow(int cash){
        money = cash;
    }
    
    public void rules(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Welcome to HighLow! Here are the rules:");
        System.out.println("1. There is a secret number. You get 7 chances to guess it correctly");
        System.out.println("2. If you guess it within your 7 chances, you get your wager back, plus your wager");
        System.out.println("3. Good Luck!");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }
    public int setCash(){
        return money;
    }
    public void Play(){
        secret = (int)(Math.random()*50+1);
        rules();
        if(money<0){
        System.out.println("Sorry buddy. Yer broke");
        return;
        }
        System.out.println("What will you wager? (Min $5 max $100)");
        int wager = sc.nextInt();
        if(wager>100||wager<5){
            System.out.println("Bruh");
            return;
        }
        while(i<7){
            System.out.println("Guess a number between 1 and 50: ");
            int guess = sc.nextInt();
            if(secret>guess){
                System.out.println("Higher!");
                i++;
            }
            else if(secret<guess){
                System.out.println("Lower!");
                i++;
            }
            else{
                System.out.println("Correct!");
                guessedRight = true;
                break;
            }
        }
        if(guessedRight){
            money+=wager*2;
            System.out.println("Congradulations! You win double your bet! You now have: $"+money);
        }
        else{
            money-=wager;
            System.out.println("Sorry buddy, you lost :( The number was: "+secret+". You now have: $"+money);
        }
    }
}