package history;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		//System.out.println("中文测试");
		// TODO Auto-generated method stub
		final File folder = new File("/home/zhaoch93/workspace/traincheckpro/src/traincheckpro/database");
		ArrayList<String> RecordFileName = listFilesForFolder(folder);

		Pattern PatternStartSta = Pattern.compile("\'([\\w|\\W]+)\',");
		Pattern PatternToSta = Pattern.compile(" u\'([\\w|\\W]+)\'");
		for(String filename : RecordFileName)
		{
			//System.out.println(filename+"  "+filename.length());
			Matcher MatcherStartSta = PatternStartSta.matcher(filename);
			Matcher MatcherToSta = PatternToSta.matcher(filename);
			if(MatcherStartSta.find()&&MatcherToSta.find())
			{
				String str1 = new String(MatcherStartSta.group(1));
				String str2 = new String(MatcherToSta.group(1));
				//System.out.println(str1);
				//System.out.println(str1.length());
				String StartStaNameStr = Utf8Stringdecode(str1);
				String ToStaNameStr = Utf8Stringdecode(str2);
				System.out.print("StartStaNameStr:"+StartStaNameStr);
				System.out.println("   ToStaNameStr:"+ToStaNameStr);
			}
			else
			{
				System.out.println("no match found");
			}
		}
	}
	
	
		/**
		 *  this static method is used to return all filename of a special folder(include subfolder)
		 * This part of code come from stackoverflow.
		 * @param File:folder
		 * @return ArrayList<String>
		 * @author zhaoch93
		 * @version 1.0
		 */
			static ArrayList<String> listFilesForFolder(final File folder) 
			{
			ArrayList<String> RecordFileName = new ArrayList<String>();
		    for (final File fileEntry : folder.listFiles()) 
		    	{
			        if (fileEntry.isDirectory()) 
			        {
						{
							System.out.println("no match found");
						}
			            listFilesForFolder(fileEntry);
			        } else 
			        {
			        	RecordFileName.add(fileEntry.getName());
			        }
		    	}
			return RecordFileName;
			}
			
			/**
			 * this method is used to return character from UTF-8code-string.
			 * example: input'961c',  you will get ‘阜’
			 * @param String of single Chinese character in UTF-8 format Utf8Str
			 * @return String of single Chinese character.
			 * @throws UnsupportedEncodingException
			 */
			static String SingleUtf8Stringdecode(String SingleUtf8Str) throws UnsupportedEncodingException
			{
				int Utf8Int = Integer.parseInt(SingleUtf8Str,16);
				//System.out.println(Integer.toBinaryString(Utf8Int));
				byte[] bytes = ByteBuffer.allocate(4).putInt(Utf8Int).array();//why it only work when allocate(4) or more?
				byte[] Utf8Code = new byte[3];
				Utf8Code[0] = (byte) ((bytes[2]>>>4 | (byte) 224 )& (byte) 239);//why this should add (byte) before bytes[2]>>>4 and >>> will add 1 at left position;
				//System.out.println("Utf8Code[0]:"+Utf8Code[0]);
				Utf8Code[1] = (byte) ((((bytes[2] & (byte) 15)<<2)|(byte) 128 )|((byte)bytes[3]>>>6)&(byte)3);
				//System.out.println(Utf8Code[1]);
				Utf8Code[2] = (byte) ((bytes[3]& (byte) 63)|(byte) 128);
				//System.out.println(Utf8Code[2]);
				String Name = new String(Utf8Code,"UTF-8");
				//System.out.println(StaName);
				return Name;
			}
			
			/**
			 * this method is used to return string of staname string in utf-8 code.
			 * @param String in utf-8 format - Utf8StaName
			 * @return String Staname.
			 * @throws Exception
			 */
			static String Utf8Stringdecode(String Utf8StaName) throws Exception
			{
				if (Utf8StaName ==null) throw new NullPointerException();
				String StaName = null;
				//System.out.println(Utf8StaName.length());
				switch(Utf8StaName.length())
				{
				case 6:
					StaName = SingleUtf8Stringdecode(Utf8StaName.substring(2, 6));
					break;
				
				case 12:
					StaName =SingleUtf8Stringdecode(Utf8StaName.substring(2, 6));//can use concat when StaName is null;
					StaName = StaName.concat(SingleUtf8Stringdecode(Utf8StaName.substring(8, 12)));
					break;
				case 18:
					StaName =SingleUtf8Stringdecode(Utf8StaName.substring(2, 6));
					StaName = StaName.concat(SingleUtf8Stringdecode(Utf8StaName.substring(8, 12)));
					StaName = StaName.concat(SingleUtf8Stringdecode(Utf8StaName.substring(14, 18)));
					break;
				case 24:
					StaName =SingleUtf8Stringdecode(Utf8StaName.substring(2, 6));
					StaName = StaName.concat(SingleUtf8Stringdecode(Utf8StaName.substring(8, 12)));
					StaName = StaName.concat(SingleUtf8Stringdecode(Utf8StaName.substring(14, 18)));
					StaName = StaName.concat(SingleUtf8Stringdecode(Utf8StaName.substring(20, 24)));
					break;
				default:
					throw new Exception("Input String is wrong");
				}
				return StaName;
			}
}
