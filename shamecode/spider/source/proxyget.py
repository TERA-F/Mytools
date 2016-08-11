#/usr/bin/env python
#-*-coding:utf8-*-

import urllib2
import urllib
import json
import sys
import spiderpractice
sys.path.append("datastruct")
from DoubleLink import DoubleLink
sys.path.append("data")
from staname2code import getstaname2code
import time

def url_usr_agent(fromsta,tosta,date):
    #proxy = {'http':'27.24.158.155:84'}
    proxy = {'http':'110.4.24.173:80'}
    proxy_support = urllib2.ProxyHandler(proxy)
    opener = urllib2.build_opener(proxy_support)
    urllib2.install_opener(opener)
    i_headers = {'User-Agent':'Mozilla/5.0(Windows NT 6.1) AppleWebKit/537.36(KHTML,like Geko) Chrome/31.0.1650.48'}
    staname2code = getstaname2code()
    web = (u"https://kyfw.12306.cn/otn/lcxxcx/query?purpose_codes=ADULT&queryDate=%s&from_station=%s&to_station=%s"%(date,staname2code[fromsta],staname2code[tosta]))
    req = urllib2.Request(web,headers = i_headers)
    response = urllib2.urlopen(req)
    result = response.read()
    if result == "-1":
        print "there isn't any train from %s to %s on %s"%(fromsta,tosta,date)
        return -1
    try:
        data = json.loads(result)["data"]["datas"]
    except KeyError:
        print "there isn't any train from %s to %s on %s"%(fromsta,tosta,date)
        return -1

    recordlist = DoubleLink()
    for i,ticketInfo in enumerate(data):
        temp = [{"station_train_code":ticketInfo["station_train_code"],\
            "start_station_name":ticketInfo["start_station_name"],\
            "to_station_name":ticketInfo["to_station_name"],\
            "start_time":ticketInfo["start_time"],\
            "arrive_time":ticketInfo["arrive_time"],\
            "swz_num":ticketInfo["swz_num"],\
            "ydz_num":ticketInfo["zy_num"],\
            "edz_num":ticketInfo["ze_num"],\
            "rw_num":ticketInfo["rw_num"],\
            "yw_num":ticketInfo["yw_num"],\
            "yz_num":ticketInfo["yz_num"],\
            "wz_num":ticketInfo["wz_num"],\
            "canWebBuy":ticketInfo["canWebBuy"]}]#,can't omit
        if recordlist.getlength() == 0:
            recordlist.initlist(temp)
        else:
            recordlist.append(temp[0])
    return recordlist

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
#print len(sta2stalist)
#for j in range(len(sta2stalist)):
for j in range(400000,len(sta2stalist)):
    num = open("numofscan","r+")
    num.write(str(j))
    num.close
    print j+1,"/",len(sta2stalist)
    time.sleep(0.2)
    try:
        recordlist = spiderpractice.spidereasyone(sta2stalist[j][0],sta2stalist[j][1],date)
    except:
        time.sleep(900)
    #recordlist = spiderpractice.spidereasyone(u"合肥",u"淮南",date)
    #recordlist  = url_usr_agent(u"合肥",u"淮南",date)
    #print recordlist
    if recordlist == -1:
        continue
    else:
        sta2stalistfile = open("./database2/%s"%(sta2stalist[j]),"w")
        for i in range(recordlist.getlength()):
            #print recordlist.getitem(i)
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
        print "file has been writeen"
