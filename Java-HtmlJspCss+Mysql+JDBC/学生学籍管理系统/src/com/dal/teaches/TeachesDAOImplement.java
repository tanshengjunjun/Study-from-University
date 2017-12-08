package com.dal.teaches;

import java.sql.*;
import java.util.ArrayList;

import com.jdbc.DBConnection;

public class TeachesDAOImplement implements TeachesDAO {
	private TeachesVO extractTeachesVOFromResultSet(ResultSet rs) throws SQLException{
		TeachesVO teachesVO=new TeachesVO();
		teachesVO.setID(rs.getString("teacher_id"));
		teachesVO.setCourse_id(rs.getString("course_id"));
		teachesVO.setSec_id(rs.getString("sec_id"));
		teachesVO.setSemester(rs.getString("semester"));
		teachesVO.setYear(rs.getInt("year"));
		
		return teachesVO;
	}
	
	@Override
	public ArrayList<TeachesVO> getTeachesVOListByTeacherID(String teacherID){//通过教师ID查询教师教授课程
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps=connection.prepareStatement("SELECT * FROM teaches WHERE teacher_id=?");
			ps.setString(1, teacherID);
			ArrayList<TeachesVO> teachesVOList = new ArrayList<TeachesVO>();
			rs=ps.executeQuery();
			while(rs.next()){
				TeachesVO teachesVO=extractTeachesVOFromResultSet(rs);
				teachesVOList.add(teachesVO);
			}
			return teachesVOList;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, ps, connection);
		}
		return null;
	}
	
	@Override
	public boolean insertTeaches(TeachesVO teachesVO){//添加授课
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		try{
			ps = connection.prepareStatement("INSERT INTO teaches VALUES (?, ?, ?, ?, ?)");
			ps.setString(1,teachesVO.getID());
			ps.setString(2,teachesVO.getCourse_id());
			ps.setString(3,teachesVO.getSec_id());
			ps.setString(4,teachesVO.getSemester());
			ps.setInt(5,teachesVO.getYear());
			
			int i = ps.executeUpdate();
			if(i == 1){
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
	public boolean deleteTeaches(TeachesVO teachesVO){//删除授课
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		try{
			ps = connection.prepareStatement("DELETE FROM teaches WHERE teacher_id=? AND course_id=? "
					+ "AND sec_id=? AND semester=? AND year=?");
			ps.setString(1,teachesVO.getID());
			ps.setString(2,teachesVO.getCourse_id());
			ps.setString(3,teachesVO.getSec_id());
			ps.setString(4,teachesVO.getSemester());
			ps.setInt(5,teachesVO.getYear());
			
			int i = ps.executeUpdate();
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
}

