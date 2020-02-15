import java.util.*;
class ana_class{
public static void main(String args[]){
    //String diziyi ve ArrayListti tanımla.
    String [] meyveler = {"kiraz","muz","karpuz","kavun","karpuz","kavun","kiraz"}; 
  
    List<String> liste = Arrays.asList(meyveler);
    // Bütün bir listeyi yazdır aynı deyerler olsada

    System.out.printf("%s ",liste);
    System.out.println();
    // tekrarlananları göz ardı ederek listeyi tekrardan yaz.

    //HashSet sayesinde.
    Set<String> set = new HashSet<String>(liste);
    System.out.printf("%s ", set);
    }
}
