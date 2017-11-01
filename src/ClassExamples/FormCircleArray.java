package ClassExamples;

/**
 *
 * @author canderson
 */
public class FormCircleArray {

    int[][] circs;

    public FormCircleArray(int rSeed)
    {
        generateCircArray(rSeed);

    }

    public int[][] genNewArray(int rs)
    {
        generateCircArray( rs);
        return circs;
    }

    private void generateCircArray(int rs)
    {
        circs = new int[rs][7];

        int startX = 100;
        int startY = 50;
        int width = 50;
        int height= 50;
        int colorNum1 = 10; //Red
        int colorNum2 = 50; //Green
        int colorNum3 = 150; //Blue

        for(int dex = 0; dex < circs.length; dex++)
        {
            circs[dex][0] = startX;
            circs[dex][1] = startY;
            circs[dex][2] = width;
            circs[dex][3] = height;
            circs[dex][4] = colorNum1;
            circs[dex][5] = colorNum2;
            circs[dex][6] = colorNum3;

            startX = startX + 10;
            startY += 10;
            width += 10;
            height += 5;
            colorNum1+= 10;
            if(colorNum1 >254)
                colorNum1 = 10;
            colorNum2+= 10;
            if(colorNum2 >254)
                colorNum2 = 10;
            colorNum3+= 10;
            if(colorNum3 >254)
                colorNum3 = 10;
        }
    }

    public int[][] getCircs()
    {
        return circs;
    }

}
