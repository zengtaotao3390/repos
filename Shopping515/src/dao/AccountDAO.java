package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBConnection;
import util.PageList;
import domain.Account;
import domain.Goods;
import domain.Shoppingcard;


public class AccountDAO {
	
	private PageList pl=new PageList();
	public boolean save(Account a) throws SQLException{
		   try{
			   String sql="insert into account(userid,tel,email,accountcode,execute,accountdate,num,goodsId) values(?,?,?,?,?,now(),?,?)";
			   JDBConnection con=new JDBConnection();
			   Connection conn=con.creatConnection();
			   PreparedStatement psmt=conn.prepareStatement(sql);
			   psmt.setInt(1, a.getUserid());
			   psmt.setString(2, a.getTel());
			   psmt.setString(3,a.getEmail());
			   psmt.setString(4, a.getAccountcode());
			   psmt.setInt(5, a.getExecute());
			   psmt.setInt(6, a.getNum());
			   psmt.setInt(7, a.getGoodsId());
			   
			   psmt.executeUpdate();
			   return true;
			  //conn.commit();
		   }catch(Exception e){
			   
			   e.printStackTrace();
		   }
		   return false;
	   }
	
	public Integer pageSize(int userId){
	 	   int maxRow=pl.pageSizeAccount("account",userId);
	 	   int pages=maxRow/8;
	 	   if(maxRow%8>0){
	 		   pages=pages+1;
	 		   return pages;
	 	   }
	 	   return pages;
	    }
	
	public List<Account> findByUserId(int userId,int currentePage)throws SQLException{
    	try{
    		
    		ResultSet rs=pl.pageListAccount(8, "account", currentePage, userId);
    		rs.beforeFirst();
    		List<Account> list=new ArrayList<Account>();

 		   while(rs.next()){
 			   Account a = new Account();
 			   a.setId(rs.getInt("id"));
 			   a.setAccountcode(rs.getString("accountcode"));
 			   a.setAccountdate(rs.getDate("accountdate"));
 			   a.setEmail(rs.getString("email"));
 			   a.setExecute(rs.getInt("execute"));
 			   a.setGoodsId(rs.getInt("goodsId"));
 			   a.setNum(rs.getInt("num"));
 			   a.setTel(rs.getString("tel"));
 			   a.setUserid(rs.getInt("userid"));
 			   
 			   
 			   
 			   list.add(a);
 		   }
 		   return list;
 	   }catch(Exception e){
 		   e.printStackTrace();
 	   }
 	   return null;
    	
    }
	
	public boolean changeExecute(int accountId){
		try{
    		String sql = "update account set execute=? where id=?";
    		int a = 1;
    		
    		JDBConnection con=new JDBConnection();
    		Connection conn=con.creatConnection();
    		PreparedStatement psmt=conn.prepareStatement(sql);
    		psmt.setInt(1, a);
    		psmt.setInt(2, accountId);
    		
    		int b=psmt.executeUpdate();
    		if(b!=0){
    			return true;
    		}else{
    			return false;
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return false;
    }
   
	public boolean changeExecuteBusiness(int accountId){
		try{
    		String sql = "update account set execute=? where id=?";
    		int a = 2;
    		
    		JDBConnection con=new JDBConnection();
    		Connection conn=con.creatConnection();
    		PreparedStatement psmt=conn.prepareStatement(sql);
    		psmt.setInt(1, a);
    		psmt.setInt(2, accountId);
    		
    		int b=psmt.executeUpdate();
    		if(b!=0){
    			return true;
    		}else{
    			return false;
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return false;
    }
   
	
	 public boolean deleteAccount(int id) throws SQLException{
	    	try{
	    		String sql="delete from account where id=?";
	    		JDBConnection con=new JDBConnection();
	    		Connection conn=con.creatConnection();
	    		PreparedStatement psmt=conn.prepareStatement(sql);
	    		psmt.setInt(1, id);
	    		int b=psmt.executeUpdate();
	    		if(b!=0){
	    			return true;
	    		}else{
	    			return false;
	    		}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return false;
	    }
	 public Account findById(int accountId){
			try{
				   String sql="select * from account where id=?";
				   //ConnectionDB a;//����һ��ConnectionDB�࣬���ڽ�����ݿ�����
				   JDBConnection conn=new JDBConnection();
				   
				   //��̬�ķ��������������ֱ�ӵ�
				   Connection con=conn.creatConnection();
				   PreparedStatement psmt=con.prepareStatement(sql);
				   psmt.setInt(1, accountId);
				  
				   ResultSet rs=psmt.executeQuery();
				   if(rs.next()){
					   Account a=new Account();
					   
					   a.setId(rs.getInt("id"));
					   a.setAccountcode(rs.getString("accountcode"));
					   a.setAccountdate(rs.getDate("accountdate"));
					   a.setEmail(rs.getString("email"));
					   a.setExecute(rs.getInt("execute"));
					   a.setGoodsId(rs.getInt("goodsId"));
					   a.setNum(rs.getInt("num"));
					   a.setTel(rs.getString("tel"));
					   a.setUserid(rs.getInt("userid"));
					   
					   //con.commit();
					   rs.close();
					   return a;
				   }else {
					   return null;
				   }
				   
			   }catch(Exception e){
				   e.printStackTrace();
				   return null;
			   }
			   
		   }
	 
	 public Account findByAccountcode(String accountcode){
			try{
				   String sql="select * from account where accountcode=?";
				   //ConnectionDB a;//����һ��ConnectionDB�࣬���ڽ�����ݿ�����
				   JDBConnection conn=new JDBConnection();
				   
				   //��̬�ķ��������������ֱ�ӵ�
				   Connection con=conn.creatConnection();
				   PreparedStatement psmt=con.prepareStatement(sql);
				   psmt.setString(1, accountcode);
				  
				   ResultSet rs=psmt.executeQuery();
				   if(rs.next()){
					   Account a=new Account();
					   
					   a.setId(rs.getInt("id"));
					   a.setAccountcode(rs.getString("accountcode"));
					   a.setAccountdate(rs.getDate("accountdate"));
					   a.setEmail(rs.getString("email"));
					   a.setExecute(rs.getInt("execute"));
					   a.setGoodsId(rs.getInt("goodsId"));
					   a.setNum(rs.getInt("num"));
					   a.setTel(rs.getString("tel"));
					   a.setUserid(rs.getInt("userid"));
					   
					   //con.commit();
					   rs.close();
					   return a;
				   }else {
					   return null;
				   }
				   
			   }catch(Exception e){
				   e.printStackTrace();
				   return null;
			   }
			   
		   }
	 
	 public List<Account> findAllAccount(String year){
		 try{
		 List<Account> list = new ArrayList<Account>();
		 String sql = "select * from account where accountdate like ?";
		 JDBConnection conn = new JDBConnection();
		 Connection con = conn.creatConnection();
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, year + "-%");
		 ResultSet rs = pstmt.executeQuery();
		 rs.beforeFirst();
		 while(rs.next()){
			  Account a=new Account();
			   
			   a.setId(rs.getInt("id"));
			   a.setAccountcode(rs.getString("accountcode"));
			   a.setAccountdate(rs.getDate("accountdate"));
			   a.setEmail(rs.getString("email"));
			   a.setExecute(rs.getInt("execute"));
			   a.setGoodsId(rs.getInt("goodsId"));
			   a.setNum(rs.getInt("num"));
			   a.setTel(rs.getString("tel"));
			   a.setUserid(rs.getInt("userid"));
			   list.add(a);
		 }
		 return list;
	 }catch(SQLException e){
		 e.printStackTrace();
	 }
	return null;
	 }
}
