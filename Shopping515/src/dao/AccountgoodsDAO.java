package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JDBConnection;
import domain.Accountgoods;

public class AccountgoodsDAO {
	public boolean save(Accountgoods ag) throws SQLException{
		   try{
			   String sql="insert into accountgoods(goodsId,accountcode,num) values(?,?,?)";
			   JDBConnection con=new JDBConnection();
			   Connection conn=con.creatConnection();
			   PreparedStatement psmt=conn.prepareStatement(sql);
			   psmt.setInt(1, ag.getGoodsId());
			   psmt.setString(2, ag.getAccountcode());
			   psmt.setInt(3,ag.getNum());
			  
			   psmt.executeUpdate();
			   return true;
			  //conn.commit();
		   }catch(Exception e){
			   
			   e.printStackTrace();
		   }
		   return false;
	   }
}
