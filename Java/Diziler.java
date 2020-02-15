//1_Diziler_Giris
class diziler{
    public static void main(String[] args){
	int a[]= new int[10];
	int b[] = {2,4,5,7,9};
	a [0] = 87;
	a [1] = 543;
	a [9] = 65;
	System.out.println(a[1]);
	System.out.println(a[9]);
	System.out.println(b[2]);
	System.out.println(a[1]);
    }
}

//2_Dizilerden_Tablo
class dizi_tablo{
    public static void main(String[] args){
	System.out.println("Sırası\tDegeri");
	int a[] = {12,45,32,12,18,54,2};
	for (int sayac=0;sayac<a.length;sayac++){
	    System.out.println(sayac + "\t" + a[sayac]);
	}
    }
}

//3_Dizinin_Sayilarini_Topla
class dizi_topla{
    public static void main(String[] args){
	int a[] = {32,12,18,54,2};
	int toplam=0;
	for (int sayac=0;sayac<a.length;sayac++){
	    toplam+=a[sayac];
	}
	System.out.println("Sayıların Toplamı " + toplam);
    }
}

//4_Dizinin_Toplami
class zengin_for{
    public static void main(String[] args){
	int dizi[] = {3,4,5,6,7};
	int toplam=0;
	for (int x: dizi){toplam +=x;}
    	
	// Dizinin toplamını ekrana yazan
    	System.out.println(toplam);
    }
}

//5_Dizi_ve_Metodlar
class dizi_method{
    public static void main(String[] args){
	int dizi[] = {3,4,5,6,7};
	change(dizi);
	for(int y:dizi) System.out.println(y);
    }
    public static void change(int x[]){
	for(int sayac=0;sayac<x.length;sayac++) x[sayac]+=5;
    }
}

//6_Cok_Boyutlu_Dizi
class cok_dizi{
    public static void main(String[] args){
	int ilkdizi[][]={{8,9,10,11},{12,13,14,15}};  // [] ilk satır [] ikinci sutun
	int ikincidizi[][]={{30,31,32,33},{43},{4,5,6}};
    }
}

//7_Cok_Boyulu_Dizi2
class cok_boyut{
    public static void main(String[] args){
	int ilkdizi[][]={{8,9,10,11},{12,13,14,15}};  // [] ilki satır [] ikinci sutun
	int ikincidizi[][]={{30,31,32,33},{43},{4,5,6}};
	System.out.print("ilk diziyi ekrana yaz \n");
	goster(ilkdizi);
	System.out.print("ikinci diziyi ekrana yaz \n");
	goster(ikincidizi);
    }
    public static void goster(int x[][]){
	for(int satir=0;satir<x.length;satir++){
	    for(int sutun=0;sutun<x[satir].length;sutun++){
		System.out.print(x[satir][sutun] + "\t");
            }
	    System.out.println();
    	}
    }
}


