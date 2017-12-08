package HW5;

public class boardSI
{
    int[][] gboard;
    int rows;
    int cols;

    public boardSI(int r, int c)
    {
       gboard = new int[r][c];

       for (int i=0;i<r;i++) {
           for(int j=0;j<c;j++) {
               gboard[i][j] = 0;
           }
       }
    }

//    public String toString()
//    {
//        String output = "";
//
//        for (int i=0;i<gboard.length;i++) {
//            for(int j=0; j<gboard[i].length;j++) {
//                output += gboard[i][j];
//            }
//            output +="\n";
//        }
//        return output;
//    }
}
