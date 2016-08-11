package cob.test;


import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Test;

import cob.data.GetUserInfo;
import cob.data.SessionData;
import cob.net.CheckLogin;
import cob.net.CheckVcode;
import cob.net.Get3WBAIDU;
import cob.net.GetBAIDUID;
import cob.net.GetBdstoken;
import cob.net.GetPublicKey;
import cob.net.GetToken;
import cob.net.GetUBI;
import cob.net.PostLogin;
import cob.net.ToPan;
import cob.net.ToPassport;
import okhttp3.OkHttpClient;

public class Testokhttp {
	
	@Test
	public void testGetBAIDUID(){
		OkHttpClient client = new OkHttpClient();
		GetBAIDUID getBAIDUID = new GetBAIDUID(client,null);
		System.out.println(getBAIDUID.execute());
		System.out.println(getBAIDUID);
	}
	
	@Test
	public void testGetToken(){
		SessionData data = new SessionData();
		OkHttpClient client = new OkHttpClient();
		
		GetBAIDUID getCookie = new GetBAIDUID(client,null);
		getCookie.execute();
		data.addCookiesList(getCookie.getSetcookiesList());
		
		GetToken getToken = new GetToken(client,data);
		System.out.println(getToken.execute());
		System.out.println(getToken);
		
	}
	
	@Test
	public void testGetUBI(){
		SessionData data = new SessionData();
		OkHttpClient client = new OkHttpClient();
		
		GetBAIDUID getCookie = new GetBAIDUID(client,null);
		getCookie.execute();
		data.addCookiesList(getCookie.getSetcookiesList());
		
		GetToken getToken = new GetToken(client,data);
		getToken.execute();
		data.addCookiesList(getToken.getSetcookiesList());
		data.setToken(getToken.getToken());
		
		GetUBI getUBI = new GetUBI(client, data);
		System.out.println(getUBI.execute());
		System.out.println(getUBI);
	}
	
	@Test
	public void testCheckLogin(){
		SessionData data = new SessionData();
		OkHttpClient client = new OkHttpClient();
		
		GetBAIDUID getCookie = new GetBAIDUID(client,null);
		getCookie.execute();
		data.addCookiesList(getCookie.getSetcookiesList());
		
		GetToken getToken = new GetToken(client,data);
		getToken.execute();
		data.addCookiesList(getToken.getSetcookiesList());
		data.setToken(getToken.getToken());
		
		GetUBI getUBI = new GetUBI(client, data);
		getUBI.execute();
		data.addCookiesList(getUBI.getSetcookiesList());
		
		data.setUsername(GetUserInfo.getUsername());
		
		CheckLogin checklogin = new CheckLogin(client, data);
		System.out.println(checklogin.execute());
		System.out.println(checklogin);
		
	}
	
	@Test
	public void testGetPublicKey(){
		SessionData data = new SessionData();
		OkHttpClient client = new OkHttpClient();
		
		GetBAIDUID getCookie = new GetBAIDUID(client,null);
		getCookie.execute();
		data.addCookiesList(getCookie.getSetcookiesList());
		
		GetToken getToken = new GetToken(client,data);
		getToken.execute();
		data.addCookiesList(getToken.getSetcookiesList());
		data.setToken(getToken.getToken());
		
		GetUBI getUBI = new GetUBI(client, data);
		getUBI.execute();
		data.addCookiesList(getUBI.getSetcookiesList());
		
		
		CheckLogin checklogin = new CheckLogin(client, data);
		if(!checklogin.execute()){
			System.out.println("error");
			return ; 
		}
		
		GetPublicKey getpublickey = new GetPublicKey(client, data);
		System.out.println(getpublickey.execute());
		System.out.println(getpublickey);
		System.out.println(getpublickey.getPubkey());
		System.out.println(getpublickey.getKey());

		
	}
	
