#!/bin/bash

export ANT_HOME=/home/ns21567/ant_pkg/apache-ant-1.9.1
export JAVA_HOME=/opt/jdk/1.7.0_21l64

APP_DIR=/home/ns21567/ant_pkg/ETL/batch
SCRIPT_DIR=$APP_DIR/bin
LOG_DIR=$APP_DIR/log

MAX_HEAP_SIZE=4096m
ANT_SCRIPT=batchStart.xml

$ANT_HOME/bin/ant -Dapp.dir="$APP_DIR" -DmaxMemory="$MAX_HEAP_SIZE" -f $ANT_SCRIPT 1> $LOG_DIR/batch.log 2>&1 & 
