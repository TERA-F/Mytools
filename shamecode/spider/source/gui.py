#/usr/bin/env python
#-*-coding:utf8-×-

from Tkinter import *
import tkMessageBox
import spiderpractice
from functools import partial
import sys
sys.path.append("data")
import getstaname2code

class Mygui:
    def callback(self):
        print "callback"

    def popup(self,event):
        self.rightclmenu.tk_popup(event.x_root,event.y_root)

    def okbuttondown(self,startstaen,tostaen,starttimeen,frame):
        print "program ok"
        startstaentext = startstaen.get()
        tostaentext = tostaen.get()
        starttimetext = starttimeen.get()
        print startstaentext
        print tostaentext
        print starttimetext
        print "pass this"
        recordlist = spiderpractice.spidereasyone(startstaentext,tostaentext,starttimetext)
        for i in range(recordlist.getlength()):
                #print type(i)
                rd_traincode = Label(frame,text = recordlist.getitem(i)['station_train_code'],height=1,width = 10).grid(row=4+i,column=0,sticky="nsew")
                rd_starttime = Label(frame,text = recordlist.getitem(i)['start_time'],height=1,width = 10).grid(row=4+i,column=1,sticky="nsew")
                rd_arrivetime = Label(frame,text = recordlist.getitem(i)['arrive_time'],height=1,width = 10).grid(row=4+i,column=2,sticky="nsew")
                rd_swz = Label(frame,text = recordlist.getitem(i)['swz_num'] ,height=1,width = 10).grid(row=4+i,column=3,sticky="nsew")
                rd_ydz = Label(frame,text = recordlist.getitem(i)['ydz_num'],height=1,width = 10).grid(row=4+i,column=4,sticky="nsew")
                rd_edz = Label(frame,text = recordlist.getitem(i)['edz_num'],height=1,width = 10).grid(row=4+i,column=5,sticky="nsew")
                rd_rw = Label(frame,text = recordlist.getitem(i)['rw_num'],height=1,width = 10).grid(row=4+i,column=6,sticky="nsew")
                rd_yw = Label(frame,text = recordlist.getitem(i)['yw_num'],height=1,width = 10).grid(row=4+i,column=7,sticky="nsew")
                rd_yz = Label(frame,text = recordlist.getitem(i)['yz_num'],height=1,width = 10).grid(row=4+i,column=8,sticky="nsew")
                rd_wz = Label(frame,text = recordlist.getitem(i)['wz_num'],height=1,width = 10).grid(row=4+i,column=9,sticky="nsew")
                rd_yp = Label(frame,text = recordlist.getitem(i)['canWebBuy'],height=1,width = 10).grid(row=4+i,column=10,sticky="nsew")



    def __init__(self,master):
        frame = LabelFrame(master,padx=5,pady=5)

        self.menubar = Menu(frame,tearoff=0)
        master.config(menu=self.menubar)

        #create a pulldown menu to swtich different functions
        self.functionmenu = Menu(self.menubar,tearoff = 0)
        self.menubar.add_cascade(label = "Function",menu = self.functionmenu)
        self.functionmenu.add_command(label = "Transit Inquiry",command = self.callback)
        self.functionmenu.add_command(label = "Train code Inquiry",command = self.callback)
        self.functionmenu.add_separator()
        self.functionmenu.add_command(label = "Exit",command = master.quit)

        #create help menu
        self.helpmenu = Menu(self.menubar,tearoff = 0)
        self.menubar.add_cascade(label = "Help",menu = self.helpmenu)
        self.helpmenu.add_command(label = "help",command = self.callback)
        self.helpmenu.add_command(label = "license",command = self.callback)

        #create right click menu
        self.rightclmenu = Menu(frame,tearoff = 0)
        self.rightclmenu.add_command(label ="Undo",command = self.callback)
        self.rightclmenu.add_command(label ="Redo",command = self.callback)
        #create a canvas
        #self.subframe = Frame(frame,width = 512,height = 512)
        #self.frame.packs()
        frame.bind("<Button-3>",self.popup)#accroding to my assumption, self.popup send two parement ,first is self ,second is event,but this need avidencet

