//Java’da Tam Ekran oluşturma

import java.awt.*;
import javax.swing.JFrame;
public class bucky extends JFrame {
  public static void main(String[] args) {
    
    DisplayMode dm = new DisplayMode(800,600,16,DisplayMode.REFRESH_RATE_UNKNOWN);
    bucky b = new bucky();
    b.run(dm);
    
  }
  public void run(DisplayMode dm){
    setBackground(Color.PINK);
    setForeground(Color.WHITE);
    setFont(new Font("Arial",Font.PLAIN,24));
    
    Screen s = new Screen();
    try{
      s.setFullScreen(dm, this);
      try{
        Thread.sleep(5000);
      }catch(Exception ex){}
    }finally{
      s.restoreScreen();
    }
  }
}
–

import java.awt.*;
import javax.swing.JFrame;
public class Screen {
  
  private GraphicsDevice vc;
  public Screen(){
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //Tüm ekranı kaplayan uygulamak için grafik karttı ile ilgili olarak...
    vc = env.getDefaultScreenDevice();
  }
  
  public void setFullScreen(DisplayMode dm,JFrame window ){
    window.setUndecorated(true);
    window.setResizable(false);
    //bütün ekranı kaplayan uygulama için...
    vc.setFullScreenWindow(window);
    // vc videocard
    if(dm != null && vc.isDisplayChangeSupported()){
      try{
        vc.setDisplayMode(dm);
      }catch(Exception ex){}
    }
    
  }
  public Window getFullScreenWindow(){
      return vc.getFullScreenWindow();
  }
  public void restoreScreen(){
    Window w = vc.getFullScreenWindow();
    if (w != null){
      w.dispose(); //garbage collector
    }
    vc.setFullScreenWindow(null);
  }  
}
