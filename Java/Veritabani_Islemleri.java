import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;
public class Veritabanı {
    //Veritabanina baglanmak icin kullanacagimiz JDBC driver
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    
    //JDBC ile Derby database baglantisi kurmamiz gerekiyor
    private String protocol = "jdbc:derby:";
    private static Connection conn = null;
    private Statement s = null;
    // Kurucu metod nesne olusturulunca veritabani baglantisi aciliyor.
    public Veritabanı(){
        connect();
    }
    public void connect() {
        try {
            //Surucuyu yukle
            Class.forName(driver).newInstance();
            Properties p = new Properties();
            String dbName = "Veritabanı"; // Olusturacagimiz Veritabanimizin ismi
            //Baglantiyi kur
            conn = DriverManager.getConnection(protocol + dbName + ";create=true", p);
            System.out.println("Baglanti kuruldu ve " + dbName + " veritabani olusturuldu");
            conn.setAutoCommit(true);
            //Daha sonra yurutecegimiz SQL sorgularini Statement yardimiyla calistiracagiz
            s = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void veritabaniOlustur(){
        try {
            //Kayitlar adinda bir veritabani olusturalim, bunun
            //isim, soyisim, ogrencino ve bolum adinda 4 adet sutunu olsun
              s.execute("create table kayitlar(isim varchar(40), " +
                      "soyisim varchar(40)," +
                      "ogrencino int, " +
                      "bolum varchar(50))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void kayitEkle(String isim, String soyisim, int ogrencino, String bolum){
        try {
            String sorgu = "insert into kayitlar values ('" +isim +
                    "','" + soyisim +
                    "'," + ogrencino +
                    ",'" + bolum +
                    "')";
            System.out.println("sorgu = " + sorgu);
            s.executeUpdate(sorgu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet kayitAl(){
        ResultSet rset = null;
        try {
            rset = s.executeQuery(
                    "SELECT * from kayitlar ORDER BY ogrencino");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return rset;
    }
    public void kayitYazdir(){
        try {
        ResultSet rset = kayitAl();
        if(rset!=null){
        ResultSetMetaData rsmd = rset.getMetaData();
        rsmd.getColumnCount();
        int i = 0;
        while (rset.next()) {
            for (int j = 1; j < rsmd.getColumnCount(); j++) {
                System.out.print(rset.getString(j) + " ");
            }
            System.out.println("");
          }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void tabloSil(){
        try {
            s.execute("drop table kayitlar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
      
      Veritabanı e = new Veritabanı();
        e.veritabaniOlustur();
        e.kayitEkle("Deniz", "Kılınç", 1, "Yazılım Muh");
        e.kayitEkle("Emin", "Borandağ", 2, "Bilgisayar Muh");
        e.kayitEkle("Akın", "Özçift", 3, "Elektrik Muh");
        e.kayitEkle("Volkan", "Tunalı", 4, "Elektronik Muh");
        e.kayitYazdir();
    }
}
