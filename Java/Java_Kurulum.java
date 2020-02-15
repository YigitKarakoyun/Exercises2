//Installing JDK
JDK Download

java.sun.com
Java SE (Standart Editation)

İşletim Sistemi Örnek:
Windows işletim sistemi için
32Bit Windows kullananlar x84
64Bit Windows kullananlar x86 olan dosyayı indirmesi gerekiyor.

1-) jdk dizinini kopyala
Örnek:
C:\Program Files\Java\jdk versiyonu\bin

2-) jdk’nın çalışması için yeni Path oluştur

My Computer->Control Panel->
System and Maintance->Advanced System Settings->
Advanced->Enviroment Variable->
New User Variable->
Variable name = Path
Variable value = Kopyalanan jdk dizinini yapıştır.
Ok ile ekranları kapat.

3-) Search->cmd (Ms Dos)

javac (Java Compiler) yüklenmişse
javac komutları cmd ekranında listelenecektir.

//RUNNING A JAVA PROGRAM
//DOSYA ISMIYLE CLASS ISMI AYNI OLMALI
class ana{
    public static void main(String args[]){
	System.out.printf("Merhaba Dünya!");
    }
}
 

Java Kodu Derleme
Cmd ekranında aşağıdaki kodları yazarak çalıştırabilirsiniz.

Örnek
Yazılan kodun dizinini bulup dosyaadı ve java dosya uzantısının bilgisini giriniz.
javac deneme.java
java ana


//DOWNLOADING ECLIPSE
Download Eclipse

eclipse.org ->Download->
Eclipse IDE for Java EE Developers->Extract All->
Exlipse.exe->Short Cut to Desktop

File->New->Java Project->Project Name-> Proje ismi (Örnek:bucky)

Sol taraftaki Pack ekranında proje ismini bulun.
Sağ click->New->Class->Class Name Örnek:apples

//DEBUG SHORTCUTS
//DEBUG
http://javayaz.com/?p=1350

//SHORTCUTS
http://javayaz.com/?p=1355


