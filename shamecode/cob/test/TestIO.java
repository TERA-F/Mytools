package cob.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import cob.data.GetUserInfo;

public class TestIO {
	
	@Test
	public void testGetUserInfo(){
		GetUserInfo.getInfo();	}
	
	@Test
	public void testRWpng(){
		File file = new File(System.getProperty("user.dir")+"/v.png");
		File file2 = new File(System.getProperty("user.dir")+"/u.png");
		byte[] buf = new byte[1024];
		try(FileInputStream fin = new FileInputStream(file)) {//对于两个资源的try怎么写
			try(FileOutputStream fout = new FileOutputStream(file2)){
				while((fin.read(buf))!= -1){
					fout.write(buf);
				}
				try(BufferedInputStream vc = new BufferedInputStream(System.in)){
					byte[] bf = new byte[1024];
					while(vc.read(bf)!=-1){
						System.out.println(new String(bf));
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void testRWio(){
		try(BufferedInputStream vc = new BufferedInputStream(System.in)){
			byte[] bf = new byte[1024];
			while(vc.read(bf)!=-1){
				System.out.println(new String(bf));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRWpngWithRW(){
		File file = new File(System.getProperty("user.dir")+"/v.png");
		File file2 = new File(System.getProperty("user.dir")+"/z.png");
		try(FileReader fr = new FileReader(file)){
			try(FileWriter fw = new FileWriter(file2)){
				char[] ch = new char[1024];
				while(fr.read(ch)!=-1){
					fw.write(ch);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
