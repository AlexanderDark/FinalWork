cd C:\users\%USERNAME%
mkdir HW7
cd HW7
curl -A "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64)" -L "https://github.com/aerokube/cm/releases/download/1.7.2/cm_windows_amd64.exe" --ssl-no-revoke -o cm.exe
cm.exe selenoid start --vnc --browsers "chrome;firefox" --last-versions 3 --args "-limit 4" -f
cm.exe selenoid-ui start