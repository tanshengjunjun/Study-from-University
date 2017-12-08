package DataAccessLayer;
import java.sql.*;
import java.util.*;
/*
import com.dal.takes.Connection;
import com.dal.takes.PreparedStatement;
import com.dal.takes.SQLException;
import com.jdbc.JDBConnection;
*/

import jdbconnection.JDBConnection;
public class Dk_khDAOImplement implements Dk_khDAO{
	/*public ArrayList<Dk_khVO> getDk_khVOList(int khid){
		ArrayList<Dk_khVO> dh_khVO=null;
		Connection conn=JDBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from Dk_kh where khid="+khid;
		try{
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next()){
			dh_khVO.add(rs.getString());
		}
		}
	}
	*/
	public boolean updateDk_kh(Dk_khVO dk_khVO)
	{	boolean flags=true;
		Connection connection = JDBConnection.getConnection();
    PreparedStatement ps = null;
	try {
        ps = connection.prepareStatement("update dk_kh set name=?,khzl=?,khdz=?,"
					+ "khdh=?,zjhm=?,post=?,email=?,account=?,dkje=?,khhmc=?,jbhzh=?,jszh=?,xypj=?,sjdw=?,xdyh=? where khid=?");
        ps.setInt(16, dk_khVO.getKhid());
		ps.setString(1, dk_khVO.getName());
		ps.setString(2, dk_khVO.getKhzl());
		ps.setString(3, dk_khVO.getKhdz());
		ps.setString(4, dk_khVO.getKhdh());
		ps.setString(5, dk_khVO.getZjhm());
		ps.setString(6, dk_khVO.getPost());
		ps.setString(7, dk_khVO.getEmail());
		ps.setString(8, dk_khVO.getAccount());
		ps.setString(9, dk_khVO.getDkje());
		ps.setString(10, dk_khVO.getKhhmc());
		ps.setString(11, dk_khVO.getJbhzh());
		ps.setString(12, dk_khVO.getJszh());
		ps.setInt(13, dk_khVO.getXypj());
		ps.setString(14, dk_khVO.getSjdw());
		ps.setInt(15, dk_khVO.getXdyh());
        int i = ps.executeUpdate();
        if(i == 0) {
	    	 flags=false;
	      }
    } 
	catch (SQLException ex) {
		System.out.println("SQL出错！");
        ex.printStackTrace();
        //下面这句是网上找的检测为什么没插入数据显示检测结果的
        System.out.println(ex.getLocalizedMessage()); 
    }
	finally{
		JDBConnection.closeAll(null, ps, connection);
	}
	return flags;
	}
	public boolean insertDk_kh(Dk_khVO dk_khVO)
	{	boolean flags=true;
		Connection conn=JDBConnection.getConnection();
		PreparedStatement ps=null;
		try{
			String insert="insert into dk_kh(khid,name,khzl,khdz,"
					+ "khdh,zjhm,post,email,account,dkje,khhmc,jbhzh,jszh,xypj,sjdw,xdyh) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//创建preparedStatement
			ps=conn.prepareStatement(insert);
			//为占位符赋值
			ps.setInt(1, dk_khVO.getKhid()); 
			ps.setString(2, dk_khVO.getName());
			ps.setString(3, dk_khVO.getKhzl());
			ps.setString(4, dk_khVO.getKhdz());
			ps.setString(5, dk_khVO.getKhdh());
			ps.setString(6, dk_khVO.getZjhm());
			ps.setString(7, dk_khVO.getPost());
			ps.setString(8, dk_khVO.getEmail());
			ps.setString(9, dk_khVO.getAccount());
			ps.setString(10, dk_khVO.getDkje());
			ps.setString(11, dk_khVO.getKhhmc());
			ps.setString(12, dk_khVO.getJbhzh());
			ps.setString(13, dk_khVO.getJszh());
			ps.setInt(14, dk_khVO.getXypj());
			ps.setString(15, dk_khVO.getSjdw());
			ps.setInt(16, dk_khVO.getXdyh());
			int i=ps.executeUpdate();
			if(i==0)
			{flags=false;}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			JDBConnection.closeAll(null,ps,conn);
		}
		return flags;
	}
	public boolean deleteDk_kh(Dk_khVO dk_khVO)//删除客户信息
	{boolean flags=true;
	Connection conn=null;
	PreparedStatement ps=null;
	String delete="delete from dk_kh where khid="+dk_khVO.getKhid();
	conn=JDBConnection.getConnection();
	try{
		ps=conn.prepareStatement(delete);
		ps.executeUpdate();
		int i=ps.executeUpdate();
		if(i==0)
		{flags=false;}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		JDBConnection.closeAll(null,ps,conn);
	}
	return flags;
	}
}