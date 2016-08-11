package cob.net;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.alibaba.fastjson.JSON;

import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sun.misc.BASE64Decoder;
import cob.data.Const;
import cob.data.ErrNoData;
import cob.data.JSonToken;
import cob.data.SessionData;

public class PostLogin extends LoginBase {
	

	private String keystr;
	private SessionData data;// this is not a good idea. fix this in the future
	private OkHttpClient client;

	@SuppressWarnings("unused")
	private PostLogin(){	}
	
	public PostLogin(OkHttpClient client, SessionData data){
		this.client = client;
		this.data =data;
		url = new HttpUrl.Builder()
		.scheme("https")
		.host("passport.baidu.com")
		.addPathSegments("v2/api/")
		.query("login")
		.build();
		
		Headers.Builder tmpheaders = new Headers.Builder()
		.add("Referer", Const.REFERER)
		.add("Accept",Const.ACCEPT_HTML)
		.add("Connection", "Keep-Alive");
		for(Cookie co : data.getCookiesList())
			tmpheaders.add("Cookie",co.name()+"="+co.value());
		headers = tmpheaders.build();
//		System.out.println(headers);
		
		
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("RSA");
			String strpubkey = data.getPubkey();
			
			strpubkey = strpubkey.replaceAll("-----BEGIN PUBLIC KEY-----", "")
					.replaceAll("-----END PUBLIC KEY-----", "")
					.replaceAll("\n", "");
			X509EncodedKeySpec bobpubkeyspec = new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(strpubkey));
			KeyFactory keyfactory = KeyFactory.getInstance("RSA");
			PublicKey publickey = keyfactory.generatePublic(bobpubkeyspec);
			cipher.init(Cipher.ENCRYPT_MODE, publickey);
			byte[] output = cipher.doFinal(data.getPassword().getBytes());
//			Base64.Decoder decoder = Base64.getDecoder();
			Base64.Encoder encoder = Base64.getEncoder();
			keystr = encoder.encodeToString(output).replace("\n", "");
//			System.out.println(keystr);		
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		RequestBody body = new FormBody.Builder()
		.add("staticpage","https://pan.baidu.com/res/static/thirdparty/pass_v3_jump.html")
		.add("charset","UTF-8")
		.add("token",data.getToken())
		.add("tpl","netdisk")
		.add("subpro","netdisk_web")
		.add("apiver","v3")
		.add("tt",""+System.currentTimeMillis())
		.add("codestring",data.getCodeString()==null ? "":data.getCodeString())//also get 100023 error
		.add("safeflg","0")
		.add("u","https://pan.baidu.com/disk/home")
		.add("isPhone","")
		.add("detect","1")
		.add("gid","8919760-EF3A-4E2A-B7D4-EE4A4A3C055B")
		.add("quick_user","0")
		.add("logintype","basicLogin")
		.add("logLoginType","pc_loginBasic")
		.add("idc","")
		.add("loginmerge","true")
//		.add("splogin","rate")
		.add("foreignusername","")
		.add("username",data.getUsername())
		.add("password",keystr)
		.add("verifycode",data.getVpngcode()==null?"":data.getVpngcode())
		.add("mem_pass","on")
		.add("rsakey",data.getKey())
		.add("crypttype","12")
		.add("ppui_logintime", "48392")
		.add("countrycode","")
		.add("callback","bd__pcbs__28g1kg")
		.build();
		
		request = new Request.Builder()
		.url(url)
		.headers(headers)
		.post(body)
		.build();
		call = client.newCall(request);
	}

	@Override
	public boolean execute() {
		try(Response res = call.execute()){
			responseheaders = res.headers();
			responsebody = res.body().string();
			setcookiesList = new ArrayList<Cookie>(Cookie.parseAll(url, res.headers()));
			
			ErrNoData errdata = new ErrNoData(responsebody);
//			data.addCookiesList(setcookiesList);
			data.setCodeString(errdata.getCodeString());
			data.setVcodetype(errdata.getVcodetype());
			if(errdata.getErr_no().equals("257")){
				GetVcodepng getVcodepng = new GetVcodepng(client, data);
				getVcodepng.execute();
				data.setVpngcode(getVcodepng.getVpngcode());
				
				PostLogin tryag = new PostLogin(client, data);
				tryag.execute();
			}
			if(errdata.getErr_no().equals("0")){
				data.addCookiesList(setcookiesList);
//				ToCache tocache = new ToCache(client, data);
//				tocache.execute();
//				data.addCookiesList(tocache.getSetcookiesList());
//				
//				GetBdstoken getbdsotken = new GetBdstoken(client, data);
//				getbdsotken.execute();
//				data.addCookiesList(getbdsotken.getSetcookiesList());
//				
//				ToPan topan = new ToPan(client, data);
//				topan.execute();
//				data.addCookiesList(getbdsotken.getSetcookiesList());
//				System.out.println(getbdsotken);
				return true;
			}
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}



}
