# SORU
    Asal sayi bulan programı yazınız.

# KODU 1

    #include <stdio.h>
    #include <stdlib.h>

    int main()
    {
        int i, j;
        for(i=2;i<50;i++)
        {
          for(j=2;j<i;j++)
          {
            if(i % j == 0)
            break;
          }
          if(i == j)
          printf("asal sayi:%d\n",i);
        }
        return 0;
    }

# KODU 2

    #include <stdio.h>
    #include <stdlib.h>

    int main()
    {
        int i=2, j;
        do{
          j = 2;
          do{
              if(i % j == 0)
              break;
              
              j++;
          }while(j<i);
        
          if(i == j)
          printf("asal sayi:%d\n",i);
        
          i++;
        }while(i<50);
        

        return 0;
    }
    
# SONUCLARI
    asal sayi:2
    asal sayi:3
    asal sayi:5
    asal sayi:7
    asal sayi:11
    asal sayi:13
    asal sayi:17
    asal sayi:19
    asal sayi:23
    asal sayi:29
    asal sayi:31
    asal sayi:37
    asal sayi:41
    asal sayi:43
    asal sayi:47



        