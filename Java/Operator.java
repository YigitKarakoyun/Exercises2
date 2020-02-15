//
class apples
{
    public static void main(String args[]){
	int girls,boys,peoples; //try with double
	girls= 6;
	boys = 3;
	peoples = girls + boys; //try with - % * /
	System.out.println("All Peoples: " + peoples);
    }
}

//
// &&AND || OR kullanımı
class yas{
    public static void main(String args[]){
	int yas;
	yas =21;
	if(yas>10 && yas<21){ //try ||
	    System.out.println("Çok gençsin");
	}
	else{ System.out.println("Tamam yeteri kadar büyüksün!"); }
    }
}

//
class apples{
    public static void main(String args[]){
	int tuna=5,bass=15;
	++tuna;
	bass++;
	tuna = bass + 5;
	bass *= 8;
	System.out.println(tuna);
	System.out.println(bass);
    }
}
