package BlackJack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        int playerSum=0, dealerSum=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to blackjack. Press any key to continue");
        scan.nextLine();

        int cardPick, cardHiddenPick, cardDealerPick;
        System.out.println("You get a ");
        cardPick = pickRandomCard();
        playerSum+=cardPick;
        System.out.println("\nand a ");
        cardPick = pickRandomCard();
        playerSum+=cardPick;
        System.out.println("\nYour total is "+playerSum);

        System.out.println("\nThe dealer shows ");
        cardDealerPick = pickRandomCard();
        dealerSum+=cardDealerPick;
        System.out.println("\nand has a card facing down\n");
        cardHiddenPick = pickRandomHiddenCard();
        dealerSum+=cardHiddenPick;
        System.out.println("\nThe dealers total is hidden");

        while(playerSum<21){
            
            System.out.println("\nWould you like to 'hit' or 'stay'?");
            String ansHS = scan.nextLine();
        
            while(!ansHS.equals("hit") && !ansHS.equals("stay")){
                System.out.println("Wrong input. Please type 'hit' or 'stay'.");
                ansHS = scan.nextLine();
            }

            if(ansHS.equals("hit")){
                System.out.println("\nYou get a ");
                cardPick = pickRandomCard();
                playerSum+=cardPick;
                System.out.println("\nYour total is "+playerSum);
            }else{
                break;
            }

        }
        
        if (playerSum>21){
            System.out.println("\nYour total is "+playerSum+" which exceeded 21. Sorry, you lost.");
            System.exit(0);
        }

        System.out.println("\nDealer's turn");
        System.out.println("The dealer's cards are \n");
        drawCard(cardDealerPick);
        System.out.println("\nand a ");
        drawCard(cardHiddenPick);

        while(dealerSum<17){
            System.out.println("\nThe dealer gets a ");
            cardDealerPick = pickRandomCard();
            dealerSum+=cardDealerPick;
            System.out.println("\nThe dealer's total is "+dealerSum);

            if (dealerSum>=17){
                if (dealerSum>21){
                    System.out.println("\nDealer's total is "+dealerSum+" which exceeds 21. Dealer loses, so you win!");
                    System.exit(0);
                }
            }
        }

        if (playerSum>dealerSum) System.out.println("YOU WIN!");
        else System.out.println("\nDEALER WINS!");

        scan.close();
    }

    public static int pickRandomCard(){
        int[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        Random r = new Random();
        int pick = cards[r.nextInt(cards.length)];
        drawCard(pick);
        return pick;
    }

    public static void drawCard(int n){
        String[] cards = {"spades","clubs","diamonds","hearts"};
        Random r = new Random();
        try {
            File myObj = new File("PlayingCards/"+n+cards[r.nextInt(cards.length)]+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static int pickRandomHiddenCard(){
        int[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        Random r = new Random();
        int pick = cards[r.nextInt(cards.length)];
        drawHiddenCard();
        return pick;
    }

    public static void drawHiddenCard(){
        try {
            File myObj = new File("PlayingCards/hidden.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}