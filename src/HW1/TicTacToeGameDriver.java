package HW1;

/**
 * Created by ajhurtado3 on 9/21/17.
 */
public class TicTacToeGameDriver {
    public static void main(String[] args) {

        //Creates the gameboard
        GameBoard gBoard = new GameBoard();
        //gBoard.showBoard();

        //Creates the player
        Player X = new Player('X');
        Player O = new Player('O');

        gBoard.playerMove(4, O);
        gBoard.playerMove(9, X);
        gBoard.playerMove(3, X);
        gBoard.playerMove(6, X);
        gBoard.playerMove(6, O);

        gBoard.showBoard();
    }
}


