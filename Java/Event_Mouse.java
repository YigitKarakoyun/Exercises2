import javax.swing.JFrame;
class ana_class{
public static void main(String args[]){
GUI go = new GUI();
go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
go.setSize(300,200);
go.setVisible(true);
}
}
—

import java.awt.*;  //color,etc
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class GUI extends JFrame {
private JPanel mousepanel;  //ekranda panel olacak.
private JLabel statusbar;  //ekranda ayrıca statusbar olacak onların değişkenleri...
public GUI(){
super("Başlık");
mousepanel = new JPanel();
mousepanel.setBackground(Color.WHITE);
add(mousepanel,BorderLayout.CENTER);  //bütün alanı kaplayacak.
statusbar = new JLabel("default");
add (statusbar, BorderLayout.SOUTH); //ekranın altında olması sağlanmıştır.
Handlerclass handler = new Handlerclass();
//2 objeninde durum bilgileri alınacağından  2 obje içinde handler bilgisi gerekiyor.
mousepanel.addMouseListener(handler);
mousepanel.addMouseMotionListener(handler);
}
private class Handlerclass implements MouseListener, MouseMotionListener {
//tıklama,press vb bilgileri almak için MouseListener, MouseMotionListener class içerisine implement edilmiştir.
// these are mouse listener event
//eventin içerisinde konum bilgileri bulunmakta
public void mouseClicked(MouseEvent event){
statusbar.setText(String.format("Clicked at %d %d", event.getX(), event.getY()));
}
public void mousePressed(MouseEvent event){
statusbar.setText("You pressed down the mouse");
}
public void mouseReleased(MouseEvent event){
statusbar.setText("You released the button");
}
public void mouseEntered(MouseEvent event){
statusbar.setText("You entered the area");
mousepanel.setBackground(Color.RED);
}
public void mouseExited(MouseEvent event){
statusbar.setText("the mouse hend left the window");
mousepanel.setBackground(Color.WHITE);
}
// these are mouse motion event
public void mouseDragged(MouseEvent event){
statusbar.setText("you are dragging the mouse");
}
public void mouseMoved(MouseEvent event){
statusbar.setText("you moved the mouse");
}
}
}
