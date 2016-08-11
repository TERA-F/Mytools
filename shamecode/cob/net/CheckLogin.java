package cob.net;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

import cob.data.Const;
import cob.data.JSonLoginCheck;
import cob.data.SessionData;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CheckLogin extends LoginBase {
	
	private String codestring;

	@SuppressWarnings("unused")
	private CheckLogin(){
		
	}
	
	public CheckLogin(OkHttpClient client,SessionData data){
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("passport.baidu.com")
		.addPathSegments("v2/api/")
		.query("logincheck")
		.addEncodedQueryParameter("token", data.getToken())
		.addEncodedQueryParameter("tpl", "mn")
		.addEncodedQueryParameter("apiver", "v3")
		.addEncodedQueryParameter("tt", ""+System.currentTimeMillis())
		.addEncodedQueryParameter("username",data.getUsername())
		.addEncodedQueryParameter("isphone", "false")
		.build();
		System.out.println(url);
		
		Headers.Builder tmpheaders = new Headers.Builder()
		.add("Accept",Const.ACCEPT_HTML)
		.add("Connection", "keep-alive")
		.add("Cache-control","max-age=0");
		for(Cookie co : data.getCookiesList())
			tmpheaders.add("Cookie",co.name()+"="+co.value());
		headers = tmpheaders.build();
//		System.out.println(headers);
		
		prepareCall(client);
	}

	public boolean execute(){
		try(Response res = call.execute()){
			responseheaders = res.headers();
			responsebody = res.body().string();
			setcookiesList = new ArrayList<Cookie>(Cookie.parseAll(url, res.headers()));
			
			JSonLoginCheck tmp = JSON.parseObject(responsebody,JSonLoginCheck.class);
			codestring = tmp.getData().getCodeString();
			return codestring.equals("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
