//Dosyayı Texture Olarak Yükle
    void enumDosyadanYukle(string path = @"D:\fatman\texture.png")
    {
    
        Texture2D texture = new Texture2D(2, 2);
        
        GameObject image = GameObject.Find("RawImage");
        
        byte[] byteArray = File.ReadAllBytes(path);
        
        bool tempYuklendi = texture.LoadImage(byteArray);
        
        if (tempYuklendi)
        {
            image.GetComponent<RawImage>().texture = texture;
        }
    }
//Texture Olarak Kaydetme
    IEnumerator enumIndirYukle()
    {
        string path = @"D:\fatman\texture.png";
        if (File.Exists(path)){ enumDosyadanYukle(path);}
        else
        {
            using (UnityWebRequest www = UnityWebRequestTexture.GetTexture("http://gazetekarinca.com/wp-content/uploads/2017/01/WhatsApp-Image-2017-01-05-at-11.29.47.jpeg"))
            {
                yield return www.SendWebRequest();

                if (www.isNetworkError || www.isHttpError) { Debug.LogError(www.error); }
                else
                {
                    // Get downloaded asset bundle
                    Texture2D texture = DownloadHandlerTexture.GetContent(www);
                    while (!www.isDone) yield return null;
                    GameObject image = GameObject.Find("RawImage");
                    File.WriteAllBytes(path, texture.EncodeToPNG());
                    enumDosyadanYukle(path);
                    //image.GetComponent<RawImage>().texture = texture;

                }
            }
        }
    }
