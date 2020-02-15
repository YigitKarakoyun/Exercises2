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

//Listboxdan seçilen renk değerine göre formun arka rengini değiştirme.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class GUI extends JFrame {
private JList list;
private static String[] colornames = {"siyah","mavi","kırmızı","beyaz"};
private static Color[] colors = {Color.BLACK,Color.BLUE,Color.RED,Color.WHITE};
public GUI(){
super("the title");
setLayout(new FlowLayout());
list = new JList(colornames);
list.setVisibleRowCount(4);
list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
add(new JScrollPane(list));
list.addListSelectionListener(
new ListSelectionListener(){
public void valueChanged(ListSelectionEvent event){
getContentPane().setBackground(colors[list.getSelectedIndex()]);
}
}
);
}
}
