import java.awt.*; 
import javax.swing.*;
public class ana_class {
  public static void main(String[] args){
    
    TheWindow w = new TheWindow();
    // Programı kapatmak için gerekli...
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    w.setSize(300,400);
    w.setVisible(true);
  }
  
  
}  
–

import java.awt.*; 
import javax.swing.*;
public class DrawOval extends JPanel{
  
  private int d=10;
  
   public void paint(Graphics g){
     super.paint(g); //Super class olan JPanel
     g.fillOval(10,10,d,d);     
   } 
  public void setD(int newD){
    d = (newD >= 0 ? newD : 10);
    repaint();
   }
  public Dimension getProferredSize(){
    return new Dimension(200,200);
  }
  public Dimension getMinimumSize(){
    return getMinimumSize();
  }
    
}
–

import java.awt.*; 
import javax.swing.*;
import javax.swing.event.*;
public class TheWindow extends JFrame{
  private JSlider slider;
  private DrawOval myPanel;
  
  public TheWindow(){
    super("Başlık");
    myPanel = new DrawOval();
    myPanel.setBackground(Color.ORANGE);
    //Slider horizon olsun 0 ile 200 arasında sayılar alsın.
    slider = new JSlider(SwingConstants.HORIZONTAL,0,200,10);
    //Aralık belirleme her 10 pixelde bir
    slider.setMajorTickSpacing(10);
    slider.setPaintTicks(true);
    //Ne zaman slider değiştirildiğinde
    slider.addChangeListener(
        new ChangeListener(){
          public void stateChanged(ChangeEvent e){
            myPanel.setD(slider.getValue()); //Hangi değer geldi ise o değeri slidera gönder.
          }
        }
                
    );
    add(slider, BorderLayout.SOUTH);
    add(myPanel, BorderLayout.CENTER);
  }
}
