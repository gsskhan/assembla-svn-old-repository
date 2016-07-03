'''
Created on 03-Jul-2016

@author: gsskhan
'''
import logging

class DatabaseAccess():
    '''
    this class contains methods for accessing database objects
    '''

    def __init__(self, connection):
        self.connection = connection        
        
    def _get_test_records(self):
        cursor = self.connection.cursor()
        cursor.execute("select * from sample_test")
        for row in cursor:
            logging.info(str(row))
        cursor.close()
        