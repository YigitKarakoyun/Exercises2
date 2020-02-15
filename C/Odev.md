# ODEV
![c odev](https://user-images.githubusercontent.com/56600057/67899162-c5823880-fb72-11e9-82a4-dfb3eae5e2a0.PNG)

# KODU
    #include <stdio.h>

    int main ()
    {

      /* local variable definition */
      printf ("--------------MUHTEŞEM YAZILIM--------------\n");
      int n, m, toplam = 0, i, j;
      printf ("N degerini giriniz:");
      scanf ("%d", &n);
      printf ("M degerini giriniz:");
      scanf ("%d", &m);
      printf ("--------------HESAPLAMALAR--------------\n");
      i = 1;
      do
        {
          j = 1;

          do
      {
        int degeri = (i * i) + (j * j) + (2 * i * j);
        printf ("i:%d, j:%d, sonuc:%d\n", i, j, degeri);
        toplam += degeri;
        j++;
      }
          while (j <= m);

          i++;
        }
      while (i <= n);

      printf ("--------------SONUÇ--------------\n");
      printf ("Toplam değeri: %d", toplam);
      return 0;
    }
    
# SONUCU
        --------------MUHTEŞEM YAZILIM--------------
        N degerini giriniz:3
        M degerini giriniz:4
        --------------HESAPLAMALAR--------------
        i:1, j:1, sonuc:4
        i:1, j:2, sonuc:9
        i:1, j:3, sonuc:16
        i:1, j:4, sonuc:25
        i:2, j:1, sonuc:9
        i:2, j:2, sonuc:16
        i:2, j:3, sonuc:25
        i:2, j:4, sonuc:36
        i:3, j:1, sonuc:16
        i:3, j:2, sonuc:25
        i:3, j:3, sonuc:36
        i:3, j:4, sonuc:49
        --------------SONUÇ--------------
        Toplam değeri: 266
