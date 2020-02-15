import java.util.*;
class ana_class{
    public static void main(String args[]){
	PriorityQueue<String>q = new PriorityQueue<String>();
	q.offer("ilk");
	q.offer("ikinci");
	q.offer("ücüncü");
	System.out.printf("%s ",q);
	System.out.println();

	// en yüksek öncelik olanı yazdıracak.
	// ilk yazılan en yüksek öneme sahip.
	System.out.printf("%s ",q.peek());
	System.out.println();
	
	// Otomatik olarak en önemli olanı kuyruktan çeker. ilk giren en önemli.
		
	q.poll();
	System.out.printf("%s ",q);
	System.out.println();
	
	q.poll();
	System.out.printf("%s ",q);
	System.out.println();
    }
}
