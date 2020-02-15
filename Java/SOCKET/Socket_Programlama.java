Anlık Mesajlaşma Programı (Socket Programlama)
Mayıs 29, 2017 Yazarı: Dr.Who
// Bu kodların çalışabilmesi için Java’da 2 ayrı proje oluşturulmalıldır.

//1.projenin adı Server. Kendi içerisinde 2 adet .java uzantılı classı barındırmaktadır.

//Kodları

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Server extends JFrame{
  
  private JTextField userText;
  private JTextArea chatWindow;
  // 2 bilgisayar arasındaki akışin olması için kullanılacaktır.
  private ObjectOutputStream output;
  private ObjectInputStream input;
  private ServerSocket server;
  private Socket connection;
  
  //constructor
  public Server()
  {
    super("Mesajlasma Programı");
    userText = new JTextField();
    userText.setEditable(false);
    userText.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent event){
            sendMessage(event.getActionCommand());
            userText.setText("");
          }
        }
    );
    add(userText, BorderLayout.NORTH);
    chatWindow = new JTextArea();
    add(new JScrollPane(chatWindow));
    setSize(300,150);
    setVisible(true);
  }
  
  //set up and run the server
  public void startRunning(){
    try{
      server = new ServerSocket(6789, 100); //port number and kaç kişinin bağlanacağı 100 kişi 
      while(true){
        try{
          //connect and have conversation
          waitForConnection(); //start up
          setupStreams(); // bağlantı sonrası veri akışına başla
          whileChatting(); // yazışma kısmı
        }catch(EOFException eofException){ //serverda yada bağlantıda sorun var.
          showMessage("\n Ana Sunucu Bağlantıyı Sonlandırdı! ");
        }finally{
          closeCrap(); //clean house staff
        }
      }
    }catch(IOException ioException){
      ioException.printStackTrace();
    }
  }
  // Bağlantı bilgilerinin gelmesi için bekle
  private void waitForConnection() throws IOException{
    showMessage("Bağlantı için bir kullanıcın daha sisteme girmesi gerekiyor..\n");
    connection = server.accept(); //herhangi bir pc bağlandığında ve server bağlantıyı kabul ettiğinde.
    showMessage(" Now connected to " + connection.getInetAddress().getHostName()); 
  }
  // get stream to send and receive data
  private void setupStreams() throws IOException{
    output = new ObjectOutputStream(connection.getOutputStream());
    output.flush();
    input = new ObjectInputStream(connection.getInputStream());
    showMessage("\n Veri Akışı Başlayabilir! \n");
  }
  //  During the chat conversation
  private void whileChatting() throws IOException{
    String message = "Bağlandı";
    sendMessage(message);
    ableToType(true);
    do{
      //have a conversation
      try{
        message = (String) input.readObject();
        showMessage("\n" + message);
      }catch(ClassNotFoundException classNotFoundException){
        showMessage("\n Alınan veri okunamadı");
      }
    }while(!message.equals("Diğer kullanıcı bağlantıdan koptu")); //KULLANAN kişi END dediğinde konuşma biter.
  }
  // konuşma sonlandırıldığınında bağlantıyı ve soketi kapat.
  private void closeCrap(){
    showMessage("\n Bağlantı sonlanıyor..\n");
    ableToType(false);
    try{
      output.close(); // veri çıkışını kapat
      input.close(); // veri girişini kapat. 
      connection.close(); //socket'i kapat.
    }catch(IOException ioException){
      ioException.printStackTrace();
    }
    
  }
  // send a message to client
  private  void sendMessage(String message){
    try{
      output.writeObject("SERVER - " + message);
      output.flush();
      showMessage("\n SERVER - "+ message);
    }catch(IOException ioException){
      chatWindow.append("\n Hata-Veri gönderilemiyor");
    }
  }
  // updates chatWindow
  private void showMessage(final String text){
    SwingUtilities.invokeLater(
        new Runnable(){
          public void run(){
            chatWindow.append(text);
          }
        }
      );
  }
  // let the user type stuff into their box
  private void ableToType (final boolean tof){
    SwingUtilities.invokeLater(
        new Runnable(){
          public void run(){
            userText.setEditable(tof);
          }
        }
      );
    
  }
  
}
–

