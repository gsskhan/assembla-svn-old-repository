'''
Created on 30-Sep-2014

@author: gsskhan
'''

from pymongo import MongoClient


client = MongoClient('localhost', 27017)

db = client.dms
collection = db.constants

print 'First record:'
print collection.find_one()

# find all documents
print 'All records:'
results = collection.find()
for record in results:
    print record
    
client.close();