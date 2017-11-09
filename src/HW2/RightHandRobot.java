//package HW2;
//
//public class RightHandRobot extends Robot {
//
//    int face;
//
//
//        public RightHandRobot(Maze maze) {
//            super(maze);
//
//            face = 2;
//
//        }
//
//        public int chooseMoveDirection() {
//
//            return (int) (Math.random() * 4);
//        }
//
//        public boolean move(int direction) {
//            boolean robotMove = false;
//
//
//            switch (direction) {
//                case 0:
//                    if (mazeTest.openCell(currentRow - 1, currentCol)) {
//                        mazeTest.setCell(currentRow, currentCol, ' ');
//                        currentRow--;
//                        mazeTest.setCell(currentRow, currentCol, 'r');
//                        robotMove = true;
//                        //move(direction);
//                    }
//                    break;
//                case 1:
//                    if (mazeTest.openCell(currentRow, currentCol + 1)) {
//                        mazeTest.setCell(currentRow, currentCol, ' ');
//                        currentCol++;
//                        mazeTest.setCell(currentRow, currentCol, 'r');
//                        robotMove = true;
//                    }
//                    break;
//                case 2:
//                    if (mazeTest.openCell(currentRow + 1, currentCol)) {
//                        mazeTest.setCell(currentRow, currentCol, ' ');
//                        currentRow++;
//                        face=2;
//                        robotMove = true;
//                    }
//                    break;
//                case 3:
//                    if (mazeTest.openCell(currentRow, currentCol - 1)) {
//                        mazeTest.setCell(currentRow, currentCol, ' ');
//                        currentCol--;
//                        mazeTest.setCell(currentRow, currentCol, 'r');
//                        robotMove = true;
//                    }
//                    break;
//            }
//            return robotMove;
//        }
//
//    }
//
//}
