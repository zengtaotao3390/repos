package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Goods;
import domain.Shoppingcard;



import util.JDBConnection;
import util.PageList;

public class GoodsDAO {
	private PageList pl=new PageList();
	
	 public List<Goods> findAllGoods(int currentePage)throws SQLException{
		   try{
			   ResultSet rs=pl.pageList(8, "goods", currentePage, "asc", "id");
			   rs.beforeFirst();
			   List<Goods> list=new ArrayList<Goods>();
			   while(rs.next()){
				   Goods g = new Goods();
				   g.setId(rs.getInt("id"));
				   g.setGoodsname(rs.getString("goodsname"));
				   g.setPrice(rs.getFloat("price"));
				   g.setDiscount(rs.getFloat("discount"));
				   g.setPic(rs.getString("pic"));
				   g.setOutdate(rs.getString("outdate"));
				   g.setIntroduction(rs.getString("introduction"));
				   g.setNum(rs.getInt("num"));
				   list.add(g);
			   }
			   return list;
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return null;
		   
	   }
	 
	 public List<Goods> findAllGoods(int currentePage, String order, String field)throws SQLException{
		   try{
			   ResultSet rs=pl.pageList(8, "goods", currentePage, order, field);
			   rs.beforeFirst();
			   List<Goods> list=new ArrayList<Goods>();
			   while(rs.next()){
				   Goods g = new Goods();
				   g.setId(rs.getInt("id"));
				   g.setGoodsname(rs.getString("goodsname"));
				   g.setPrice(rs.getFloat("price"));
				   g.setDiscount(rs.getFloat("discount"));
				   g.setPic(rs.getString("pic"));
				   g.setOutdate(rs.getString("outdate"));
				   g.setIntroduction(rs.getString("introduction"));
				   g.setNum(rs.getInt("num"));
				   list.add(g);
			   }
			   return list;
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return null;
		   
	   }
	 
	 
	 public List<Goods> findAllSearchGoods(int currentePage, String keyword)throws SQLException{
		   try{
			   ResultSet rs=pl.pageSearchList(8, "goods", currentePage, keyword, "desc", "id");
			   rs.beforeFirst();
			   List<Goods> list=new ArrayList<Goods>();
			   while(rs.next()){
				   Goods g = new Goods();
				   g.setId(rs.getInt("id"));
				   g.setGoodsname(rs.getString("goodsname"));
				   g.setPrice(rs.getFloat("price"));
				   g.setDiscount(rs.getFloat("discount"));
				   g.setPic(rs.getString("pic"));
				   g.setOutdate(rs.getString("outdate"));
				   g.setIntroduction(rs.getString("introduction"));
				   g.setNum(rs.getInt("num"));
				   list.add(g);
				   
			   }
			   return list;
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return null;
		   
	   }
	 
	 
	 
	public Integer pageSize(){
		   int maxRow=pl.pageSize("goods");
		   int pages=maxRow/8;
		   if(maxRow%8>0){
			   pages=pages+1;
			   return pages;
		   }
		   return pages;
	   }
	
	
	public Integer pageSearchSize(String keyword){
		int maxRow=pl.pageSearchSize(keyword);
		   int pages=maxRow/8;
		   if(maxRow%8>0){
			   pages=pages+1;
			   return pages;
		   }
		   return pages;
	   }
	
	
	
	public Goods findById(int goodsId){
		try{
			   String sql="select * from goods where id=?";
			   //ConnectionDB a;//����һ��ConnectionDB�࣬���ڽ�����ݿ�����
			   JDBConnection conn=new JDBConnection();
			   
			   //��̬�ķ��������������ֱ�ӵ�
			   Connection con=conn.creatConnection();
			   PreparedStatement psmt=con.prepareStatement(sql);
			   psmt.setInt(1, goodsId);
			  
			   ResultSet rs=psmt.executeQuery();
			   if(rs.next()){
				   Goods g=new Goods();
				   g.setId(rs.getInt("id"));
				   g.setGoodsname(rs.getString("goodsname"));
				   g.setDiscount(rs.getFloat("discount"));
				   g.setIntroduction(rs.getString("introduction"));
				   g.setOutdate(rs.getString("outdate"));
				   g.setPic(rs.getString("pic"));
				   g.setPrice(rs.getFloat("price"));
				   g.setNum(rs.getInt("num"));
				   //con.commit();
				   rs.close();
				   return g;
			   }else {
				   return null;
			   }
			   
		   }catch(Exception e){
			   e.printStackTrace();
			   return null;
		   }
		   
	   }
	public void changeNum(Goods goods, Shoppingcard sc){
		try {
			String sql="update goods set num=? where id=?";
			int num = goods.getNum() + sc.getNumber();
			JDBConnection conn=new JDBConnection();
			   
			   Connection con=conn.creatConnection();
			PreparedStatement psmt=con.prepareStatement(sql);
			   psmt.setInt(1, num);
			   psmt.setInt(2, goods.getId());
			   psmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}//��̬�ķ��������������ֱ�ӵ���
		   
	}
	public boolean adminDeleteGoods(int id){
		try {
		     String sql = "delete from goods where id = ?";
		     JDBConnection conn = new JDBConnection();
		     Connection con = conn.creatConnection();
		     PreparedStatement psmt = con.prepareStatement(sql);
		     psmt.setInt(1, id);
		     int b = psmt.executeUpdate();
		     if(b != 0){
		    	 return true;
		     }else{
		    	 return false;
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void adminAddGoods(Goods g){
		try{
			String sql = "insert into goods(goodsname, price, discount, introduction) values(?, ?, ?, ?) ";
			JDBConnection conn = new JDBConnection();
			Connection con = conn.creatConnection();
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, g.getGoodsname());
			psmt.setFloat(2, g.getPrice());
			psmt.setFloat(3, g.getDiscount());
			psmt.setString(4, g.getIntroduction());
			psmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public boolean goodsModify(Goods g){
		try{
			/*String sql = "update goods set goodsname = " + g.getGoodsname() + ", price = " + g.getPrice() + 
			", discount = " + g.getDiscount() + ",introduction = '" + g.getIntroduction() + "' where id = " + g.getId();
			System.out.println(sql);*/
			String sql = "update goods set goodsname = ?, price = ?, discount = ?, introduction = ? where id = ?";
			JDBConnection conn = new JDBConnection();
			Connection con = conn.creatConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g.getGoodsname());
			pstmt.setFloat(2, g.getPrice());
			pstmt.setFloat(3, g.getDiscount());
			pstmt.setString(4, g.getIntroduction());
			pstmt.setInt(5, g.getId());
			int i = pstmt.executeUpdate();
			if(i != 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean updatePic(String dataName, int id){
		String sql = "update goods set pic = ? where id = ?";
		JDBConnection conn = new JDBConnection();
		Connection con = conn.creatConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dataName);
			pstmt.setInt(2, id);
			int i = pstmt.executeUpdate();
			if(i != 0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}
	public List<Goods> simpleSearch(String keyword){
		try {
			List<Goods>  list = new ArrayList<Goods>();
			JDBConnection conn = new JDBConnection();
			Connection con = conn.creatConnection();
			String sql = "select * from goods where goodsname like ? or introduction like ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"%" + keyword + "%" );
			pstmt.setString(2, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			rs.beforeFirst();
			while(rs.next()){
				Goods g = new Goods();
				g.setId(rs.getInt("id"));
				g.setGoodsname(rs.getString("goodsname"));
				g.setPrice(rs.getFloat("price"));
				g.setDiscount(rs.getFloat("discount"));
				g.setPic(rs.getString("pic"));
				g.setOutdate(rs.getString("outdate"));
				g.setIntroduction(rs.getString("introduction"));
				g.setNum(rs.getInt("num"));
				list.add(g);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public List<Goods> complexSearch(String keyword, float lowPrice, float highPrice, float lowDiscount, float highDiscount){
		try {
			List<Goods>  list = new ArrayList<Goods>();
			JDBConnection conn = new JDBConnection();
			Connection con = conn.creatConnection();
			String sql = "select * from goods where goodsname like ? and price between ? and ? and discount between ? and ?" ;
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"%" + keyword + "%" );
			pstmt.setFloat(2, lowPrice);
			pstmt.setFloat(3, highPrice);
			pstmt.setFloat(4, lowDiscount);
			pstmt.setFloat(5, highDiscount);
			
			ResultSet rs = pstmt.executeQuery();
			rs.beforeFirst();
			while(rs.next()){
				Goods g = new Goods();
				g.setId(rs.getInt("id"));
				g.setGoodsname(rs.getString("goodsname"));
				g.setPrice(rs.getFloat("price"));
				g.setDiscount(rs.getFloat("discount"));
				g.setPic(rs.getString("pic"));
				g.setOutdate(rs.getString("outdate"));
				g.setIntroduction(rs.getString("introduction"));
				g.setNum(rs.getInt("num"));
				list.add(g);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Goods> findAllGoods(){
		try{
			List<Goods> list = new ArrayList<Goods>();
			String sql = "select * from goods";
			JDBConnection conn = new JDBConnection();
			Connection con = conn.creatConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.beforeFirst();
			while(rs.next()){
				Goods g = new Goods();
				g.setId(rs.getInt("id"));
				g.setGoodsname(rs.getString("goodsname"));
				g.setPrice(rs.getFloat("price"));
				g.setDiscount(rs.getFloat("discount"));
				g.setPic(rs.getString("pic"));
				g.setOutdate(rs.getString("outdate"));
				g.setIntroduction(rs.getString("introduction"));
				g.setNum(rs.getInt("num"));
				list.add(g);
				}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}
