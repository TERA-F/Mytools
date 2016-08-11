package cob.data;

import okhttp3.Headers;
 /*这个包保存有常用的网络常量*/

public class Const {
	// URL常量
	public static final String BAIDU_URL = "http://www.baidu.com/";
	public static final String PASSPORT_BASE = "https://passport.baidu.com/";
	public static final String PASSPORT_URL = PASSPORT_BASE + "v2/api/";
	public static final String PASSPORT_LOGIN = PASSPORT_BASE + "v2/api/?login";
	public static final String REFERER = PASSPORT_BASE + "v2/?login";
	//public static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64; rv:30.0) Gecko/20100101 Firefox/30.0";
	public static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64; rv:31.0) Gecko/20100101 Firefox/31.0 Iceweasel/31.2.0";
	public static final String PAN_URL = "http://pan.baidu.com/";
	public static final String PAN_API_URL = PAN_URL + "api/";
	public static final String PAN_REFERER = "http://pan.baidu.com/disk/home";
	public static final String SHARE_REFERER = PAN_URL + "share/manage";
	
	//headers常用值：
	public static final Headers HEADERS = new Headers.Builder()
	.add("User-agent", Const.USER_AGENT)
	.add("Referer",Const.PAN_REFERER)
	.add("Accept",Const.ACCEPT_JSON)
	.add("Accept-language","zh-cn, zh;q=0.5")
	.add("Accept-encoding","gzip, deflate")
	.add("Pragma","no-cache")
	.add("Cache-control","no-cache")
	.build();

	//服务器常量
	//一般服务器的名字
	public static final String PCS_URL = "http://pcs.baidu.com/rest/2.0/pcs/";
	//上传的服务器名
	public static final String PCS_URL_C = "http://c.pcs.baidu.com/rest/2.0/pcs/";
	public static final String PCS_URLS_C = "https://c.pcs.baidu.com/rest/2.0/pcs/";
	//下载的服务器名
	public static final String PCS_URL_D = "http://d.pcs.baidu.com/rest/2.0/pcs/";
	
	//模拟客户端常量
	public static final String CHANNEL_URL = "https://channel.api.duapp.com/rest/2.0/channel/channel?";
	public static final String PC_USER_AGENT = "netdisk;4.5.0.7;PC;PC-Windows;5.1.2600;WindowsBaiduYunGuanJia";
	public static final String PC_DEVICE_ID = "08002788772E";
	public static final String PC_DEVICE_NAME = "08002788772E";
	public static final String PC_DEVICE_TYPE = "2";
	public static final String PC_CLIENT_TYPE = "8";
	public static final String PC_APP_ID = "1981342";
	public static final String PC_DEVUID = "BDIMXV2%2DO%5FFD60326573E54779892088D1378B27C6%2DC%5F0%2DD%5F42563835636437366130302d6662616539362064%2DM%5F08002788772E%2DV%5F0C94CA83";
	public static final String PC_VERSION = "4.5.0.7";
	
	//HTTP请求时的一些常量
	public static final String CONTENT_FORM = "application/x-www-form-urlencoded";
	public static final String CONTENT_FORM_UTF8 = CONTENT_FORM + "; charset=UTF-8";
	public static final String ACCEPT_HTML = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
	public static final String ACCEPT_JSON = "application/json, text/javascript, */*; q=0.8";
}
