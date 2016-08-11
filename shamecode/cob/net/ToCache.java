package cob.net;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import cob.data.Const;
import cob.data.SessionData;

public class ToCache extends LoginBase {

	@SuppressWarnings("unused")
	private ToCache() {
	}
	
	public ToCache(OkHttpClient client, SessionData data){
		
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("www.baidu.com")
		.addPathSegments("cache/user/html/v3_jump.html")
		.addEncodedQueryParameter("err_no", "0")
		.addEncodedQueryParameter("callback", "parent.bd__pcbs__95f5x9")
		.addEncodedQueryParameter("codeString", "")
		.addEncodedQueryParameter("userName", data.getUsername())
		.addEncodedQueryParameter("mail", "")
		.addEncodedQueryParameter("hao123Param", "")
		.addEncodedQueryParameter("u", "https://www.baidu.com/")
		.addEncodedQueryParameter("tpl", "")
		.addEncodedQueryParameter("secstate", "")
		.addEncodedQueryParameter("gotourl", "")
		.addEncodedQueryParameter("authtoken", "")
		.addEncodedQueryParameter("loginproxy", "")
		.addEncodedQueryParameter("resetpwd", "")
		.addEncodedQueryParameter("vcodetype", "")
		.addEncodedQueryParameter("lstr", "")
		.addEncodedQueryParameter("ltoken", "")
		.addEncodedQueryParameter("bckv", "1")
		.addEncodedQueryParameter("bcsync", "")
		.addEncodedQueryParameter("bcchecksum", "")
		.addEncodedQueryParameter("code", "")
		.addEncodedQueryParameter("bdToken", "")
		.addEncodedQueryParameter("realnameswitch", "")
		.addEncodedQueryParameter("setpwdswitch", "")
		.addEncodedQueryParameter("bctime", "")
		.build();
//		System.out.println(url);
		
		headers = Const.HEADERS.newBuilder()
				.add("Referer", "https://passport.baidu.com/v2/api/?login")
				.add("Connection", "keep-alive")
				.build();
//		System.out.println(headers);
		
		prepareCall(client);
	}
	
	public boolean execute(){
		try(Response res = call.execute()){
			responseheaders = res.headers();
			responsebody = res.body().string();
			setcookiesList = new ArrayList<Cookie>(Cookie.parseAll(url, res.headers()));
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
