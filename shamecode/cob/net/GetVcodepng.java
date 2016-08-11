package cob.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import cob.data.Const;
import cob.data.JSonToken;
import cob.data.SessionData;

public class GetVcodepng extends LoginBase {

	private String vpngcode; 
	private SessionData data;
	
	@SuppressWarnings("unused")
	private GetVcodepng(){		}
	
	public GetVcodepng(OkHttpClient client, SessionData data){
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("passport.baidu.com")
		.addPathSegments("cgi-bin/")
		.addPathSegment("genimage")
		.query(data.getCodeString())
		.build();
		
		Headers.Builder tmpheaders = new Headers.Builder()
		.add("Referer", Const.REFERER);
		for(Cookie co : data.getCookiesList())
			tmpheaders.add("Cookie",co.name()+"="+co.value());
		headers = tmpheaders.build();

		prepareCall(client);
	}
	
	
	@Override
	public boolean execute() {
		try(Response res = call.execute()){
			responseheaders = res.headers();
//			responsebody = res.body().string();
			setcookiesList = new ArrayList<Cookie>(Cookie.parseAll(url, res.headers()));
//			data.addCookiesList(setcookiesList);
			
			try(FileOutputStream fo = new FileOutputStream(new File(System.getProperty("user.dir")+"/b.png"))){
				fo.write(res.body().bytes());
			}
			/*byte[] bf = new byte[1024];// why this can't work ,and will get a bigger unreadable png.
			try(FileOutputStream fo = new FileOutputStream(new File(System.getProperty("user.dir")+"/a.png"))){
				while(res.body().byteStream().read(bf)!=-1){
					fo.write(bf);
				}
			}*/
			try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))){
				vpngcode = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getVpngcode() {
		return vpngcode;
	}

	public void setVpngcode(String vpngcode) {
		this.vpngcode = vpngcode;
	}
	

}
