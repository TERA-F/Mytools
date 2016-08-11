package test;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;



public class Test {
	public static void main(String[] args) {
		RsaKeytest res = new RsaKeytest();
		res.genKeyPair();
		Encoder encoder = Base64.getEncoder();
		Decoder decoder = Base64.getDecoder();
		
		String text = "RSA公钥加密私钥解密";
		System.out.println("待发送的数据"+text);
		try {
			byte [] bytes = res.encrypt(res.str2publickey(), text.getBytes());
			String senddata = encoder.encodeToString(bytes);
			System.out.println("正在发送的数据："+senddata);
			String getdata = encoder.encodeToString(res.decrypt(res.str2privatekey(), bytes));
			System.out.println("接收到的数据："+new String(decoder.decode(getdata)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		text = "RSA私钥加密公钥解密";
		System.out.println(text);
		try{
			byte [] bytes = res.encrypt(res.str2privatekey(), text.getBytes());
			String senddata = encoder.encodeToString(bytes);
			System.out.println("正在发送的数据："+senddata);
			String getdata = encoder.encodeToString(res.decrypt(res.str2publickey(), bytes));
			System.out.println("接收到的数据："+new String(decoder.decode(getdata)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		
		System.out.println();
		
		RSASignature signature = new RSASignature();
		text = "RSA签名";
		String send = signature.sign(text, res.getPrivateKeyString());
		System.out.println("发送的签名："+send);
		
		boolean v = signature.doCheck(text, send,res.getPublicKeyString());
		System.out.println("解密是否成功"+v);
	}
}
