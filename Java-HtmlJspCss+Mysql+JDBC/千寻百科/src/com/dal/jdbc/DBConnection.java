package com.dal.jdbc;

import java.sql.*;

public class DBConnection {
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/qxbk";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "qazsedcft";
	   public static Connection getConnection() {
		   Connection conn = null;
		   try{
		      //  Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //  Open a connection
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      return conn;
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
	   
	   public static void closeAll(ResultSet rs ,Statement stmt,Connection connection){  //关闭连接(Statement)
	        if(rs != null){
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if(stmt != null){
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if(connection != null){
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    public static void closeAll(ResultSet rs ,PreparedStatement ps,Connection connection){  // 关闭连接(PreparedStatement)
	        if(rs != null){
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if(ps != null){
	            try {
	                ps.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if(connection != null){
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
