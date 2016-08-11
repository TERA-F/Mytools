package test;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class RSASignature {

	public String sign(String content,String privateKey){
		try{
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey PriKey = keyf.generatePrivate(priPKCS8);
			Signature signature = Signature.getInstance("SHA256withRSA");
			signature.initSign(PriKey);
			signature.update(content.getBytes());
			byte[] signed = signature.sign();
			return Base64.encode(signed);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean doCheck(String content,String sign, String publicKey){
		try {
			KeyFactory kefactory = KeyFactory.getInstance("RSA");
			byte[] encodeKey = Base64.decode(publicKey);
			PublicKey pubkey = kefactory.generatePublic(new X509EncodedKeySpec(encodeKey));
			Signature signature = Signature.getInstance("SHA256withRSA");
			signature.initVerify(pubkey);
			signature.update(content.getBytes());
			return  signature.verify(Base64.decode(sign));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
}
