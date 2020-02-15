//Dosyayı Texture Olarak Yükle
void enumDosyadanYukle(string path = @"D:\fatman\texture.png")
{
  Texture2D texture = new Texture2D(2, 2);
  GameObject image = GameObject.Find("RawImage");
  byte[] byteArray = File.ReadAllBytes(path);
  bool tempYuklendi = texture.LoadImage(byteArray);
  if (tempYuklendi)
  {
    image.GetComponent<RawImage>().texture = texture;
  }
}

//Dosyayı Texture Olarak Yükle
void enumDosyadanYukle(string path = @"D:\fatman\texture.png", GameObject image)
{
  Texture2D texture = new Texture2D(2, 2);
  byte[] byteArray = File.ReadAllBytes(path);
  bool tempYuklendi = texture.LoadImage(byteArray);
  if (tempYuklendi)
  {
    image.GetComponent<RawImage>().texture = texture;
  }
}
