'''
Created on 03-Jul-2016

@author: gsskhan
'''


import sys, logging, mysql.connector
from logging.handlers import RotatingFileHandler

def _enable_logging():
    log = logging.getLogger()
    log.setLevel(logging.DEBUG)
    frmt = logging.Formatter("[%(asctime)s] %(levelname)s {%(module)s,%(lineno)s} - %(message)s")    
    # console logging
    ch = logging.StreamHandler(sys.stdout)
    ch.setFormatter(frmt)
    log.addHandler(ch)    
    # file logger
    fh = RotatingFileHandler("/home/gsskhan/logs/sihir-log.log", maxBytes=1000000 , backupCount=3)
    fh.setFormatter(frmt)
    log.addHandler(fh)
    
def _get_mysqldb_connection(user, password, host='localhost', port=3306 , database='test'):
    try:
        conn = mysql.connector.connect(user=user, password=password, 
                                      host=host, port=port, database=database)        
    except Exception as e:
        logging.error("problem connecting mysqldb...")
        logging.exception(e)
        raise e
    else:
        logging.info("connection to mysqldb at host:"+ str(host)+ ", port:"+str(port)+" successful ...")
    return conn

def _close_mysqldb_connection(connection):
    connection.close()