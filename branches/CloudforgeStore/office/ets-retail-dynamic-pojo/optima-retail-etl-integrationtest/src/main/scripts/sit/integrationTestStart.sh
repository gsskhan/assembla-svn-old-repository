#!/bin/bash


# Set JAVA_HOME class path.
export JAVA_HOME=/opt/jdk/1.7.0_21l64
export PATH=$PATH:$JAVA_HOME/bin

# Set Ant Home
export ANT_HOME=/opt/build/home/apache-ant-1.9.1
export PATH="$ANT_HOME/bin:$PATH"

APP_DIR=/opt/RRTS/ETL/integrationtest
SCRIPT_DIR=$APP_DIR/bin
LOG_DIR=$APP_DIR/log

MAX_HEAP_SIZE=4096m
ANT_SCRIPT=integrationTestStart.xml

ant -Dapp.dir="$APP_DIR" -DmaxMemory="$MAX_HEAP_SIZE" -f $ANT_SCRIPT 1> $LOG_DIR/test.log 2>&1 & 
