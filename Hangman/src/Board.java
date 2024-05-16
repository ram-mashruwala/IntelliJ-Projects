public class Board {

    private String[] words = {"puff pastry" , "egg tart", "hello", "croissant", "eesh desai", "cream puff", "what about bob", "turquoise", "i am the solution", "indicator", "universe"};
    private String word;
    private char[] board;

    public Board(){
        word = words[(int) (Math.random() * words.length)];
        board = new char[word.length()];
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ' '){
                board[i] = ' ';
                continue;
            }
            board[i] = '_';
        }
    }

    public boolean guess(char guess){
        boolean guessRight = false;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == guess){
                guessRight = true;
                board[i] = Character.toUpperCase(guess);
            }
        }
        return guessRight;
    }

    public void printBoard(){
        for(int i = 0; i < board.length; i++){
            System.out.print(board[i]);
        }
        System.out.println();
    }

    public String getWord(){return word;}

    public boolean isWin(){
        for(int i = 0; i < board.length; i++){
            if(board[i] == '_'){
                return false;
            }
        }
        return true;
    }

}
