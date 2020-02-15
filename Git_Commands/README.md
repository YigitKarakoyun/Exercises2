# Git_Kaynaklar
http://ahmetertem.com.tr/git-temel-komutlar-kullanimlar/

https://medium.com/@odayibasi/git-komutlar%C4%B1-ve-kullan%C4%B1m%C4%B1-51ec0c07a434

https://www.hostinger.web.tr/rehberler/github-kullanimi-basit-git-komutlari

https://kod5.org/baslica-git-komutlari/

https://yazilimportal.com/git-komutlari-ve-ileri-kullanim-9198fbeef777

http://www.kernel.org/pub/software/scm/git/docs/

http://git-scm.com/book

https://github.com/marmara/Culture/blob/master/Git%20Komutlari

http://tasarlamag.com/git-komutlari/

https://ceaksan.com/tr/git-komutlari/

http://kadirkasim.com/yazi/git-komutlari

https://www.sourcetreeapp.com/

# Git Olusturma
Initialize yaptigimizda klasorde git alt yapisini (klasor yapisini) olusturur.

    git init


# Duruma Bakma
Ingilizcedeki status kelimesi Turkce’ye durum olarak cevirilebilir. 

Repository’mizin durumuna bakmak cogu zaman yapmamiz gereken bir adimdir. 

Bize repo ile ilgili bilgi verir ve duruma gore islem yapmamizi saglar.

    git status

# Repository Klonlama
Bir repository’yi klonlamak en basit islemlerden birisidir. 

Tek sart hedef klasorun olmamasi ya da bos olmasidir (bazilari klasor olsa da icini bosaltiyor vs o ayri bir konu fakat Git SCM uzerinden konusacagim)

    git clone repository_url [klasor_adi]


Klasor adi ise zorunlu degildir fakat ogrenmenizde de fayda var elbette.

Ornek olarak bunu yapabilirsiniz. Eger SSH Key ayarlamadiysaniz hata verebilir.

    git clone git@github.com:ahmetertem/query_builder.git qb


# Repository’ye Dosya Ekleme
Dosya eklemek ve commit etmek iki ayri istir, hatta yukariya (sunucuya) yuklemek ayri islerdir. Bunu adim adim isleyecek olursak, dosyalari eklemek, commit etmek ve yukari yuklemek (pushlamak) olarak sirayla gitmemiz gerekiyor.

# Dosyalari Ekleme
Dosyalari repository’ye eklemek icin add argumanini kullanacagiz.

Ornegin;

    // repository root dizininden;
    git add dosyaadi.uzanti
    git add klasor/yolu/dosyaadi.uzanti
    git status

Repositorymizin root dizinindeyken bu sekilde ekleyebiliriz, root dizinde degilsek cd ile dolasarak islem yapabiliriz.

Ornegin;

    // root dizinden yola cikarak hareket edecegiz.
    cd images
    git add logo.png
    cd ..
    cd scripts
    git add layout.js
    git add npm.js
    cd ..
    git status

# Dosyalari Commit Etme
Add yaparak degisiklik yapilmis, eklenmis, silinmis dosyalari vs commit’imiz icin hazirladik. Simdi sira commit etmede. Commit etmeyi islemek olarak adlandirabiliriz. Yani; su, su dosyayi ekledim, su dosyayi sildim, bunu guncelledim vs diyoruz.

Commit ederken bir de mesaj yazmamiz gerekiyor, neyi ekledik sildik gibi fakat cok da abartmamak gerek zaten committe neler degisti gorulebiliyor. Ornegin “#123. bug giderildi” yazabiliriz. Tutup da a dosyasi eklendi, b dosyasi silindi gibi uzun uzadiya mesaj yazmaniza gerek yok, ornek olarak burayi inceleyebilirsiniz. Ornekteki commit detayinda sadece 1 tane dosyada degisiklik yapildigi icin sadece o dosyanin degisikliklerini gorebilirsiniz fakat farkli repolara bakarak o committe neler degismis gorebilirsiniz.

    git commit -m 'mesajimizi buraya yaziyoruz'

Yukarida tek satirlik bir ornek yaptik.

-m ile direk mesajimizi yazabiliriz. Alternatif olarak direk git commit diyerek vim gibi mesajimizi yazabilir ve degisiklige detayli yazi yazabilirdik.

 

# Commit(ler)i Pushlama
Pushlamak, yukari atmak olarak da adlandiracagimiz bir adim… Dosyalari duzenledik, sildik, ettik artik sira degisiklikleri ana repository’ye atmakta.

    git push [remote_adi] [branch_adi]

Ornegin;

    git push origin master

 
# Uzak Repo’dan Guncel Hali Cekmek
Remote (uzak) repository’den son guncel halini cekmek icin oncelikle fetch, ardindan pull yapacagiz.

# Fetch
Fetch, Ingilizcede ‘git, al, getir‘ demektir (ya da oyle birsey). Fetch ettigimizde ise son guncel halinin sadece durumunu getirir. Yani su degisti, bu degisti gibi… Degisiklikleri cekmek icin ise pull’u kullanacagiz.

    git fetch [remote_ismi]

Ornegin;

    git fetch origin

Varsayilan isim, belirtmemisseniz eger “origin” dir…

 
# Pull
Pull, cekmek demektir. Degisiklikleri aldik, artik cekebiliriz. Fetch yapmadan pull yaparsaniz fetchlemis oldugunuz son halini cekersiniz.

    git pull [remote_adi] [branch_adi]

Ornegin;

    git fetch origin
    git pull origin master
