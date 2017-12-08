package com.dal.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dal.jdbc.DBConnection;
import com.logic.Manager;

public class ManagerDAOImplement implements ManagerDAO {
	private Manager extractManagerFromResultSet(ResultSet rs) throws SQLException {
		Manager manager = new Manager();
        manager.setManager_id(rs.getString("ID") );
        manager.setName(rs.getString("name") );
        manager.setPassword(rs.getString("password") );
        
        return manager;
	}
	@Override
	public Manager getManagerByManagerIDAndPassword(String managerID, String password) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement
            		("SELECT * FROM manager WHERE ID=? AND password=?");
            ps.setString(1, managerID);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
            	Manager manager=extractManagerFromResultSet(rs);
            	return manager;
            }
        } 
		catch (SQLException ex) {
            ex.printStackTrace();
        }
		finally{
			DBConnection.closeAll(rs, ps, connection);
		}
		return null;
	}

	@Override
	public boolean updateManager(Manager manager) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("UPDATE manager SET name=?,"
	        		+ " password=? WHERE ID=?");
	        ps.setString(1, manager.getName());
	        ps.setString(2, manager.getPassword());
	        ps.setString(3, manager.getManager_id());
	        
	        int i = ps.executeUpdate();
	        if(i == 1) {
		    	  return true;
		      }
	    } 
		catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		finally{
			DBConnection.closeAll(null, ps, connection);
		}
		return false;
	}

	@Override
	public boolean insertManager(Manager manager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteManager(String managerID) {
		// TODO Auto-generated method stub
		return false;
	}

}
