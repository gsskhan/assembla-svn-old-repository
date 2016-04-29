#!/bin/bash

APP_DIR=/orbs/home/ETL/integrationtest
SCRIPT_DIR=$APP_DIR/bin
LOG_DIR=$APP_DIR/log

MAX_HEAP_SIZE=4096m
ANT_SCRIPT=integrationTestStart.xml

sh ant -Dapp.dir="$APP_DIR" -DmaxMemory="$MAX_HEAP_SIZE" -f $ANT_SCRIPT 1> $LOG_DIR/test.log 2>&1 & 
