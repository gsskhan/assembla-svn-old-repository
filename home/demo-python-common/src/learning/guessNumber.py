'''
Created on 13-Sep-2014

@author: gsskhan
'''

# This program will help user to guess a number.
print "program started ..."
num = 23
running = True

while running:
    guess = raw_input("Enter a number please : ")
    print 'guessing the input number', guess ,"."
    guess = int(guess)
    if guess == num:
        print 'Congrats! your guess is correct.'
        running = False
    elif guess > num:
        print 'No, its lower than that'
    elif guess < num:
        print 'No, its higher than that'
else:
    print 'exiting shortly.'
  
print "program end ..."