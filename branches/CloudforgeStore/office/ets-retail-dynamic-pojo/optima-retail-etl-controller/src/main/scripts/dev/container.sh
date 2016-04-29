#!/bin/sh

# Export Java Home
export JAVA_HOME=/optware/jdk-1.7.0_21l64
export PATH=$PATH:$JAVA_HOME/bin

#controller configuration
MODULE_CFG="classpath:/retail.optima.etl.controller.xml"
JMX_PORT=1080
HTTP_PORT=8080
REMOTE_PORT=9010

Usage() {
 echo "Usage: sh container.sh  {start|stop|restart} {controller|batch}"
 exit 1
}

if [[ "$2" == "" ]]
then 
  echo "Usage: sh container.sh {start|stop} {controller|batch}"
  exit 1
fi

# Batch configuration
if [ "$2" == "batch" ];
then
	echo "Starting batch module!"
	MODULE_CFG="classpath:/retail.optima.etl.batch.xml"
	JMX_PORT=1110
	HTTP_PORT=8081
	REMOTE_PORT=9012
fi

# Classpath configuration
APP_DIR=/orbs/home/ETL/$2
CLASSPATH="$APP_DIR/lib/*:$APP_DIR/config"
CLASS=com.citi.retail.optima.etl.container.ContainerAdmin
LOG="$APP_DIR/config/$2.log"
DEBUGLOG="$APP_DIR/config/$2_debug.log"



# Start container Configuration parameters.
START_ARGS="-Djmx.port=$JMX_PORT -Dhttp.port=$HTTP_PORT -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=$REMOTE_PORT -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false"
START_PARAMS="--command=start --type=container --module-name=$2 --module-config=$MODULE_CFG --auto-start=true"

# stop container Configuration parameters.
STOP_ARGS="-Djmx.port=$JMX_PORT -Dhttp.port=$HTTP_PORT"
STOP_PARAMS="--command=stop --type=container"

StartContainer() {
$JAVA_HOME/bin/java   $START_ARGS -cp $CLASSPATH $CLASS  $START_PARAMS > $LOG 2> $DEBUGLOG & 
}

StopContainer() {
 $JAVA_HOME/bin/java   $STOP_ARGS -cp $CLASSPATH $CLASS  $STOP_PARAMS
}

case "$1" in
  start)      
	StartContainer	
       ;;
  restart) 
	StartContainer     
	StopContainer	
       ;;
  stop)
	StopContainer
      ;;  
   *)
    Usage       
esac