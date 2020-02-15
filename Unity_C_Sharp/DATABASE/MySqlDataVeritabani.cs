//SUNUCU KAYNAKÇALAR
  https://www.apachefriends.org/tr/index.html
  http://www.wampserver.com/en/
  https://www.mamp.info/en/

//DLL KAYNAKÇA
  https://www.dllme.com/dll/files/mysql_data_dll.html

//BAĞLANTI STRINGI
  https://www.connectionstrings.com/mysql/
  

// MYSQL NASIL KULLANILIR.
Assembly klasorü oluştur.
MySql.Data.dll dosyasını indir.
Assembly klasorünün içine MySql.Data.dll dosyasını at. 
Usingle çağır ve ConnectionStrings ile değerlerini gir. 

using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using MySql.Data.MySqlClient;
public class MySqlDataVeritabani : MonoBehaviour
{
  MySqlConnection conn;
  public string server, database, user_name, pass, port;

  private void Start()
  {
    //server = "MySQL";//Bozuk
    //server = ".";//Bozuk

    //server = "127.0.0.1"; //Sağlam
    server = "localhost"; //Sağlam

    database = "dataBase1";
    user_name = "root";
    pass = "";

    port = "3306";
  }
  void setConnection()
  {
    conn = new MySqlConnection();
    
    //Portlu Bağlantı
    conn.ConnectionString = "Server=" + server + ";Port=" + port + ";Database=" + database + ";Uid=" + user_name + ";Pwd=" + pass + ";";
    
    //Portsuz Bağlantı
    //conn.ConnectionString = "Server="+server+";Database="+database+";Uid="+user_name+";Pwd="+pass+";";
    
    try
    {
      conn.Open();
      Debug.Log("Bağlantı Sağlandı! " + conn.State);
    }
    catch (System.Exception ex){ Debug.LogError("Hata: " + ex.Message);}
  }
  void Update(){ if (Input.GetKeyDown(KeyCode.Space)){ setConnection(); }}
  
}
