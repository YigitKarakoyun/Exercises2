using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Networking;
using System.IO;
using UnityEngine.UI;
using System.Threading;
using System;

public class DownloadImage : MonoBehaviour
{
    public RawImage rawImage;

    void Update()
    {
             if (Input.GetKeyDown(KeyCode.A)){ StartCoroutine(IDownloadImages_pathIMAGES(url1, name1,rawImage)); }
    }

    //PATHLER
    private void Start(){
        pathRESOURCES = Application.dataPath + "/Resources/"; 
        pathIMAGES = Application.dataPath + "/Resources/Images/";
        getPathImages = "Images/"; 
    }
    public string pathRESOURCES;
    public string pathIMAGES;
    public string getPathImages;


    public string url2 = "http://gazetekarinca.com/wp-content/uploads/2017/01/WhatsApp-Image-2017-01-05-at-11.29.47.jpeg";
    public string name2 = "ordek.png";

    public string url1 = "https://iatkv.tmgrup.com.tr/28263f/616/321/0/9/800/426?u=https://itkv.tmgrup.com.tr/2018/10/15/1539592140720.jpg";
    public string name1 = "kopek.jpg";

    public Texture2D texture1;
    public Sprite sprite1;


    #region ---------------------------------------DOSYAYI YAZDIRMA---------------------------------------
    public void writeImageKonumdan(string path, Texture2D texture)
    {
        //RESOURCE YOKSA OLUŞTURSUN
        bool boolTemp = Directory.Exists(pathRESOURCES);
        if (!boolTemp) Directory.CreateDirectory(pathRESOURCES);

        //IMAGE YOKSA OLUŞTURSUN
        boolTemp = Directory.Exists(pathIMAGES);
        if (!boolTemp) Directory.CreateDirectory(pathIMAGES);

        //RESOURCE YOKSA OLUŞTURSUN
    


        //ISIM & TURUNU BELİRLEME
        string tempIsim = path.Split('.')[0]; //RESOURCEDAN ÇAĞIRILACAK İSİM BİLGİSİ
        string tempTuru = path.Split('.')[1].ToLower(); //KAYDEDİLECEK TÜRÜ BİLGİSİ

        //DOSYA KAYDETME İŞLEMİ
        if (tempTuru == "png") { File.WriteAllBytes(path, texture.EncodeToPNG()); }
        else if (tempTuru == "jpg" || tempTuru == "jpeg") { File.WriteAllBytes(path, texture.EncodeToJPG()); }
        else if (tempTuru == "tga") { File.WriteAllBytes(path, texture.EncodeToTGA()); }
        else if (tempTuru == "exr") { File.WriteAllBytes(path, texture.EncodeToEXR()); }
        else { Debug.LogWarning("Öyle bir resim tipimiz yok"); }
        Debug.Log("Dosya Başarılı Şekilde Kaydedildi: " + path);
    }
    public void writeImageIsimden(string isim, Texture2D texture)
    {
        //if (!File.Exists(pathRESOURCES)){ File.Create(pathRESOURCES); }
        //if (!File.Exists(pathIMAGES)){    File.Create(pathIMAGES); }
        writeImageKonumdan(pathIMAGES + isim, texture);
    }
    #endregion

    #region ---------------------------------------DOSYA KONUMUNDAN RESİMLERİ OLUŞTURUR---------------------------------------

    //SPRITE OLUŞTURUR
    public Sprite getSprite_DosyaKonumdanYukle(string path)
    {
        Texture2D texture = getTexture2D_KonumdanYukle(path);
        Sprite sprite = Sprite.Create(texture, new Rect(0.0f, 0.0f, texture.width, texture.height), new Vector2(0.5f, 0.5f), 100.0f);
        if (sprite != null) { return sprite; }
        else { Debug.Log("Sprite Yüklenemedi"); return null; }
    }
    public Sprite getSprite_DosyaIsimdenYukle(string isim)
    {
        Texture2D texture = getTexture2D_IsimdenYukle(isim);
        Sprite sprite = Sprite.Create(texture, new Rect(0.0f, 0.0f, texture.width, texture.height), new Vector2(0.5f, 0.5f), 100.0f);
        if (sprite != null) { return sprite; }
        else { Debug.Log("Sprite Yüklenemedi"); return null; }
    }

    //TEXTURE2D OLUŞTURUR      @"D:\fatman\texture.png"
    public Texture2D getTexture2D_KonumdanYukle(string path)
    {
        Texture2D texture = new Texture2D(2, 2);
        byte[] byteArray = File.ReadAllBytes(path);
        bool tempYuklendi = texture.LoadImage(byteArray);
        if (tempYuklendi) { return texture; }
        else { Debug.Log("Texture Yüklenemedi"); return null; }
    }
    public Texture2D getTexture2D_IsimdenYukle(string isim)
    {
        Texture2D texture = new Texture2D(2, 2);
        byte[] byteArray = File.ReadAllBytes(pathIMAGES + isim);
        bool tempYuklendi = texture.LoadImage(byteArray);
        if (tempYuklendi){  return texture; }
        else { Debug.Log("Texture Yüklenemedi"); return null;   }
    }
    #endregion

