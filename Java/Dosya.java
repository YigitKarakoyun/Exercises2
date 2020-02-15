//----------------------------------DOSYA OLUŞTURUR-----------------------------
String yeniYol = "C:\\CAN\\";
File dosyaOlustur = new File(yeniYol);
boolean kontrol = dosyaOlustur.createNewFile();
if (kontrol) {
   //DOSYA OLUŞTURULDU
}


//--------------------------DOSYA OKUMA----------------------------------------
public void setDosyaOkuma(int indeks,JTextArea textArea) throws IOException 
    {        
        File dosya = null; 
        try {
            dosya = "C:\\yeni.txt";
            BufferedReader br = new BufferedReader(new FileReader(dosya));
            
            String st; 
            textArea.setText("");
            while ((st = br.readLine()) != null) {
                textArea.append(st+"\n");
            }
            
        } 
        catch (Exception e) 
        {            
        } 
    }
    
//----------------------------DOSYAYA YAZMA-----------------------------------
public void setDosyaYazma(int indeks,JTextArea textArea){
   
        try{
            String yeniYol = getDosyaFile(indeks).getPath();
            File dosya = new File(yeniYol);
            FileWriter yazici = new FileWriter(dosya);
            BufferedWriter yaz = new BufferedWriter(yazici);
            
            String tempTextAreaText = textArea.getText();
            
            String[] tempLines = tempTextAreaText.split("\\n");
           
            for (String line : tempLines) {
                String tempWrite = line+"\n";
                yaz.write(tempWrite);
                //message(tempWrite);
            }

            //System.out.println("Ekleme İşlemi Başarılı");
            yaz.flush();
            yaz.close();            
        }
            
        catch (Exception hata){
                  System.out.println(hata.getMessage());;
            
        }
    }
