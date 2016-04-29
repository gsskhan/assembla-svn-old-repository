#!/bin/bash

# Set JAVA_HOME class path.
export JAVA_HOME=/opt/jdk/1.7.0_21l64
export PATH=$PATH:$JAVA_HOME/bin

# SET ANT_HOME class path.
export ANT_HOME=/opt/build/home/apache-ant-1.9.1
export PATH="$ANT_HOME/bin:$PATH"

#  Build file path.
BATCH_SOURCE_FILE="/opt/build/home/.jenkins/jobs/Optima Retail ETL Build/workspace/optima-retail-etl-batch/target/optima-retail-etl-batch-1.0-SNAPSHOT-deploy.zip"

# Destination folder to unzip the build file.
BATCH_DESTINATION_FOLDER=/tmp/RRTS/ETL

# Application folder path, ant configuration file will load the required jars and configuration files.
APP_DIR=$BATCH_DESTINATION_FOLDER/batch

# Ant will write the log files in config folder.
ANT_CONFIG_DIR=$BATCH_DESTINATION_FOLDER/config

#Ant build file
ANT_BUILD_FILE=$APP_DIR/bin/batchAdmin.xml

# JMX Configuration details.
MAX_HEAP_SIZE=4096m
JMX_PORT=1099
HTTP_PORT=8080

if [ -f "$BATCH_SOURCE_FILE" ]
then
	# Stop the Batch container if build file exists in config file.
	if [ -f "$ANT_BUILD_FILE" ]
	then
		echo "Stopping container"
		sh ant -Dapp.dir="$APP_DIR" -DmaxMemory="$MAX_HEAP_SIZE" -Djmx.port="$JMX_PORT" -Dhttp.port="$HTTP_PORT" stop -f $ANT_BUILD_FILE 1> $ANT_CONFIG_DIR/batch-stop.log 2>&1 &
	fi	
	# Remove the old files from batch folder.
	rm -rf $BATCH_DESTINATION_FOLDER/batch	
	# Unzip and move the build to batch destination folder.
	unzip "$BATCH_SOURCE_FILE" -d $BATCH_DESTINATION_FOLDER
	
	echo "Starting container"
	sh ant -Dapp.dir="$APP_DIR" -DmaxMemory="$MAX_HEAP_SIZE" -Djmx.port="$JMX_PORT" -Dhttp.port="$HTTP_PORT" start -f $ANT_BUILD_FILE 1> $ANT_CONFIG_DIR/batch-start.log 2>&1 &
else
	echo "$BATCH_SOURCE_FILE not found."
fi
