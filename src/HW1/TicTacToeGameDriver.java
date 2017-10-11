package HW1;

import java.security.PublicKey;

/**
 * Created by ajhurtado3 on 9/21/17.
 */
public class TicTacToeGameDriver {
    public static void main(String[] args) {

        //Creates the gameboard
        GameBoard gBoard = new GameBoard();

        //Creates the player
        Player X = new Player('X');
        Player O = new Player('O');

        //Game 1 example
        gBoard.playerMove(1, X);
        gBoard.playerMove(2, O);
        gBoard.playerMove(3, X);
        gBoard.playerMove(4, O);
        gBoard.playerMove(5, X);
        gBoard.playerMove(6, O);
        gBoard.playerMove(7, X);
        gBoard.playerMove(8, O);
        gBoard.playerMove(9, X);

        gBoard.showBoard();
        gBoard.checkForWinner();

        if (gBoard.checkForWinner()) {
            System.out.println("Game Over!");
        }

        if (gBoard.checkForWinner() == false) {
            System.out.printf("Cat's game!");
        }

        System.out.println("\n");

        //Game 2 example

        //Creates the gameboard
        GameBoard gBoard2 = new GameBoard();

        gBoard2.playerMove(1, X);
        gBoard2.playerMove(3, O);
        gBoard2.playerMove(2, X);
        gBoard2.playerMove(5, O);
        gBoard2.playerMove(4, X);
        gBoard2.playerMove(7, O);
        gBoard2.playerMove(6, X);
        gBoard2.playerMove(8, O);
        gBoard2.playerMove(9, X);

        gBoard2.showBoard();
        gBoard2.checkForWinner();

        if (gBoard2.checkForWinner()) {
            System.out.println("Game Over!");
        }

        if (gBoard2.checkForWinner() == false) {
            System.out.printf("Cat's game!");
        }

        System.out.println("\n");

        //Game 3 example

        GameBoard gBoard3 = new GameBoard();

        gBoard3.playerMove(1, X);
        gBoard3.playerMove(3, O);
        gBoard3.playerMove(2, X);
        gBoard3.playerMove(5, O);
        gBoard3.playerMove(6, X);
        gBoard3.playerMove(4, O);
        gBoard3.playerMove(7, X);
        gBoard3.playerMove(8, O);
        gBoard3.playerMove(9, X);

        gBoard3.showBoard();
        gBoard3.checkForWinner();

        if (gBoard3.checkForWinner()) {
            System.out.println("Game Over!");
        }

        if (gBoard3.checkForWinner() == false) {
            System.out.printf("Cat's game!");
        }
    }
}


