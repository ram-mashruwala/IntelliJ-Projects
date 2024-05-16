import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> guessedWords;

    public static void main(String[] args) {
        int lives = 5;
        guessedWords = new ArrayList<>();
        Board board = new Board();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to HangMan!");
        //thestoinewfowiefowijfoweijfoiwjefoijwef

        while(true){
            System.out.println("\n\nPlease guess a character, or guess the whole word");
            System.out.println("You have " + lives + " lives left");
            board.printBoard();
            System.out.print("You have guessed: ");
            for(String i : guessedWords){
                System.out.print(i + ", ");
            }
            System.out.println();
            String guess = scan.nextLine();
            if(guess.isEmpty()){
                System.out.println("TYPE SOMETHING!!!!");
                continue;
            }
            if(alreadyUsed(guess.toUpperCase())){
                System.out.println("YOU ALREADY GUESSED THIS WORD!!!!!!");
                continue;
            } else {
                guessedWords.add(guess.toUpperCase());
            }

            if(guess.length() > 1 && guess.equalsIgnoreCase(board.getWord())){
                System.out.println(board.getWord());
                System.out.println("YOU WIN!!!!!");
                break;
            } else if(guess.length() > 1){
                System.out.println("NOPE!");
                lives--;
                System.out.println(lives);
                continue;
            }

            if(!board.guess(Character.toLowerCase(guess.charAt(0)))){
                System.out.println("NOPE!");
                lives--;
            }

            if(lives == 0){
                System.out.println("YOU LOSE!!!");
                break;
            }

            if(board.isWin()){
                System.out.println("YOU WIN!!!!!");
                break;
            }

        }
        System.out.println("\nThe correct word is : " + board.getWord().toUpperCase());
    }

    public static boolean alreadyUsed(String str){
        for (String guessedWord : guessedWords) {
            if (guessedWord.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

}