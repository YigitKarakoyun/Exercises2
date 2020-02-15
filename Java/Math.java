//
class matematik{
public static void main(String[] args){
    System.out.println(Math.ceil(7.3));
    // try Math.abs(-26.7)
    // try Math.floor(8.4)
    // try Math.max(7.6,5.2)
    // try Math.min(7.6,5.2)
    // try Math.pow(6,3)
    // try Math.sqrt(16)
    }
}

//
class faiz_hesabi{
public static void main(String[] args){
    double miktar;
    double taban = 10000;
    double oran = .01;
    for (int gun=1; gun <=20;gun++){
        miktar = taban*Math.pow(1+oran,gun);
        System.out.println(gun + ". sonra  " + miktar);
        }
    }
}

//
class ana_class{
public static void main(String args[]){
    System.out.println(faktoriyel(23));
}

//Factöriyel hesabı
public static long faktoriyel(long n){
    if( n <=1 ) return 1;
    else return n * faktoriyel(n-1);
    }
}

//
import java.util.Random;
class random_sayi{
    public static void main(String[] args){
        Random zar = new Random();
        int sayi;
        for(int sayac=1; sayac<=10;sayac++){
            //Zarda 0 sayısı olmadığından her seferinde 1 arttır.
            sayi = 1+ zar.nextInt(6);  //try 10
            System.out.println(sayi + " ");
        }
    }
}

//
import java.util.Random;
class apples{
public static void main(String[] args){
    Random rast = new Random();
    int frekans[] = new int[7]; //0 dan başladığı için 7 tane
    for (int atma=1;atma<1000;atma++){ // zarda 0 olmadığı için 1 den başlıyoruz.
        ++frekans[1+rast.nextInt(6)];  
	//her seferinde gelen sayı dizinin ilgili indexine artı 1 olarak eklenir.
    }
    System.out.println("Face\t Frequency");
    for (int sira=1;sira<frekans.length;sira++){
        System.out.println(sira+ "\t" +frekans[sira]);
    }
}

//
class deneme{
public static void main(String[] args){
    System.out.println(ortalama(43,34,45,56,7));
}
public static int ortalama(int...sayilar){
    int toplam=0;
    for(int x:sayilar)
        toplam+=x;
    return toplam/sayilar.length;
    }
}

