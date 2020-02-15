# ---ADRESLER---
https://docs.microsoft.com/en-us/aspnet/core/tutorials/publish-to-azure-webapp-using-vscode?view=aspnetcore-2.2


# ---KOMUTLAR---
# Yeni konsol projesi
dotnet new console

# Derleme
dotnet build

# Çalıştırma
dotnet run

# Publish Etme
dotnet publish -c Release -o ./publish

# Release Etme
dotnet publish -c Release -r win10-x64

dotnet publish -c Release -r ubuntu.16.10-x64


