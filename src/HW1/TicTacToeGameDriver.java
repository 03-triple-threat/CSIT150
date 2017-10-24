package HW1;

import java.security.PublicKey;
import java.util.Scanner;

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

        Player[] pList = new Player[2];
        pList[0] = X;
        pList[1] = O;

        int current = 1;

        int moveCount = 1;

        while (gBoard.checkForWinner() == false) {

            Scanner input = new Scanner(System.in);

            int playerPosition;

            current = (current + 1) % 2;

            System.out.println("Player " + pList[current].getName() +
                    ", enter a position: \n");

            playerPosition = input.nextInt();

            if (gBoard.validMove(playerPosition, pList[current])) {
                gBoard.playerMove(playerPosition, pList[current]);
                gBoard.showBoard();
                gBoard.checkForWinner();
                moveCount++;
                if (gBoard.checkForWinner() == true) {
                    System.out.println("Game Over!");
                }

                if (moveCount == 9) {
                    System.out.println("Cat's Game");
                }
            }
        }
    }
}


