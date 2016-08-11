package cob.net;

import java.io.IOException;
import java.util.ArrayList;
import cob.data.Const;
import cob.data.JSonToken;
import cob.data.SessionData;

import com.alibaba.fastjson.JSON;

import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetToken extends LoginBase{

	//different received Info
	private String token;
	
	@SuppressWarnings("unused")
	private GetToken(){ 	}
	
	public GetToken(OkHttpClient client, Cookie cookie){
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
		
		headers = new Headers.Builder()
				.add("Cookie",cookie.name())
				.add("Accept",Const.ACCEPT_HTML)
				.add("Cache-control","max-age=0")
				.build();
//		System.out.println(headers);
		
		request = new Request.Builder()
		.url(url)
		.headers(headers)
		.build();
//		System.out.println(headers);
		
		call = client.newCall(request);
	}
	
	public GetToken(OkHttpClient client, SessionData data){
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
		
		Headers.Builder tmpheaders = new Headers.Builder()
				.add("Accept",Const.ACCEPT_HTML)
				.add("Connection", "keep-alive")
				.add("Cache-control","max-age=0");
		for(Cookie co :data.getCookiesList() )
			tmpheaders.add("Cookie", co.name()+"="+co.value());
		headers = tmpheaders.build();
//		System.out.println(headers);
		
		prepareCall(client);
	}
	
	public boolean execute(){
		try(Response res = call.execute()){
			responseheaders = res.headers();
			responsebody = res.body().string();
			setcookiesList = new ArrayList<Cookie>(Cookie.parseAll(url, res.headers()));
			
//			String rbs = res.body().string();//can't  string() twice;
			JSonToken jsontoken = JSON.parseObject(responsebody,JSonToken.class);
			token = jsontoken.getData().getToken();
			if(!token.equals("")) return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getToken() {
		return token;
	}
}
