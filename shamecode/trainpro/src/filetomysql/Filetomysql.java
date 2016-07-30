package filetomysql;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mysqlmanage.*;

public class Filetomysql {
	public static void main(String[] args) throws IOException, SQLException {
		Filetomysql FileToMysql = new Filetomysql();
		Vector<Vector<String>> filename = new Vector<Vector<String>>();
		filename = FileToMysql.returnfileName();
		filename=FileToMysql.FileNameTrans(filename);
		System.out.println(filename.get(0));
		System.out.println(filename.get(1));
		
		MyConnection Con = new MyConnection();
		for (int i = 0; i < filename.get(0).size(); i++) {
			String statement = "insert into start2to values(\'"+filename.get(0).get(i)+"\',\'"+filename.get(1).get(i)+"\')";
			//String statement = "insert into start2to values()";
			
			System.out.println(statement);
			Con.execute(statement);
		}

	}
	
	
	 ArrayList<String> listFilesForFolder(final File folder) 
	{
	ArrayList<String> RecordFileName = new ArrayList<String>();
    for (final File fileEntry : folder.listFiles()) 
    	{
	        if (fileEntry.isDirectory()) 
	        {
	            listFilesForFolder(fileEntry);
	        } else 
	        {
	        	RecordFileName.add(fileEntry.getName());
	        }
    	}
	return RecordFileName;
	}
	Vector<Vector<String>> returnfileName()
	{
		final File folder = new File("/home/zhaoch93/workspace/data/database3");
		Vector<String> StartStaList = new Vector<String>();
		Vector<String> ToStaList = new Vector<String>();
		Vector<Vector<String>> returntemp= new Vector<Vector<String>>();
		returntemp.add(0, StartStaList);
		returntemp.add(1, ToStaList);
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
				StartStaList.add(MatcherStartSta.group(1));
				ToStaList.add(MatcherToSta.group(1));				
			}
			else
			{
				System.out.println("no match found");
			}
		}
		return returntemp;
	}
	
	Vector<Vector<String>> FileNameTrans(Vector<Vector<String>> filename) throws UnsupportedEncodingException
	{
		Pattern getName = Pattern.compile("u([\\w|\\W]{4})");
		Vector<String> getfilename = new Vector<String>();
		for (Vector<String> vector : filename) {
			for (String string : vector) {
				Matcher getNameMatcher = getName.matcher(string);
				String orginize=null;
				while(getNameMatcher.find())
				{
					//System.out.println(getNameMatcher.groupCount());
					//System.out.println(getNameMatcher.group(1));
					String teset = utf8stringtoutf8code(getNameMatcher.group(1).toString());
					//System.out.println(teset);
					if(null == orginize)
						orginize = teset;
					else
						orginize = orginize.concat(teset);
				}
				string = new String(orginize);
				//System.out.println(string);
				getfilename.addElement(string);
			}
		}
		//System.out.println(getfilename);
		System.out.println(getfilename.size());
		Vector<Vector<String>> returnname = new Vector<Vector<String>>();

		returnname.addElement(new Vector<String>(getfilename.subList(0, getfilename.size()/2)));//fix it without new
		returnname.addElement(new Vector<String>(getfilename.subList(getfilename.size()/2,getfilename.size())));

		//System.out.println(returnname.elementAt(0).size());
		//System.out.println(returnname.elementAt(1).size());
		return returnname;
	}
	
	String utf8stringtoutf8code(String Utf8Str) throws UnsupportedEncodingException
	{
		int Utf8Int = Integer.parseInt(Utf8Str,16);
		//System.out.println(Integer.toBinaryString(Utf8Int));
		byte[] bytes = ByteBuffer.allocate(4).putInt(Utf8Int).array();//why it only work when allocate(4) or more?
		byte[] Utf8Code = new byte[3];
		Utf8Code[0] = (byte) ((bytes[2]>>>4 | (byte) 224 )& (byte) 239);//why this should add (byte) before bytes[2]>>>4 and >>> will add 1 at left position;
		//System.out.println("Utf8Code[0]:"+Utf8Code[0]);
		Utf8Code[1] = (byte) ((((bytes[2] & (byte) 15)<<2)|(byte) 128 )|((byte)bytes[3]>>>6)&(byte)3);
		//System.out.println(Utf8Code[1]);
		Utf8Code[2] = (byte) ((bytes[3]& (byte) 63)|(byte) 128);
		//System.out.println(Utf8Code[2]);
		String StaName = new String(Utf8Code,"UTF-8");
		//System.out.println(StaName);
		return StaName;
	}
}
