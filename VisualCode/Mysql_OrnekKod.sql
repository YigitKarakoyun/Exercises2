USE master
CREATE TABLE tablo1(

    id int identity(0,5) Primary key,
	isim nvarchar(50) not null
)
SELECT * FROM tablo1
insert into tablo1 values('adem')
