package MidTerm;

/**
 * Author: AJ Hurtado
 * Date: 10/20/2017
 */
public class TwoDPoint {
    private double x;
    private double y;

    public TwoDPoint() {}

    /**
     * Constructor for TwoDPoints
     * @param inX
     * @param inY
     */
    public TwoDPoint(double inX, double inY){
        x = inX;
        y = inY;
    }

    /**
     * Accessor for X
     * @return x
     */
    public double getX(){return x;}

    /**
     * Accessor for y
     * @return y
     */
    public double getY(){return  y;}

    /**
     * Sets x variable to inX
     * @return x
     */
    public void setX(double inX){
        x = inX;
    }

    /**
     * sets y variable to inY
     * @return x
     */
    public void setY(double inY){
        y = inY;
    }

    /**
     * Calculates the length of the rectangle
     * using the two X coordinates
     * @return len
     */
    public double getLen(double inY1, double inY2) {
        double len = inY2 - inY1;
        return len;
    }

    /**
     * Calculates the width of the rectangle
     * using the two X coordinates
     * @return wid
     */
    public double getWid(double inX1, double inX2) {
        double wid = inX2 - inX1;
        return wid;
    }

    /**
     * Calculates the Area of the rectangle by using the
     * length and wide of the rectangle
     * @return area
     */
    public double getArea(double inLen, double inWid) {
        double area = inLen * inWid;
        return area;
    }

//    public String toString(TwoDPoint coordinate){
//        "The area of the rectangle created by the coordinates is" +
//                "equal to: " + coordinate.getArea((coordinate.getLen(1, 4)) , coordinate.getWid(1, 5)
//
//    }
}
