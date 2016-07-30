package mysqlmanage;

import java.sql.*;


public interface MyStatement {
	  void CreateTable(MyCreateTable TableInfo) throws SQLException;
	  ResultSet DisplayQuery(String statement) throws SQLException;
	  ResultSet executeQuery(String Statement) throws SQLException;
	  void execute(String Statement)throws SQLException;
}
