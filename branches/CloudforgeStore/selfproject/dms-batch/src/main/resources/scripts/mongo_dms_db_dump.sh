#!/bin/sh

echo 'creating dump files'
mongodump --host localhost --port 27017 -db dms --out /tmp/batch/

echo 'archiving and compressing dump files'
cd /tmp/batch
tar -zcvf dms_mongo_dump.tar.gz dms

echo 'cleaned up disk space'
rm -r /tmp/batch/dms

exit