package jdbconnection;
import java.util.*;
import java.sql.*;
import java.lang.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/*
import com.jdbc.ClassNotFoundException;
import com.jdbc.Connection;
import com.jdbc.Exception;
import com.jdbc.PreparedStatement;
import com.jdbc.ResultSet;
import com.jdbc.SQLException;
*/
public class JDBConnection {
	 static final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	 static final String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=CreditManageSystem";

	 static final String userName="sa";

	 static final String userPwd="812tsj";

	  public static Connection getConnection()
	  {   Connection conn=null;
		  try
		  {
			  Class.forName(driverName);
			  conn=DriverManager.getConnection(dbURL,userName,userPwd);
		  }
		  catch (ClassNotFoundException e) 
		   {
			   System.out.println("This is a ClassNotFoundException");
			   e.printStackTrace();
		   }
		   catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
		   catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		  return conn;
	  }
	  public static void closeAll(ResultSet rs ,PreparedStatement ps,Connection connection){  // πÿ±’¡¨Ω”(PreparedStatement)
	        if(rs != null){
	            try {
	                rs.close();
	            } 
	            catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if(ps != null){
	            try {
	                ps.close();
	            } 
	            catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if(connection != null){
	            try {
	                connection.close();
	            } 
	            catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}



