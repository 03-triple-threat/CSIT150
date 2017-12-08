package tutorDemos;

import java.util.*;

/**
 *
 * @author canderson
 */
public class FormRecArray {
    int[][] recs;
    Random rand;
    private int step = 7;
    private int rot = 1;
    double radConvert = 2*Math.PI/360;

    public FormRecArray(int s)
    {

        rand = new Random();
        generateRecArray(s);

    }

    public int[][] genNewArray(int rs)
    {
        generateRecArray( rs);
        return recs;
    }

    private void generateRecArray(int rs)
    {
        recs = new int[rs][7];
        double s = .80;
        double startX = 800;
        double startY = -200;
        int width = 50;
        int height= 50;
        int colorNum1 = 210;
        int colorNum2 = 50;
        int colorNum3 = 50;
        int r = 20;
        for(int dex = 0; dex < recs.length; dex++)
        {
            recs[dex][0] = (int)startX;
            recs[dex][1] = (int)startY;
            recs[dex][2] = width;
            recs[dex][3] = height;
            recs[dex][4] = colorNum1;
            recs[dex][5] = colorNum2;
            recs[dex][6] = colorNum3;

            startX = (startX +1 + s*step*(Math.cos(radConvert*r)));
            startY   = (startY+1 + s*step*(Math.sin(radConvert*r)));
            r += 5;
            width += 0;
            height += 0;
            colorNum1+= 5;
            if(colorNum1 >250)
                colorNum1 = 50;
            colorNum2+= 5;
            if(colorNum2 >250)
                colorNum2 = 50;
            colorNum3+= 5;
            if(colorNum3 >250)
                colorNum3 = 50;
        }
    }

    public int[][] getRecs()
    {
        return recs;
    }

}


