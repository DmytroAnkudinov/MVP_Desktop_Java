package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import presenter.MainContract;
import presenter.MainPresenter;
import model.Engine;

public class MainView extends JPanel implements MainContract.View, MouseListener, MouseMotionListener 
{
   private MainContract.Presenter presenter = null;
   
   
   private int ballX = 0;
   private int ballY = 0;
   private int ballRadius = 0;
   
   
   private JFrame mainFrame = null;
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      JFrame mainFrame = new JFrame();
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setSize(800, 650);
      mainFrame.getContentPane().add(new MainView(mainFrame));
      mainFrame.setResizable(false);
      mainFrame.setVisible(true);
   }
   
   public MainView(JFrame mainFrame)
   {
      addMouseListener(this);
      addMouseMotionListener(this);
      this.mainFrame = mainFrame;

      Engine engine = new Engine();
      this.presenter = new MainPresenter(this, engine);
   }
   
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      
      g2.fill(new Ellipse2D.Double(ballX, ballY, ballRadius, ballRadius));      
   }

   @Override
   public void mouseDragged(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseMoved(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseClicked(MouseEvent e)
   {
      System.out.println("Mouse clicked at " + e.getX() + " , " + e.getY());
      presenter.onClickedPoint(e.getX(), e.getY());
      
   }

   @Override
   public void mousePressed(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseExited(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void redrawBall(int x, int y, int radius)
   {
      ballX = x;
      ballY = y;
      ballRadius = radius;
      
      repaint();
   }
}
