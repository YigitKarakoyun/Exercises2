ÜZERİNDE TIKLANAN Z YÖNLÜ RAY
private Rigidbody rigidbody;
void Start(){ rigidbody = GetComponent<Rigidbody>();}

public float force;           
private void OnMouseDown(){// Create a ray from the transform position along the transform's z-axis
        Ray ray = new Ray(transform.position, transform.forward*force);
        rigidbody.AddForce(ray.direction, ForceMode.Impulse);//HEMEN KUVVETİ ANİ PATLAMA ÇARPMA EFEKTİ
    }


ÜZERİNDE TIKLANAN YERDEN RAY
private Rigidbody rigidbody;
void Start(){ rigidbody = GetComponent<Rigidbody>();}

public float force;           
private void OnMouseDown(){
        Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
        RaycastHit hit;
        if (Physics.Raycast(ray,out hit, 100))
        {
            //rigidbody.AddForceAtPosition(new Vector3(0, 0, force), hit.point,ForceMode.Impulse);//DÜZ İLERLER
rigidbody.AddForceAtPosition((transform.position-hit.point)*force, hit.point,ForceMode.Impulse); //TIKLANDIĞI YERDEN İLER

        }      
    }
HER YERDEN TIKLAMA RAY ADDEXPLOSION

public float force;           
private Rigidbody rigidbody;
void Start(){ rigidbody = GetComponent<Rigidbody>();}

private void Update(){
        if (Input.GetMouseButtonDown(0)){  //HER YERDEN TIKLAMA
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            RaycastHit hit;
            if (Physics.Raycast(ray, out hit, 100)){
                rigidbody.AddExplosionForce(force, hit.point, 5, 0, ForceMode.Impulse);
  //rigidbody.AddExplosionForce(force, hit.point, 5, 1, ForceMode.Impulse);//PATLAMA YERDEN OLUYOR
            }
        }
    }
YERDEN PATLAMA EFEKTİ
public float force,radius=5;    
private Rigidbody rigidbody;
void Start(){ rigidbody = GetComponent<Rigidbody>();}

    private void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            RaycastHit hit;
            if (Physics.Raycast(ray, out hit, 100))
            {
                Collider[] colliders = Physics.OverlapSphere(hit.point,radius);
                foreach (Collider c in colliders)
                {
                    Rigidbody r = c.GetComponent<Rigidbody>();
                    if (r == null) continue;
                    r.AddExplosionForce(force, hit.point, radius, 1, ForceMode.Impulse);
			  //0 OLURSA NORMAL PATLAMA 1 OLURSA YERDEN PATLAMA EFEKTİ OLUR
                }

            }
        }
    }
NORMAL PATLAMA EFEKTİ
public float force,radius=5;    
private Rigidbody rigidbody;
void Start(){ rigidbody = GetComponent<Rigidbody>();}

    private void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            RaycastHit hit;
            if (Physics.Raycast(ray, out hit, 100))
            {
                Collider[] colliders = Physics.OverlapSphere(hit.point,radius);
                foreach (Collider c in colliders)
                {
                    Rigidbody r = c.GetComponent<Rigidbody>();
                    if (r == null) continue;
                    r.AddExplosionForce(force, hit.point, radius, 0, ForceMode.Impulse);
			  //0 OLURSA NORMAL PATLAMA 1 OLURSA YERDEN PATLAMA EFEKTİ OLUR
                }
            }
        }
    }

İSTENEN DOĞRULTUDA PATLAMA EFEKTİ
public float force,radius=5; //radius düşürürsen daha az etki eder
private Rigidbody rigidbody;
void Start(){ rigidbody = GetComponent<Rigidbody>();}

    private void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            RaycastHit hit;
            if (Physics.Raycast(ray, out hit, 100))
            {
                Collider[] colliders = Physics.OverlapSphere(hit.point,radius);
                foreach (Collider c in colliders)
                {
                    Rigidbody r = c.GetComponent<Rigidbody>();
                    if (r == null) continue;
                    r.AddForce(new Vector3(0,0,1) * force, ForceMode.Impulse);
                }
            }
        }
    }
İSTENEN KONUMLU PATLATMA
    public Vector3 location = new Vector3(0, 0, -6);
    void Start() { Invoke("Detonate", 3); }
    
    private void Detonate()
    {
        Collider[] colliders = Physics.OverlapSphere(location, 10);
        foreach (Collider c in colliders)
        {
            Rigidbody r = c.GetComponent<Rigidbody>();
            if (r == null) continue;
            r.AddExplosionForce(10, location, 10, 0, ForceMode.Impulse);
        }   
    }
    
RAY ATEŞ ETME(CLONE)
public GameObject particle;
    void Update(){
        if (Input.GetButtonDown("Fire1")){
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            if (Physics.Raycast(ray))
                Instantiate(particle, transform.position, transform.rotation);
        }
    }

	
