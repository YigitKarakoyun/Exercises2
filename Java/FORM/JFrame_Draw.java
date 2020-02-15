Çizim Örnekleri
Mayıs 5, 2017 Yazarı: Dr.Who
import java.awt.Color;
import javax.swing.JFrame;
class ana_class{
public static void main(String args[]){
JFrame f = new JFrame("Paint");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
GUI p = new GUI();
p.setBackground(Color.WHITE);
f.add(p);
f.setSize(500,270);
f.setVisible(true);
}
}
—

import java.awt.*;  //color,etc
import java.awt.event.*;
import javax.swing.*;
public class GUI  extends JPanel{
public void paintComponent(Graphics g){
super.paintComponent(g);
this.setBackground(Color.WHITE);
g.setColor(Color.BLUE);
g.drawLine(10, 25, 200, 45);
g.setColor(Color.RED);
g.drawRect(10, 35, 100,30);
g.setColor(Color.GREEN);
g.fillOval(10, 95, 100,30);
g.setColor(Color.ORANGE);
g.fill3DRect(10,160,100,50,true);
}
}
