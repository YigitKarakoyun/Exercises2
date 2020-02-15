//LinkedList
import java.util.*;
class ana_class{
    public static void main(String args[]){

	//String diziyi ve ArrayListti tanımla.
	String [] meyveler = {"kiraz","muz","karpuz","kavun"};
	List<String> liste1 = new LinkedList<String>();

	//Meyveler isimli dizinin içerisindeki elemanları teker teker l
	//iste1 isimli AraryListin içerisine at.
	for (String x: meyveler) liste1.add(x);

	//2.String diziyi ve 2.ArrayListti tanımla.
	String [] dahacokmeyve = {"kivi","elma"};
	List<String> liste2 = new LinkedList<String>();

	//dahacokmeyve isimli dizinin içerisindeki elemanları teker teker 
	//liste2 isimli AraryListin içerisine at.
	for (String y: dahacokmeyve) liste2.add(y);

	// liste2 isimli ArrayListin içerisindeki bilgileri ekrana yaz.
	for (int i=0;i<liste2.size();i++){
	    System.out.printf("%s ", liste2.get(i));
	}

	//Liste2'nin içerisinekileri liste1'e at ve liste2'nin 
	//içerisindeki bilgileri boşalt.
	liste1.addAll(liste2);
	liste2 = null;
	printMe(liste1);
	removeStuff(liste1,2,5); 

	//2 ile 5 arasındaki bütün elemanları liste1'den sil.
	printMe(liste1);
	reversMe(liste1);
	printMe(liste1);
    }

    //printMe methodunun içi
    public static void printMe(List<String> l){
	for(String b: l) System.out.printf("%s ", b);
	System.out.println(); //blank line
    }

    //removeStuff methodunun içi
    public static void removeStuff(List<String> l, int from, int to){
	l.subList(from, to).clear();
    }

    //removeStuff methodunun içi
    public static void reversMe(List<String> l){
        ListIterator<String> bobby = l.listIterator(l.size());
    	while(bobby.hasPrevious()) //terse çevir
    	System.out.printf("%s ", bobby.previous()); //teker teker yazdır.
    	System.out.println(); //boş satır
    }
}

//Collections Sıralama
import java.util.*;
class ana_class{
    public static void main(String args[]){

        //String diziyi ve ArrayListti tanımla.
        String [] meyveler = {"kiraz","muz","karpuz","kavun"};

	List<String> liste1 = Arrays.asList(meyveler);

	Collections.sort(liste1);
	System.out.printf("%s \n",liste1);

	Collections.sort(liste1,Collections.reverseOrder());
	System.out.printf("%s \n",liste1);
    }
}

//LinkedList Diziye Atama
public class LinkedList {
    Node firstNode;
    public void addFirst(Node newNode){
        if(firstNode==null)
          firstNode = newNode;
        else{
          newNode.next = firstNode;
            firstNode = newNode;
        }
    }
    public void addLast(Node newNode){
        if (firstNode == null) {
          firstNode = newNode;
           System.out.println("ilk düğüm oluşturuldu." +
               firstNode.value);
        }
        else {
          Node temp = firstNode;
            while (temp != null) {
                if(temp.next==null){
                  temp.next=newNode;
                    break;
                }
                temp = temp.next;
            }
        }
    }
    public void add(Node eklenecek, Node n){
      eklenecek.next = n.next;
        n.next = eklenecek;
    }
    
    /*LinkedList'ten eleman silme*/
    public void sonDugumuSil(){
      
    //LinkedList'in boş olma durumu kontrol edilir.
        if(firstNode==null)
            System.out.println("Liste Bos");
        
     //Listede sadece bir eleman varsa onu silmemiz gerekir.
        else if(firstNode.next==null)
          firstNode=null;
        
        //listede birden fazla eleman varsa:
        else{
          
            //Listede en az iki eleman var ve en sondakini silmek istiyoruz
            //o zaman aktif düğümün iki sonrakini kontrol ederiz, eger null ise
            //aktif düğümün bir sonrakini null yaparız, böylece en son elemanla bir öncekinin
            //bağını koparmış oluruz.
          Node temp = firstNode;
            while(true){
                if(temp.next.next==null){
                  temp.next=null;
                    break;
                }
                temp = temp.next;
            }
        }
    }
    public void ilkDugumuSil(){
        if(firstNode==null)
            System.out.println("Liste Bos");
     //Listede sadece bir eleman varsa onu silmemiz gerekir.
        else {
          firstNode = firstNode.next;
        }
    }
    public void dugumSil(Node silinecek){
      Node temp = firstNode;
      
        //Eger ilk düğüm silinmek isteniyorsa;
        if(temp==silinecek)
          firstNode = firstNode.next;
        //aradaki herhangi bir düğüm silinmek isteniyorsa;
        while(temp!=null){
            if(temp.next!=silinecek)
              temp = temp.next;
            else{
              temp.next = temp.next.next;
            }
        }
    }
    
    public void listeYazdir(){
      Node temp = firstNode;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        LinkedList b = new LinkedList();
        b.ilkDugumuSil();
        
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        b.addLast(n1);
        b.listeYazdir();
        
        //İlk düğümü silelim
        b.ilkDugumuSil();
        System.out.println("İlk düğüm silindi");
        b.addLast(n2);
        b.addLast(n3);
        b.addLast(n4);
        b.listeYazdir();
        
        Node n5 = new Node(7);
        b.addFirst(n5);
        System.out.println("En basa 7 eklendi");
        b.listeYazdir();
        Node n6 = new Node(12);
        //n6`yi n3`ten sonraya eklemek icin
        System.out.println("3 ten sonra 12 eklendi");
        b.add(n6, n3);
        b.listeYazdir();
        b.sonDugumuSil();
        System.out.println("Son dugum silindi");
        b.listeYazdir();
        System.out.println("2. dugumu silelim");
        b.dugumSil(n2);
        b.listeYazdir();
    }
}
public class Node{
    int value;
    Node next;
    public Node(int n, Node no){
      value = n;
        next = no;
    }
    public Node(int n){
      value = n;
        next = null;
    }
}

//LinkedList Diziye Atama
import java.util.*;
class ana_class{
    public static void main(String args[]){
	//String diziyi ve ArrayListti tanımla.
	String [] meyveler = {"kiraz","muz","karpuz","kavun"};
	LinkedList<String> liste1 = new LinkedList<String>(Arrays.asList(meyveler));
	
	// liste1'e ekleme
	liste1.add("elma");
	liste1.addFirst("armut");
	
	// linklisti diziye çevirme
	meyveler = liste1.toArray(new String [liste1.size()]);
	for(String x: meyveler) System.out.printf("%s ",x); //dizi
    }
}

