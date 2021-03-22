package model;

public class Ball
{
   public Point center;
   public int   radius;
   
   public Ball(int x, int y, int radius)
   {
      center = new Point(x, y);
      this.radius = radius;
   }
}
