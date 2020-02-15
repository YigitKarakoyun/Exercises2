#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    //TANIMLAMALAR
    int parti_sayisi = 8;
    int il_sayisi = 5;

    int iller[il_sayisi];
    char parti_isimleri[parti_sayisi];

    int illerin_mv_sayilari[parti_sayisi];

    int illerin_gecerlioylarin_toplami[il_sayisi];
    int illerin_gecerlioy_sayilari[il_sayisi][parti_sayisi];
    double illerin_parti_oy_yuzdeleri[il_sayisi][parti_sayisi];
    int illerin_partilere_gore_mv_sayilari[il_sayisi][parti_sayisi];

    //İLLERİN GEÇERLİ OYLARIN TOPLAMI
    for(int i=0;i<il_sayisi;i++){
        illerin_gecerlioylarin_toplami[i]=0;
    }


    //İLLER TANIMLAMA
    for(int i = 1; i < il_sayisi+1; i++ ) {
		iller[ i-1 ] = i;

	}

	//İLLER YAZDIRMA
	printf("IL PLAKA KODLARI");
	printf("\n");
	for(int i = 0; i < il_sayisi; i++ ) {
		printf( "%d ", iller[ i ] );
	}

	//PARTİLERİ TANIMLAMA
    for(char i = 65; i < 65+parti_sayisi; i++ ) {
        parti_isimleri[ i-65 ] = (char)i;
	}

	//PARTİLERİ YAZDIRMA
	printf("\n\n");
	printf("PARTI ISIMLERI");
	printf("\n");
	for(int i = 0; i < parti_sayisi; i++ ) {
		printf( "%c ", parti_isimleri[ i ] );
	}
    printf("\n\n");

    //İLLERE GÖRE MİLLET VEKİLİ SAYILARINI ALMA
    for(int i = 0; i < il_sayisi; i++ ) {
		printf( "%d numarali plakali ilin millet vekili sayisini giriniz: ", i+1 );
		scanf( "%d", &illerin_mv_sayilari[ i ]);
	}

	//MİLLET VEKİLLERİ SAYILARINI İLLERE GÖRE YAZDIRMA
	printf("\n\n");
	printf("ILLERIN MILLET VEKILLERI SAYILARI");
	printf("\n");
	for(int i = 0; i < il_sayisi; i++ ) {
		printf( "%d ", illerin_mv_sayilari[ i ] );
	}





	//İLLERİN PARTİLERE GÖRE GEÇERLİ OY SAYILARI
	printf("\n\n");
	printf("---GECERLI OY SAYILARINI GIRINIZ---");
	printf("\n");
    for(int i = 0;i<il_sayisi;i++)
    {
        printf("---%d plakali ilin gecerli oy sayilarini giriniz---",i+1);
        printf("\n");
        for(int j = 0;j<parti_sayisi;j++){
            printf( "%c Partisi gecerli oy sayisini giriniz: ", parti_isimleri[j] );
            scanf( "%d", &illerin_gecerlioy_sayilari[i][j]);

            //İLLERE GORE TOPLAM BULMA
            illerin_gecerlioylarin_toplami[i]+=illerin_gecerlioy_sayilari[i][j];


        }
        printf("\n");
        printf("%d plakali ilin gecerli oy toplami: %d",iller[i],illerin_gecerlioylarin_toplami[i]);
        printf("\n");

        printf("\n");
    }

    //İLLERİN PARTİLERE GÖRE GEÇERLİ OY SAYILARI YAZDIRMA
	printf("\n\n");
	printf("---GECERLI OY SAYILARINI YAZDIRMA---");
	printf("\n");
    for(int i = 0;i<il_sayisi;i++){
        printf("---%d plakali ilin gecerli oy sayilari---",i+1);
        printf("\n");
        for(int j = 0;j<parti_sayisi;j++){
            printf( "%c Partisi gecerli oy sayisi: %d\n", parti_isimleri[j],illerin_gecerlioy_sayilari[i][j]);
        }
        printf("\n");
    }


    //PARTİLERİN OY YÜZDELERİNİ HESAPLAR
    void Partilerin_OyYuzdelerini_Hesapla()
    {
         printf("\n\n");
        for(int i=0;i<il_sayisi;i++)
         for(int j = 0; j< parti_sayisi;j++){
            double bolme_sonucu = ((double)illerin_gecerlioy_sayilari[i][j] / (double)illerin_gecerlioylarin_toplami[i])*100;
            illerin_parti_oy_yuzdeleri[i][j] = (bolme_sonucu);
        }
        printf("\n\n");
    }

    Partilerin_OyYuzdelerini_Hesapla();

    //İLLERİN YUZDELERİNE GÖRE YAZDIRMA
	printf("\n\n");
	printf("---GECERLI OY YUZDELERI YAZDIRMA---");
	printf("\n");
    for (int i = 0; i < il_sayisi; i++)
    {
        printf("---%d Plakali Il Parti Yuzdeleri---",iller[i]);
        printf("\n");
        for(int j = 0; j< parti_sayisi;j++)
        {
            printf("%c Partisi Oy Yüzdesi: %f",parti_isimleri[j],illerin_parti_oy_yuzdeleri[i][j]);
            printf("\n");
        }
    }
    printf("\n\n");

    //MV ATAMA

            //int enbuyuk = Get_EnBuyuk_IndeksBulma(il_indeks);
            //illerin_partilere_gore_mv_sayilari[i][enbuyuk]++;

    //EN BUYUK INDEKS BULMA
    /*int Get_EnBuyuk_IndeksBulma(int il_indeks){
        int tempEnBuyuk_Indeks = 0;
        double tempEnBuyuk_Yuzde = 0;
        for(int i=0;i<parti_sayisi;i++){
            if(illerin_parti_oy_yuzdeleri[il_indeks][i]>tempEnBuyuk_Yuzde){
                tempEnBuyuk_Yuzde = illerin_parti_oy_yuzdeleri[il_indeks][i];
                tempEnBuyuk_Indeks = i;
            }
        }
        return tempEnBuyuk_Indeks;
    }*/
    ///////////////////////////////////////////////////////////////////////////
    printf("\n\n");
    return 0;
}

