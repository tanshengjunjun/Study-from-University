package com.dal.section;

import java.sql.*;
import java.util.ArrayList;

import com.jdbc.DBConnection;

public class SectionDAOImplement implements SectionDAO {
	private SectionVO extractSectionVOFromResultSet(ResultSet rs) throws SQLException {
		SectionVO sectionVO = new SectionVO();
		sectionVO.setCourse_id(rs.getString("course_id"));
		sectionVO.setSec_id(rs.getString("sec_id"));
		sectionVO.setSemester(rs.getString("semester"));
		sectionVO.setYear(rs.getInt("year"));
		sectionVO.setRoom_number(rs.getString("room_number"));
		sectionVO.setTime_slot_id(rs.getString("time_slot_id"));
		
		return sectionVO;
	}
	@Override
	public SectionVO getSectionVOBySectionKey(String course_id, String sec_id, String semester, int year) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT * FROM section WHERE course_id=? AND sec_id=? AND semester=? AND year=?");
            ps.setString(1, course_id);
            ps.setString(2, sec_id);
            ps.setString(3, semester);
            ps.setInt(4, year);
            rs=ps.executeQuery();
			if(rs.next()){
				SectionVO sectionVO=extractSectionVOFromResultSet(rs);
				return sectionVO;
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
	public ArrayList<SectionVO> getSectionVOListBySemesterAndYear(String semester, int year) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT * FROM section WHERE semester=? AND year=?");
            ps.setString(1, semester);
            ps.setInt(2, year);
            ArrayList<SectionVO> sectionVOList = new ArrayList<SectionVO>();
            rs=ps.executeQuery();
            while(rs.next()){
            	SectionVO sectionVO=extractSectionVOFromResultSet(rs);
            	sectionVOList.add(sectionVO);
            }
            return sectionVOList;
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
	public boolean updateSectionInfo(SectionVO sectionVO) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("UPDATE section SET room_number=?, time_slot_id=? WHERE course_id=? AND sec_id=? "
	        		+ "AND semester=? AND year=?");
	        ps.setString(1, sectionVO.getRoom_number());
	        ps.setString(2, sectionVO.getTime_slot_id());
	        ps.setString(3, sectionVO.getCourse_id());
	        ps.setString(4, sectionVO.getSec_id());
	        ps.setString(5, sectionVO.getSemester());
	        ps.setInt(6, sectionVO.getYear());
	        
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
	public boolean insertSection(SectionVO sectionVO) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("INSERT INTO section VALUES (?, ?, ?, ?, ?, ?)");
	        ps.setString(1, sectionVO.getCourse_id());
	        ps.setString(2, sectionVO.getSec_id());
	        ps.setString(3, sectionVO.getSemester());
	        ps.setInt(4, sectionVO.getYear());
	        ps.setString(5, sectionVO.getRoom_number());
	        ps.setString(6, sectionVO.getTime_slot_id());
	        
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
	public boolean deleteSection(SectionVO sectionVO) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("DELETE FROM section WHERE course_id=? AND sec_id=? "
	        		+ "AND semester=? AND year=?");
	        ps.setString(1, sectionVO.getCourse_id());
	        ps.setString(2, sectionVO.getSec_id());
	        ps.setString(3, sectionVO.getSemester());
	        ps.setInt(4, sectionVO.getYear());
	        
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
