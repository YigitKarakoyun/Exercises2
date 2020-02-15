
//-----------------------JUNIT----------------------------------
Java’da diğer pek çok programlama dilinde olduğu gibi test kodları yazılarak (white box testing), geliştirilen programın kodları test edilebilir . Java kodlarını test etmek için farklı araçlar bulunsa da. Temel anlamda Java’da  test için kullanılacak en iyi araç JUnit dir. Aşağıda bir kodun nasıl test edildiği ile ilgili bir örnek adım adım anlatılarak verilmiştir.

1.adım ana kodu yazın (Java Class).

package testing;
public class JunitTesting {
  public int square(int x) {
    return x*x;
  }
  public int countA(String word){
    int count=0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i)=='a' || word.charAt(i)== 'A') {
        count++;
      }
    }
    return count;
  }
}
 

2.adım squareTest isimli (JUnit classını ekleyin)

Package’in üzerine gelip sağ click yapın. Açılan ekranda New->JUnitTestCase seçeneğini tıklayın. Açılan ekranda class ismi olarak squareTest olarak girip OK butonuna tıklayın. Yazılacak kod aşağıda verilmiştir.

package testing;
import static org.junit.Assert.*;
import org.junit.Test;
public class squareTest {
  @Test
  public void test() {
    JunitTesting test = new JunitTesting();
    int output= test.square(5);
    assertEquals(25,output);
  }
}
 

3.adım countAtest isimli (JUnit classını ekleyin)

Package’in üzerine gelip sağ click yapın. Açılan ekranda New->JUnitTestCase seçeneğini tıklayın. Açılan ekranda class ismi olarak countAtest olarak girip OK butonuna tıklayın. Yazılacak kod aşağıda verilmiştir.

package testing;
import static org.junit.Assert.*;
import org.junit.Test;
public class countAtest {
  @Test
  public void test() {
    JunitTesting test = new JunitTesting();
    int output= test.countA("alphabet");
    // alphabet yazısında 2 tane a olduğu için beklenen sonuç 2 olmalı.
    assertEquals(2,output);
  }
}
4.adım testleri teker teker çalıştırma

Aktif olan testti seçip testti çalıştırın. squareTest isimli classta beklenen değer 5 in karesi için 25 olduğundan ilk test başarı ile çalışacaktır. assertEquals(25,output);

5.adım testleri çoklu çalıştırın. (Alltests.Java)

Package’in üzerine gelip sağ click yapın. Açılan ekranda New->Other->Java->JUnit->JUnitTest Suite seçeneğini tıklayın. Açılan ekranda package kısıma testing yazın. Aşağıda daha önceden yazdığımız iki test kodu çıkacaktır.  Finish isimli butona tıkladıktan sonra testleri toplu olarak çalıştırmamıza yarayan kod otomatik olarak oluşturulacaktır. Bu kod ayrıca aşağıda verilmiştir.

package testing;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses({ countAtest.class, squareTest.class })
public class AllTests {
}
Proje Alltests isimli class seçipip sağ click yapılıp Run As-> JUnit Test menüleri seçilerek çalıştırıldığında çıkacak ekran aşağıda verilmiştir. Aşağıdaki ekranda programın yazılan 2 farklı testtende başarı ile geçtiği görülmektedir. (Yeşil barlar ve yeşil onay işaretleri)
//--------------------------------ADRESLER---------------------------------
//http://javayaz.com/?p=1362
//https://www.youtube.com/watch?time_continue=8&v=I8XXfgF9GSc
