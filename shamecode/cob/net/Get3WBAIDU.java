package cob.net;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import cob.data.Const;
import cob.data.JSONPublicKey;
import cob.data.SessionData;

import com.alibaba.fastjson.JSON;

public class Get3WBAIDU extends LoginBase {
	@SuppressWarnings("unused")
	private Get3WBAIDU() {	}

	public Get3WBAIDU(OkHttpClient client, SessionData data) {
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("www.baidu.com")
		.build();
//		System.out.println(url);
		
		Headers.Builder tmpheaders = new Headers.Builder()
//		.add("Referer", Const.REFERER);
		.add("Connection", "keep-alive");
		for(Cookie co : data.getCookiesList())
			tmpheaders.add("Cookie",co.name()+"="+co.value());
		headers = tmpheaders.build();
//		System.out.println(headers);
		
		prepareCall(client);
	}

	@Override
	public boolean execute() {
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
