package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        char[][] board = {{'_','_','_'}, {'_','_','_'}, {'_','_','_'}};
        System.out.println("Let's play Tic Tac Toe\n");
        printBoard(board);
        boolean tieFlag = true;

        for (int i=0; i<9; i++){
            if (i%2==0){
                System.out.println("Turn: X");
                int[] answer = askUser(board);
                board[answer[0]][answer[1]] = 'X';
                printBoard(board);
            }else{
                System.out.println("Turn: O");
                int[] answer = askUser(board);
                board[answer[0]][answer[1]] = 'O';
                printBoard(board);
            }

            if(checkWin(board)==3){
                System.out.println("\nX player won!");
                tieFlag = false;
                break;
            }else if(checkWin(board)==-3){
                System.out.println("\nO player won!");
                tieFlag = false;
                break;
            }
        }

        if (tieFlag) System.out.println("It's a tie!");
    }

    public static void printBoard(char[][] board){
        for (int i=0; i<3; i++){
            System.out.print("\t");
            for (int j=0; j<3; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static int[] askUser(char[][] board){
        System.out.print("Pick the row and column to place your mark: ");
        int[] ans = {0,0};
        boolean flag = true;
        
        do{
            flag = true;
            for (int i=0; i<2; i++){
                do{
                    ans[i] = scan.nextInt();
                }while(ans[i]!=0 && ans[i]!=1 && ans[i]!=2);
            }

            if (board[ans[0]][ans[1]]!='_'){
                System.out.println("Space already taken, choose another row and column");
                flag = false;
            }
        }while(!flag);

        return new int[] {ans[0],ans[1]};
    }

    public static int checkWin(char[][] board){
        int count = 0;
        
        //check row
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(board[i][j]=='X') count++;
                else if(board[i][j]=='O') count--;
            }
            if(count==3 || count==-3) break;
            else count=0;
        }
        
        //check column
        for (int i=0; i<3; i++){
            for (int j=0; j<board.length; j++){
                if(board[j][i]=='X') count++;
                else if(board[j][i]=='O') count--;
            }
            if(count==3 || count==-3) break;
            else count=0;
        }

        //check left diagonal
        for (int i=0; i<3; i++){
            if(board[i][i]=='X') count++;
            else if(board[i][i]=='O') count--;    
        }
        if(count==3 || count==-3) return count;
        else count=0;

        //check right diagonal
        for (int i=0; i<3; i++){
            if(board[i][board.length-i-1]=='X') count++;
            else if(board[i][board.length-i-1]=='O') count--;
        }
        if(count==3 || count==-3) return count;
        else count=0;
                
        return count;
    }
    
}
