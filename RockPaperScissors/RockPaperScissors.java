package Tests;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.");
        System.out.println("Are you ready? 'yes' or 'no'");
        String ans;
        do{
            ans = scan.nextLine();
        }while(!ans.equals("yes") && !ans.equals("no"));
        if (!ans.equals("yes")){
            System.out.println("Damn, maybe another time");
            System.exit(0);
        }

        String choice;
        System.out.println("Great, lets play!\nRock - Paper - Scissors ... SHOOT!");
        do{
            choice = scan.nextLine();
        }while(!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors"));
        String cChoice = randomPick();
        
        System.out.println("You chose: "+choice+"\nComputer chose: "+cChoice);
        if(choice.equals(cChoice)) System.out.println("Its a tie");
        else if(choice.equals("rock") && cChoice.equals("paper")) System.out.println("You lose!");
        else if(choice.equals("rock") && cChoice.equals("scissors")) System.out.println("You win!");
        else if(choice.equals("paper") && cChoice.equals("rock")) System.out.println("You win!");
        else if(choice.equals("paper") && cChoice.equals("scissors")) System.out.println("You lose!");
        else if(choice.equals("scissors") && cChoice.equals("paper")) System.out.println("You win!");
        else if(choice.equals("scissors") && cChoice.equals("rock")) System.out.println("You lose!");
        scan.close();
    }

    private static String randomPick() {
        String[] compChoices = {"rock","paper","scissors"};
        Random r = new Random();
        return compChoices[r.nextInt(compChoices.length)];
    }
}
