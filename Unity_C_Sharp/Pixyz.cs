using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using SFB;
using UnityEngine.UI;
using System;
using PiXYZ.Import;
using PiXYZ.Interface;
using UnityEditor;

public class _fileBrowser : MonoBehaviour
{
    #region YAZDIRMA
    void printAyrac(string temp) { temp = temp.ToUpper(); Debug.Log("------------------------------------- " + temp + " -------------------------------------"); }
    void printAyrac(){ Debug.Log("---------------------------------------------------------------------"); }
    #endregion

    #region DEĞİŞKENLER
    public string _path;
    PiXYZ.Import.ImportSettings importSettings;
    PiXYZ.Import.Importer importer;
   // private ImportStamp importedModel2;
    #endregion

    #region Import0
    public void setModel0Import()
    {
        //--------------------------Unity Tutorial 0---------------------------------
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));
        if (_path == "") { return; }

        importer = new PiXYZ.Import.Importer(_path, importSettings);
        importer.progressed += onProgressChanged0;
        importer.completed += onImportEnded0;
        importer.run();

    }
    void onProgressChanged0(float progress, string message) { Debug.Log("Progress : " + 100f * progress + "%"); }
    void onImportEnded0(GameObject gameObject) { Debug.Log("Model Imported"); }
    #endregion

    #region Import1
    public void setModel1Import()
    {
        //--------------------------Unity Tutorial 1---------------------------------
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));
        if (_path == "") { return; }

        importer = new PiXYZ.Import.Importer(_path, importSettings);
        importer.isAsynchronous = true;
        importer.completed += onImportEnded1;
        importer.run();
        if (Input.GetKeyDown(KeyCode.A))
        {
            //PiXYZ.Config.Configuration.IsLicenseValid();//Lisans
        }
    }
    void onImportEnded1(GameObject gameObject) { }

    #endregion

    #region Import2
    public void setModel2Import()
    {
        //--------------------------Unity Tutorial 2---------------------------------
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));
        if (_path == "") { return; }

        importer = new PiXYZ.Import.Importer(_path, importSettings);
       
        importer.isAsynchronous = false;
        importer.completed += onImportEnded2;
        importer.run();
        
    }
    void onImportEnded2(GameObject gameObject) { }

    #endregion

    #region Import Count

    public void setModel3Count()
    {   //--------------------------Unity Count---------------------------------
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));
        if (_path == "") { return; }
        print("---------------------------------------------------");
        
        importer = new PiXYZ.Import.Importer(_path, importSettings);
        importer.isAsynchronous = false;//FALSE DİĞER KOMUTLAR BUNU BEKLER, TRUE İSE BEKLEMEZ DİĞER KOMUTLAR İŞLETİLİR
        importer.completed += onImportEnded3;
        importer.run();

        print("---------------------------------------------------");
    }
    //Burada yapılacak GameObject count yoksa patlar, bitirmediğini için null
    void onImportEnded3(GameObject gameObject)
    {
        //------------------POLIGON SAYISI------------------------------
        Debug.Log("Poligon sayısı: " + importer.polycount);

        //------------------IMPORTER COUNT------------------------------
        Debug.Log("Importer gameobject sayısı " + importer.gameObjectCount);

        //------------------DURDUYSA-----------------------
        if (importer.isStopped){ Debug.Log("STOPPED"); }
    }

    #endregion

    #region Tutorial1
    //--------------------------Unity Tutorial 1---------------------------------
    public void setModel4Tutorial1()
    {
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));
        if (_path == "") { return; }

        ImportSettings importSettings1 = ScriptableObject.CreateInstance<ImportSettings>();

        var importer = new PiXYZ.Import.Importer(_path, importSettings1);
      
        importer.isAsynchronous = false;
        importer.progressed += progressedtutorial1;
        importer.completed += tutorialEnded1;
        importer.run();
    }

    void progressedtutorial1(float progress, string message){ Debug.Log("Tutorial İlerleme: " + progress); }
    void tutorialEnded1(GameObject gameObject) { Debug.Log("Tutorial 1"); }

    #endregion

    #region CreateUV
    public void setModel5CreateUv()
    {
        
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));
        if (_path == "") { return; }

        ImportSettings importSettings1 = ScriptableObject.CreateInstance<ImportSettings>();
        importer = new PiXYZ.Import.Importer(_path, importSettings1);
        //--------------------------Creat UV---------------------------------
        PiXYZ.Tools.Builtin.CreateUVs createUVs = new PiXYZ.Tools.Builtin.CreateUVs() { uvSize = 120f, useLocalBoundingBox = false, uvChannel = 0, };
        Debug.Log("CREATE UV TIPI: " + createUVs.GetType());
        Debug.Log("KURAL ERİŞİM ŞEKLİ: " + createUVs.displayNameRuleEngine);
        
        importer.run();
    
    }

    void progressedcreateUV1(float progress, string message){ Debug.Log("Tutorial İlerleme: " + progress); }
    void progressedEnded1(GameObject gameObject) { Debug.Log("Tutorial 1"); }

    #endregion

    #region Desteklenen Formatlar
    public string[] getSupportedFormatsForFileBrowser()
    {
        string[] tempStringDizi = PiXYZ.Import.Formats.SupportedFormatsForFileBrowser;
        return tempStringDizi;
    }
    public void setModel6FormatlarUzantilar()
    {
        //--------------------------Unity Desteklenen Formatlar---------------------------------
        printAyrac("Unity Desteklenen Formatlar");
        HashSet<string> desteklenenFormatlar = PiXYZ.Import.Formats.UnitySupportedFormats;
        string temp = "";
        foreach (string item in desteklenenFormatlar){
            temp += item+", ";
        }

        Debug.Log("Desteklenen formatlar: " + temp);
        //--------------------------FileBrowserın Desteklenen Formatlar--------------------------
        printAyrac("FileBrowser Desteklenen Formatlar");
        string[] tempStringDizi = PiXYZ.Import.Formats.SupportedFormatsForFileBrowser;
        temp = "";
        foreach (string item in tempStringDizi)
        {
            temp += item+", "; 
        }

        Debug.Log("Desteklenen browser formatlar: " + temp);
        //***********************************************************************************************
        //------------------------------------FILE BROWSERLI----------------------------------
        
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));
        if (_path == "") return;
        printAyrac("Uzantisini Öğrenme");
        string tempString = PiXYZ.Import.Formats.GetExtension2(_path);
        Debug.Log("Uzantı format: " + tempString);


        //--------------------------Uzantı destekliyor mu HEPSİ AYNI SONUCU VERİYOR NEDEN?------------------------------------------
        printAyrac("Uzanti Destekliyor Mu");
        bool boolUzantiDestekliyorMu = PiXYZ.Import.Formats.IsFileSupported(_path, true);
        Debug.Log("Destekliyor mu: " + boolUzantiDestekliyorMu);

        bool boolUzantiDesteklemiyorMu = PiXYZ.Import.Formats.IsFileSupported(_path, false);
        Debug.Log("Desteklemiyor mu: " + boolUzantiDesteklemiyorMu);

        bool boolUzantiMu = PiXYZ.Import.Formats.IsFileSupported(_path);
        Debug.Log("Destek bu mu: " + boolUzantiMu);

        //----------------------------Desteklenen Formatlar Dictionary---------------------------------
        printAyrac("Desteklenen Formatlar Dictionary");
        Dictionary<string, string> desteklenenFormatlarDictionary = PiXYZ.Import.Formats.SupportedFormatsGrouped;
        temp = "";
        foreach (KeyValuePair<string,string> item in desteklenenFormatlarDictionary)
        {
            temp += item.Key + ":" + item.Value+", ";
        }

        Debug.Log(temp);

        //-----------------------------Count öğrenme------------------------------
        try { Debug.Log(importer.gameObjectCount); } catch (Exception ex){ Debug.Log("Count Hata: "+ex); }
        

        //-----------------------------Sahneye Nesne Ekleme----------------------------
        PiXYZ.Tools.Builtin.AddChild addChild = new PiXYZ.Tools.Builtin.AddChild() ;
        GameObject tempChild = new GameObject() { name = "12" };   addChild.newChild = tempChild;
        GameObject tempChild2 = new GameObject() { name = "13" };  addChild.newChild = tempChild2;

        //-----------------------------Nesneye Collider Ekleme----------------------------
        PiXYZ.Tools.Builtin.AddCollider addCollider = new PiXYZ.Tools.Builtin.AddCollider();
        addCollider.type = PiXYZ.Tools.Builtin.AddCollider.ColliderType.MeshCollider;
        Debug.Log("COLLIDER TYPE: "+addCollider.type);
        

        new GameObject() { name = "max" };//Bu komutla otomatik ekliyor.
        try { Debug.Log("New child " + addChild.newChild + " "); } catch(Exception ex) { }



    }
    #endregion

    #region Meta Data        CAD metası lazım
    public void setModel7MetaData()
    {
        //----------------------------Meta Data Dictionary---------------------------------
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));
        if (_path == "") { return; }

        try
        {
            importer = new PiXYZ.Import.Importer(_path, importSettings);
            importer.completed += onImportEnded7;
            importer.run();
        }
        catch (Exception ex)
        {

            Debug.Log("setModel7MetaData Hata: " + ex);
            //EditorApplication.isPlaying = true;
            //EditorApplication.NewScene();
        }
        
    }

    private void onImportEnded7(GameObject importedObject)
    {
        printAyrac("Meta Data");

        Metadata metadata = null;
        Debug.Log("Imported Model: "+importer.importedModel);
        //importedObject.GetComponent<Metadata>();

        /*try
        {
            metadata = importer.importedModel.gameObject.GetComponent<Metadata>();
            if (metadata==null)
            {
                Debug.Log("Meta Null");
                return;
            }
        }
        catch (Exception)
        {
            return;
        }*/
        metadata = importer.importedModel.gameObject.AddComponent<Metadata>();
        try { metadata = importer.importedModel.GetComponent<Metadata>();  } catch(Exception ex){
            
            return;
        }
        if (metadata == null) { Debug.Log("Metadatası NULL"); return; }
        else
        {
            Debug.Log("GameObject: " + metadata.gameObject);    //Debug.Log("Model Yuklenme Zamanı"+importer.importedModel.importTime);

            Debug.Log("Aktif mi: " + metadata.isActiveAndEnabled);
            Debug.Log("Instance mi: " + metadata.isInstance);
            Debug.Log("Name: " + metadata.name);
            metadata.addOrSetProperty("yelken","yeniYelken");
            metadata.addOrSetProperty("araba", "yeniAraba");
            metadata.addOrSetProperty("yemek", "yeniYemek");

            Debug.Log("Property ekleme seçme: " + metadata.getProperty("yelken"));
            Debug.Log("Property ekleme seçme: " + metadata.getProperty("araba"));

            Debug.Log("Weight var mi? "+ metadata.containsProperty("Weight"));
            Debug.Log("Araba var mi? " + metadata.containsProperty("araba"));

            Debug.Log("Araba silindi " + metadata.removeProperty("araba")); //Property silme
            Debug.Log("Silinemedi: " + metadata.removeProperty("heyt"));

            string tempString = "";
            Dictionary<string, string> properties = metadata.getProperties();
            foreach (KeyValuePair<string,string> item in properties)
            {
                tempString += item.Key + ":" + item.Value+", ";
            }
            Debug.Log(tempString);
        }
        
        //Check if a property exists To check weither a property exists or not based on its name, use :
        /*


        string temp = "";
        foreach (KeyValuePair<string, string> item in properties)
        {
            temp += item.Key + ":" + item.Value + ", ";
        }

        Debug.Log(temp);*/
    }
    #endregion

    #region ISVALID
    public void setmodel8IsValid()
    {
        bool temp = PiXYZ.Config.Configuration.IsLicenseValid();
        Debug.Log("Lisans geçerlimidir?: "+temp);

        string message="";
        PiXYZ.Config.Compatibility compatibility = PiXYZ.Config.Configuration.IsPluginCompatible(out message);
        //Debug.Log("Compatible mı?: " + compatibility);
        Debug.Log(message);

        //PiXYZ.Interface.Plugin4UnityI UpdateStatus = PiXYZ.Interface.Plugin4UnityI.checkForUpdatesReturn;

    }
    public void setModel9ImportedModel()
    {
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));
        if (_path == "") { return; }
        importer = new PiXYZ.Import.Importer(_path, importSettings);
        importer.completed += onImportEnded9;
        importer.run();

        //The ImportedModel component inherits from MonoBehaviour.That said, it can be gathered with:
        //new PiXYZ.Tools.Builtin.GetImportedModel();
        //ImportedModel importedModel = gameObject.GetComponent<ImportedModel>();   
    }

    private void onImportEnded9(GameObject importedObject)
    {
        //Model Import edildi
        try
        {
            Debug.Log("Bu model import edildi: " + importer.importedModel);//PIXYZ.Import.ImportStamp
            
            Debug.Log("Bu model import edildi: " + importer.importedModel.gameObject);//GameObject
            Debug.Log("Bu model import edildi: " + importedObject);//GameObject

          
            //importer.importedModel.importSettings.loadMetadata();
            //ImportedModel importedModel = gameObject.GetComponent<ImportedModel>();
            //https://www.pixyz-software.com/documentations/html/2019.1/plugin4unity/GettingInfoonImportedMode.html
            //Debug.Log("Bu model import edildi: " + gameObject.GetComponent<ImportedModel>());
            //Tembel Kod çalışmıyor
        }
        catch (Exception ex){ Debug.Log("Model Import Edilemedi: " + ex);}


    }
    #endregion

    #region FILE BROWSER
    public void WriteResult(string[] paths)
    {
        if (paths.Length == 0)
        {
            Debug.LogWarning("Dosya yolu alınamadı");
            _path = "";
            return;
        }

        _path = "";
        foreach (var p in paths)
        {
            _path += p + "\n";
        }
        _path = _path.Replace('\\', '/').TrimEnd();    

    }

    //public void WriteResult(string path){_path = _path.Replace('\\', '/').TrimEnd();}
    #endregion

}
