import java.util.Scanner;
import pkg.*;

class starter {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int cash = 100;
        int input;
        System.out.println("Welcome to Nathan's epic Casino! You start with $100. We have (1)BlackJack, (2)GoFish, (3)HighLow, and (4)Slots. Please enter the number of the game you would like to play:");
        int game = sc.nextInt();
        while(true){
            if(game == 1){
                blackjack jack = new blackjack(cash);
                jack.Play();
                cash = jack.setCash();
            }
            else if(game == 2){
                gofish fish = new gofish(cash);
                fish.Play();
                cash = fish.setCash();
            }
            else if(game == 3){
                highlow high = new highlow(cash);
                high.Play();
                cash = high.setCash();
            }
            else if(game == 4){
                slots slot = new slots(cash);
                slot.Play();
                cash = slot.setCash();
            }
            else{
                System.out.println("Wrong input buddy");
            }
            System.out.println("Would you like to continue playing? (1 for yes, 2 for no)");
            input = sc.nextInt();
            if(input == 1){
                System.out.println("Enter 1 for BlackJack, 2 for Gofish, 3 for HighLow, or 4 for Slots:");
                game = sc.nextInt();
            }
            else{
                System.out.println("See you next time!");
                break;
            }
        }
    
    
    
    }
}