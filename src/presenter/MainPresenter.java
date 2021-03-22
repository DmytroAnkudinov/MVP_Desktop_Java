package presenter;

import model.Engine;

public class MainPresenter implements MainContract.Presenter
{
   private MainContract.View view;
   private MainContract.Model model;
   
   public MainPresenter(MainContract.View view, MainContract.Model model)
   {
      this.view = view;
      this.model = model;
      
      ((Engine)this.model).temp = this;
      this.model.refresh();
   }

   @Override
   public void onClickedPoint(int x, int y)
   {
      model.setBallDestination(x, y);
      
   }

   @Override
   public void onUpdateBall(int x, int y, int radius)
   {
      view.redrawBall(x, y, radius);
   }
}
