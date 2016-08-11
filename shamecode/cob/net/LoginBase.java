package cob.net;

import java.util.ArrayList;

import cob.data.SessionData;
import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public abstract class LoginBase {
	//fixed domain of Interface
	protected HttpUrl url;
	protected Headers headers;
	protected Request request;
	protected Call call;
	protected Headers responseheaders;
	protected String responsebody;
	protected ArrayList<Cookie> setcookiesList;
	
	protected LoginBase(){}
	protected LoginBase(OkHttpClient client, SessionData data){	}
	
	protected void prepareCall(OkHttpClient client){
		request = new Request.Builder()
		.url(url)
		.headers(headers)
		.build();
		call = client.newCall(request);
	}
	
	public abstract boolean execute();
	
	
	public HttpUrl getUrl() {
		return url;
	}
	public Headers getHeaders() {
		return headers;
	}
	public Headers getResponseheaders() {
		return responseheaders;
	}
	public String getResponsebody() {
		return responsebody;
	}	
	public ArrayList<Cookie> getSetcookiesList() {
		return setcookiesList;
	}
	public String toString(){
		StringBuilder str = new StringBuilder().append("Request:\n")
		.append("-------------------------------------------------------------\n")
		.append("URL:\n")
		.append(url+"\n")
		.append("header:\n")
		.append(headers+"\n")
		.append("\n")
		.append("Response:\n")
		.append("-------------------------------------------------------------\n")
		.append("Response Header:\n")
		.append(responseheaders+"\n")
		.append("Response Body:\n")
		.append((responsebody.equals(""))?"":responsebody);
		return str.toString();
	}
}
