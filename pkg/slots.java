package pkg;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class slots{
    int firstSlot;
    int secondSlot;
    int thirdSlot;
    int money;
    Scanner sc = new Scanner(System.in);
    
    public slots(int cash){
        money = cash;
        firstSlot = (int)(Math.random()*5+1);
    }
    public void rules(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Welcome to Slots! Here are the rules:");
        System.out.println("1. After making your wager, the three slots will roll");
        System.out.println("2. If they are all equal, you win the jackpot!! Lucky you");
        System.out.println("3. If two are equal, you win your money back, plus your money");
        System.out.println("4. If not, you lose your money. Sorry bucko");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        secondSlot = (int)(Math.random()*5+1);
    }
    public int setCash(){
        return money;
    }
    public void Play(){
        rules();
        if(money<0){
        System.out.println("Sorry buddy. Yer broke");
        return;
        }
        System.out.println("What will you wager? (Min $5, Max however much money you have ;))");
        int wager = sc.nextInt();
        if(wager>money||wager<5){
            System.out.println("Bruh");
            return;
        }
        thirdSlot = (int)(Math.random()*5+1);
        System.out.println("The slots are: {"+firstSlot+"}{"+secondSlot+"}{"+thirdSlot+"}");
        if(firstSlot==secondSlot&&secondSlot==thirdSlot){
            money += wager*3;
            System.out.println("JACKPOT! You win triple your wager. Your total is: $"+money);
        }
        else if(firstSlot==secondSlot||secondSlot==thirdSlot||firstSlot==thirdSlot){
            money += wager;
            System.out.println("You win! You win your money back, plus your wager! Your total is: $"+money);
        }
        else{
            money -= wager;
            System.out.println("Sorry bucko. You lose :( Your total is: $"+money);
        }
    }
}