package cob.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cob.data.Const;
import cob.data.ErrNoData;
import cob.data.SessionData;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class GetBdstoken extends LoginBase {

	
	@SuppressWarnings("unused")
	private GetBdstoken(){		}
	
	public  GetBdstoken (OkHttpClient client, SessionData data){
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("pan.baidu.com")
		.addPathSegments("disk/home")
		.build();
		
		Headers.Builder tmpheaders = new Headers.Builder()
		.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
		.add("Accept-Encoding", "deflate, sdch, br")
		.add("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4,zh-TW;q=0.2")
		.add("Connection", "keep-alive")
		.add("Host", "pan.baidu.com")
		.add("Upgrade-Insecure-Requests", "1")
		.add("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36")
		.add("Cookie","PANWEB=1");
		for(Cookie co : data.getCookiesList()){
			if(co.name().equals("BAIDUID")||co.name().equals("BDUSS"))
			tmpheaders.add("Cookie",co.name()+"="+co.value());
		}
			
		headers = tmpheaders.build();

		prepareCall(client);
	}
	@Override
	public boolean execute() {
		try(Response res = call.execute()){
			responseheaders = res.headers();
			responsebody = res.body().string();
			setcookiesList = new ArrayList<Cookie>(Cookie.parseAll(url, res.headers()));
			
			Pattern r1 = Pattern.compile("(err_no[^\"]+)");
			Matcher m1 = r1.matcher(responsebody);
			m1.find();
			String url = m1.group(0);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
