package history;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/**
 * this method is used to test utf8-code file and shold be delete when finish 
 * @author zhaoch93
 * @
 */
public class Utf8stringdecode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String Utf8Str = new String("5357");
		int Utf8Int = Integer.parseInt(Utf8Str,16);
		System.out.println(Integer.toBinaryString(Utf8Int));
		byte[] bytes = ByteBuffer.allocate(4).putInt(Utf8Int).array();//why it only work when allocate(4) or more?
		byte[] Utf8Code = new byte[3];
		Utf8Code[0] = (byte) ((bytes[2]>>>4 | (byte) 224 )& (byte) 239);//why this should add (byte) before bytes[2]>>>4 and >>> will add 1 at left position;
		System.out.println("Utf8Code[0]:"+Utf8Code[0]);
		Utf8Code[1] = (byte) ((((bytes[2] & (byte) 15)<<2)|(byte) 128 )|((byte)bytes[3]>>>6)&(byte)3);
		System.out.println(Utf8Code[1]);
		Utf8Code[2] = (byte) ((bytes[3]& (byte) 63)|(byte) 128);
		System.out.println(Utf8Code[2]);
		String StaName = new String(Utf8Code,"UTF-8");
		System.out.println(StaName);
	}
}
