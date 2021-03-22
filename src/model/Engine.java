package model;

import java.util.Random;

import presenter.MainContract;

public class Engine implements MainContract.Model
{
   public MainContract.Presenter temp;
   
   private Ball ball;
   
   private Point ballDestination;
     
   private int framerate = 24;
   private int speed = 2;
   
   public Engine()
   {
      Random random = new Random();
      
      ball = new Ball(100 + random.nextInt(600), 100 + random.nextInt(400), 10);
   }
   
   public void refresh()
   {
      temp.onUpdateBall((int)ball.center.x, (int)ball.center.y, ball.radius);
   }
   
   public void setBallDestination(int newX, int newY)
   {
      ballDestination = new Point(newX, newY);      
           
      new Thread(new Runnable()
      {         
         @Override
         public void run()
         {
            moveBall();
         }
      }).start();
   }
   
   private void moveBall()
   {
      while ((ball.center.x != ballDestination.x) || (ball.center.y != ballDestination.y))
      {
         double distX = ballDestination.x - ball.center.x;
         double distY = ballDestination.y - ball.center.y;
         if (Math.abs(distX) < speed)
            ball.center.x = ballDestination.x;
         else
            ball.center.x += Math.signum(distX) * speed;
         if (Math.abs(distY) < speed)
            ball.center.y = ballDestination.y;
         else
            ball.center.y += Math.signum(distY) * speed;
      
         if (temp != null)
            temp.onUpdateBall((int)ball.center.x, (int)ball.center.y, ball.radius);
      
         try
         {
            Thread.sleep(1000 / framerate);
         } catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
}
