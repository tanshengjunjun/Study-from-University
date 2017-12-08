package DataAccessLayer;
import java.sql.*;

import jdbconnection.JDBConnection;

public class Dk_sqDAOImplement implements Dk_sqDAO{
public boolean updateDk_sq(Dk_sqVO dk_sqVO){
boolean flags=true;
Connection connection=JDBConnection.getConnection();
PreparedStatement ps=null;
try{
	ps=connection.prepareStatement("update dk_sq set "
			+ "dkkhid=?,dkzl=?,dkxz=?,dkyt=?,dkfw=?,dkdyp=?,dypje=?,dbrid=?,dkje=?,zcglid=?,"
			+ "sqrq=?,sprq=?,fdbz=?,sprid=?,dkzh=?,dkhth=?,"
			+ "dkhtje=?,dkhtll=?,hkfs=?,mqhkje=?,dcxdyid=? where dk_sqh=?");
	ps.setInt(22,dk_sqVO.getDk_sqh());
	ps.setInt(1,dk_sqVO.getDkkhid());
	ps.setString(2,dk_sqVO.getDkzl());
	ps.setString(3,dk_sqVO.getDkxz());
	ps.setString(4,dk_sqVO.getDkyt());
	ps.setString(5,dk_sqVO.getDkfw());
	ps.setString(6,dk_sqVO.getDkdyp());
	ps.setFloat(7,dk_sqVO.getDypje());
	ps.setInt(8,dk_sqVO.getDbrid());
	ps.setFloat(9,dk_sqVO.getDkje());
	ps.setInt(10,dk_sqVO.getZcglid());
	ps.setString(11,dk_sqVO.getSqrq());
	ps.setString(12,dk_sqVO.getSprq());
	ps.setInt(13,dk_sqVO.getFdbz());
	ps.setInt(14,dk_sqVO.getSprid());
	ps.setString(15,dk_sqVO.getDkzh());
	ps.setString(16,dk_sqVO.getDkhth());
	ps.setFloat(17,dk_sqVO.getDkhtje());
	ps.setFloat(18,dk_sqVO.getDkhtll());
	ps.setString(19,dk_sqVO.getHkfs());
	ps.setFloat(20,dk_sqVO.getMqhkje());
	ps.setInt(21,dk_sqVO.getDcxdyid());
	int i=ps.executeUpdate();
	if(i==0){
		flags=false;
	}
}
catch(SQLException ex){
	System.out.println("SQL出错！");
	 ex.printStackTrace();
}
finally{
	JDBConnection.closeAll(null, ps, connection);
}
return flags;
}
public boolean insertDk_sq(Dk_sqVO dk_sqVO){
	boolean flags=true;
	Connection conn=JDBConnection.getConnection();
	PreparedStatement ps=null;
	try{
		String insert="insert into dk_sq(dkkhid,dkzl,dkxz,dkyt,dkfw,dkdyp,dypje,dbrid,dkje,zcglid,"
			+ "sqrq,sprq,fdbz,sprid,dkzh,dkhth,"
			+ "dkhtje,dkhtll,hkfs,mqhkje,dcxdyid,dk_sqh) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	//创建preparedStatement
		ps=conn.prepareStatement(insert);
		//为占位符赋值
		ps.setInt(22,dk_sqVO.getDk_sqh());
		ps.setInt(1,dk_sqVO.getDkkhid());
		ps.setString(2,dk_sqVO.getDkzl());
		ps.setString(3,dk_sqVO.getDkxz());
		ps.setString(4,dk_sqVO.getDkyt());
		ps.setString(5,dk_sqVO.getDkfw());
		ps.setString(6,dk_sqVO.getDkdyp());
		ps.setFloat(7,dk_sqVO.getDypje());
		ps.setInt(8,dk_sqVO.getDbrid());
		ps.setFloat(9,dk_sqVO.getDkje());
		ps.setInt(10,dk_sqVO.getZcglid());
		ps.setString(11,dk_sqVO.getSqrq());
		ps.setString(12,dk_sqVO.getSprq());
		ps.setInt(13,dk_sqVO.getFdbz());
		ps.setInt(14,dk_sqVO.getSprid());
		ps.setString(15,dk_sqVO.getDkzh());
		ps.setString(16,dk_sqVO.getDkhth());
		ps.setFloat(17,dk_sqVO.getDkhtje());
		ps.setFloat(18,dk_sqVO.getDkhtll());
		ps.setString(19,dk_sqVO.getHkfs());
		ps.setFloat(20,dk_sqVO.getMqhkje());
		ps.setInt(21,dk_sqVO.getDcxdyid());
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
public boolean deleteDk_sq(Dk_sqVO dk_sqVO){
	boolean flags=true;
	Connection conn=null;
	PreparedStatement ps=null;
	String delete="delete from dk_sq where dk_sqh="+dk_sqVO.getDk_sqh();
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
