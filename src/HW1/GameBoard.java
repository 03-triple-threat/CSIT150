package HW1;

public class GameBoard {
    private char[][] gameBoard;

    //Default constructor of the gameboard
    public GameBoard() {
        gameBoard = new char[3][3];

        int spaceOnBoard = 1;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = (char) ('0' + spaceOnBoard++);
            }
        }
    }

    //Displays the board
    public void showBoard() {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

//    //Completed player move
//    public boolean playerMove(int position, Player p) {
//
//        boolean validMove = true;
//
//        char value = (char) ('0' + position);
//
//        char row = (char) ((position - 1) / 3);
//        char col = (char) ((position - 1) % 3);
//
//        if (gameBoard[row][col] == value) {
//            validMove = true;
//            gameBoard[row][col] = p.getName();
//
//        } else {
//            validMove = false;
//        }
//        return validMove;
//    }

//    public boolean checkForWinner(){
//
//        boolean winner = false;
//
//        int i;
//
//        for (i = 0; i < 3; i++) {
//            if (gameBoard[i][0] == gameBoard[i][1] &&
//                    gameBoard[i][0] == gameBoard[i][2]) {
//                winner = true;
//            } if (gameBoard[0][i] == gameBoard[1][i] &&
//                    gameBoard[1][i] == gameBoard[2][i]) {
//                winner = true;
//            }
//        }
//
////        if(gameBoard[0][0] == gameBoard[1][1] &&)
////
////        return winner;
//    }
}

//Notes for the HW

//char value = position + '0'
//int number = value - '0'

//Creates a new array of Players and sets the players in index 0 and 1
//Player[] plist = new Player[2];
//plist[0] = new Player('X');
//plist[1] = new Player('O');

//Tracks which player currently is moving
//int current = 0;
//current = (current + 1) % 2
//plist[current]