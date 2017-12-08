package com.dal.attribute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dal.jdbc.DBConnection;

public class AttributeDAOImplement implements AttributeDAO {
	private AttributeVO extractAttributeFromResultSet(ResultSet rs) throws SQLException {
		AttributeVO attribute = new AttributeVO();
		attribute.setEntry_id(rs.getInt("entry_id"));
		attribute.setAttribute_name(rs.getString("attribute_name"));
		attribute.setContent(rs.getString("content"));
		attribute.setOrder(rs.getInt("number"));
		
		return attribute;
	}

	@Override
	public AttributeVO getAttributeByEntryIDAndAttributeName
		(int entry_id, String attribute_name) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement
            		("SELECT * FROM attribute WHERE entry_id=? AND attribute_name=?");
            ps.setInt(1, entry_id);
            ps.setString(2, attribute_name);
            rs=ps.executeQuery();
            if(rs.next()){
            	AttributeVO attribute=extractAttributeFromResultSet(rs);
            	return attribute;
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
	public ArrayList<AttributeVO> getAttributeByEntryID(int entry_id) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM attribute WHERE entry_id="+entry_id);
            ArrayList<AttributeVO> attributeList = new ArrayList<AttributeVO>();
			while(rs.next()){
				AttributeVO attribute=extractAttributeFromResultSet(rs);
				attributeList.add(attribute);
			}
			return attributeList;
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, stmt, connection);
		}
		return null;
	}

	@Override
	public boolean updateAttribute(AttributeVO attribute) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		try{
			ps = connection.prepareStatement
					("UPDATE attribute SET content=?, number=? "
							+ "WHERE entry_id=? AND attribute_name=?");
			ps.setString(1, attribute.getContent());
			ps.setInt(2, attribute.getOrder());
			ps.setInt(3, attribute.getEntry_id());
			ps.setString(4, attribute.getAttribute_name());
			
			int i=ps.executeUpdate();
			if(i==1){
				return true;
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		finally{
			DBConnection.closeAll(null, ps, connection);
		}
		return false;
	}

	@Override
	public boolean insertAttribute(AttributeVO attribute) {
		// TODO Auto-generated method stub
	    Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement
	        		("INSERT INTO attribute(entry_id,attribute_name,content,number)VALUES (?, ?, ?, ?)");
			ps.setInt(1, attribute.getEntry_id());
			ps.setString(2, attribute.getAttribute_name());
			ps.setString(3, attribute.getContent());
			ps.setInt(4, attribute.getOrder());
			
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
	public boolean deleteAttribute(AttributeVO attribute) {
		// TODO Auto-generated method stub
	    Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement
	        		("DELETE FROM attribute WHERE entry_id=? AND attribute_name=?");
			ps.setInt(1, attribute.getEntry_id());
			ps.setString(2, attribute.getAttribute_name());
			
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
}
