//0_Class_Simple
class ana{
    void bak(){
	// NASIL YAPILACAK...
	// BU MODUL İLE İLGİLİ ALGORİTMA BURAYA YAZILACAK
    }
}

//1_Coklu_Class
class ana{
    public static void main(String args[]){
	diger digerObject = new diger();
	digerObject.simpleMessage();
	System.out.println("\n Merhaba");
    }
}

// Diger isimli class
public class diger{
    public void simpleMessage() {
        System.out.print("Bu Diger Bir Classtır.");
	
    }
}

//2_Coklu_Class_Parametre
public class diger {
    public void simpleMessage(String name) {
	System.out.print("Merhaba " +  name);
    }
}


import java.util.Scanner;
class ana{
    public static void main(String args[]){
	Scanner input = new Scanner(System.in);
	diger digerObject = new diger();
	System.out.println("Adini Gir: ");
	String name =  input.nextLine();
	digerObject.simpleMessage(name);
    }  
}

//3_Coklu_Metod
import java.util.Scanner;
class ana{
    public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	diger digerObject = new diger();
	System.out.println("İlk kız arkadasinin adi: ");
	String temp =  input.nextLine();
	digerObject.setName(temp);
	digerObject.saying();
    }
}


public class diger{
    private String girlName;
    public void setName(String name){
	girlName = name;
    }
    public String getName() {
	return girlName;
    }
    public void saying() {
	System.out.printf("Senin ilk kız arkadasin %s", getName());
    }
}

//4_Yapici_Metodlar
class ana{
    public static void main(String[] args){
	tuna digerObject = new tuna("Ayse");
	tuna digerObject2 = new tuna("Fatma");
	tuna digerObject3 = new tuna("Hayriye");
	digerObject.saying();
	digerObject2.saying();
	digerObject3.saying();
    }
}


public class tuna{
    private String KizinAdi;

    public tuna(String name){ KizinAdi =name; }
    public String getName() { return KizinAdi; }

    public void saying() {
	System.out.printf("Senin ilk kızarkadasin %s \n", getName());
    }
}

//5_Adapter_Class
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

//Mouse buttonlarının  tıklamalarını yakalama
import java.awt.*;  //color,etc
import java.awt.event.*;
import javax.swing.*;
public class GUI extends JFrame {
private String details;
private JLabel statusbar;  //ekranda statusbar olması için...
public GUI(){
super("Başlık");
statusbar = new JLabel("Varsayılan");
add (statusbar, BorderLayout.SOUTH); //ekranın altında olması sağlanmıştır.
addMouseListener(new MouseClass());
}
private class MouseClass extends MouseAdapter {
public void mouseClicked(MouseEvent event){
statusbar.setText(String.format("Clicked at %d %d", event.getX(), event.getY()));
details = String.format("You clicked %d", event.getClickCount());
if(event.isMetaDown()) //mouse tipi 1,2,3 tuşlu
details += "with right mouse button";
else if(event.isAltDown())
details += "with center mouse button";
else
details += "with left mouse button";
statusbar.setText(details);
//Örneği çalıştırdıktan sonra  statusbar.setText(details); yorum satırı yapıp örneği tekrar çalıştırın.
}
}
}



