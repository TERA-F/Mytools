#/usr/bin/env python
#-*-coding:utf8-*-

import urllib
import urllib2
import json
from NodeInfo import NodeInfo

#    def AssumbleUrl(slef,purpose,date,fromstation,tostation):
#        self.url ='https://kyfw.12306.cn/otn/lcxxcx/query?purpose_codes=%s&queryDate=%s&from_station=%s&to_station=%s'%(purpose,date,fromstation,tostation)
#        self.response = urllib2.urlopen(self.url)
#        data = json.loads(response.read())["data"]["datas"]


#self.singleinfo = {"date":None,"fromsta":None,"tosta":None,"firseat":None,"secseat":None,"busblock":None,"softsleep":None,"hardsleep":None,"hardseat":None,"noseat":None}




class DoubleLink(object):
    def __init__(self):
        self.head = 0

    def getlength(self):
        p = self.head
        length = 0
        while p!=0:
            length += 1
            p = p.nextnode
        return length

    def __getitem__(self,key):
        if self.is_empty():
            print "Linklist is empty."
            return
        elif key<0 or key>self.getlength():
            print "The given key isn't in right range"
            return
        else:
            return self.getitem(key)

    def __setitem__(self,key,value):
        if self.is_empty():
            print "Linklist is empty."
            return
        elif k<0 or key>self.getlength():
            print "The given key isn't in right range"
            return
        else:
            self.delete(key)
            return self.insert(key)

    def initlist(self,data):
        self.head = NodeInfo(data[0])

        p = self.head

        for i in data[1:]:
            node = NodeInfo(i)
            p.nextnode = node
            node.prevnode = p
            p = p.nextnode

    def is_empty(self):
        if self.getlength() == 0:
            return True
        else:
            return False

    def clear(self):
        self.head = 0

    def append(self,item):
        q = NodeInfo(item)
        if self.head == 0:
            self.head = q
        else:
            p = self.head
            while p.nextnode != 0:
                p = p.nextnode
            p.nextnode = q
            q.prevnode = p

    def getitem(self,index):
        if self.is_empty():
            print 'Linklist is empty.'
            return
        j = 0
        p = self.head
        while p.nextnode != 0 and j<index:
            p = p.nextnode
            j += 1
        if j == index:
            return p.data
        else:
            print 'target is not exist!'

    def insert(self,index,item):
        if self.is_empty() or index < 0 or index > self.getlength():
            print 'Linklist is empty.'
            return
        if index == 0:
            q = NodeInfo(item,self.head)
            self.head = q
        p = self.head
        post = self.head
        j = 0
        while p.nextnode != 0 and j < index:
            post = p
            p = p.nextnode
            j += 1
        if index == j:
            q = NodeInfo(item,p)
            post.nextnode = q#?
            q.prevnode = post
            q.nextnode = p
            p.prevnode = q

    def delete(self,index):
        if self.is_empty() or index < 0 or index > self.getlength():
            print 'Linklist is empty.'
            return
        if index == 0:
            q = NodeInfo(item,self.head)
            self.head = q
        p = self.head
        post = self.head
        j = 0
        while p.nextnode != 0 and j < index:
            post = p
            p = p.nextnode
            j += 1

        if index == j:
            post.nextnode = p.nextnode
            p.nextnode.prevnode = post

    def index(self,value):
        if self.is_empty():
            print 'Linklist is empty.'
            return
        p = self.head
        i = 0
        while p.nextnode != 0 and not p.data == value:
            p = p.nextnode
            i +=1
        if p.data == value:
            return 1
        else:
            return -1
