package com.dal.edit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dal.jdbc.DBConnection;

public class EditDAOImplement implements EditDAO {
	private EditVO extractEditVOFromResultSet(ResultSet rs) throws SQLException {
		EditVO editVO = new EditVO();
		editVO.setEmail(rs.getString("email"));
		editVO.setEntry_id(rs.getInt("entry_id"));
		editVO.setAttribute_name(rs.getString("attribute_name"));
		editVO.setScore(rs.getInt("score"));
		
		return editVO;
	}

	@Override
	public ArrayList<EditVO> getEditVOByEmail(String email) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM edit WHERE email="+email);
            ArrayList<EditVO> editVOList = new ArrayList<EditVO>();
			while(rs.next()){
				EditVO editVO=extractEditVOFromResultSet(rs);
				editVOList.add(editVO);
			}
			return editVOList;
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
	public boolean updateEditVO(EditVO edit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertEditVO(EditVO edit) {
		// TODO Auto-generated method stub
	    Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement
	        		("INSERT INTO edit"
	        				+ "(email,entry_id,attribute_name,score) VALUES (?, ?, ?, ?)");
			ps.setString(1, edit.getEmail());
			ps.setInt(2, edit.getEntry_id());
			ps.setString(3, edit.getAttribute_name());
			ps.setInt(4, edit.getScore());
			
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
	public boolean deleteEditVO(EditVO edit) {
		// TODO Auto-generated method stub
		return false;
	}

}
