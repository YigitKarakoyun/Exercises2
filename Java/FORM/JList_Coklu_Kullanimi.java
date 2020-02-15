import javax.swing.JFrame;
class apples{
public static void main(String[] args){
GUI go = new GUI();
go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
go.setSize(300,200);
go.setVisible(true);
}
}
—

//Çoklu seçim için Ctrl tuşu kullanılabilir.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class GUI extends JFrame {
private JList rightlist;
private JList leftlist;
private JButton movebutton;
private static String[] food = {"dolma","makarna","pilav","köfte","iskender"};
public GUI(){
super("the title");
setLayout(new FlowLayout());
leftlist = new JList(food);
leftlist.setVisibleRowCount(3);
leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
add(new JScrollPane(leftlist));
movebutton = new JButton("Seçilen(ler) -->");
movebutton.addActionListener(
new ActionListener(){
public void actionPerformed(ActionEvent event){
rightlist.setListData(leftlist.getSelectedValues());
}
}
);
add (movebutton);
rightlist = new JList();
rightlist.setVisibleRowCount(3);
rightlist.setFixedCellWidth(100);
rightlist.setFixedCellHeight(15);
rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
add(new JScrollPane(rightlist));
}
}
