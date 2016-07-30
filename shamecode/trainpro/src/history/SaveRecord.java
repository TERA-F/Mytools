package history;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This class is used to add all train-record list get from special folder to Mysql database.
 * @author zhaoch93
 * @version 1.0
 *
 */

public class SaveRecord 
{
	static public void main(String[] args) throws FileNotFoundException 
	{
		final File folder = new File("/home/zhaoch93/workspace/data/database");
		ArrayList<String> RecordFileName = listFilesForFolder(folder);
		Pattern PatternStartSta = Pattern.compile("\'([\\w|\\W]+)\',");
		Pattern PatternToSta = Pattern.compile(" u\'([\\w|\\W]+)\'");
		
		for(String filename : RecordFileName)
		{
			System.out.println(filename+"  "+filename.length());
			Matcher MatcherStartSta = PatternStartSta.matcher(filename);
			Matcher MatcherToSta = PatternToSta.matcher(filename);
			if(MatcherStartSta.find()&&MatcherToSta.find())
			{
				System.out.println(MatcherStartSta.group(1));	
				System.out.println(MatcherToSta.group(1));
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
	            listFilesForFolder(fileEntry);
	        } else 
	        {
	        	RecordFileName.add(fileEntry.getName());
	        }
    	}
	return RecordFileName;
	}

/**
 * this static method is used to read record list from a file,and this method will call ReadDataLine
 * n times,which n is lines number of this file.
 * @param Scanner:in
 * @return SingleLineofRecord[]
 * @author zhaoch93
 * @version 1.0
 */
	static SingleLineofRecord [] ReadDataFile(Scanner in)
	{
		int n = in.nextInt();
		in.nextLine();
		SingleLineofRecord [] StatoStaRecord =new SingleLineofRecord[n];
		for(int i = 0; i < n ; i++)
		{
			//StatoStaRecord [i] = ReadDateLine(in);
		}
	}

/**
 * this static method is used to return a SingleLineofRecord, data come from single line of data file
 * @param Scanner:in
 * @return SingleLineofRecord
 * @author zhaoch93
 * @version 1.0
 */
	public static SingleLineofRecord ReadDataLine(Scanner in)
	{
		return SingleLineofRecord(in);
	}


	public class SingleLineofRecord
	{
		private String TrainCode;
		private String StartStation;
		private String ToStation;
		private String StartData;
		private String ToData;
		private boolean Available;
		
		static final int Lastfixcharnumber = 27;
		public SingleLineofRecord(Scanner in)
		{
			String Line = in.nextLine();
			int TrainCodenumber = Line.length()-Lastfixcharnumber;
			TrainCode = Line.substring(0,TrainCodenumber);
			StartData = Line.substring(TrainCodenumber,TrainCodenumber+5);
			ToData = Line.substring(TrainCodenumber+5,TrainCodenumber+10);
		}
	}
}