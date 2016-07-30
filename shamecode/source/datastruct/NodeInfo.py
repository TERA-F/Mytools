#/usr/bin/env python
#-*-coding:utf8-*-

class NodeInfo(object):
    def __init__(self,value,p=0):
        self.data = value
        self.prevnode = 0
        self.nextnode = 0
