//Java’da Basit Grafik Ekleme (JPanel Kullanımı)
import java.awt.*;  //color,etc
import java.awt.event.*;
import javax.swing.*;
public class GUI  extends JPanel{
public void paintComponent(Graphics g)
{
//color,object şekillendirmeyi içermektedir.
super.paintComponents(g);
this.setBackground(Color.WHITE);
g.setColor(Color.BLUE);
g.fillRect(25, 25,100, 30); //g.fillRect(x, y,width, height);
g.setColor(new Color(190,81,215)); // rgb()
g.fillRect(25, 55, 100, 30);
g.setColor(Color.RED);
g.drawString("Renkli Yazı", 25, 120);
}
}
—

import javax.swing.JFrame;
class ana_class{
public static void main(String args[]){
JFrame f = new JFrame("Title");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
GUI p = new GUI();
f.add(p);
f.setSize(300,200);
f.setVisible(true);
}
}
