'''
Created on 14-Sep-2014

@author: gsskhan
'''

# function definition
def print_max(a, b):
    '''Prints the maximum of two numbers.
The two values must be integers.'''
    try:
        a = int(a)
        b = int(b)
        if a > b :
            print "max is", a
        elif a < b :
            print "max is", b
        else :
            print a, "and" , b, "are equal."
    except Exception:
        print "error... one or more input argument to function is not of int type." 
        
# calling the function
if __name__ == '__main__':
    print print_max.__doc__
    firstnum = raw_input("please enter first number: ")
    secondnum = raw_input("please enter second number: ")
    print_max(firstnum, secondnum)
    print "program end, exiting ..."

