using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class _top : MonoBehaviour
{
    float yok_olma_hizi = 0.03f;
    
    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.tag =="Delik"){ setYoketme(other); }
        if (other.gameObject.tag == "Bitis"){ setYoketme(other); }
    }
    private void setYoketme(Collider other)
    {
        Destroy(GetComponent<Rigidbody>());
        transform.position = other.gameObject.transform.position;

        InvokeRepeating("yokol", 0.0f, 0.02f);
    }

    void yokol()
    {
        transform.localScale -= 
	new Vector3(yok_olma_hizi,yok_olma_hizi,yok_olma_hizi);
        if (transform.localScale.x <= 0.0f)
        {
            Debug.Log("Yeniden başlatılıyor");
            SceneManager.LoadScene("Scenes/SampleScene");
        }
    }
}