	@Test
	public void testPostLogin(){
		SessionData data = new SessionData();
		OkHttpClient client = new OkHttpClient();
		
		GetBAIDUID getCookie = new GetBAIDUID(client,null);
		getCookie.execute();
		data.addCookiesList(getCookie.getSetcookiesList());
		
		GetToken getToken = new GetToken(client,data);
		getToken.execute();
		data.addCookiesList(getToken.getSetcookiesList());
		data.setToken(getToken.getToken());
		
		GetUBI getUBI = new GetUBI(client, data);
		getUBI.execute();
		data.addCookiesList(getUBI.getSetcookiesList());
		
		
		CheckLogin checklogin = new CheckLogin(client, data);
		if(!checklogin.execute()){
			System.out.println("error");
			return ; 
		}
		
		GetPublicKey getpublickey = new GetPublicKey(client, data);
		getpublickey.execute();
		data.setPubkey(getpublickey.getPubkey());
		data.setKey(getpublickey.getKey());
		
		GetUserInfo.getInfo();
		data.setUsername(GetUserInfo.getUsername());
		data.setPassword(GetUserInfo.getPassword());
		
		PostLogin postlogin = new PostLogin(client, data);
		postlogin.execute();
		System.out.println(postlogin);
	}
	@Test
	public void testCheckVcode(){
		SessionData data = new SessionData();
		OkHttpClient client = new OkHttpClient();
		
/*		Get3WBAIDU getbadu = new Get3WBAIDU(client, data);
		getbadu.execute();
		data.addCookiesList(getbadu.getSetcookiesList());*/
		
		GetBAIDUID getbaiduid = new GetBAIDUID(client,null);
		getbaiduid.execute();
		data.addCookiesList(getbaiduid.getSetcookiesList());
		
		GetToken getToken = new GetToken(client,data);
		getToken.execute();
		data.addCookiesList(getToken.getSetcookiesList());
		data.setToken(getToken.getToken());
		
		GetUBI getUBI = new GetUBI(client, data);
		getUBI.execute();
		data.addCookiesList(getUBI.getSetcookiesList());
		
		
		CheckLogin checklogin = new CheckLogin(client, data);
		if(!checklogin.execute()){
			System.out.println("error");
			return ; 
		}
//		data.addCookiesList(checklogin.getSetcookiesList());
		
		GetPublicKey getpublickey = new GetPublicKey(client, data);
		getpublickey.execute();
		data.setPubkey(getpublickey.getPubkey());
		data.setKey(getpublickey.getKey());
//		data.addCookiesList(getpublickey.getSetcookiesList());
		
		GetUserInfo.getInfo();
		data.setUsername(GetUserInfo.getUsername());
		data.setPassword(GetUserInfo.getPassword());
		
		PostLogin postlogin = new PostLogin(client, data);
		postlogin.execute();
		System.out.println(postlogin);
//		data.addCookiesList(postlogin.getSetcookiesList());
		
		PostLogin tryagain = new PostLogin(client, data);
		tryagain.execute();
		System.out.println(tryagain);
		
	}
	@Test
	public void testToPan(){
		SessionData data = new SessionData();
		OkHttpClient client = new OkHttpClient();
		
/*		Get3WBAIDU getbadu = new Get3WBAIDU(client, data);
		getbadu.execute();
		data.addCookiesList(getbadu.getSetcookiesList());*/
		
		GetBAIDUID getbaiduid = new GetBAIDUID(client,null);
		getbaiduid.execute();
		data.addCookiesList(getbaiduid.getSetcookiesList());
		
		GetToken getToken = new GetToken(client,data);
		getToken.execute();
		data.addCookiesList(getToken.getSetcookiesList());
		data.setToken(getToken.getToken());
		
		GetUBI getUBI = new GetUBI(client, data);
		getUBI.execute();
		data.addCookiesList(getUBI.getSetcookiesList());
		
		
		CheckLogin checklogin = new CheckLogin(client, data);
		if(!checklogin.execute()){
			System.out.println("error");
			return ; 
		}
//		data.addCookiesList(checklogin.getSetcookiesList());
		
		GetPublicKey getpublickey = new GetPublicKey(client, data);
		getpublickey.execute();
		data.setPubkey(getpublickey.getPubkey());
		data.setKey(getpublickey.getKey());
//		data.addCookiesList(getpublickey.getSetcookiesList());
		
		GetUserInfo.getInfo();
		data.setUsername(GetUserInfo.getUsername());
		data.setPassword(GetUserInfo.getPassword());
		
		PostLogin postlogin = new PostLogin(client, data);
		postlogin.execute();
//		System.out.println(postlogin);
		data.addCookiesList(postlogin.getSetcookiesList());
		
//		ToPan topan = new ToPan(client, data);
//		topan.execute();
//		System.out.println(topan);
		
		
		GetBdstoken getbdsotken = new GetBdstoken(client, data);
		getbdsotken.execute();
		data.addCookiesList(getbdsotken.getSetcookiesList());
		
	}
}
