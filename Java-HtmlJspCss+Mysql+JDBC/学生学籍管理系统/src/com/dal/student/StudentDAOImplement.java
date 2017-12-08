package com.dal.student;

import java.sql.*;
import java.util.ArrayList;

import com.jdbc.DBConnection;

public class StudentDAOImplement implements StudentDAO {

	private StudentVO extractStudentVOFromResultSet(ResultSet rs) throws SQLException {
		StudentVO studentVO = new StudentVO();
        studentVO.setID(rs.getString("student_id") );
        studentVO.setName(rs.getString("student_name") );
        studentVO.setClassNumber(rs.getInt("class_number"));
        studentVO.setMajor(rs.getString("major"));
        studentVO.setDept_name(rs.getString("dept_name"));
        studentVO.setSex(rs.getString("sex"));
        studentVO.setTot_cred(rs.getDouble("tot_cred"));
        studentVO.setBirthday(rs.getDate("birthday"));
        studentVO.setAddress(rs.getString("address"));
        studentVO.setPhone(rs.getString("phone"));
        studentVO.setEmail(rs.getString("email"));
        studentVO.setPassword(rs.getString("password") );
        studentVO.setIdentification(rs.getString("identification"));
        studentVO.setNation(rs.getString("nation"));
        studentVO.setPolitic(rs.getString("politic"));
        
        return studentVO;
	}
	@Override
	public StudentVO getStudentVOByStudentID(String studentID) {
		
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    Statement stmt = null;
	    ResultSet rs = null;
		try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM student WHERE student_id=" + studentID);
            if(rs.next()){
            	StudentVO studentVO=extractStudentVOFromResultSet(rs);
            	return studentVO;
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
	public StudentVO getStudentVOByStudentIDAndPassword(String studentID, String password) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
            ps = connection.prepareStatement("SELECT * FROM student WHERE student_id=? AND password=?");
            ps.setString(1, studentID);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
            	StudentVO studentVO=extractStudentVOFromResultSet(rs);
            	return studentVO;
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
	
	@SuppressWarnings("null")
	@Override
	public ArrayList<StudentVO> getStudentVOListByStudentIDList(ArrayList<String> studentIDList) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList<StudentVO> studentVOList = null;
		try {
			for(int i=0;i<studentIDList.size();i++){
				if(this.getStudentVOByStudentID(studentIDList.get(i))!=null)
					studentVOList.add(this.getStudentVOByStudentID(studentIDList.get(i)));
			}
	        return studentVOList;
	    } 
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
		finally{
			DBConnection.closeAll(rs, ps, connection);
		}
		return null;
	}

	@Override
	public boolean updateStudentInfo(StudentVO studentVO) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("UPDATE student SET student_name=?, class_number=?, major=?, dept_name=?"
	        		+ ", sex=?, tot_cred=?, birthday=?, address=?, phone=?, email=?, password=?, "
	        		+ "identification=?, nation=?, politic=? WHERE student_id=?");
	        ps.setString(1, studentVO.getName());
	        ps.setInt(2, studentVO.getClassNumber());
	        ps.setString(3, studentVO.getMajor());
	        ps.setString(4, studentVO.getDept_name());
	        ps.setString(5, studentVO.getSex());
	        ps.setDouble(6, studentVO.getTot_cred());
	        ps.setDate(7, (Date) studentVO.getBirthday());
	        ps.setString(8, studentVO.getAddress());
	        ps.setString(9, studentVO.getPhone());
	        ps.setString(10, studentVO.getEmail());
	        ps.setString(11, studentVO.getPassword());
	        ps.setString(12, studentVO.getID());
	        ps.setString(13, studentVO.getIdentification());
	        ps.setString(14, studentVO.getNation());
	        ps.setString(15, studentVO.getPolitic());
	        
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
	public boolean insertStudent(StudentVO studentVO) {
		// TODO Auto-generated method stub
	    Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = null;
		try {
	        ps = connection.prepareStatement("INSERT INTO student"
	        		+ "(student_id,student_name,class_number,major,dept_name,sex,tot_cred,birthday,address,phone,email,password,identification,nation,politic) "
	        		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        ps.setString(1, studentVO.getID());
	        ps.setString(2, studentVO.getName());
	        ps.setInt(3, studentVO.getClassNumber());
	        ps.setString(4, studentVO.getMajor());
	        ps.setString(5, studentVO.getDept_name());
	        ps.setString(6, studentVO.getSex());
	        ps.setDouble(7, studentVO.getTot_cred());
	        ps.setDate(8, (Date) studentVO.getBirthday());
	        ps.setString(9, studentVO.getAddress());
	        ps.setString(10, studentVO.getPhone());
	        ps.setString(11, studentVO.getEmail());
	        ps.setString(12, studentVO.getPassword());
	        ps.setString(13, studentVO.getIdentification());
	        ps.setString(14, studentVO.getNation());
	        ps.setString(15, studentVO.getPolitic());
	        
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
	public boolean deleteStudent(String studentID) {
		// TODO Auto-generated method stub
	    Connection connection = DBConnection.getConnection();
		Statement stmt = null;
		try{
			stmt = connection.createStatement();
	        int i = stmt.executeUpdate("DELETE FROM student WHERE student_id=" + studentID);
	        if(i == 1) {
	        	return true;
	        }
		}
		catch (SQLException ex) {
			ex.printStackTrace();
        }
    return false;
	}

}
