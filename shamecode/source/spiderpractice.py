#/usr/bin/env python
#-*-coding:utf8-*-

import urllib2
import urllib
import json
import sys
sys.path.append("datastruct")
from DoubleLink import DoubleLink
sys.path.append("data")
from staname2code import getstaname2code

def displaydict(recordlist):#this function can't work
        #print recordlist
        for record in recordlist:
            if type(record) != 'NoneType':
                print record


def spidereasyone(fromsta,tosta,date):
        #fromsta = u'合肥'
        #tosta = u'淮南'
        #date = '2016-02-10'
        staname2code = getstaname2code()
        requeststr= (u"https://kyfw.12306.cn/otn/lcxxcx/query?purpose_codes=ADULT&queryDate=%s&from_station=%s&to_station=%s"%(date,staname2code[fromsta],staname2code[tosta]))
        #print requeststr
        request = urllib2.Request(requeststr)
        print "attempt to get infromation form kyfw.12306.cn"
	response = urllib2.urlopen(request)
        print "inquiry successly"
	result = response.read()
        #print result
        data = json.loads(result)["data"]["datas"]

        recordlist = DoubleLink()
        sta2stare = open("./data/sta2stare","w")
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
                sta2stare.write(str(recordlist.getitem(i)))
                sta2stare.write('\n')
        sta2stare.write(str(recordlist))
        sta2stare.close()
        #display(recordlist)
        return recordlist


if __name__ == '__main__':
	print spidereasyone().getitem(0)
        print spidereasyone().getitem(1)
