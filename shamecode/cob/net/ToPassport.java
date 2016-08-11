package cob.net;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import cob.data.SessionData;

public class ToPassport extends LoginBase {

	@SuppressWarnings("unused")
	private ToPassport(){		}
	
	public  ToPassport (OkHttpClient client, SessionData data){
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("passport.baidu.com")
		.addPathSegments("v3/login/api/auth/")
		.addEncodedQueryParameter("return_type","3")
		.addEncodedQueryParameter("tpl","netdisk")
		.addEncodedQueryParameter("u","http://pan.baidu.com/disk/home")
		.build();
		
		Headers.Builder tmpheaders = new Headers.Builder()
//		.add("https://pan.baidu.com/");
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
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
