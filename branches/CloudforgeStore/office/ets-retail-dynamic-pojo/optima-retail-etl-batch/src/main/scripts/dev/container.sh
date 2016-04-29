# Export Java Home
export JAVA_HOME=/opt/jdk/1.7.0_25l64
export PATH=$PATH:$JAVA_HOME/bin

#controller configuration
MODULE_CFG="classpath:/retail.optima.etl.controller.xml"
JMX_PORT=1080
HTTP_PORT=8080


Usage() {
 echo "Usage: sh container.sh  {start|stop|restart} {controller|batch|logging}"
 exit 1
}

if [[ "$2" == "" ]]
then 
  echo "Usage: sh container.sh {start|stop} {controller|batch|logging}"
  exit 1
fi

# Batch configuration
if [ "$2" == "batch" ];
then
	echo "Starting batch module!"
	MODULE_CFG="classpath:/retail.optima.etl.batch.xml"
	JMX_PORT=1110
	HTTP_PORT=8081
elif [ "$2" == "logging" ]
then
	echo "Starting logging module!"
	MODULE_CFG="classpath:/retail.optima.etl.logging.xml"
	JMX_PORT=1111
	HTTP_PORT=8082
fi

# Classpath configuration
APP_DIR=/orbs/home/ETL/$2
CLASSPATH="$APP_DIR/lib/*:$APP_DIR/config"
CLASS=com.citi.retail.optima.etl.container.ContainerAdmin
LOG="/orbs/home/ETL/logs/$2.log"
DEBUGLOG="/orbs/home/ETL/logs/$2_debug.log"

# Start container Configuration parameters.
START_ARGS="-Djmx.port=$JMX_PORT -Dhttp.port=$HTTP_PORT -Dlogback.configurationFile=$APP_DIR/config/logback.xml"
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