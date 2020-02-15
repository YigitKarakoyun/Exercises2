Server Client Programı (Port Kullanımı)
Mart 20, 2017 Yazarı: Dr.Who
// Client Tarafı

import java.io.*;
import java.net.*;
public class Port_Sinifi {
public static void main(String[] args) {
try{
Socket s=new Socket("localhost",6666);
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
dout.writeUTF("Merhaba");
dout.flush();
dout.close();
s.close();
}catch(Exception e){System.out.println(e);}
}
}
// Server Tarafı

// Serverın Aktif RAM kullanım bilgisi ekrana yazılacaktır.
// Bu örneğin kullanımı için sigar isimli JAR programa eklenmiştir.
package portlar_p;
import java.io.*;
import java.net.*;
import java.text.DecimalFormat;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
public class MyServer {
public static void main(String[] args){
try{
ServerSocket ss=new ServerSocket(6666);
Socket s=ss.accept();//establishes connection
DataInputStream dis=new DataInputStream(s.getInputStream());
String  str=(String)dis.readUTF();
System.out.println("message= "+str);
Sigar sigar = new Sigar();
Mem memory = null;
memory = sigar.getMem();
System.out.println("Toplam bellek : " + (memory.getTotal()/1024)/1024);
System.out.println("Kullanılan bellek : " + (memory.getUsed()/1024)/1024);
System.out.println("Kullanılan oran : " + new DecimalFormat("##.##").format(memory.getUsedPercent()));
ss.close();
}catch(Exception e){System.out.println(e);}
}
}
// Sigar isimli JAR pakati indirme adresi (Serverın RAM bilgisini almak için kullanılmıştır.)

// https://netcologne.dl.sourceforge.net/project/sigar/sigar/1.6/hyperic-sigar-1.6.4.zip

// Eclipse’e Jar Ekleme
