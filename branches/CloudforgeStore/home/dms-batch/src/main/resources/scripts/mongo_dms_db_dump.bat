
echo 'creating dump files'
C:/mongodb/bin/mongodump --host localhost --port 27017 -db dms --out /tmp/batch

echo 'archiving and compressing dump files'
cd /tmp/batch
"C:/Program Files (x86)/7-Zip/7z.exe" a -tzip dms_mongo_dump.zip dms

echo 'cleaned up disk space'
echo y| rmdir /S dms

exit