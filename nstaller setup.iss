[Setup]
AppName=OBS-like App
AppVersion=1.0
DefaultDirName={pf}\OBS-like App
OutputBaseFilename=setup
SetupIconFile=resources\icon.ico
Compression=lzma
SolidCompression=yes

[Files]
Source: "dist\*"; DestDir: "{app}"

[Icons]
Name: "{group}\OBS-like App"; Filename: "{app}\obs-like-app.exe"
Name: "{commondesktop}\OBS-like App.lnk"; Filename: "{app}\obs-like-app.exe"; Tasks: desktopicon

[Run]
Filename: "{app}\obs-like-app.exe"; Description: "Launch OBS-like App"; Flags: nowait postinstall skipifsilent

[Tasks]
Name: "desktopicon"; Description: "Создать ярлык на рабочем столе"; GroupDescription: "Дополнительно:"

