package mysqlmanage;

import java.io.IOException;
import java.sql.*;

public class MysqlMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		try
		{
			AddStaNameList();
		}
		catch(SQLException ex)
		{
			for(Throwable t:ex)
				t.printStackTrace();
		}
	}
	
	/**
	 * this method is used to execute statment when imput is mapset, I want to use it in strategy patten. 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	 
	private static void AddStaNameList() throws SQLException, IOException, ClassNotFoundException
	{
		MyConnection Con = new MyConnection();
		
		/*
		MyCreateTable CodeNameTable = new MyCreateTable("Code2Name2");
		CodeNameTable.setSinlgeField("Code", "nvarchar(3)");
		CodeNameTable.setSinlgeField("Name", "nvarchar(5)");
		CodeNameTable.setPrimaryKey("Code");
		Con.CreateTable(CodeNameTable);	
		*/
		//System.out.println("This table is exist!");//how to send CodeTableName or other object created in try block?

		Con.DisplayQuery("desc Code2Name");
	}
}