    #region ---------------------------------------DOSYA KONUMUNDAN RESİMLERİ YÜKLER---------------------------------------
    //ISIMDEN TEXTURE YÜKLEME
    public void setDosyaIsimdenYukle(string isim, GameObject tempImage){tempImage.GetComponent<Renderer>().material.mainTexture = getTexture2D_IsimdenYukle(isim);}
    public void setDosyaIsimdenYukle(string isim, Sprite tempImage){    tempImage = getSprite_DosyaIsimdenYukle(isim);}
    public void setDosyaIsimdenYukle(string isim, Image tempImage){     tempImage.sprite = getSprite_DosyaIsimdenYukle(isim);}
    public void setDosyaIsimdenYukle(string isim, RawImage tempImage){  tempImage.texture = getTexture2D_IsimdenYukle(isim);}

    //KONUMDAN TEXTURE YÜKLEME
    public void setDosyaKonumdanYukle(string path, GameObject tempImage){tempImage.GetComponent<Renderer>().material.mainTexture = getTexture2D_KonumdanYukle(path);}
    public void setDosyaKonumdanYukle(string path, Sprite tempImage){    tempImage = getSprite_DosyaKonumdanYukle(path);}
    public void setDosyaKonumdanYukle(string path, Image tempImage){     tempImage.sprite = getSprite_DosyaKonumdanYukle(path);}
    public void setDosyaKonumdanYukle(string path, RawImage tempImage){  tempImage.texture = getTexture2D_KonumdanYukle(path);}
    #endregion

    #region ---------------------------------------URLDEN İNDİRİP DOSYA KONUMUNA KAYDEDER ORADAN YÜKLER---------------------------------------
    //"http://gazetekarinca.com/wp-content/uploads/2017/01/WhatsApp-Image-2017-01-05-at-11.29.47.jpeg"
    //@"D:\fatman\texture.png"
    public IEnumerator IDownloadImages_pathIMAGES(string url, string isim, RawImage tempImage)
    {
        string path = pathIMAGES + isim;
        if (File.Exists(path)) { setDosyaIsimdenYukle(isim,tempImage); }
        else
        {
            using (UnityWebRequest www = UnityWebRequestTexture.GetTexture(url))
            {
                yield return www.SendWebRequest();
                if (www.isNetworkError || www.isHttpError) { Debug.LogError(www.error); }
                else
                {
                    Texture2D texture = DownloadHandlerTexture.GetContent(www);
                    while (!www.isDone) yield return null;

                    writeImageKonumdan(path, texture);
                    setDosyaIsimdenYukle(isim,tempImage);
                }
            }
        }
    }

    public IEnumerator IDownloadImages_pathIMAGES(string url, string isim, Image tempImage)
    {
        string path = pathIMAGES + isim; 
        if (File.Exists(path)) { setDosyaIsimdenYukle(isim, tempImage); }
        else
        {
            using (UnityWebRequest www = UnityWebRequestTexture.GetTexture(url))
            {
                yield return www.SendWebRequest();
                if (www.isNetworkError || www.isHttpError) { Debug.LogError(www.error); }
                else
                {
                    Texture2D texture = DownloadHandlerTexture.GetContent(www);
                    while (!www.isDone) yield return null;

                    writeImageKonumdan(path, texture);
                    setDosyaIsimdenYukle(isim, tempImage);
                }
            }
        }
    }

    public IEnumerator IDownloadImages_pathIMAGES(string url, string isim, Sprite tempImage)
    {
        string path = pathIMAGES + isim;
        if (File.Exists(path)) { setDosyaIsimdenYukle(isim, tempImage); }
        else
        {
            using (UnityWebRequest www = UnityWebRequestTexture.GetTexture(url))
            {
                yield return www.SendWebRequest();
                if (www.isNetworkError || www.isHttpError) { Debug.LogError(www.error); }
                else
                {
                    Texture2D texture = DownloadHandlerTexture.GetContent(www);
                    while (!www.isDone) yield return null;

                    writeImageKonumdan(path, texture);
                    setDosyaIsimdenYukle(isim, tempImage);
                }
            }
        }
    }

    public IEnumerator IDownloadImages_pathIMAGES(string url, string isim, GameObject tempImage)
    {
        string path = pathIMAGES + isim;
        if (File.Exists(path)) { setDosyaIsimdenYukle(isim, tempImage); }
        else
        {
            using (UnityWebRequest www = UnityWebRequestTexture.GetTexture(url))
            {
                yield return www.SendWebRequest();
                if (www.isNetworkError || www.isHttpError) { Debug.LogError(www.error); }
                else
                {
                    Texture2D texture = DownloadHandlerTexture.GetContent(www);
                    while (!www.isDone) yield return null;
                    
                    writeImageKonumdan(path, texture);
                    setDosyaIsimdenYukle(isim, tempImage);
                }
            }
        }
    }

    #endregion
}
