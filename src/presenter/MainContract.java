package presenter;

public class MainContract
{
   public interface View
   {
      void redrawBall(int x, int y, int radius);
   }
   
   public interface Presenter
   {
      void onClickedPoint(int x, int y);
      
      void onUpdateBall(int x, int y, int radius);
   }
   
   public interface Model
   {
      void setBallDestination(int newX, int newY);
      void refresh();
      
   }
}
