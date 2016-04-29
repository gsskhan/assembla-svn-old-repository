#!/usr/bin/env python3

'''
Created on 06-Dec-2015
@author: gsskhan
@attention: #!/usr/bin/env python3 on top of script acts as shebang character, and if you want to run this file without specifying python version
            from command line, then shebangs helps to get the correct python version detected to run this program
'''

# import section
import platform
import os
import sys
from learning import constants


# code section
print ('Started program with python ' + platform.python_version());       
print ('Platform: ' + sys.platform +' \n');    

print("Example of importing an attribute " + constants.application_name);

print('Two raised to power of four = ' + str (2 ** 4) );

emp_name = 'Gulam Sabir Shahbaz Khan'
print('Employee Name= ' + emp_name);

print('Printing a word 8 times: '+ 'hello!' * 8);

print('Present working directory: '+ os.getcwd());

print('Printing each alphabet in a string:');
for x in 'GulamKhan':
    print(x)
print('done printing. \n');


input_str = input('Please input a string to be read: ');
print('you have entered: '+input_str+'\n');

print('Addition for two numbers.');
num_first = input("Please enter first number: ");
num_second = input("Please enter second number: ");
print("Result of addition is "+ str( int(num_first) + int(num_second) ) +'\n');

# To read contents of a file and execute
exec(open('constants.py').read());

