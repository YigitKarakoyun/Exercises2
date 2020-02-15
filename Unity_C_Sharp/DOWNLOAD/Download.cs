DonwloadImage
using (UnityWebRequest uwr = UnityWebRequestTexture.GetTexture("http://www.my-server.com/myimage.png"))
        {
            yield return uwr.SendWebRequest();

            if (uwr.isNetworkError || uwr.isHttpError){ Debug.Log(uwr.error);}
            else
            {
                // Get downloaded asset bundle
                Texture2D texture2D = DownloadHandlerTexture.GetContent(uwr);
                TargetObject.GetComponent<Image>().sprite = Sprite.Create(texture2D, new Rect(0, 0, texture2D.width, texture2D.height), new Vector2(0, 0));
            }
        }

IEnumerator ImportObject()
    {
        string url = "http://www.mcbu.edu.tr/duyururss.php";
        UnityWebRequest www = UnityWebRequest.Get(url);
        yield return www.SendWebRequest(); 

        string write_path = Application.dataPath + "/Downloaded/" + "duyuru.xml";

        System.IO.File.WriteAllBytes(write_path, www.downloadHandler.data);

        Debug.Log("Wrote to path");
    }

//HATALI
IEnumerator ImportObject()
    {
        string url = "http://www.mcbu.edu.tr/duyururss.php";
        UnityWebRequest www = UnityWebRequest.Get(url);
        yield return www.SendWebRequest();

        //HATA OLURSA
        if (www.isNetworkError || www.isHttpError) { Debug.Log(www.error); }
        else
        {
            string write_path = Application.dataPath + "/Downloaded/" + "duyuru.xml";
            System.IO.File.WriteAllBytes(write_path, www.downloadHandler.data);
//www.downloadHandler.text

            Debug.Log("Wrote to path");
        }
    }

AsyncOperation async = SceneManager.LoadSceneAsync(scene);
// While the asynchronous operation to load the new scene is not yet complete, continue waiting until it's done.
while (!async.isDone) {yield return null;}

using (wwwOne = UnityWebRequest.Get(url))
        {
            yield return wwwOne.SendWebRequest();

            if (wwwOne.isNetworkError || wwwOne.isHttpError) { Debug.LogError(wwwOne.error); }
            else
            {
                if (wwwOne.isDone)
                {
                    Debug.LogWarning("İNDİRME BİTTİ: " + url);
                    action(false);
                }
                else
                {
                    Debug.LogWarning("İNDİRME BİTMEDİ: " + url);
                    action(true);
                }
            }
        }

string pathRESOURCES { get { return Application.dataPath + "/Resources/"; } }
public IEnumerator IDownloadPathResource(string url, string isim)
    {
        //RESOURCE YOKSA OLUŞTURSUN
        bool boolTemp = Directory.Exists(pathRESOURCES);    //Debug.Log(boolTemp);
        if (!boolTemp) Directory.CreateDirectory(pathRESOURCES);
        
        string tempPath = pathRESOURCES + isim;
        if (System.IO.File.Exists(tempPath)) { Debug.Log("Dosya bulunmaktadır"); }

        var www = new UnityWebRequest(url, UnityWebRequest.kHttpVerbGET);
        www.downloadHandler = new DownloadHandlerFile(tempPath);
        yield return www.SendWebRequest();

        if (www.isNetworkError || www.isHttpError) Debug.LogError(www.error);
        else Debug.Log("Dosya Başarılı Şekilde Kaydedildi: " + tempPath);
    }

string pathRESOURCES { get { return Application.dataPath + "/Resources/"; } }
public IEnumerator IDownloadTexture(string url, string isim)
    {
        Debug.Log("------------------- DOWNLOAD TEXTURE PNG -----------------");
        using (UnityWebRequest www = UnityWebRequestTexture.GetTexture(url))
        {
            yield return www.SendWebRequest();

            if (www.isNetworkError || www.isHttpError){ Debug.Log(www.error);}
            else
            {
                string tempPath = pathRESOURCES + isim;
                // Get downloaded asset bundle
                Texture2D texture = DownloadHandlerTexture.GetContent(www);
                texture1 = texture;
                File.WriteAllBytes(tempPath,texture.EncodeToPNG());
                Debug.Log("Dosya Başarılı Şekilde Kaydedildi: " + tempPath);

            }
        }
        Debug.Log("------------------------------------------------");
    }

[ExecuteInEditMode()]
