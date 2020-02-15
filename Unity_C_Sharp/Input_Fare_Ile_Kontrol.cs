using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class _zemin : MonoBehaviour
{
    public float
        hiz = 25f; 

    float
        yatay_ok_tuslari, 
        dikey_ok_tuslari;
    
    void FixedUpdate()
    {
        yatay_ok_tuslari = Input.GetAxis("Mouse X") * Time.deltaTime * -hiz;
        dikey_ok_tuslari = Input.GetAxis("Mouse Y") * Time.deltaTime * hiz;

        Vector3 angles = new Vector3(dikey_ok_tuslari, 0, yatay_ok_tuslari);
        transform.eulerAngles += angles;
    }
}
