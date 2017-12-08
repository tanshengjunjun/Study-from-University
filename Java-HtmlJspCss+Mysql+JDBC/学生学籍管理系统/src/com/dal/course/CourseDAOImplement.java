package com.dal.course;

import java.sql.*;
import java.util.ArrayList;

import com.jdbc.DBConnection;

public class CourseDAOImplement implements CourseDAO{

	private CourseVO extractCourseVOFromResultSet(ResultSet rs) throws SQLException {
		CourseVO courseVO = new CourseVO();
		courseVO.setCourse_id(rs.getString("course_id"));
		courseVO.setTitle(rs.getString("title"));
		courseVO.setCredits(rs.getDouble("credits"));
		courseVO.setDept_name(rs.getString("dept_name"));
		courseVO.setCapacity(rs.getInt("capacity"));
		courseVO.setType(rs.getString("type"));
		
		return courseVO;
	}

	@Override
	public CourseVO getCourseVOByCourseID(String courseID){
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM course WHERE course_id="+courseID);
			if(rs.next()){
				CourseVO courseVO=extractCourseVOFromResultSet(rs);
				return courseVO;
			}
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
	public CourseVO getCourseVOByTitle(String title) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM course WHERE title="+title);
			if(rs.next()){
				CourseVO courseVO=extractCourseVOFromResultSet(rs);
				return courseVO;
			}
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
	public ArrayList<CourseVO> getCourseVOListByDeptName(String dept_name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM course WHERE dept_name="+dept_name);
			ArrayList<CourseVO> courseVOList = new ArrayList<CourseVO>();
			while(rs.next()){
				CourseVO courseVO = extractCourseVOFromResultSet(rs);
				courseVOList.add(courseVO);
			}
			return courseVOList;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, stmt, connection);
		}
		return null;
	}
	
	@Override
	public boolean updateCourseInfo(CourseVO courseVO){
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		try{
			ps = connection.prepareStatement("UPDATE course SET title=?,credits=?,"
					+ "dept_name=?,capacity=?,type=? WHERE course_id=?");
			ps.setString(1,courseVO.getTitle());
			ps.setDouble(2,courseVO.getCredits());
			ps.setString(3,courseVO.getDept_name());
			ps.setInt(4,courseVO.getCapacity());
			ps.setString(5,courseVO.getCourse_id());
			ps.setString(6, courseVO.getType());
			
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
	public boolean insertCourse(CourseVO courseVO) {
	    Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("INSERT INTO course VALUES (?, ?, ?, ?, ?, ?)");
	        ps.setString(1,courseVO.getCourse_id());
	        ps.setString(2,courseVO.getTitle());
			ps.setDouble(3,courseVO.getCredits());
			ps.setString(4,courseVO.getDept_name());
			ps.setInt(5,courseVO.getCapacity());
			ps.setString(6, courseVO.getType());
			
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
	public boolean deleteCourse(String courseID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		try{
			stmt = connection.createStatement();
			int i= stmt.executeUpdate("DELETE FROM course WHERE course_id="+courseID);
			if(i==1){
				return true;
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
	return false;		
	}
}
