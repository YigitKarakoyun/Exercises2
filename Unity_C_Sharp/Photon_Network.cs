//1_OnJoinedLobby
void Start()
{
   //PhotonNetwork.autoJoinLobby = true;
    PhotonNetwork.ConnectUsingSettings("0.1");
}

//Lobby girildi
void OnJoinedLobby()
{
    Debug.Log("LOBBY ERİŞİLDİ");
}

//2_AutoJoinLobby
PhotonNetwork.autoJoinLobby = true;

//3_OnCreatedRoom
void Start()
{
    PhotonNetwork.ConnectUsingSettings("0.1");
}

void OnJoinedLobby()
{
    Debug.Log("LOBBY ERİŞİLDİ");
    PhotonNetwork.CreateRoom("Oda1");
    //PhotonNetwork.JoinOrCreateRoom("Oda1",null,TypedLobby.Default);
}
void OnCreatedRoom()
{
    Debug.Log("ODA OLUŞTURULDU");
}

//4_OnCreatedRoom
void OnCreatedRoom()
{
    Debug.Log(PhotonNetwork.room.Name+" ADINDA ODA OLUŞTURULDU");
}

//5_PlayerName
void OnCreatedRoom()
{
   //Oyuncu ismini vermek
   PhotonNetwork.playerName = "Slayer1";

   Debug.Log(
PhotonNetwork.room.Name+" odaya "+
PhotonNetwork.playerName+" giris yapti.");
}

//6_Player_NickName
//İKİSİNİN DE GÖREVİ AYNI
//PhotonNetwork.playerName = "Slayer1";
//PhotonNetwork.player.NickName = "Slayer1";

//7_RoomOptions
void OnJoinedLobby()
{
    RoomOptions roomOptions = new RoomOptions() {
      MaxPlayers = 7,
      IsVisible = true,
      IsOpen = true,
    };
    Debug.Log("LOBBY ERİŞİLDİ");
    PhotonNetwork.JoinOrCreateRoom("Oda1",roomOptions,TypedLobby.Default);
}

//7_RoomOptions_Sample
void Start()
{
    PhotonNetwork.ConnectUsingSettings("0.1");
}
void OnJoinedLobby()
{
    RoomOptions roomOptions = new RoomOptions() {
      MaxPlayers = 7,
      IsVisible = true,
      IsOpen = true,
    };
    Debug.Log("LOBBY ERİŞİLDİ");
    //PhotonNetwork.CreateRoom("Oda1");
    PhotonNetwork.JoinOrCreateRoom("Oda1",roomOptions,TypedLobby.Default);
}
void OnCreatedRoom()
{
    PhotonNetwork.playerName = "Ahmet";
    PhotonNetwork.player.NickName = "Slayer1";
    Debug.Log(PhotonNetwork.room.Name+" odaya "+PhotonNetwork.playerName+" oyuncusu giris yapti.= "+PhotonNetwork.player.NickName);
    Debug.Log("Max oyuncu sayisi: "+PhotonNetwork.room.MaxPlayers+" oyuncu sayisi: "+PhotonNetwork.room.PlayerCount);
}

