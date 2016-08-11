package cob.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public  class GetUserInfo {
	private static String username;
	private static String password;
	
	public static boolean getInfo(){
		File file = new File(System.getProperty("user.dir")+"/UserInfo");
		System.out.println(file.toString());
		try(BufferedReader get = new BufferedReader(new FileReader(file))){
			 username = get.readLine();
			 password = get.readLine();
			if(username != null && password != null)	
				return true;
			else 
				return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	public static boolean setInfo(){
		File file = new File(System.getProperty("user.dir")+"/UserInfo");
		try(BufferedWriter wr = new BufferedWriter(new FileWriter(file))){
			if(username == null || password == null) return false;
			wr.write(username+"\n");
			wr.write(password);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean setInfo(String name, String pass){
			setUsername(name);
			setPassword(pass);
			return setInfo();
	}
	public static String getUsername() {
		if(username==null)
			getInfo();
		return username;
	}

	public static void setUsername(String username) {
		GetUserInfo.username = username;
	}

	public static String getPassword() {
		if(password==null)
			getInfo();
		return password;
	}

	public static void setPassword(String password) {
		GetUserInfo.password = password;
	}
	
}
