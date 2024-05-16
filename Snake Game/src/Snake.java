public class Snake {

    boolean head;
    int length;
    int row;
    int col;
    Game game;

    public Snake(int length, int row, int col, Game game){
        this.length = length;
        this.row = row;
        this.col = col;
        head = true;
        this.game = game;
    }

    public boolean isHead(){
        return head;
    }

    public char currentState(){
        length--;
        if(game.justAte){
            length++;
        }
        if (isHead()){
            head = false;
            return 'D';
        }
        if (length < 0){
            game.board[row][col] = null;
            return '0';
        }
        return '0';

    }

}
