package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbconnection.JDBConnection;

public class T_dkfhDAOImplement implements T_dkfhDAO{
	public boolean updateT_dkfh(T_dkfhVO t_dkfhVO){
		boolean flags=true;
		Connection connection = JDBConnection.getConnection();
    PreparedStatement ps = null;
	try {
        ps = connection.prepareStatement("update t_dkfh set khid=?,dksqid=?,kmh=?,sybz=?"    		
+"dkbz=?,dkksrq=?,kddqrq=?,dkzqrq=?,zhhkrq=?,zhjxrq=?,ye=?,sjll=?,zqll=?,yqll=?,fqll=? where dkbh=?");
        ps.setString(16, t_dkfhVO.getDkbh());
		ps.setInt(1, t_dkfhVO.getKhid());
		ps.setInt(2, t_dkfhVO.getDksqid());
		ps.setString(3, t_dkfhVO.getKmh());
		ps.setString(4, t_dkfhVO.getSybz());
		ps.setString(5, t_dkfhVO.getDkbz());
		ps.setString(6, t_dkfhVO.getDkksrq());
		ps.setString(7, t_dkfhVO.getKddqrq());
		ps.setString(8, t_dkfhVO.getDkzqrq());
		ps.setString(9, t_dkfhVO.getZhhkrq());
		ps.setString(10, t_dkfhVO.getZhjxrq());
		ps.setFloat(11, t_dkfhVO.getYe());
		ps.setFloat(12, t_dkfhVO.getSjll());
		ps.setFloat(10, t_dkfhVO.getZqll());
		ps.setFloat(11, t_dkfhVO.getYqll());
		ps.setFloat(12, t_dkfhVO.getFqll());
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
	public boolean insertT_dkfh(T_dkfhVO t_dkfhVO){
		boolean flags=true;
		Connection conn=JDBConnection.getConnection();
		PreparedStatement ps=null;
		try{
			String insert="insert into t_dkfh(khid"
        		+ ",dksqid,kmh,sybz,dkbz,dkksrq"
        		+ ",kddqrq,dkzqrq,zhhkrq,zhjxrq,ye,"
        		+ "sjll, zqll,yqll,fqll,dkbh) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//创建preparedStatement
			ps=conn.prepareStatement(insert);
			//为占位符赋值
				ps.setString(16, t_dkfhVO.getDkbh());
				ps.setInt(1, t_dkfhVO.getKhid());
				ps.setInt(2, t_dkfhVO.getDksqid());
				ps.setString(3, t_dkfhVO.getKmh());
				ps.setString(4, t_dkfhVO.getSybz());
				ps.setString(5, t_dkfhVO.getDkbz());
				ps.setString(6, t_dkfhVO.getDkksrq());
				ps.setString(7, t_dkfhVO.getKddqrq());
				ps.setString(8, t_dkfhVO.getDkzqrq());
				ps.setString(9, t_dkfhVO.getZhhkrq());
				ps.setString(10, t_dkfhVO.getZhjxrq());
				ps.setFloat(11, t_dkfhVO.getYe());
				ps.setFloat(12, t_dkfhVO.getSjll());
				ps.setFloat(10, t_dkfhVO.getZqll());
				ps.setFloat(11, t_dkfhVO.getYqll());
				ps.setFloat(12, t_dkfhVO.getFqll());
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
	public boolean deleteT_dkfh(T_dkfhVO t_dkfhVO){
		boolean flags=true;
		Connection conn=null;
		PreparedStatement ps=null;
		String delete="delete from dk_fh where dkbh=?"+t_dkfhVO.getDkbh();
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
