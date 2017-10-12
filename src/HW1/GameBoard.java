package HW1;

public class GameBoard {
    private char[][] gameBoard;

    /**
     * Default constructor for gameboard.
     * A 3x3 char array is created and
     * filled in with the characters
     * '1' - '9'.
     */
    public GameBoard() {
        gameBoard = new char[3][3];

        int spaceOnBoard = 1;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = (char) ('0' + spaceOnBoard++);
            }
        }
    }

    /**
     * This method displays the board and it's contents.
     * It can be called after any move is made to see the board.
     */
    public void showBoard() {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method takes in the player and the position the
     * player wants to set their character on. The method then checks
     * the player's choice to see if the spot is open. If it is open,
     * the spot is filled with the player's character
     * @param position
     * @param p
     * @return
     */
    public boolean playerMove(int position, Player p) {

        boolean validMove = true;

        char value = (char) ('0' + position);

        char row = (char) ((position - 1) / 3);
        char col = (char) ((position - 1) % 3);

        if (gameBoard[row][col] == value) {
            validMove = true;
            gameBoard[row][col] = p.getName();

        } else {
            validMove = false;
        }
        return validMove;
    }

    public boolean validMove(int position, Player p) {

        boolean validMove = true;

        char value = (char) ('0' + position);

        char row = (char) ((position - 1) / 3);
        char col = (char) ((position - 1) % 3);

        if (gameBoard[row][col] == value) {
            gameBoard[row][col] = p.getName();
        } else {
            validMove = false;
        }
        return validMove;
    }

    /**
     * This method checks for three in a row in each
     * column and row. It also checks for three in a row in
     * the diagonal paths.
     * @return
     */
    public boolean checkForWinner(){

        boolean winner = false;

        int i;
        int moveCount = 0;

        for (i = 0; i < 3; i++) {
            if (gameBoard[i][0] == gameBoard[i][1] &&
                    gameBoard[i][0] == gameBoard[i][2]) {
                winner = true;
            } if (gameBoard[0][i] == gameBoard[1][i] &&
                    gameBoard[0][i] == gameBoard[2][i]) {
                winner = true;
            }
        }

        if(gameBoard[0][0] == gameBoard[1][1] &&
                gameBoard[0][0] == gameBoard[2][2]) {
            winner = true;
        }

        if (gameBoard[0][2] == gameBoard[1][1] &&
                gameBoard[0][2] == gameBoard[2][0]) {
            winner = true;
        }

        if (moveCount == 9) {
            winner = false;
        }
        return winner;
    }

}