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
public class GUI extends JFrame {
private JButton lb; //sol orta ve sağ buttonları tanımla
private JButton cb;
private JButton rb;
private FlowLayout layout;
private Container container;
public GUI(){
super("the title");
layout = new FlowLayout();
container = getContentPane();
setLayout(layout);
//sol butonu tanımla ve layouta ekle
lb = new JButton("sol");
add(lb);
lb.addActionListener(
new ActionListener(){
public void actionPerformed(ActionEvent event){
layout.setAlignment(FlowLayout.LEFT);
layout.layoutContainer(container);
}
}
);
//orta butonu tanımla ve layouta ekle
cb = new JButton("orta");
add(cb);
cb.addActionListener(
new ActionListener(){
public void actionPerformed(ActionEvent event){
layout.setAlignment(FlowLayout.CENTER);
layout.layoutContainer(container);
}
}
);
//sağ butonu tanımla ve layouta ekle
rb = new JButton("sağ");
add(rb);
rb.addActionListener(
new ActionListener(){
public void actionPerformed(ActionEvent event){
layout.setAlignment(FlowLayout.RIGHT);
layout.layoutContainer(container);
}
}
);
}
}
—

import javax.swing.JFrame;
class ana_class{
public static void main(String args[]){
GUI go = new GUI();
go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
go.setSize(300,200);
go.setVisible(true);
}
}
