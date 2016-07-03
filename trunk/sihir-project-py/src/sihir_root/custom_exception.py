'''
Created on 03-Jul-2016

@author: gsskhan
'''
class SihirCustomException(RuntimeError):
    '''
    exception class over ridden exclusive for sihir project
    '''

    def __init__(self, message):
        self.msg = message