//
// While kullanımı.
class ana_sayac{
    public static void main(String args[]){
	int say=0;
	while (say <10){
	    System.out.println(say);
	    say++;
	}
    }
}

//
import java.util.Scanner;
class ortalama{
    public static void main(String[] args){
	Scanner giris = new Scanner(System.in);
	int toplam = 0;
	int grade;
	int ortalama;
	int sayac = 0;
	while (sayac <10){
	    grade = giris.nextInt();
	    toplam += grade ;
	    sayac++;
	}
	ortalama = toplam/10;
	System.out.println("Girilen on sayının ortalaması " + ortalama);
    }
}

//
class do_while_dongusu{
    public static void main(String[] args){
	int sayac=0;
	do {
	    System.out.println(sayac);
	    sayac++;
	}while (sayac <=10);
    }
}

//
class for_dongusu{
    public static void main(String[] args){
	for (int sayac=1; sayac <=10;sayac++){
	    System.out.println(sayac);
	}
    }
}

//
public class Main {
    public static void main(String[] args) {
        for(int a = 10; a > 0; a--){
            int b;
            for(b = 0; b < a; b++){
                System.out.print(" ");
            }
            for (int j = b; j < 10; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}

//
public class Main {
    public static void main(String[] args) {
        forRepeat(2, 2);
        System.out.println();
        forRepeat(3, 3);
        System.out.println();
        forRepeat(4, 4);
        System.out.println();
        forRepeat(5, 5);
    }
    static String repeat(int k){
        return k > 0 ? repeat(k - 1) + "*" : "";
    }
    static String space(int k){
        return k > 0 ? space(k - 1) + " " : "";
    }
    static void forRepeat(int i, int k){
        if(i > 0){
            forRepeat(i - 1, k);
            System.out.println(
                      repeat(i)
                    + space((2 * k + 1) - 2 * i)
                    + repeat(i)
                    + space(1)
                    + repeat((k + 1) - i)
                    + space(2 * i - 1)
                    + repeat((k + 1) - i));
        }
    }
}

//
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



