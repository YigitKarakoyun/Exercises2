//
class ana_class{
    public static void main(String args[]){
	zaman zamObject  = new zaman(4,5,6);
    }
}


// Zaman class'ında print içerinde this dendiği için o anda çalışan objeyi gösterir
// %s dendiği için toStrig otomatik olarak formatı algılar ve ekrana yazar.
public class zaman {
    private int ay;
    private int gun;
    private int yil;
    public zaman (int a, int g, int y){
	ay = a;
	gun = g;
	yil = y;
	System.out.printf("This için constractor %s\n",this);
    }
    public String toString(){
	return String.format("%d/%d/%d", gun,ay,yil);
    }
}
}

//
public class ana_class{
    public static void main(String[] args){
	String a = "elma";
	String b = "murat";
	String c = "MURAT";
	System.out.println(a.length());
	System.out.println(b.toUpperCase());
	System.out.println(c.toLowerCase());

	if(a.equals("elma")){ System.out.println("a değişkeninde elma var!");}
	if(b.equals(c)){ System.out.println("Murat isimleri eşleşti!");}
	if(b.equalsIgnoreCase(c)){
	    System.out.println("b ve c değişkenindeki yazılar aynı ,case durumu var");
	}
    }
}

//
import javax.swing.JFrame;
class ana_class{
    public static void main(String args[]){
	String[] nesneler = {"elma","kitap","kiraz","karpuz","buz"};
	// Başlayan
	for(String w: nesneler){
	    if(w.startsWith("ki"))
		System.out.println(w + " ki hecesi ile başlayan nesneler");
        }
    	// Biten
    	for(String w: nesneler){
	    if(w.endsWith("uz"))
		System.out.println(w + " uz harfleri ile biten nesneler");
	    
	}
    }
}

//
import javax.swing.JFrame;
class ana_class{
    public static void main(String args[]){
	String s = "merhabadostlarmerhababizgeldik";
	String a = "Murat ";
	String b = "Demir";
	String c = "     Merhaba Murat      ";
	System.out.println(s.indexOf('m'));  
	//Verilen Stringin içerisinde kaçtane m harfi olduğunu kelime sırası ile listeleme.
	System.out.println(s.indexOf('k',5)); //ilk beş karakteri göz ardı ondan sonra ara
	System.out.println(s.indexOf('x')); // EĞERdeğer yoksa -1 değeri döndürür.
	System.out.println(s.indexOf("mer")); // mer kelimesini bulma.
	System.out.println(s.indexOf("mer",10)); //ilk 10 değeri boşver sonrasında ara.
	System.out.println(a+ " " + b);
	System.out.println(a.concat(b));
	System.out.println(a.replace('M','X')); 
	// Murat içerisindeki M harfini F harfi olarak değiştir.
	System.out.println(b.toLowerCase());
	System.out.println(b.toUpperCase());
	System.out.println(b);
	System.out.println(c.trim());
    }
}
