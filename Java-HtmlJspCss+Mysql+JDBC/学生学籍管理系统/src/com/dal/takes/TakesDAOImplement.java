package com.dal.takes;

import java.sql.*;
import java.util.ArrayList;

import com.dal.section.SectionVO;
import com.jdbc.DBConnection;

public class TakesDAOImplement implements TakesDAO {
	private TakesVO extractTakesVOFromResultSet(ResultSet rs) throws SQLException {
		TakesVO takesVO = new TakesVO();
		takesVO.setID(rs.getString("student_id"));
		takesVO.setCourse_id(rs.getString("course_id"));
		takesVO.setSec_id(rs.getString("sec_id"));
		takesVO.setSemester(rs.getString("semester"));
		takesVO.setYear(rs.getInt("year"));
		takesVO.setGrade(rs.getInt("grade"));
        
        return takesVO;
	}
	
	@Override
	public ArrayList<TakesVO> getTakesVOListByStudentID(String studentID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT * FROM takes WHERE student_id=?");
            ps.setString(1, studentID);
            ArrayList<TakesVO> takesVOList = new ArrayList<TakesVO>();
            rs=ps.executeQuery();
            while(rs.next()){
            	TakesVO takesVO=extractTakesVOFromResultSet(rs);
            	takesVOList.add(takesVO);
            }
            return takesVOList;
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
	public ArrayList<TakesVO> getTakesVOListBySemesterAndYear(String semester, int year) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT * FROM takes WHERE semester=? AND year=?");
            ps.setString(1, semester);
            ps.setInt(2, year);
            ArrayList<TakesVO> takesVOList = new ArrayList<TakesVO>();
            rs=ps.executeQuery();
            while(rs.next()){
            	TakesVO takesVO=extractTakesVOFromResultSet(rs);
            	takesVOList.add(takesVO);
            }
            return takesVOList;
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
	public double getGradeByTakesVO(TakesVO takesVO) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT grade FROM takes WHERE student_id=? AND course_id=? AND sec_id=? "
            		+ "AND semester=? AND year=?");
            ps.setString(1, takesVO.getID());
            ps.setString(2, takesVO.getCourse_id());
            ps.setString(3, takesVO.getSec_id());
            ps.setString(4, takesVO.getSemester());
            ps.setInt(5, takesVO.getYear());
            rs=ps.executeQuery();
            if(rs.next()){
            	return rs.getDouble("grade");
            }
        } 
		catch (SQLException ex) {
            ex.printStackTrace();
        }
		finally{
			DBConnection.closeAll(rs, ps, connection);
		}
		return 0;
	}

	@Override
	public boolean updateTakesInfo(TakesVO takesVO) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("UPDATE takes SET grade=? WHERE student_id=? AND course_id=? AND sec_id=? "
	        		+ "AND semester=? AND year=?");
	        ps.setInt(1, takesVO.getGrade());
	        ps.setString(2, takesVO.getID());
	        ps.setString(3, takesVO.getCourse_id());
	        ps.setString(4, takesVO.getSec_id());
	        ps.setString(5, takesVO.getSemester());
	        ps.setInt(6, takesVO.getYear());
	        
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
	public boolean insertTakes(TakesVO takesVO) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("INSERT INTO takes(student_id,course_id,sec_id,semester,year,grade)"
	        		+ " VALUES (?, ?, ?, ?, ?, ?)");
	        ps.setString(1, takesVO.getID());
	        ps.setString(2, takesVO.getCourse_id());
	        ps.setString(3, takesVO.getSec_id());
	        ps.setString(4, takesVO.getSemester());
	        ps.setInt(5, takesVO.getYear());
	        ps.setInt(6, takesVO.getGrade());//选课时在逻辑上没有成绩
	        
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
	public boolean deleteTakes(TakesVO takesVO) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("DELETE FROM takes WHERE student_id=? AND course_id=? "
	        		+ "AND sec_id=? AND semester=? AND year=?");
	        ps.setString(1, takesVO.getID());
	        ps.setString(2, takesVO.getCourse_id());
	        ps.setString(3, takesVO.getSec_id());
	        ps.setString(4, takesVO.getSemester());
	        ps.setInt(5, takesVO.getYear());
	        
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
	public ArrayList<String> getStudentIDListBySectionVO(SectionVO sectionVO) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT student_id FROM takes WHERE course_id=? "
            		+ "AND sec_id=? AND semester=? AND year=?");
            ps.setString(1, sectionVO.getCourse_id());
            ps.setString(2, sectionVO.getSec_id());
            ps.setString(3, sectionVO.getSemester());
            ps.setInt(4, sectionVO.getYear());
            ArrayList<String> studentIDList = new ArrayList<String>();
            rs=ps.executeQuery();
            while(rs.next()){
            	studentIDList.add(rs.getString("student_id"));
            }
            return studentIDList;
        } 
		catch (SQLException ex) {
            ex.printStackTrace();
        }
		finally{
			DBConnection.closeAll(rs, ps, connection);
		}
		return null;
	}

}
