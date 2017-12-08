package com.dal.teacher;

import java.sql.*;
import java.util.ArrayList;

import com.jdbc.DBConnection;

public class TeacherDAOImplement implements TeacherDAO{
	
	private TeacherVO extractTeacherVOFromResultSet(ResultSet rs) throws SQLException {
		TeacherVO teacherVO=new TeacherVO();
		teacherVO.setID(rs.getString("teacher_id"));
		teacherVO.setName(rs.getString("teacher_name"));
		teacherVO.setDept_name(rs.getString("dept_name"));
		teacherVO.setPhone(rs.getString("phone"));
		teacherVO.setEmail(rs.getString("email"));
		teacherVO.setPassword(rs.getString("password"));
		
		return teacherVO;
	}
	
	@Override
	public TeacherVO getTeacherVOByTeacherID(String teacherID){//通过教师ID查找教师
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
	    ResultSet rs = null;
		try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM teacher WHERE teacher_id=" + teacherID);
            if(rs.next()){
            	TeacherVO teacherVO=extractTeacherVOFromResultSet(rs);
            	return teacherVO;
            }
        } 
		catch (SQLException ex) {
            ex.printStackTrace();
        }
		finally{
			DBConnection.closeAll(rs, stmt, connection);
		}
		return null;
	}
	
	@Override
	public TeacherVO getTeacherVOByTeacherIDAndPassword(String teacherID,String password){//登录
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps=connection.prepareStatement("SELECT * FROM teacher WHERE teacher_id=? AND password=?");
			ps.setString(1, teacherID);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				TeacherVO teacherVO=extractTeacherVOFromResultSet(rs);
				return teacherVO;
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, ps, connection);
		}
		return null;
	}
	
	@Override
	public ArrayList<TeacherVO> getTeacherVOList(){
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM teacher");
			ArrayList<TeacherVO> teacherVOList = new ArrayList<TeacherVO>();
			while(rs.next()){
				TeacherVO teacherVO= extractTeacherVOFromResultSet(rs);
				teacherVOList.add(teacherVO);
			}
			return teacherVOList;
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
	public boolean updateTeacherInfo(TeacherVO teacherVO){//修改教师个人信息
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps=null;
		try{
			ps=connection.prepareStatement("UPDATE teacher SET teacher_name=?,dept_name=?,phone=?,"
					+ "email=?,password=? WHERE teacher_id=?");
			ps.setString(1,teacherVO.getName());
			ps.setString(2,teacherVO.getDept_name());
			ps.setString(3,teacherVO.getPhone());
			ps.setString(4,teacherVO.getEmail());
			ps.setString(5,teacherVO.getPassword());
			ps.setString(6,teacherVO.getID());
			
			int i = ps.executeUpdate();
			if(i==1){
				return true;
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			DBConnection.closeAll(null, ps, connection);
		}
		return false;
	}
	
	@Override
	public boolean insertTeacher(TeacherVO teacherVO){//插入教师信息
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps=null;
		try{
			ps=connection.prepareStatement("INSERT INTO teacher VALUES(?,?,?,?,?,?)");
			ps.setString(1,teacherVO.getID());
			ps.setString(2,teacherVO.getName());
			ps.setString(3,teacherVO.getDept_name());
			ps.setString(4,teacherVO.getPhone());
			ps.setString(5,teacherVO.getEmail());
			ps.setString(6,teacherVO.getPassword());
			
			int i = ps.executeUpdate();
			if(i==1){
				return true;
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			DBConnection.closeAll(null, ps, connection);
		}
		return false;
	}
	
	@Override
	public boolean deleteTeacher(String teacherID){//删除教师信息
		Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		try{
			stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM teacher WHERE teacher_id="+teacherID);
			if(i==1){
				return true;
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}
}
