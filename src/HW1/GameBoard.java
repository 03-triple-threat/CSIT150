package HW1;

public class GameBoard {
    private char[][] gameBoard;

    public GameBoard() {
        gameBoard = new char[3][3];

        int spaceOnBoard = 1;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = (char)('0' + spaceOnBoard++);
            }
        }
    }

    public void showBoard() {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

//    public boolean playerMove(int position, Player p) {
//
//        boolean validMove = true;
//
//        char value = (char)('0' + position);
//
//        for (int i = 0; i < gameBoard.length; i++) {
//            for (int j = 0; j < gameBoard[i].length; j++) {
//                if ((value != 'X') && (value != 'O')) {
//                    validMove = true;
//                }
//                else {
//                    validMove = false;
//                    System.out.println("Invalid Move");
//                }
//            }
//        }
//
//        //Work to set position chosen to player mark
//        if(validMove) {
//            for (int i = 0; i < gameBoard.length; i++){
//                for (int j = 0; j < gameBoard[i].length; j++) {
//                    if (value == gameBoard[i][j]) {
//                        gameBoard[i][j] = ;
//                    }
//                }
//            }
//        }
//
//        return validMove;
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

