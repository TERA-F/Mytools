#/usr/bin/env python
#-*-coding:utf8-*-

import urllib
import urllib2
import re

def getstaname2code():
    request = urllib2.Request("https://kyfw.12306.cn/otn/resources/js/framework/station_name.js?station_version=1.8902")
    response = urllib2.urlopen(request)
    temp = response.read().decode("utf-8")
    #print temp
    pattern = re.compile(u'\|[\u4e00-\u9fa5][\u4e00-\u9fa5][\u4e00-\u9fa5]?[\u4e00-\u9fa5]?\|\w\w\w?\|')
    results = pattern.findall(temp)
    stalist=[]
    for result in results:
        #print result
        #print type(result)
        stalist.append(result)
    #print stalist[0]

    stanamelist = []
    stacodelist = []
    pattern = re.compile(u'[\u4e00-\u9fa5][\u4e00-\u9fa5][\u4e00-\u9fa5]?[\u4e00-\u9fa5]?')
    for i in range(len(stalist)):
        staname = pattern.findall(stalist[i])
        stanamelist.append(staname[0])
    #print len(stanamelist)
    pattern = re.compile(u'\w\w\w')
    for i in range(len(stalist)):
        stacode = pattern.findall(stalist[i])
        stacodelist.append(stacode[0])
    #print len(stacodelist)

    staname2codelist = dict(zip(stanamelist,stacodelist)) #this is staname2codelist
    return staname2codelist

if __name__ == '__main__':
    result =getstaname2code()
    for item in result:
        print "dict[%s]="% item,result[item]
