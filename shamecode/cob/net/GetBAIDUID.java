package cob.net;

import java.io.IOException;
import java.util.ArrayList;
import cob.data.Const;
import cob.data.SessionData;

import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class GetBAIDUID extends LoginBase {
	
	@SuppressWarnings("unused")
	private GetBAIDUID() {
	}
	
	public GetBAIDUID(OkHttpClient client, SessionData data){
		
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("passport.baidu.com")
		.addPathSegments("v2/api/")
		.query("getapi")
		.addEncodedQueryParameter("tpl", "mn")
		.addEncodedQueryParameter("apiver", "v3")
		.addEncodedQueryParameter("tt", ""+System.currentTimeMillis())
		.addEncodedQueryParameter("class", "login")
		.addEncodedQueryParameter("logintype", "basicLogin")
		.build();
//		System.out.println(url);
		
		headers = Const.HEADERS.newBuilder()
				.add("Referer", "")
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
			
			for(Cookie co: setcookiesList)
				if(co.name().equals("BAIDUID")) return true; 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
