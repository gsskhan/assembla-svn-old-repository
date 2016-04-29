'''
Created on 04-Sep-2014
author - gsskhan
'''
# first program of learning python

from learning import maxnumber

print 'program started ...'

print 'hello' ,
print 'world !!!'

name = 'Gulam'
age = 28
print '1. My name is {0}, and age is {1}.'.format(name, age)
print '2. My name is {}, and age is {}.'.format(name, age)
print '3. My name is {n}, and age is {a}.'.format(n='Gulam',a='28')
print '4. My name is '+ name +', and age is '+ str(age) +'.'

print '5. Representation of float value of 1 divided by 3 to precision of 4 decimal places = {0:.4f}'.format(1.0/3)
# fill with underscores (_) with the text centered (^) to 11 width '___hello___'
print '6. Sample Text = {0:_^11}'.format('hello')

print "7. This is the first sentence. \
This is the second line."

age = age + 2
print '8. printing incremented value of age = ' , age

print "9. String repeat three times = " + 'Hello!' * 3

print '10. Display numbers from one to 6.'
for i in range(1, 7):
    print ' >>', i
else:
    print 'done.'

print "11. program to find maximum b/w two numbers (10, 6)..."
learning.maxnumber.print_max(10, 6)

print 'program finished ...'