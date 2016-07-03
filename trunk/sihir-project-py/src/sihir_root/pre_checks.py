'''
Created on 02-Jul-2016

@author: gsskhan
'''
import os, logging, subprocess, platform, pwd

def _perform_prechecks():
    logging.info("performing prechecks...")
    _print_environment_attributes()
    _check_java_version()
    _check_mysql_client_version()
    logging.info("completed performing prechecks...")


def _check_java_version():
    logging.info("searching java ...")
    pr = subprocess.Popen('java -version', shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    for line in pr.stdout.readlines():
        logging.info("\t" + str(line.decode('ascii')).strip())
    retval = pr.wait()
    if retval == 0 :
        logging.info("java found ...")
    else:
        logging.info("java not found ...")
        
def _check_mysql_client_version():
    logging.info("searching mysql client ...")
    pr = subprocess.Popen('mysql -V', shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    for line in pr.stdout.readlines():
        logging.info("\t"+ str(line.decode('ascii')).strip())
    retval = pr.wait()
    if retval == 0 :
        logging.info("mysql client found ...")
    else:
        logging.info("mysql client not found ...")
        
def _print_environment_attributes():    
    logging.info("\t"+ "operating system        - " + str(platform.uname()))
    logging.info("\t"+ "operating system version- " + str(platform.version()))
    logging.info("\t"+ "linux system            - " + str(platform.linux_distribution()))
    logging.info("\t"+ "mac system              - " + str(platform.mac_ver()))
    logging.info("\t"+ "login id                - " + str(pwd.getpwuid(os.getuid()).pw_name))
    logging.info("\t"+ "python version          - " + str(platform.python_version()))