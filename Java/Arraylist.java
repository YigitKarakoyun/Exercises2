//Arraylist
import java.util.*;
class ana_class{
public static void main(String args[])
{
    //String diziyi ve ArrayListti tanımla.
    String [] meyveler = {"kiraz","muz","karpuz","kavun"};
    List<String> liste1 = new ArrayList<String>();

    //Meyveler isimli dizinin içerisindeki elemanları teker teker 
    //liste1 isimli AraryListin içerisine at.
    for (String x: meyveler) liste1.add(x);

    //2.String diziyi ve 2.ArrayListti tanımla.
    String [] dahacokmeyve = {"kivi","elma"};
    List<String> liste2 = new ArrayList<String>();
   
    //dahacokmeyve isimli dizinin içerisindeki elemanları teker teker 
    //liste2 isimli AraryListin içerisine at.
    for (String y: dahacokmeyve) liste2.add(y);

    // liste2 isimli ArrayListin içerisindeki bilgileri ekrana yaz.
    for (int i=0;i<liste2.size();i++){
	System.out.printf("%s ", liste2.get(i));
    }
}
}

//ArrayList2
import java.util.*;
class ana_class{
    public static void main(String args[]){
	
	//String diziyi ve ArrayListti tanımla.
	String [] meyveler = {"kiraz","muz","karpuz","kavun"};
	List<String> liste1 = new ArrayList<String>();

	//Meyveler isimli dizinin içerisindeki elemanları teker teker 
	//liste1 isimli AraryListin içerisine at.
	for (String x: meyveler) liste1.add(x);

	//2.String diziyi ve 2.ArrayListti tanımla.
	String [] dahacokmeyve = {"kivi","elma"};
	List<String> liste2 = new ArrayList<String>();

	//dahacokmeyve isimli dizinin içerisindeki elemanları teker teker 
	//liste2 isimli AraryListin içerisine at.
	for (String y: dahacokmeyve) liste2.add(y);

	// liste2 isimli ArrayListin içerisindeki bilgileri ekrana yaz.
	for (int i=0;i<liste2.size();i++){
	    System.out.printf("%s ", liste2.get(i));
	}

	// liste1 isimli ArrayListin içerisindeki bilgileri ekrana yaz.
	for (int i=0;i<liste1.size();i++){
	    System.out.printf("%s ", liste1.get(i));
	}
	System.out.println("\n");
	farkliolanibul(liste1,liste2);
	System.out.println("Liste1 de olp Liste2 de olmayanlar:");
	//print out list1
	for (int i=0;i<liste2.size();i++){
	    System.out.printf("%s  ", liste1.get(i));
	}
    }
    public static void farkliolanibul(Collection<String> l1,Collection<String> l2){
        Iterator<String> it = l1.iterator(); 
        //listte içerisindeki elemanların her birine Collection içerisinde
	//erişim için kullanılabilir.
        while(it.hasNext()){  //teker teker ekle
            if(l2.contains(it.next()))
        it.remove(); //eğer liste1 de varsa çıkar
        }
    }
}

//3_ArrayListte_Metod
import java.util.ArrayList;
import java.util.Iterator;
    public class Main {
        public static void main(String[] args) {
            ArrayList a1 = new ArrayList();
            a1.add("A");
            a1.add("B");
            a1.add("C");
            a1.add("D");
            a1.add("E");
            a1.add("F");
            a1.add("G");
            System.out.println(a1);
            a1.remove(5);
            System.out.println(a1.get(5));
            System.out.println(a1.indexOf("B"));
            System.out.println(a1.isEmpty());
            System.out.println(a1.contains("F"));
            // a1.clear();
            System.out.println(a1.isEmpty()); // true
            System.out.println(a1);
            Iterator itr = a1.iterator();
            while(itr.hasNext()) {
                 System.out.print(itr.next() + " ");
                 itr.remove();
            }     
        }
    }
}

//4_ArrayList_Karakterler
import java.util.*;
class ana_class{
    public static void main(String args[]){
	//karakter dizisini oluştur ve Listtenin içerisine at
	Character[] meyve1 ={'k','i','v','i'};
	List<Character> liste1 = Arrays.asList(meyve1); //listi diziye çevir.

	System.out.println("Meyvenin Adı : ");
	output(liste1);
	
	//tersine çevir ve ekrana yaz
	Collections.reverse(liste1);
	System.out.println("Testten yazılışı: ");
	output(liste1);

	//Yeni bir dizi ve liste tanımla
	Character[] meyve2 = new Character[4];
	List<Character> liste2 = Arrays.asList(meyve2);

	//liste1 deki verileri liste2 ye atarak kopyalama
	Collections.copy(liste2,liste1);

	System.out.println("Liste2'nin kopyalandıktan Sonraki hali: ");
	output(liste2);

	// liste 1 i X harfi ile doldur eski veriler silinecektir.
	Collections.fill(liste1, 'X');
	System.out.println("Listeyi X harfi ile doldurduktan sonraki hali: ");
	output(liste1);
    }
    
    // output methodunun içi
    public static void output(List<Character> thelist){
	for(Character thing: thelist)
	    System.out.printf("%s ",thing);
	System.out.println();
    }
}

//5_ArrrayList_Ekleme
import java.util.*;
class ana_class{
    public static void main(String args[]){
	//String diziyi ve ArrayListti tanımla.
	String [] meyveler = {"kiraz","muz","karpuz","kavun"};
	List<String> liste1 = Arrays.asList((meyveler));

	ArrayList<String> liste2 = new ArrayList<String>();
	liste2.add("elma");
	liste2.add("kivi");
	liste2.add("portakal");

	for(String x: liste2) System.out.printf("%s ",x); //dizi
	// meyveler dizisinde bulunan elemanları liste2 nin içerisine ekle.
	
	System.out.println("\n");
	Collections.addAll(liste2,meyveler);
	for(String x: liste2) System.out.printf("%s ",x); //dizi
    }
}

//6_Frequency
import java.util.*;
class ana_class{
    public static void main(String args[]){

	//String diziyi ve ArrayListti tanımla.
	String [] meyveler = {"kiraz","muz","karpuz","kavun"};
	List<String> liste1 = Arrays.asList((meyveler));

	ArrayList<String> liste2 = new ArrayList<String>();
	liste2.add("elma");
	liste2.add("kivi");
	liste2.add("portakal");

	for(String x: liste2) System.out.printf("%s ",x); //dizi
	// meyveler dizisinde bulunan elemanları liste2 nin içerisine ekle.

	System.out.println("\n");
	Collections.addAll(liste2,meyveler);

	for(String x: liste2) System.out.printf("%s ",x); //dizi
	//frequency liste içerisinde aranan elemanın kaç tane olduğu 
	//bilgisini döndürür.
	
	System.out.println(Collections.frequency(liste2, "elma"));
	boolean tof = Collections.disjoint(liste1, liste2);
	System.out.println(tof);
	
	//ortak kayıt varmı yokmu? liste2 nin içerisine liste1 eklendiği için
	// Collections.addAll(liste2,meyveler); kodu ile ortak kayıt var.
	if(tof) System.out.println("2 liste arasında ortak bir kayıt yok");
	else System.out.println("2 liste arasında ortak kayıt var!");
    }
}





