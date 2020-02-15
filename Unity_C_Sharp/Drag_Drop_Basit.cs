DRAG DROP
Vector3 objectPos;
    private void OnMouseDown()
    {
        objectPos = Camera.main.WorldToScreenPoint(transform.position);

    }
    private void OnMouseDrag()
    {
        Vector3 vector = new Vector3(Input.mousePosition.x,Input.mousePosition.y,objectPos.z);
        transform.position = Camera.main.ScreenToWorldPoint(vector);
    }

ESKİ KONUMA DÖNMESİ
bool kontrol = false;
    private void OnMouseDrag()
    {
        kontrol = false;
        Rigidbody.isKinematic = false;
        Vector3 vector = new Vector3(Input.mousePosition.x, Input.mousePosition.y, objectPos.z);
        transform.position = camera.ScreenToWorldPoint(vector);
    }
    private void OnMouseUp()
    {
        kontrol = true;
        transform.position = backPosition.position;
        transform.rotation = backPosition.rotation;
        Rigidbody.isKinematic = true;
        setObjectDrag();
        //Debug.Log(transform.position.x+"-"+transform.position.y);

    }
