Renk Paletinden Renk Seçme(JColor Chooser)
Mayıs 5, 2017 Yazarı: Dr.Who
import javax.swing.JFrame;
class ana_class{
public static void main(String args[]){
GUI p = new GUI();
p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
—

import java.awt.*;  //color,etc
import java.awt.event.*;
import javax.swing.*;
public class GUI  extends JFrame{
private JButton b;
private Color color = (Color.WHITE);
private JPanel panel;
public GUI(){
super("Başlık");
panel = new JPanel();
panel.setBackground(color);
b=new JButton("Bir Renk Seç");
b.addActionListener(
new ActionListener(){
public void actionPerformed (ActionEvent event){
color = JColorChooser.showDialog(null,"Bir Renk Seç",color);
if(color==null)  //eğer cancel edilmişse yani hiçbir renk seçilmemişse beyaz olsun.
color=(Color.WHITE);
panel.setBackground(color);
}
}
);
add(panel, BorderLayout.CENTER);
add(b,BorderLayout.SOUTH);
setSize(425,150);
setVisible(true);
}
}
