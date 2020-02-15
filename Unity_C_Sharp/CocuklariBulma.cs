//COCUKLARI BULMA
Transform[] allChildren = nesne1.GetComponentsInChildren<Transform>();
foreach (Transform child in allChildren)
{
	GameObject obj = child.gameObject;
        Debug.Log(obj);
}

//ÇOCUK NESNELER
//------------------------------------------ Ä°LGÄ°LÄ° Ã‡OCUÄ�UNU GAMEOBJECT DÃ–NDÃœRÃœR-----------------------
public GameObject getCocukNesne(GameObject tempNesne,int i)
{
    if (tempNesne==null) { return null; }
    int adet =tempNesne.transform.childCount;
    if(adet>0 && i<adet && i>=0){return tempNesne.transform.GetChild(i).gameObject;}
    return null;
}


//------------------------------------------  Ã‡OCUK SAYISINI VERÄ°R.------------------------------------------------------
transform.childCount;

//------------------------------------------  KAÃ‡INCI Ã‡OCUK GAMEOBJECT VERÄ°R ----------------------------------
transform.GetChild(i).gameObject;}

//------------------------------------------  Ã‡OCUKLARINI BULMA SADE------------------------------------------------

Transform[] allChildren = nesne1.GetComponentsInChildren<Transform>();    
foreach (Transform child in allChildren)
{
    GameObject obj = child.gameObject;
    Debug.Log(obj);
}


//ÇOCUKLARI BULMA ORNEK
using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class _cocuklariAlma : MonoBehaviour
{
    #region ÇOCUKLAR
    public Transform[] getCocuklarTransform(GameObject nesne)
    {
        if (nesne == null) { Debug.LogError("NESNE NULL"); return null; }
        return nesne.GetComponentsInChildren<Transform>();
    }
    public GameObject[] getCocuklar(GameObject nesne)
    {
        if (nesne == null) { Debug.LogError("NESNE NULL"); return null; }
        Transform[] transforms = getCocuklarTransform(nesne);
        if (transforms == null){ Debug.LogError("COCUĞU YOK"); return null;}
        int adet = transforms.Length;
        if (adet<=0) return null;
        
        GameObject[] cocuklar = new GameObject[adet];
        for (int i = 0; i < adet; i++)
        {
            cocuklar[i] = transforms[i].gameObject;
        }

        return cocuklar;
    }
    
    public int getCocuklarSayisi(GameObject nesne)
    {
        if (nesne == null) { Debug.LogError("NESNE NULL"); return 0; }
        return nesne.GetComponentsInChildren<GameObject>().Length;
    }
    public int getCocuklarSayisi(GameObject[] nesneler)
    {
        if (nesneler == null) { Debug.LogError("NESNELER NULL"); return 0; }
        return nesneler.Length;
    }
    public int getCocuklarSayisi(Transform[] nesneTransformlar)
    {
        if (nesneTransformlar == null) { Debug.LogError("NESNE TRANSFORMLAR NULL"); return 0; }
        return nesneTransformlar.Length;
    }
    #endregion

    public GameObject[] getParentlar(GameObject nesne)
    {
        if (nesne == null) { Debug.LogError("NESNE NULL"); return null; }
        Transform[] transforms = getCocuklarTransform(nesne);
        int adet = transforms.Length;
        if (adet <= 0) return null;

        GameObject[] cocuklar = new GameObject[adet];
        for (int i = 0; i < adet; i++)
        {
            Transform trans = transforms[i].parent;
            if (trans == null) cocuklar[i] = null;
            else cocuklar[i] = trans.gameObject;
        }

        return cocuklar;
    }
    public GameObject[] getParentlar(GameObject[] cocuklar)
    {
        if (cocuklar == null) { Debug.LogError("NESNE NULL"); return null; }

        int adet = cocuklar.Length;
        if (adet <= 0) return null;
        GameObject[] parentlar = new GameObject[adet];
       
        for (int i = 0; i < adet; i++)
        {
            Transform trans = cocuklar[i].transform;
            GameObject obj = null;
            if (trans!=null)
            {
                Transform transParent = trans.parent;
                if (transParent!=null)
                {
                    obj = transParent.gameObject;
                }
               
            }
             
            parentlar[i] = obj;
        }
        return parentlar;
    }

    public Transform[] getParentTransformlar(GameObject nesne)
    {
        if (nesne == null) { Debug.LogError("NESNE NULL"); return null; }
        Transform[] transforms = getCocuklarTransform(nesne);
        int adet = transforms.Length;
        if (adet <= 0) return null;

        Transform[] cocuklar = new Transform[adet];
        for (int i = 0; i < adet; i++)
        {
            Transform transform = transforms[i].parent;
            if (transform == null) cocuklar[i] = null;
            else cocuklar[i] = transform;
        }

        return cocuklar;
    }
    public int[] getKategoriler(GameObject nesne)
    {
        GameObject[] cocuklar = getCocuklar(nesne);
        GameObject[] parentlar = getParentlar(cocuklar);
        if (parentlar == null){ return null; }
        int adet = parentlar.Length;
        if (adet <= 0){ return null; }
        int[] temp = new int[adet];
        temp[0] = 0;
        for (int i = 1; i < adet; i++)
        {
            GameObject tempObj = parentlar[i];
            int arama = getDiziArama(cocuklar, tempObj);
            temp[i] = temp[arama]+1;
         
        }

        
        return temp;
    }
    #region ARAMA
    public int getDiziArama(GameObject[] nesneler,GameObject nesne)
    {
        int temp = Array.IndexOf(nesneler, nesne);
        if (temp == -1) Debug.Log("Aradığınız isim bulunamadı "+temp);
        else Debug.Log("Aradığınız isim bulundu "+ temp);
        return temp;
    }
    public int getDiziArama(Transform[] nesneTransformlar, GameObject nesne)
    {
        int temp = Array.IndexOf(nesneTransformlar, nesne.transform);
        if (temp == -1) Debug.Log("Aradığınız isim bulunamadı " + temp);
        else Debug.Log("Aradığınız isim bulundu " + temp);
        return temp;
    }
    public int getDiziArama(Transform[] nesneler, Transform nesneTransform)
    {
        int temp = Array.IndexOf(nesneler, nesneTransform);
        if (temp == -1) Debug.Log("Aradığınız isim bulunamadı " + temp);
        else Debug.Log("Aradığınız isim bulundu " + temp);
        return temp;
    }
    #endregion
    public GameObject nesne1;
    public GameObject[] cocuklari1;
    public GameObject[] parentlar1;
    public Transform[] parentlarTransformlar1;
    public int arama1,arama2;
    public int[] kategoriler;
    private void Start()
    {
        cocuklari1 = getCocuklar(nesne1);
        parentlar1 = getParentlar(cocuklari1);
        //parentlarTransformlar1 = getParentTransformlar(nesne1);
        //arama1 = getDiziArama(cocuklari1, cocuklari1[11]);
        //arama2 = getDiziArama(parentlarTransformlar1, parentlarTransformlar1[12]);
        kategoriler = getKategoriler(nesne1);

        Transform[] allChildren = nesne1.GetComponentsInChildren<Transform>();
        foreach (Transform child in allChildren)
        {
            Debug.Log(child);
    
        }
        Debug.Log(allChildren.Length);
       // parentlarTransformlar1 = getCocuklarTransform(nesne1);
    }
}