Server Test
import javax.swing.JFrame;
  public class ServerTest {
    public static void main(String[] args) {
      Server sally = new Server();
      sally.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      sally.startRunning();
    }
  }
 

//2.projenin adı Client. Kendi içerisinde 2 adet .java uzantılı classı barındırmaktadır.

//Kodları

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Client extends JFrame{
  
  private JTextField userText;
  private JTextArea chatWindow;
  private ObjectOutputStream output;
  private ObjectInputStream input;
  private String message = "";
  private String serverIP;
  private Socket connection;
  
  //constructor
  public Client(String host){
    super("Client");
    serverIP = host;
    userText = new JTextField();
    userText.setEditable(false);
    userText.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent event){
          sendMessage(event.getActionCommand());
          userText.setText("");
        }
      }
    );
    add(userText, BorderLayout.NORTH);
    chatWindow = new JTextArea();
    add(new JScrollPane(chatWindow));
    setSize(300, 200); //Ekran büyüklüğünü ayarla
    setVisible(true);
  }
  
  //connect to server
  public void startRunning(){
    try{
      connectToServer();
      setupStreams();
      whileChatting();
    }catch(EOFException eofException){
      showMessage("\n Kullanıcı bağlantıdan koptu");
    }catch(IOException ioException){
      ioException.printStackTrace();
    }finally{
      closeConnection();
    }
  }
  
  //verilen ip numarasındaki bilgisayara 6789 numaralı port üzerinden bağlan.
  private void connectToServer() throws IOException{
    showMessage("Bağlanmaya Çalışıyor... \n");
    connection = new Socket(InetAddress.getByName(serverIP), 6789);
    showMessage("Connection Established! Connected to: " + connection.getInetAddress().getHostName());
  }
  
  //veri akışını ayarla
  private void setupStreams() throws IOException{
    output = new ObjectOutputStream(connection.getOutputStream());
    output.flush();
    input = new ObjectInputStream(connection.getInputStream());
    showMessage("\n Veri akışı ayarlandır! \n");
  }
  
  //while chatting with server
  private void whileChatting() throws IOException{
    ableToType(true);
    do{
      try{
        message = (String) input.readObject();
        showMessage("\n" + message);
      }catch(ClassNotFoundException classNotFoundException){
        showMessage("Unknown data received!");
      }
    }while(!message.equals("Server kapandı"));  
  }
  
  //Close connection
  private void closeConnection(){
    showMessage("\n Bağlantı sonlandırılıyor!");
    ableToType(false);
    try{
      output.close();
      input.close();
      connection.close();
    }catch(IOException ioException){
      ioException.printStackTrace();
    }
  }
  
  //mesajı servera ilet
  private void sendMessage(String message){
    try{
      output.writeObject("CLIENT - " + message);
      output.flush();
      showMessage("\nCLIENT - " + message);
    }catch(IOException ioException){
      chatWindow.append("\n Bir hata meydana geldi!");
    }
  }
  
  // mesaj ekranını güncelle
  private void showMessage(final String message){
    SwingUtilities.invokeLater(
      new Runnable(){
        public void run(){
          chatWindow.append(message);
        }
      }
    );
  }
  
  //kullanıcıların mesaj yazmasına izin ver.
  private void ableToType(final boolean tof){
    SwingUtilities.invokeLater(
      new Runnable(){
        public void run(){
          userText.setEditable(tof);
        }
      }
    );
  }
}
–

import javax.swing.JFrame;
public class ClientTest {
  public static void main(String[] args) {
    Client charlie;
    charlie = new Client("127.0.0.1");
    charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    charlie.startRunning();
  }
}
//Kodlar yazıldıktan sonra 2 projede ayrı ayrı çalıştırılmalıdır.

// 2 projede 127.0.0.1(local ip) ip numaralı bilgisayın 6789 numaralı porttu  üzerinden anlık mesajlaşabileceklerdir.

//Örnek farklı bir ip ile farklı bilgisayarlarda denenebilir.
