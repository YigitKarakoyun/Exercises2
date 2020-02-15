//IF
class apples{
    public static void main(String args[]){
	//Scanner bucky = new Scanner(System.in);
	int test=6;
	if(test == 9){ //try < <= > >= !=
	    System.out.println("yes");
        }
	else{ System.out.println("this is else");}
    }
}

//İÇ İÇE İF
class yas_hesabi{
    public static void main(String[] args){
	int yas= 60;
	if (yas < 50){ System.out.println("Gencsin");}
	else{
	    System.out.println("Yaslisin");
	    if (yas > 75){S ystem.out.println("Gerçekten yaslisin!"); } 
	    else { System.out.println("Endiselenme o kadar yasli degilsin");}
	}
    }
}

//İÇ İÇE İF ELSE
import java.util.Scanner;
class yas_hesabi{
    public static void main(String[] args){
	int yas = 55;
	if (yas >= 60) System.out.println("Kidemli Vatandas");
	else if (yas >= 50) System.out.println("50 lerindesin");
	else if (yas >= 40) System.out.println("40 larındasin");
	else System.out.println("Gençsin");
    }
}

//TEK SATIR İF
class yas_hesabi{
    public static void main(String[] args){
	int yas = 41;
	System.out.print(yas > 50 ? "Yaşlısın" : "Gençsin");
    }
}

//SWITCH CASE ORNEGI
// Yaşa göre içerik oluştur.
class ana{
    public static void main(String args[]){
	int age;
	yas = 3;
	switch (yas){
	    case 1:System.out.println("Ağlayabilirsin ");break;
	    case 2:System.out.println("Konuşabilirsin");break;
	    case 3:System.out.println("Belaya bulaşabilirsin");break;
	    default:System.out.println("Kaç yasindasin bilmiyorum!");break;
        }
    }
}



