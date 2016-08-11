#/usr/bin/env python
#-*-coding:utf8-*-

import urllib2
import urllib
import json
import sys
import spiderpractice
sys.path.append("data")
from staname2code import getstaname2code

staname2code = getstaname2code()
#print staname2code
stacode = staname2code.keys()
date = u"2016-02-11"
sta2stalist=[]
for fromsta in stacode:
    for tosta in stacode:
        if fromsta != tosta:
            tmp = [fromsta,tosta]
            sta2stalist.append(tmp)
print len(sta2stalist)
for j in range(1):
    print j+1,"/",len(sta2stalist)
    #recordlist = spiderpractice.spidereasyone(sta2stalist[j][0],sta2stalist[j][1],date)
    recordlist = spiderpractice.spidereasyone(u"合肥",u"淮南",date)
    print recordlist
    if recordlist == -1:
        continue
    else:
        sta2stalistfile = open("./database/%s"%(sta2stalist[j]),"w")
        for i in range(recordlist.getlength()):
            print recordlist.getitem(i)
            sta2stalistfile.write(recordlist.getitem(i)['station_train_code'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['start_time'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['arrive_time'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['swz_num'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['ydz_num'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['edz_num'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['rw_num'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['yw_num'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['yz_num'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['wz_num'].encode("utf8"))
            sta2stalistfile.write(recordlist.getitem(i)['canWebBuy'].encode("utf8"))
            sta2stalistfile.write(u"\n")
        sta2stalistfile.close
