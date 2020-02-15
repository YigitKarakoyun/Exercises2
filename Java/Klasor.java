//---KLASOR YOLUNU TANIMLAR---
public String dirPath = System.getProperty("user.dir")+"\\Notes"; 

//İLGİLİ SINIF
public File dir = new File(dirPath);

//YOKSA KLASOR OLUŞTUR
if (!dir.exists()) { dir.mkdir();}


//---KLASOR OLUŞTUR---
public void setKlasorOlustur(){
        String tempString = txtKlasor.getText().trim();
        if (tempString.length()<=0) {
            JOptionPane.showMessageDialog(null, "Boş girdi kabul edilemez", "HataKutusu: " + "Boş Girdi Hatası", JOptionPane.ERROR_MESSAGE);
            txtKlasor.setText("");
            return;
        }  
        //Doluysa
        try {
            String yeniYol = bilgiler.dirPath+"\\"+tempString.toUpperCase();
            System.out.println(yeniYol+" as");
            File dosyaOlustur = new File(yeniYol);
            boolean tempKontrol = dosyaOlustur.mkdir();
            System.out.println(tempKontrol);
            setListKlasorler();
            
            txtKlasor.setText("");
        } catch (Exception e) {System.out.println("Hata mesajı: "+e.getMessage());}
    }


//---DOSYA KLASOR---
package javaapplication1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import javax.swing.JTextArea;

/**
 *
 * @author ykegi
 */
public class _dosyaKlasorIslemleri {
    File file;
    String fileString;
    public _dosyaKlasorIslemleri(){
        this.fileString = System.getProperty("user.dir");
        this.file = new File(fileString);
   
    }
    public _dosyaKlasorIslemleri(String yolString){
        this.fileString = yolString;
        this.file = new File(yolString);
    }
    
    
    //----------------------------------------------------KLASORLER---------------------------------------------------------------------------------
    public File[] getKlasorler(File folder){
        FileFilter filter=new FileFilter(){
          public boolean accept(File file){
            return (file.isDirectory());
          }            
        };
        return folder.listFiles(filter);
    }
    public File[] getKlasorler(String yol){
        File tempFile = new File(yol);
        return getKlasorler(tempFile);
    }
    public File[] getKlasorlerFile(){
        return getKlasorler(this.file);
    }
    

  //-----------------------------------------------------DOSYALAR-------------------------------------------------------------------------
    public File[] getDosyalar(File folder){
        FileFilter filter=new FileFilter(){
          public boolean accept(File file){
            return (file.isFile() && file.toString().toUpperCase().endsWith(".TXT"));
          }            
        };
        return folder.listFiles(filter);
    }
    public File[] getDosyalar(String yol){
        File tempFile = new File(yol);
        return getDosyalar(tempFile);
    }
    public File[] getDosyalarFile(){
        return getDosyalar(this.file);
    }
    public File[] getDosyalar(File[] files,int indeks){
        try {
            File tempFiles = getDosya(files,indeks);
            return getDosyalar(tempFiles.getPath());
     
        } catch (Exception e) {return null;}
    }
    
    public File getDosya(File[] files,int indeks){
        try {
            return files[indeks];
        } catch (Exception e) {return null;}
    }
    public void printDosya(File[] files,int indeks){
        File tempFile = getDosya(files,indeks);
        System.out.println(tempFile.getName()+" "+tempFile.getPath());
    }
  //-----------------------------------------------------PRINTS--------------------------------------------------------------------------
    public void printNames(File[] normals){
        for(int i=0;i<normals.length;i++){
        System.out.println(normals[i].getName());
        }
    }
    public void printPaths(File[] normals){
        for(int i=0;i<normals.length;i++){
        System.out.println(normals[i].getPath());
        }
    }
    public void print(String tempString){
        System.out.println(tempString);
    }
    
    public void setDosyaOkumayup_TextAreaEsitleme(String dosyaYolu, JTextArea textArea) throws IOException 
    {        
        
        File dosya = new File(dosyaYolu); 
        BufferedReader br = new BufferedReader(new FileReader(dosya)); 
        
        String st; 
        while ((st = br.readLine()) != null) {
            textArea.append(st+"\n");
        } 
    }
    public String[] getDosyaOkuma(File dosya) throws IOException 
    {        
        String[] temp = null;
        FileReader fileReader = new FileReader(dosya);
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        long adet = br.lines().count();
        temp = new String[5];
        int indeks = 0;
                
        while ((line = br.readLine()) != null) {

            temp[indeks] = line;
            indeks++;

        }

        br.close();

        return temp;
    }
    public void write(File dosya, JTextArea textArea) throws IOException 
    {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(dosya));
            //String lines = textArea.getText().;
            
            writer.write(textArea.getText()); // Dosyaya yazılıyor
            writer.newLine(); // Yeni satıra geçiliyor
            
        } 
        catch (Exception e) {}
        finally
        {
            if (writer != null) {
            writer.flush();
            writer.close();
            }
        }
    }
    // myTextArea.append(e.getActionCommand() + newline);
    public void write(File dosya, String[] listString) throws IOException 
    {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(dosya));
            for (int i = 0; i < listString.length; i++) {
                writer.write(listString[i]); // Dosyaya yazılıyor
                writer.newLine(); // Yeni satıra geçiliyor
            }           
        } 
        catch (Exception e) {}
        finally
        {
            if (writer != null) {
            writer.flush();
            writer.close();
            }
        }
    }
    
    public void writeClean(File dosya) throws IOException 
    {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(dosya));                
            writer.write(""); // Dosyaya yazılıyor 
        } 
        catch (Exception e) {}
        finally
        {
            if (writer != null) {
            writer.flush();
            writer.close();
            }
        }
    }
}

