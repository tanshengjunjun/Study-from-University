package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbconnection.JDBConnection;

public class T_dklxDAOImplement {
	public boolean updateT_dklx(T_dklxVO t_dklxVO){
		boolean flags=true;
		Connection connection = JDBConnection.getConnection();
    PreparedStatement ps = null;
	try {
        ps = connection.prepareStatement("update t_dklx set flx_id=?"
        		+ ",lxbz=?,dk_zh=?,dk_ye=?,fxzhrq=?,fxksrq=?"
        		+ ",lxdqrq=?,lxjxrq=?,lxclrq=?,ll=?,lxe=?,"
        		+ "lxclbz=?,where lx_id=?");
        ps.setInt(13, t_dklxVO.getLx_id());
		ps.setInt(1, t_dklxVO.getFlx_id());
		ps.setString(2, t_dklxVO.getLxbz());
		ps.setString(3, t_dklxVO.getDk_zh());
		ps.setFloat(4, t_dklxVO.getDk_ye());
		ps.setString(5, t_dklxVO.getFxzhrq());
		ps.setString(6, t_dklxVO.getFxksrq());
		ps.setString(7, t_dklxVO.getLxdqrq());
		ps.setString(8, t_dklxVO.getLxjxrq());
		ps.setString(9, t_dklxVO.getLxclrq());
		ps.setFloat(10, t_dklxVO.getLl());
		ps.setFloat(11, t_dklxVO.getLxe());
		ps.setString(12, t_dklxVO.getLxclbz());
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
	public boolean insertT_dklx(T_dklxVO t_dklxVO){
		boolean flags=true;
		Connection conn=JDBConnection.getConnection();
		PreparedStatement ps=null;
		try{
			String insert="insert into t_dklx(flx_id"
        		+ ",lxbz,dk_zh,dk_ye,fxzhrq,fxksrq"
        		+ ",lxdqrq,lxjxrq,lxclrq,ll,lxe,"
        		+ "lxclbz, lx_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//创建preparedStatement
			ps=conn.prepareStatement(insert);
			//为占位符赋值
		      ps.setInt(13, t_dklxVO.getLx_id());
				ps.setInt(1, t_dklxVO.getFlx_id());
				ps.setString(2, t_dklxVO.getLxbz());
				ps.setString(3, t_dklxVO.getDk_zh());
				ps.setFloat(4, t_dklxVO.getDk_ye());
				ps.setString(5, t_dklxVO.getFxzhrq());
				ps.setString(6, t_dklxVO.getFxksrq());
				ps.setString(7, t_dklxVO.getLxdqrq());
				ps.setString(8, t_dklxVO.getLxjxrq());
				ps.setString(9, t_dklxVO.getLxclrq());
				ps.setFloat(10, t_dklxVO.getLl());
				ps.setFloat(11, t_dklxVO.getLxe());
				ps.setString(12, t_dklxVO.getLxclbz());
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
	public boolean deleteT_dklx(T_dklxVO t_dklxVO){
		boolean flags=true;
		Connection conn=null;
		PreparedStatement ps=null;
		String delete="delete from dk_kh where lx_id="+t_dklxVO.getLx_id();
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
