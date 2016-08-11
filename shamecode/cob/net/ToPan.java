package cob.net;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import cob.data.Const;
import cob.data.SessionData;

public class ToPan extends LoginBase {

	@SuppressWarnings("unused")
	private ToPan() {
	}
	
	public ToPan(OkHttpClient client, SessionData data){
		
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("pan.baidu.com")
		.addPathSegments("disk/home")
//		.addEncodedQueryParameter("errno", "0")
//		.addEncodedQueryParameter("errmsg", "Auth Login Sucess")
//		.addEncodedQueryParameter("stoken", "")
//		.addEncodedQueryParameter("bduss", "")
//		.addEncodedQueryParameter("ssnerror", "0")
		.build();
//		System.out.println(url);
		
		Headers.Builder tmpheaders = new Headers.Builder()
		.add("Connection", "Keep-Alive");
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
			
//			BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(res.body().bytes())),"UTF-8"));
//			for(String str = in.readLine() ; str != null ;str = in.readLine()){
//				System.out.println(str);
//			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
