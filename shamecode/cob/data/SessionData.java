package cob.data;

import java.util.ArrayList;
import java.util.Collection;

import okhttp3.Cookie;

public class SessionData {
	//这里存放历史通信得到的必要数据；
	private ArrayList<Cookie> CookiesList;
	private String token;
	private String pubkey;
	private String key;
	private String username;
	private String password;
	private String codeString;
	private String vcodetype;
	private String vpngcode;
	
	public SessionData(){
		CookiesList = new ArrayList<Cookie>();
		token = "";
	}
	
	public boolean addCookie(Cookie cookie){
		for(Cookie co : CookiesList){
			if(co.equals(cookie)) return false;
			if(co.name().equals(cookie.name())){
				CookiesList.remove(co);
				CookiesList.add(cookie);
				return true;
			}
		}
		CookiesList.add(cookie);
		return true;
	}
	
	public boolean removeCookie(Cookie cookie){
		for(Cookie co : CookiesList)
			if(co.equals(cookie)){
				CookiesList.remove(cookie);
				return true;
			}
		return false;
	}
	
	public boolean containsCookie(Cookie cookie){
		for(Cookie co : CookiesList)
			if(co.equals(cookie))
				return true;
		return false;
	}
	
	public boolean addCookiesList(Collection<? extends Cookie> cookeslist){
		if(cookeslist==null) return false;
		
		for(Cookie co:cookeslist)
			addCookie(co);
		return true;
	}
	
	public ArrayList<Cookie> getCookiesList() {
		return CookiesList;
	}
	
	public void setCookiesList(ArrayList<Cookie> cookiesList) {
		CookiesList = cookiesList;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}	
	
	public String getPubkey() {
		return pubkey;
	}
	
	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getCodeString() {
		return codeString;
	}

	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}

	public String getVcodetype() {
		return vcodetype;
	}

	public void setVcodetype(String vcodetype) {
		this.vcodetype = vcodetype;
	}

	public String getVpngcode() {
		return vpngcode;
	}

	public void setVpngcode(String vpngcode) {
		this.vpngcode = vpngcode;
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Cookies:\n");
		for(Cookie co : CookiesList)
			str.append(co.toString()+"\n");
		str.append("Token:\n");
		str.append(token+"\n");
		return str.toString();
	}
}
