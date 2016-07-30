#/usr/bin/env python
#-*-coding:utf8-*-

for i in range(43):
    f = open("num","wr+")
    #print f.read()
    f.write(str(i))
    print 'test'
    f.close()

