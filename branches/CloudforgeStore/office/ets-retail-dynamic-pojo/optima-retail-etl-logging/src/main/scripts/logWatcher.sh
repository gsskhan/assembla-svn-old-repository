#!/bin/ksh
# Set the config variables

#*************************************************Configuration*****************
LOG_FILE_NAME="./error.out"
ERROR_LIST="Exception"
EMAIL_SUBJECT="SUBJECT: OPTIMA RETAIL ETL Application ERROR Notification\n"
EMAIL_TO="hs73849@imcnam.ssmb.com"
EMAIL_FROM="admin@OptimaRetail"
EMAIL_MESSAGE_LINE_COUNT=10
SKIP_ALL_MESSAGE_FLAG=true
#*******************************************************************************

while [ ! -s $LOG_FILE_NAME ];
do
	echo "INFO - Log file is not available. Watcher will check after 30 seconds!!"
	sleep 30
done

i=1
integer lastVal=0;
integer fileLastLineNumber=0;
integer skipCount=0;
while [ "$i" -ne 0 ]
do
	fileLastLineNumber=`wc -l $LOG_FILE_NAME  |sed 's/^\([0-9]\+\).*$/\1/'`
	if  (( $lastVal <= $fileLastLineNumber ));
	then
		awk 'NR >= value1 && NR <=value2' value1="$lastVal" value2="$fileLastLineNumber" $LOG_FILE_NAME > errorTemp.log
		for x in `grep -n -E "$ERROR_LIST" errorTemp.log | sed 's/^\([0-9]\+\):.*$/\1/'`;
		do
			fileContent=`expr $x + $EMAIL_MESSAGE_LINE_COUNT`;
            if (( $x > $skipCount)) || $SKIP_ALL_MESSAGE_FLAG ; then
				echo -e $EMAIL_SUBJECT > mailContent.txt
				awk 'NR >= value3 && NR <= value4' value3="$x" value4="$fileContent" errorTemp.log >> mailContent.txt
				cat mailContent.txt | sendmail -F $EMAIL_FROM $EMAIL_TO
				echo "ERROR FOUND EMAIL SENT TO USER $EMAIL_TO"
            fi
            skipCount=fileContent
			rm -f mailContent.txt
		done;
		rm -f errorTemp.log
	fi
	lastVal=`expr $fileLastLineNumber + 1`;
	sleep 20
done
