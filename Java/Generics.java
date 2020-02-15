//Generic Giris
import java.util.*; // list kullanmak için gerekmekte.
public class ana_class {
  public static void main(String[] args){
    
    //(overloaded method) aynı işi faklı veri tiplerinde
    //yapıyorlarsa o durumlarda aynı isimde methodlar kullanılabilir.
    
    Integer[] sayilar = {1,2,3,4};
    Character[] harfler = {'a','b','c','d'};
    
    ekranaYaz(sayilar);
    ekranaYaz(harfler);
    
  }
  public static void ekranaYaz(Integer[] i){
    for (Integer y: i)
      System.out.printf("%s ", y);
    System.out.println();
  }
  public static void ekranaYaz(Character[] i){
    for (Character y: i)
      System.out.printf("%s ", y);
    System.out.println();
  }

//Generic Kullanımı
import java.util.*; // list kullanmak için gerekmekte.
public class ana_class {
  public static void main(String[] args){
    
    //(overloaded method) aynı işi faklı veri tiplerinde
    //yapıyorlarsa o durumlarda aynı isimde methodlar kullanılabilir.
    
    Integer[] sayilar = {1,2,3,4};
    Character[] harfler = {'a','b','c','d'};
    
    ekranaYaz(sayilar);
    ekranaYaz(harfler);
    
  }
  // generic method farklı methodlara gerek olmadan...
    // t = TypeParametre   T[] generic method
    // T gererictir 
    public static <T> void ekranaYaz(T[] x){
      for (T y: x)
        System.out.printf("%s ", y);
      System.out.println();
    }
    // dönen datada generic tipte
}

//Generic CompareTo
import java.util.*; // list kullanmak için gerekmekte.
public class ana_class
{
  // generic class
  public static void main(String[] args)
  {
    System.out.println(enbuyuk(44,542,21));
    System.out.println(enbuyuk("elma","armut","karpuz"));
    System.out.println(enbuyuk('m','z','a'));
    
  }
  //Sadece karşılaştırılabilir tipteki veriler burada kullanılabilir.
  // o nedenle extends Comparable edilmek zorunda.
  //karşılaştırılabilir olmak şartı ile her türlü generik veri kullanılabilir.
  //hem gerekik data ile çalışabilir hemde generik datayı return ettirebiliriz.
  public static <T extends Comparable<T>> T enbuyuk(T a,T b,T c)
  {
    T m = a;
    if(b.compareTo(a)>0)
      m = b;
    if(c.compareTo(m)>0)
      m = c;
    return m;
  }
}


