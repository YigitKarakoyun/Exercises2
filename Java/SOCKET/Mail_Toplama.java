Web Sitesinden Mail Toplama Aracı
Ocak 25, 2017 Yazarı: Dr.Who
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.*;
public class FetTheMailUI extends javax.swing.JFrame {
public FetTheMailUI() {
initComponents();
}
@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">
private void initComponents() {
jScrollPane1 = new javax.swing.JScrollPane();
jTextArea1 = new javax.swing.JTextArea();
jPanel1 = new javax.swing.JPanel();
jLabel1 = new javax.swing.JLabel();
jTextField1 = new javax.swing.JTextField();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
jMenuBar1 = new javax.swing.JMenuBar();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setTitle("FetchTheMail");
setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
setResizable(false);
jTextArea1.setColumns(20);
jTextArea1.setRows(5);
jScrollPane1.setViewportView(jTextArea1);
jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
jLabel1.setText("Web Sayası");
jButton1.setText("E-mail Getir");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});
jButton2.setText("Dosyayı Aç");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});
javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
jPanel1.setLayout(jPanel1Layout);
jPanel1Layout.setHorizontalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addComponent(jLabel1)
.addGap(18, 18, 18)
.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addComponent(jButton1)
.addGap(18, 18, 18)
.addComponent(jButton2)
.addContainerGap(25, Short.MAX_VALUE))
);
jPanel1Layout.setVerticalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment. BASELINE)
.addComponent(jLabel1)
.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jButton1)
.addComponent(jButton2))
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
);
setJMenuBar(jMenuBar1);
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(jScrollPane1))
.addContainerGap(50, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap(30, Short.MAX_VALUE)
.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
);
pack();
}// </editor-fold>
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
try {
Document doc = Jsoup.connect(jTextField1.getText()).get();
String email = doc.getElementsMatchingOwnText("(?simx)\\b[A-Z0-9._%+]+" +"@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b").text();
email = email.replace(" ","\n");
jTextArea1.setText(email);
} catch (IOException ex) {
Logger.getLogger(FetTheMailUI.class.getName()).log(Level.SEVERE, null, ex);
}
try{
File dosya = new File("C:/Users/FetchTheMail/eMails/eMails.txt");
FileWriter yazici = new FileWriter(dosya,true);
try (BufferedWriter yaz = new BufferedWriter(yazici)) {
yaz.write(jTextArea1.getText()+"    " );
yaz.close();
}
}
catch (Exception e){
JOptionPane.showMessageDialog(null,e.getMessage());
}
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
try {
Runtime load = Runtime.getRuntime();
String program = "notepad.exe";
String file = "C:/Users/Cevanşir/Desktop/FetchTheMail/eMails/eMails.txt";
load.exec(program + " " + file);
} catch (IOException e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
/**
* @param args the command line arguments
*/
public static void main(String args[]) {
/*
* Set the Nimbus look and feel
*/
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
/*
* If Nimbus (introduced in Java SE 6) is not available, stay with the
* default look and feel. For details see
* http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
*/
try {
for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
if ("Nimbus".equals(info.getName())) {
javax.swing.UIManager.setLookAndFeel(info.getClassName());
break;
}
}
} catch (ClassNotFoundException ex) {
java.util.logging.Logger.getLogger(FetTheMailUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
java.util.logging.Logger.getLogger(FetTheMailUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
java.util.logging.Logger.getLogger(FetTheMailUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
java.util.logging.Logger.getLogger(FetTheMailUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
//</editor-fold>
/*
* Create and display the form
*/
java.awt.EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
new FetTheMailUI().setVisible(true);
}
});
}
//"http://mf.maltepe.edu.tr/yazilimtr/kadro"
// Variables declaration - do not modify
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JLabel jLabel1;
private javax.swing.JMenuBar jMenuBar1;
private javax.swing.JPanel jPanel1;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTextArea jTextArea1;
private javax.swing.JTextField jTextField1;
// End of variables declaration
}
