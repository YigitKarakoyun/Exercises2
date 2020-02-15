using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using SFB;
using UnityEngine.UI;
public class _dosyaBrowser : MonoBehaviour
{
    //----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------BAŞLANGIÇ DEĞERLER --------------------------------------------------------
    private _sayfaDegistir menuGosterGizle;
    private _modelYukle modelYukle;
    public string _path;
    private void Start()
    {
        menuGosterGizle = GetComponent<_sayfaDegistir>();
        modelYukle = GetComponent<_modelYukle>();
    }
    //----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------DOSYA SEÇME --------------------------------------------------------
    public void setDosyaAc()
    {
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", "", false));//StandaloneFileBrowser.OpenFilePanelAsync("Open File", "", "", false, (string[] paths) => { WriteResult(paths); });
    }
    public void setDosyaAcFbx()
    {
        var extensions = new[] { new ExtensionFilter("fbx"), };//new ExtensionFilter("Image Files", "png", "jpg", "jpeg" ),new ExtensionFilter("Sound Files", "mp3", "wav" ),new ExtensionFilter("All Files", "*" ),
        WriteResult(StandaloneFileBrowser.OpenFilePanel("Open File", "", extensions, true));
    }
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
        modelYukle.importModel_New(_path);//MODEL YÜKLEME
    }
    
    public void WriteResult(string path)
    {
        _path = _path.Replace('\\', '/').TrimEnd();
        modelYukle.importModel_New(_path);
        Debug.Log("Seçilen Konum: " + _path);
    }
}
