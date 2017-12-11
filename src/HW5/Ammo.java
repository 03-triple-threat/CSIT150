//package HW5;
//
//import HW1.Player;
//
//import java.awt.*;
//
//public class Ammo {
//
//    private int xLoc, yLoc;
//    public boolean player;
//    private Color color;
//
//    public Ammo(int x, int y, boolean inPlayer)
//    {
//        xLoc = x;
//        yLoc = y;
//        player = inPlayer;
//        color = Color.BLUE;
//    }
//
//    public int getxLoc()
//    {
//        return xLoc;
//    }
//
//    public  int getyLoc()
//    {
//        return yLoc;
//    }
//
//    public boolean checkCollision(Player player)
//    {
//        int x = player.getXLoc();
//        int y = player.getYLoc();
//
//        if (xLoc < x && xLoc + 3 > x && yLoc < y && yLoc + 3 > y) {
//            return true;
//        } else if (x < xLoc && x + 25 > xLoc & y < yLoc &&)
//    }
//}
