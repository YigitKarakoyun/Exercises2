BİRDEN FAZLA PARAMETRE YAPIMI   
 public Tuple<int[], int> getDizi(int[] dizi, int arama)
    {
        var tuple = new Tuple<int[], int>(dizi,arama);
        return tuple;
    }
TUPLE ERİŞİM
public void setTest()
    {
       var tuple = getDizi(null, 0);
        tuple.Item1 = new int[5];
        tuple.Item2 = 5;
    }//TUPLE İTEM SALT OKUNUR ATAMA YAPILAMAZ!!!!!!!!