#start entry text layout
        startsta = Label(frame,text = "startstaion:",height = 1,width =10).grid(row=0,column=0,sticky="nsew")
        startstaen = Entry(frame,width =10)
        startstaen.insert(END,u'合肥')
        startstaen.grid(row=0,column=1,sticky="nsew")
        tosta = Label(frame,text = "tostaion:",height = 1,width =10).grid(row=1,column=0,sticky="nsew")
        tostaen = Entry(frame,width =10)
        tostaen.insert(END,u'淮南')
        tostaen.grid(row=1,column=1,sticky="nsew")
        starttime = Label(frame,text = "start time:",height = 1,width =10).grid(row=0,column=2,sticky="nsew")
        starttimeen = Entry(frame,width =10)
        starttimeen.insert(END,u'2016-02-10')
        starttimeen.grid(row=0,column=3,columnspan=2,sticky="nsew")
        #getsta2sta = Button(frame,text = "OK",command = self.okbuttondown(startstaen,tostaen,starttimeen))
        print self.callback()
        print self.callback
        buttoncall_ad = partial(self.okbuttondown,startstaen,tostaen,starttimeen,frame)
        getsta2sta = Button(frame,text = "OK",command = buttoncall_ad)
        getsta2sta.grid(row=0,rowspan=2,column = 9,sticky="nsew")

#recordlist display
        rd_traincode = Label(frame,text = "traincode",height=1,width = 10).grid(row=3,column=0,sticky="nsew")
        rd_starttime = Label(frame,text = "starttime",height=1,width = 10).grid(row=3,column=1,sticky="nsew")
        rd_arrivetime = Label(frame,text = "arrivetime",height=1,width = 10).grid(row=3,column=2,sticky="nsew")
        rd_swz = Label(frame,text = "swz",height=1,width = 10).grid(row=3,column=3,sticky="nsew")
        rd_ydz = Label(frame,text = "ydz",height=1,width = 10).grid(row=3,column=4,sticky="nsew")
        rd_edz = Label(frame,text = "edz",height=1,width = 10).grid(row=3,column=5,sticky="nsew")
        rd_rw = Label(frame,text = "rw",height=1,width = 10).grid(row=3,column=6,sticky="nsew")
        rd_yw = Label(frame,text = "yw",height=1,width = 10).grid(row=3,column=7,sticky="nsew")
        rd_yz = Label(frame,text = "yz",height=1,width = 10).grid(row=3,column=8,sticky="nsew")
        rd_wz = Label(frame,text = "wz",height=1,width = 10).grid(row=3,column=9,sticky="nsew")
        rd_yp = Label(frame,text = "yp",height=1,width = 10).grid(row=3,column=10,sticky="nsew")
        #recordlist = spiderpractice.spidereasyone()
        #for i in range(recordlist.getlength()):
                #print type(i)
                #rd_traincode = Label(frame,text = recordlist.getitem(i)['station_train_code'],height=1,width = 10).grid(row=4+i,column=0,sticky="nsew")
                #rd_starttime = Label(frame,text = recordlist.getitem(i)['start_time'],height=1,width = 10).grid(row=4+i,column=1,sticky="nsew")
                #rd_arrivetime = Label(frame,text = recordlist.getitem(i)['arrive_time'],height=1,width = 10).grid(row=4+i,column=2,sticky="nsew")
                #rd_swz = Label(frame,text = recordlist.getitem(i)['swz_num'] ,height=1,width = 10).grid(row=4+i,column=3,sticky="nsew")
                #rd_ydz = Label(frame,text = recordlist.getitem(i)['ydz_num'],height=1,width = 10).grid(row=4+i,column=4,sticky="nsew")
                #rd_edz = Label(frame,text = recordlist.getitem(i)['edz_num'],height=1,width = 10).grid(row=4+i,column=5,sticky="nsew")
                #rd_rw = Label(frame,text = recordlist.getitem(i)['rw_num'],height=1,width = 10).grid(row=4+i,column=6,sticky="nsew")
                #rd_yw = Label(frame,text = recordlist.getitem(i)['yw_num'],height=1,width = 10).grid(row=4+i,column=7,sticky="nsew")
                #rd_yz = Label(frame,text = recordlist.getitem(i)['yz_num'],height=1,width = 10).grid(row=4+i,column=8,sticky="nsew")
                #rd_wz = Label(frame,text = recordlist.getitem(i)['wz_num'],height=1,width = 10).grid(row=4+i,column=9,sticky="nsew")
                #rd_yp = Label(frame,text = recordlist.getitem(i)['canWebBuy'],height=1,width = 10).grid(row=4+i,column=10,sticky="nsew")



        frame.grid(padx=5,pady=5,sticky="nsew")


if __name__ == "__main__":
    root = Tk()
    traingui = Mygui(root)
    root.mainloop()

