// Ana Class Zamanı Formatla
//_Zaman_ve_Formatlama.java
class zaman{
    public static void main(String[] args){
	zamanli zamanliObject = new zamanli();
	System.out.println(zamanliObject.toMilitary());
	zamanliObject.zamanSet(11,22, 9);
	System.out.println(zamanliObject.toMilitary());
    }
}
// Zamanli Class’ı

public class zamanli{
    private int hour;
    private int minute;
    private int second;
    public void zamanSet(int h, int m, int s) {
	hour =((h>=0&&h<24)? h:0);
	minute =((m>=0&&m<60)? m:0);
	second =((s>=0&&s<60)? s:0);
    }
    public String toMilitary(){
    	return String.format("%02d:%02d:%02d", hour,minute,second);
    }
}

//----------Zamani_Formatla---------
public class ana_class {
    public static void main(String[] args) {
	diger bizimObject = new diger();
	System.out.println(bizimObject.toAskeri());
	bizimObject.setZaman(12,1, 9);
	System.out.println(bizimObject.toAskeri());
	System.out.println(bizimObject.toString());
    }
}


public class diger {
    private int saat;
    private int dakika;
    private int saniye;
    public void setZaman(int sa, int d, int s) {
	saat =((sa>=0&&sa<24)? sa:0);
	dakika =((d>=0&&d<60)? d:0);
	saniye =((s>=0&&s<60)? s:0);
    }
    public String toAskeri(){
	return String.format("%02d:%02d:%02d", saat,dakika,saniye);
    }
    public String toKarakter(){
	return String.format("%d:%02d:%02d %s", ((saat==0 || saat ==12)?12:saat%12), dakika, saniye, (saat<12 ? "AM":"PM"));
    }
}
