package com.dal.entry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dal.jdbc.DBConnection;

public class EntryDAOImplement implements EntryDAO {
	private EntryVO extractEntryFromResultSet(ResultSet rs) throws SQLException {
		EntryVO entry = new EntryVO();
		entry.setEntry_id(rs.getInt("entry_id"));
		entry.setTitle(rs.getString("title"));
		entry.setBrief(rs.getString("brief"));
		entry.setCategory(rs.getString("category"));
		entry.setPassed(rs.getBoolean("isPassed"));
		entry.setCreate_date(rs.getDate("create_date"));
		
		return entry;
	}

	@Override
	public EntryVO getEntryByEntryID(int entry_id) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT * FROM entry WHERE entry_id=?");
            ps.setInt(1, entry_id);
            rs=ps.executeQuery();
            if(rs.next()){
            	EntryVO entry=extractEntryFromResultSet(rs);
            	return entry;
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
	public ArrayList<EntryVO> getEntryByTitle(String title) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM entry WHERE title='"+title+"'");
            ArrayList<EntryVO> entryList = new ArrayList<EntryVO>();
			while(rs.next()){
				EntryVO entry=extractEntryFromResultSet(rs);
				entryList.add(entry);
			}
			return entryList;
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
	public ArrayList<EntryVO> getEntryByCateGory(String category) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM entry WHERE category='"+category+"'");
            ArrayList<EntryVO> entryList = new ArrayList<EntryVO>();
			while(rs.next()){
				EntryVO entry=extractEntryFromResultSet(rs);
				entryList.add(entry);
			}
			return entryList;
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
	public ArrayList<EntryVO> getEntryByIsPassed(boolean isPassed) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT * FROM entry WHERE isPassed=?");
			if(isPassed)
				ps.setString(1, "b'1'");
			else
				ps.setString(1, "b'0'");
            rs=ps.executeQuery();
            ArrayList<EntryVO> entryList = new ArrayList<EntryVO>();
            if(rs.next()){
            	EntryVO entry=extractEntryFromResultSet(rs);
            	entryList.add(entry);
            }
            return entryList;
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
	public boolean updateEntry(EntryVO entry) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		try{
			ps = connection.prepareStatement
					("UPDATE entry SET title=?, brief=?, category=?, isPassed=?"
							+ " WHERE entry_id=?");
			ps.setString(1, entry.getTitle());
			ps.setString(2, entry.getBrief());
			ps.setString(3, entry.getCategory());
			ps.setBoolean(4, entry.isPassed());
			ps.setInt(5, entry.getEntry_id());
			
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
	public boolean insertEntry(EntryVO entry) {
		// TODO Auto-generated method stub
	    Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement
	        		("INSERT INTO entry(title,brief,category,isPassed,create_date)"
	        				+ " VALUES (?, ?, ?, b'0', ?)");
			ps.setString(1, entry.getTitle());
			ps.setString(2, entry.getBrief());
			ps.setString(3, entry.getCategory());
			ps.setDate(4, entry.getCreate_date());
			
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
	public boolean deleteEntry(int entry_id) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		try{
			stmt = connection.createStatement();
			int i= stmt.executeUpdate
					("DELETE FROM entry WHERE entry_id="+entry_id);
			if(i==1){
				return true;
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		finally{
			DBConnection.closeAll(null, stmt, connection);
		}
		return false;
	}
}
