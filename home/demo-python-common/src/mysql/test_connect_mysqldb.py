'''
Created on 18-Sep-2014

@author: gsskhan
'''

# To connect to local mysql db

import mysql.connector as my

# Open database connection
cnx = my.connect(host='localhost',port='3306',user='root',password='password',database='dms')

# prepare a cursor object using cursor() method
cur = cnx.cursor()

# execute SQL query using execute() method.
sql = 'SELECT * FROM SYSTEM_USER'
cur.execute(sql)

# Fetch a all rows using fetchall() method.
results = cur.fetchall()

print "Records fetched from db -"
for row in results:
    print row

# disconnect from server
cnx.close()



