//
public class ana_class {
    public static void main(String[] args) {
      
        Thread t1 = new Thread(new diger("bir"));
        Thread t2 = new Thread(new diger("iki"));
        Thread t3 = new Thread(new diger("üç"));
        Thread t4 = new Thread(new diger("dört"));
      
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


import java.util.*;
//Runnable interface contains run() method
// Video yükle ve izle gibi.
// Thread için Runnable implements edilmeli.
public class diger implements Runnable{
    String name;
    int time;
    Random r = new Random();
    
    public diger(String x){
        name = x;
        time = r.nextInt(999); //between 0-1 second
    }
    
    //this runs when you start thread
    public void run(){
        try{
            System.out.printf("%s . numaralı threet, %d sanise uyuduktan sonra çalıştı\n", name, time);
            Thread.sleep(time); //Thread'in ne kadar uyumasını istersin?
            System.out.printf("%s thread işini tamamladı\n", name);
        }catch(Exception e){}
    }
}
–

/*Örnek Ekran çıktısı

üç . numaralı threet, 665 sanise uyuduktan sonra çalıştı
iki . numaralı threet, 726 sanise uyuduktan sonra çalıştı
bir . numaralı threet, 448 sanise uyuduktan sonra çalıştı
dört . numaralı threet, 244 sanise uyuduktan sonra çalıştı
dört thread işini tamamladı
bir thread işini tamamladı
üç thread işini tamamladı
iki thread işini tamamladı*/

//
public class Main {
    public static void main(String[] args) {
      Threads i1 = new Threads();
      Threads i2 = new Threads();
      Threads i3 = new Threads();
      Threads i4 = new Threads();
        long baslangıc = System.currentTimeMillis();
        i1.start();
        i2.start();
        i3.start();
        i4.start();
        long bitis = System.currentTimeMillis();
        System.out.println("Gecen Zaman = " +
                (bitis - baslangıc));
    }
}
class Threads extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.getName() + " : " + i);
            try {
                //2 sn uyu
                this.sleep(2000);
            } catch (Exception e) {}
        }
    }
}

//
/*
 * Dizideki en büyük değer 2 şekilde bulunur:
 * 1. Ana class içinde yer alan metot aracılığıyla bulunur.
 * 2. Bulma işi parçalara bölünür, thread'lere yaptırılır.
 * İki durum için de performanslar ortaya konur.
 */
import java.util.Random;
public class Maximum {
    public int maxBul(int[] dizi){
        int max = dizi[0];
        for (int i = 0; i < dizi.length; i++) {
            if(dizi[i]>max)
                max = dizi[i];
            
            sleep(1);
        }
        return max;
    }
    public void sleep(int ms){
        try {
        Thread.sleep(ms);
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
      Maximum m = new Maximum();
        //1000 elemanlı ve her elemani 0 ile 200 arasinda
        //rasgele bir sayi olan bir dizi olusturup icini
        //dolduralim
        int[] dizi = new int[1000];
        Random r = new Random();
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = r.nextInt(200);
        }
        // maxBul metodunun ne kadar zamanda bulduğunu hesaplayalim
        System.out.println("maxBul METODU");
        long start  = System.currentTimeMillis();
        System.out.println("EnBuyuk -> " + m.maxBul(dizi));
        long finish = System.currentTimeMillis();
        System.out.println("maxBul metodunun bulma süresi " + (finish-start) + " ms");
        //Problemi parçalara bölüp thread'lere aratalım.
        MaxThread t1 = new MaxThread(dizi, 0, 200);
        MaxThread t2 = new MaxThread(dizi, 200, 400);
        MaxThread t3 = new MaxThread(dizi, 400, 600);
        MaxThread t4 = new MaxThread(dizi, 600, 800);
        MaxThread t5 = new MaxThread(dizi, 800, 1000);
        System.out.println("");
        System.out.println("THREAD");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
class MaxThread extends Thread{
    int s, f;
    int[] a;
    public MaxThread(int[] array,
            int start,
            int finish){
        a = array;
        s = start;
        f = finish;
    }
    public void run(){
        long start  = System.currentTimeMillis();
        enBuyuk();
        long finish = System.currentTimeMillis();
        System.out.println(this.getName() + " " + (finish-start) + " ms");
    }
    public int enBuyuk(){
        int max = a[0];
        for (int i = s; i < f; i++) {
            if(a[i]>max)
                max = a[i];
            try {
                this.sleep(2);
            } catch (Exception e) {
            }
        }
        return max;
    }
}
