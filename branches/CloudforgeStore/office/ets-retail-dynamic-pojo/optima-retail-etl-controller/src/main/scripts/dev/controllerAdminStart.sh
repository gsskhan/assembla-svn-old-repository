#!/bin/bash

# Set JAVA_HOME class path.
export JAVA_HOME=/opt/jdk/1.7.0_21l64
export PATH=$PATH:$JAVA_HOME/bin

# SET ANT_HOME class path.
export ANT_HOME=/opt/build/home/apache-ant-1.9.1
export PATH="$ANT_HOME/bin:$PATH"

#  Build file path.
CONTROLLER_SOURCE_FILE="/opt/build/home/.jenkins/jobs/Optima Retail ETL Build/workspace/optima-retail-etl-controller/target/optima-retail-etl-controller-1.0-SNAPSHOT-deploy.zip"

# Destination folder to unzip the build file.
CONTROLLER_DESTINATION_FOLDER=/tmp/RRTS/ETL

# Application folder path, ant configuration file will load the required jars and configuration files.
APP_DIR=$CONTROLLER_DESTINATION_FOLDER/controller

# Ant will write the log files in config folder.
ANT_CONFIG_DIR=$CONTROLLER_DESTINATION_FOLDER/config

#Ant build file
ANT_BUILD_FILE=$APP_DIR/bin/controllerAdmin.xml

# JMX Configuration details.
MAX_HEAP_SIZE=4096m
JMX_PORT=1101
HTTP_PORT=8081

if [ -f "$CONTROLLER_SOURCE_FILE" ]
then
	# Stop the Controller container if build file exists in config file.
	if [ -f "$ANT_BUILD_FILE" ]
	then
		echo "Stopping controller container"
		sh ant -Dapp.dir="$APP_DIR" -DmaxMemory="$MAX_HEAP_SIZE" -Djmx.port="$JMX_PORT" -Dhttp.port="$HTTP_PORT" stop -f $ANT_BUILD_FILE | tee $ANT_CONFIG_DIR/controller-stop.log
	fi	
	# Remove the old files from controller folder.
	rm -rf $CONTROLLER_DESTINATION_FOLDER/controller	
	# Unzip and move the build to controller destination folder.
	unzip "$CONTROLLER_SOURCE_FILE" -d $CONTROLLER_DESTINATION_FOLDER
	
	echo "Starting container for controller"
	sh ant -Dapp.dir="$APP_DIR" -DmaxMemory="$MAX_HEAP_SIZE" -Djmx.port="$JMX_PORT" -Dhttp.port="$HTTP_PORT" start -f $ANT_BUILD_FILE | tee $ANT_CONFIG_DIR/controller-start.log 
else
	echo "$BATCH_SOURCE_FILE not found."
fi
