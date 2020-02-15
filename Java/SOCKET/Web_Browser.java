//Web Browser Örneği

import javax.swing.JFrame;
public class ana_class {
    public static void main(String[] args) {
      diger tarayici = new diger();
      tarayici.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    }
}
–

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class diger extends JFrame{
  private JTextField addressBar;
  private JEditorPane display;
  
  //constructor
  public diger(){
    super("Tarayıcı Başlığı");
    
    addressBar = new JTextField("URL adresi girin!");
    addressBar.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent event){
            loadCrap(event.getActionCommand());
            
          }
        }
        );
    add(addressBar,BorderLayout.NORTH); //ekranın sağ ust koşesinde
    
    display = new JEditorPane();
    display.setEditable(false);
    display.addHyperlinkListener(
        new HyperlinkListener(){
          public void hyperlinkUpdate(HyperlinkEvent event){
            // kullanıcı ekrana tıkladığında...
            if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
              loadCrap(event.getURL().toString());
            }
          }
        }
    );
    add(new JScrollPane(display),BorderLayout.CENTER);
    //JScrollPane'i JFrame'e ekle.
    setSize(500,300);
    setVisible(true);
  }
  private void loadCrap(String userText){
    try{
      // çalıştırma kısmı
      display.setPage(userText);
      addressBar.setText(userText);
    }catch(Exception e){
      System.out.println("Çalışmadı!Lütfen geçerli bir adres girin. Örnek http://www.javayaz.com ");
    }
  }
}
