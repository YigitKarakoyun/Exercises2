Asdas
if (Input.GetMouseButtonDown(0))
{
RaycastHit hitInfo = new RaycastHit();
if (Physics.Raycast(Camera.main.ScreenPointToRay(Input.mousePosition), out hitInfo) && hitInfo.transform.tag == "Construction"){print ("It's working");}
}

FARE BASILIRSA
public GameObject particle;
    void Update(){
        if (Input.GetButtonDown("Fire1")){
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            if (Physics.Raycast(ray)) Instantiate(particle, transform.position, transform.rotation);
        }
    }


FAREYLE ÜZERİNE TIKLANINCA
    private Rigidbody rigidbody;
    void Start(){ rigidbody = GetComponent<Rigidbody>();}

    public float force;    
    private void OnMouseDown()
    {
        rigidbody.AddForce(new Vector3(0, 0, 5));//BASİT KUVVET
        #region VARSAYILAN FORCE MODDA İKİ METOD AYNI SONUCU VERİR
        rigidbody.AddForce(new Vector3(0, 0, force));  
        rigidbody.AddForce(new Vector3(0, 0, force),ForceMode.Force);
        #endregion

        rigidbody.velocity = (new Vector3(0, 0, force)); //SABİT HIZ
        rigidbody.AddForce(new Vector3(0, 0, force),ForceMode.Impulse);//HEMEN KUVVETİ ANİ PATLAMA ÇARPMA EFEKTİ
        rigidbody.AddForce(new Vector3(0, 0, force), ForceMode.VelocityChange);//IMPULSE AMA KÜTLEYİ ÖNEMSEMİYOR
        rigidbody.AddForce(new Vector3(0, 0, force), ForceMode.Acceleration);//KÜTLEYİ ÖNEMSEMİYOR
    }

FAREYLE SOLA BASILIRSA
if (Input.GetMouseButtonDown(0)){}


FARE KONUMU
Input.mousePosition
