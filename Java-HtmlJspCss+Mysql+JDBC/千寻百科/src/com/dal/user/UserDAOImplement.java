package com.dal.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dal.jdbc.DBConnection;
import com.logic.OrdinaryUser;

public class UserDAOImplement implements UserDAO {
	private OrdinaryUser extractOrdinaryUserFromResultSet(ResultSet rs) 
			throws SQLException {
		OrdinaryUser user = new OrdinaryUser();
        user.setEmail(rs.getString("email") );
        user.setName(rs.getString("name") );
        user.setPassword(rs.getString("password") );
        user.setSex(rs.getString("sex"));
        user.setPhone(rs.getString("phone"));
        user.setIntroduction(rs.getString("introduction"));
        user.setTot_score(rs.getInt("tot_score"));
        
        return user;
	}
	@Override
	public OrdinaryUser getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT * FROM user WHERE email=?");
            ps.setString(1, email);
            rs=ps.executeQuery();
            if(rs.next()){
            	OrdinaryUser user=extractOrdinaryUserFromResultSet(rs);
            	return user;
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
	public OrdinaryUser getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement
            		("SELECT * FROM user WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
            	OrdinaryUser user=extractOrdinaryUserFromResultSet(rs);
            	return user;
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
	public boolean updateUser(OrdinaryUser ordinaryUser) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("UPDATE user SET name=?,"
	        		+ " password=?, sex=?, phone=?,"
	        		+ " introduction=?, tot_score=? WHERE email=?");
	        ps.setString(1, ordinaryUser.getName());
	        ps.setString(2, ordinaryUser.getPassword());
	        ps.setString(3,	ordinaryUser.getSex());
	        ps.setString(4, ordinaryUser.getPhone());
	        ps.setString(5, ordinaryUser.getIntroduction());
	        ps.setInt(6, ordinaryUser.getTot_score());
	        ps.setString(7, ordinaryUser.getEmail());
	        
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
	public boolean insertUser(OrdinaryUser ordinaryUser) {
		// TODO Auto-generated method stub
	    Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("INSERT INTO user"
	        		+ "(email,name,password,sex,phone,introduction,tot_score) "
	        		+ "VALUES (?, ?, ?, ?, ?, ?, 0)");
	        ps.setString(1, ordinaryUser.getEmail());
	        ps.setString(2, ordinaryUser.getName());
	        ps.setString(3, ordinaryUser.getPassword());
	        ps.setString(4, ordinaryUser.getSex());
	        ps.setString(5, ordinaryUser.getPhone());
	        ps.setString(6, ordinaryUser.getIntroduction());
	        
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
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
