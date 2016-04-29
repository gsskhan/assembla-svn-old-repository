#!/bin/bash

# Export Java Home
export JAVA_HOME=/opt/jdk/1.7.0_21l64
export PATH=$PATH:$JAVA_HOME/bin

APP_DIR=/opt/RRTS/ETL/logging
LOG_DIR=$APP_DIR/log

CLASSPATH="$APP_DIR/lib/*:$APP_DIR/config"

CLASS=com.citi.retail.optima.etl.logging.JMSLoggingConsumer
 
java  -DmaxMemory="$MAX_HEAP_SIZE" -classpath $CLASSPATH $CLASS  1> $LOG_DIR/logging.log 2>&1 & 
