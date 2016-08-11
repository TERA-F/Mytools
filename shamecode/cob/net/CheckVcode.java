package cob.net;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import cob.data.ErrNoData;
import cob.data.SessionData;

public class CheckVcode extends LoginBase {
	
	@SuppressWarnings("unused")
	private CheckVcode(){		}
	
	public CheckVcode(OkHttpClient client, SessionData data){
		url = new HttpUrl.Builder()
		.scheme("http")
		.host("pan.baidu.com")
		.addPathSegments("V2")
		.query("checkvcode")
		.addEncodedQueryParameter("token", data.getToken())
		.addEncodedQueryParameter("tpl", "mn")
		.addEncodedQueryParameter("apiver", "v3")		
		.addEncodedQueryParameter("tt", ""+System.currentTimeMillis())		
		.addEncodedQueryParameter("verifycode", data.getVpngcode()==null?"":data.getVpngcode())
		.addEncodedQueryParameter("codestring", data.getCodeString())
		.addEncodedQueryParameter("callback", "bd__cbs__tdp3df")
		.build();
		
		Headers.Builder tmpheaders = new Headers.Builder();
		for(Cookie co : data.getCookiesList())
			tmpheaders.add("Cookie",co.name()+"="+co.value());
		headers = tmpheaders.build();

		prepareCall(client);
	}
	@Override
	public boolean execute() {
		try(Response res = call.execute()){
			responseheaders = res.headers();
			responsebody = res.body().string();
			setcookiesList = new ArrayList<Cookie>(Cookie.parseAll(url, res.headers()));
			
			ErrNoData errdata = new ErrNoData(responsebody);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
