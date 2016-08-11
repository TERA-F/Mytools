package test;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.print.attribute.standard.MediaSize.Other;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.xml.internal.txw2.TXW;

public class RsaKeytest {
	private String publicKeyString;
	private String privateKeyString;
	
	public void genKeyPair(){
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keyPairGen.initialize(1024,new SecureRandom());
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPrivateKey privatekey = (RSAPrivateKey) keyPair.getPrivate();
		RSAPublicKey publickey = (RSAPublicKey) keyPair.getPublic();
		publicKeyString = Base64.encode(publickey.getEncoded());
		privateKeyString = Base64.encode(privatekey.getEncoded());
	}
	
	public RSAPublicKey str2publickey(){
			KeyFactory keyFactory;
			X509EncodedKeySpec keySpec;
			RSAPublicKey publickey = null;
			try {
				byte[] buffer = Base64.decode(publicKeyString);
				keyFactory = KeyFactory.getInstance("RSA");
				keySpec = new X509EncodedKeySpec(buffer);
				publickey =keyFactory.generatePublic(keySpec); 
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return publickey;
	}
	
	public RSAPrivateCrtKey str2privatekey(){
		KeyFactory keyFactory;
		RSAPrivateCrtKey privatekey = null;
		try {
			byte[] buffer = Base64.decode(privateKeyString);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
			keyFactory = KeyFactory.getInstance("RSA");
			privatekey = (RSAPrivateCrtKey) keyFactory.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return privatekey;
	}
	
	public byte[] encrypt(RSAPublicKey publickey, byte[] text){
		Cipher cipher = null;
		byte [] output = null; 
			try {
				cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, publickey);
				output = cipher.doFinal(text);
			} catch (NoSuchAlgorithmException
					| NoSuchPaddingException e) {
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
		return output;
	}
	
	public byte[] encrypt(RSAPrivateCrtKey privatekey, byte[] text){
		Cipher cipher = null;
		byte [] output = null; 
			try {
				cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, privatekey);
				output = cipher.doFinal(text);
			} catch (NoSuchAlgorithmException
					| NoSuchPaddingException e) {
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
		return output;
	}
	
	public byte[] decrypt(RSAPublicKey publickey, byte[] CipherData){
		byte[] output = null;

		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, publickey);
			output = cipher.doFinal(CipherData);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
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

		return output;
	}
	
	public byte[] decrypt(RSAPrivateKey privatekey, byte[] CipherData){
		byte[] output = null;

		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privatekey);
			output = cipher.doFinal(CipherData);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
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
		return output;
	}

	public String getPublicKeyString() {
		return publicKeyString;
	}

	public String getPrivateKeyString() {
		return privateKeyString;
	}
}
