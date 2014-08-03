package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Shoppingcard;

import util.JDBConnection;
import util.PageList;

public class ShoppingcartDAO {
	private PageList pl=new PageList();
	
	public boolean findById(int goodsId,int userId){
		try{

			   String sql="select * from shoppingcart where goodsId=? and userId=?";
					   //ConnectionDB a;//创建一个ConnectionDB类，用于建立数据库连接
					   
					   //静态的方法，所以类可以直接调
			   JDBConnection conn=new JDBConnection();
			   Connection con=conn.creatConnection();
			   PreparedStatement psmt=con.prepareStatement(sql);
			   psmt.setInt(1,goodsId);
			   psmt.setInt(2, userId);
			   ResultSet rs=psmt.executeQuery();
			   if(rs.next()){
				   
				  String sql1="update shoppingcart set number=? where goodsId=? and userId=?";
					
					JDBConnection conn1=new JDBConnection();
					   
					   //静态的方法，所以类可以直接调
					   Connection con1=conn1.creatConnection();
					PreparedStatement psmt1=con1.prepareStatement(sql1);
					   psmt1.setInt(1, rs.getInt("number")+1);
					   psmt1.setInt(2, goodsId);
					   psmt1.setInt(3, userId);
					   psmt1.executeUpdate();
				 return true;
			     
			   }else{
			   return false;
			   }
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return false;
	   }
	public void add(Shoppingcard sc) throws SQLException{
		   try{
			   String sql="insert into shoppingcart(goodsName,price,number,userId,goodsId) values(?,?,?,?,?)";
			   JDBConnection con=new JDBConnection();
			   Connection conn=con.creatConnection();
			   PreparedStatement psmt=conn.prepareStatement(sql);
			   psmt.setString(1, sc.getGoodsName());
			   psmt.setFloat(2, sc.getPrice());
			   psmt.setInt(3,sc.getNumber());
			   psmt.setInt(4, sc.getUserId());
			   psmt.setInt(5, sc.getGoodsId());
			   
			   psmt.executeUpdate();
			  //conn.commit();
		   }catch(Exception e){
			   
			   e.printStackTrace();
		   }
	   }
	 public Integer pageSize(int userId){
	 	   int maxRow=pl.pageSizeScart("shoppingcart",userId);
	 	   int pages=maxRow/8;
	 	   if(maxRow%8>0){
	 		   pages=pages+1;
	 		   return pages;
	 	   }
	 	   return pages;
	    }
	 public List<Shoppingcard> findByUserId(int userId,int currentePage)throws SQLException{
	    	try{
	    		ResultSet rs=pl.pageListScart(8, "shoppingcart", currentePage, userId);
	    		rs.beforeFirst();
	    		List<Shoppingcard> list=new ArrayList<Shoppingcard>();

	 		   while(rs.next()){
	 			   Shoppingcard sc = new Shoppingcard();
	 			   sc.setId(rs.getInt("id"));
	 			   sc.setGoodsName(rs.getString("goodsName"));
	 			   sc.setPrice(rs.getFloat("price"));
	 			   sc.setNumber(rs.getInt("number"));
	 			   sc.setUserId(rs.getInt("userId"));
	 			   sc.setGoodsId(rs.getInt("goodsId"));
	 			   
	 			   list.add(sc);
	 		   }
	 		   return list;
	 	   }catch(Exception e){
	 		   e.printStackTrace();
	 	   }
	 	   return null;
	    	
	    }
	 public boolean deleteCart(int id) throws SQLException{
	    	try{
	    		String sql="delete from shoppingcart where id=?";
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
	    
	 public boolean deleteAllCart(int userId) throws SQLException{
		   try{
			   String sql="delete from shoppingCart where userId=?";
			   JDBConnection con=new JDBConnection();
			   Connection conn=con.creatConnection();
			   PreparedStatement psmt2=conn.prepareStatement(sql);
			   psmt2.setInt(1, userId);
			   int b=psmt2.executeUpdate();
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
	 public void changeNum(int number,int id){
		 try {
		 String sql="update shoppingcart set number=? where id=?";
		 JDBConnection conn=new JDBConnection();
		   Connection con=conn.creatConnection();
		   PreparedStatement psmt= con.prepareStatement(sql);	
		   psmt.setInt(1,number);
		   psmt.setInt(2, id);
		   psmt.executeUpdate();
	 } catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 }
	 
	 
	


