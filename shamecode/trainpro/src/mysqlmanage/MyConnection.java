package mysqlmanage;

import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

public class MyConnection implements MyStatement{
	private static String Name = "database.properties";
	private static String Dir = System.getProperty("user.dir");
	private static Connection Conn;
	private static Statement Sta;
	private static ResultSet Res;

	public MyConnection() throws IOException, SQLException
	{
		//Class.forName("com.mysql.jdbc.Driver");//can't add CLASSPATH through .bashrc,export can add and echo is fine ,but can't work in eclipse
		//System.out.println("pass this");
		Properties props = new Properties();
		try(InputStream in = Files.newInputStream(Paths.get(Dir+"/src/mysqlmanage/"+Name)))
		{
			props.load(in);
		}
		String drivers = props.getProperty("jdbc.drivers");
		if(drivers != null) System.setProperty("jdbc.drivers",drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		Conn = DriverManager.getConnection(url, username, password);
		Sta =Conn.createStatement();
	}
	
	void close() 
	{
		Conn = null;
		Sta = null;
	}
		
	void SetName(String SetName)
	{
		Name = SetName;
	}
	void SetDir(String SetDir)
	{
		Dir = SetDir;
	}
	
	String GetName()
	{
		return Name;
	}
	String GetDir()
	{
		return Dir;
	}
	Connection getConnection()
	{
		return Conn;
	}
	Statement getStatement()
	{
		return Sta;
	}
	
	//Implement of MyStatement
	
	@Override	
	public void CreateTable(MyCreateTable TableInfo) throws SQLException
	{
		String StaName = TableInfo.toMySQLString();
		Sta.executeUpdate(StaName);
	}
	
	@Override
	public ResultSet DisplayQuery(String statement) throws SQLException
	{
		System.out.println(statement);
		Res = Sta.executeQuery(statement);
		ResultSetMetaData ResMeta = Res.getMetaData();
		String [] ColumnName = new String [ResMeta.getColumnCount()];
		int MetaCount = ResMeta.getColumnCount();
		for (int i = 0; i < MetaCount; i++) {
			ColumnName [i] =  ResMeta.getColumnLabel(i+1);
		}
		String LeftAlignFormat = "|";
		String Separator = "+";
		for (int i = 0; i < MetaCount; i++) {
			LeftAlignFormat = LeftAlignFormat.concat(" %-20s |");
			Separator =Separator.concat("----------------------+");
		}
		LeftAlignFormat = LeftAlignFormat.concat("%n");
		Separator = Separator.concat("%n");
		if(Res.isBeforeFirst()){
				System.out.format(Separator);
				System.out.format(LeftAlignFormat, ColumnName);
				System.out.format(Separator);	
			}
		while (Res.next()) {
				String[] RowData = new String[MetaCount];
				for (int i = 0; i < MetaCount; i++) {
				RowData[i]=Res.getString(i+1);
			}
		System.out.format(LeftAlignFormat, RowData);
		}
		if(Res.isAfterLast())
				System.out.format(Separator);
		  return Res;
	}
	
	@Override
	public ResultSet executeQuery(String Statement) throws SQLException
	{
		Res = Sta.executeQuery(Statement);
		return Res;
	}
	
	@Override
	public void execute(String statement) throws SQLException
	{
		Sta.execute(statement);
	}
	
}
