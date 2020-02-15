//
public void diziYazdir(int[] array){
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
    System.out.println("");
}

//
public int[] bubbleSort(int [] array){
    int n = array.length;
    for (int i=1; i < n; i++) 
    {
      //Elemanlar ikiser ikiser karşılaştırılıp küçük olan sol tarafa alınıyor.
        for (int j=0; j < n-1; j++) {
            if (array[j] > array[j+1]) {
                
              //elemanların yeri değiştiriliyor.
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
    return null;
}

//
public static void insertionSort(int array[]){
    int n = array.length;
    for (int i = 1; i < n; i++){
      int j = i;
      int temp = array[i];
      while ((j > 0) && (array[j-1] > temp)){
        array[j] = array[j-1];
        j--;
      }
      array[j] = temp;
    }
  }

//
public int[] selectionSort(int[] array){
    for (int i=0; i<array.length-1; i++) {
        for (int j=i+1; j<array.length; j++) {
            if (array[i] > array[j]) {
              //elemanların yeri değiştiriliyor.
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    return null;
}

//
import java.util.Random;
public class Arama {
public int[] diziOlustur(int boyut){
    int array[] = new int[boyut];
    Random r = new Random();
    for (int i = 0; i < array.length; i++) 
    {
      array[i] = r.nextInt(100);
    }
    return array;
}
public void diziYazdir(int[] array){
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
    System.out.println("");
}
public int[] bubbleSort(int [] array){
    int n = array.length;
    for (int i=1; i < n; i++) 
    {
      //Elemanlar ikiser ikiser karşılaştırılıp küçük olan sol tarafa alınıyor.
        for (int j=0; j < n-1; j++) {
            if (array[j] > array[j+1]) {
                
              //elemanların yeri değiştiriliyor.
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
    return null;
}
//Sırasıyla herbir eleman ile dizinin geri kalanı karşılaştırılıp eldeki elemandan 
//daha küçük biri bulununca ikisinin yeri degistiriliyor.
public int[] selectionSort(int[] array){
    for (int i=0; i<array.length-1; i++) {
        for (int j=i+1; j<array.length; j++) {
            if (array[i] > array[j]) {
              //elemanların yeri değiştiriliyor.
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    return null;
}
  public static void insertionSort(int array[]){
      int n = array.length;
    for (int i = 1; i < n; i++){
      int j = i;
      int temp = array[i];
      while ((j > 0) && (array[j-1] > temp)){
        array[j] = array[j-1];
        j--;
      }
      array[j] = temp;
    }
  }
    public static void main(String[] args) {
      Arama a = new Arama();
        //Bubble Sort
        System.out.println("BUBBLE SORT");
        int [] dizim = a.diziOlustur(10);
        System.out.println("Sırasız dizi");        
        a.diziYazdir(dizim);
        a.bubbleSort(dizim);
        System.out.println("Sıralı dizi");
        a.diziYazdir(dizim);
        System.out.println("");
        //Selection Sort
        System.out.println("SELECTION SORT");
        dizim = a.diziOlustur(10);
        System.out.println("Sırasız dizi");  
        a.diziYazdir(dizim);
        a.selectionSort(dizim);
        System.out.println("Sıralı dizi");
        a.diziYazdir(dizim);
        System.out.println("");
        //Insertion Sort
        System.out.println("INSERTION SORT");
        dizim = a.diziOlustur(10);
        System.out.println("Sırasız dizi");  
        a.diziYazdir(dizim);
        a.insertionSort(dizim);
        System.out.println("Sıralı dizi");
        a.diziYazdir(dizim);
    }
}
