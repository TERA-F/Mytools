package cob.net;

import java.io.IOException;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import cob.data.Const;
import cob.data.JSONPublicKey;
import cob.data.JSonLoginCheck;
import cob.data.SessionData;

public class GetPublicKey extends LoginBase {
	
	private String pubkey;
	private String key;
	

	@SuppressWarnings("unused")
	private GetPublicKey() {	}

	public GetPublicKey(OkHttpClient client, SessionData data) {
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("passport.baidu.com")
		.addPathSegments("v2/")
		.addPathSegment("getpublickey")
		.addEncodedQueryParameter("token", data.getToken())
		.addEncodedQueryParameter("tpl", "mn")
		.addEncodedQueryParameter("apiver", "v3")
		.addEncodedQueryParameter("tt", ""+System.currentTimeMillis())
		.build();
//		System.out.println(url);
		
		Headers.Builder tmpheaders = new Headers.Builder()
		.add("Connection", "keep-alive")
		.add("Referer", Const.REFERER);
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
			
			JSONPublicKey tmp = JSON.parseObject(responsebody,JSONPublicKey.class);
			pubkey = tmp.getPubkey();
			key = tmp.getKey();
			return !pubkey.equals("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getPubkey() {
		return pubkey;
	}

	public String getKey() {
		return key;
	}
}
