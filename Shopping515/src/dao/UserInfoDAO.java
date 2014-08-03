package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;

import domain.Goods;
import domain.Userinfo;
import util.*;
import domain.*
;//import webtier.Connection;
//import webtier.PreparedStatement;
//import webtier.ResultSet;

public class UserInfoDAO {
	private PageList pl = new PageList();
	
	
   public Userinfo login(Userinfo user) throws SQLException{
	   try{
		   String sql="select * from userinfo where username=? and password=?";
		   //ConnectionDB a;//����һ��ConnectionDB�࣬���ڽ�����ݿ�����
		   JDBConnection conn=new JDBConnection();
		   
		   //��̬�ķ��������������ֱ�ӵ�
		   Connection con=conn.creatConnection();
		   PreparedStatement psmt=con.prepareStatement(sql);
		   psmt.setString(1, user.getUsername());
		   psmt.setString(2, user.getPassword());
		   ResultSet rs=psmt.executeQuery();
		   if(rs.next()){
			   Userinfo u=new Userinfo();
			   u.setId(rs.getInt("id"));
			   u.setUsername(rs.getString("username"));
			   u.setPassword(rs.getString("password"));
			   u.setSex(rs.getInt("sex"));
			   u.setTel(rs.getString("tel"));
			   u.setEmail(rs.getString("email"));
			   u.setRealname(rs.getString("realname"));
			  u.setTimes(rs.getInt("times")+1);
			   addLoginTimes(u);
			   //con.commit();
			   rs.close();
			   return u;
		   }else {
			   return null;
		   }
		   
	   }catch(Exception e){
		   e.printStackTrace();
		   return null;
	   }
	   
   }
  public void addLoginTimes(Userinfo user) throws SQLException{
			 
		try {
			String sql="update userinfo set times=? where id=?";
			
			JDBConnection conn=new JDBConnection();
			   
			   //��̬�ķ��������������ֱ�ӵ�
			   Connection con=conn.creatConnection();
			PreparedStatement psmt=con.prepareStatement(sql);
			   psmt.setInt(1, user.getTimes());
			   psmt.setInt(2, user.getId());
			   psmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}//��̬�ķ��������������ֱ�ӵ���
		   
	}
   public boolean sameName(Userinfo user)throws SQLException{
	   try{

		   String sql="select * from userinfo where username=?";
				   //ConnectionDB a;//����һ��ConnectionDB�࣬���ڽ�����ݿ�����
				   
				   //��̬�ķ��������������ֱ�ӵ�
		   JDBConnection conn=new JDBConnection();
		   Connection con=conn.creatConnection();
		   PreparedStatement psmt=con.prepareStatement(sql);
		   psmt.setString(1,user.getUsername());
		   ResultSet rs=psmt.executeQuery();
		   if(rs.next()){
			 return true;
		     
		   }else{
		   return false;
		   }
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return false;
   }
   public Integer pageSize(){
	   int maxRow = pl.pageSize("userinfo");
	   int pages = maxRow / 8;
	   if(maxRow % 8 > 0){
		   pages += 1;
		   
		   return pages;
	   }
	   return pages;
   }
   
   public boolean deleteUser(int userId){
	   try{
		   String sql = "delete from userinfo where id=?";
		   System.out.println(sql);
		   JDBConnection con = new JDBConnection();
		   Connection conn = con.creatConnection();
		   PreparedStatement pstmt = conn.prepareStatement(sql);
		   pstmt.setInt(1, userId);
		   int b = pstmt.executeUpdate();
		   if(b != 0){
		   return true;
		   }else{
			   return false;
		   }
		   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return false;
	
}
   
   
   public List<Userinfo> findAllUsers(int currentePage){
	   try{
	   ResultSet rs=pl.pageList(8, "userinfo", currentePage, "asc", "id");
	 
		rs.beforeFirst();
	
	   List<Userinfo> list = new ArrayList<Userinfo>();
	   while(rs.next()){
		   Userinfo user = new Userinfo();
		   user.setEmail(rs.getString("email"));
		   user.setId(rs.getInt("id"));
		   user.setPassword(rs.getString("password"));
		   user.setRealname(rs.getString("realname"));
		   user.setSex(rs.getInt("sex"));
		   user.setTel(rs.getString("tel"));
		   user.setTimes(rs.getInt("times"));
		   user.setUsername(rs.getString("username"));
		   list.add(user);
	   }
	   return list;
	   }catch(Exception e){
		   e.printStackTrace();
   }
	   return null;
   }
   
   public List<Userinfo> findByUserName(String keyword){
	   try{
	   
	   String sql = "select * from userinfo where username like ?";
	   JDBConnection con = new JDBConnection();
	   Connection conn = con.creatConnection();
	   PreparedStatement pstmt = conn.prepareStatement(sql);
	   pstmt.setString(1,"%" + keyword + "%");
	   ResultSet rs = pstmt.executeQuery();
	   List<Userinfo> list = new ArrayList<Userinfo>();
	   while(rs.next()){
		   Userinfo user = new Userinfo();
		   user.setEmail(rs.getString("email"));
		   user.setId(rs.getInt("id"));
		   user.setPassword(rs.getString("password"));
		   user.setRealname(rs.getString("realname"));
		   user.setSex(rs.getInt("sex"));
		   user.setTel(rs.getString("tel"));
		   user.setTimes(rs.getInt("times"));
		   user.setUsername(rs.getString("username"));
		   list.add(user);
	   }
	   
	 
	 return list;  
   }catch(SQLException e){
	   e.printStackTrace();
   }
   return null;
   }
   public void addUser(Userinfo user)throws SQLException{
	   try{
		   JDBConnection conn=new JDBConnection();//��ǰզJDBConnection��һ��������һ���������
		 
		   conn.preparedExecuteStatement(user.getUsername(),user.getSex(),user.getPassword(),user.getEmail(),user.getTel(),user.getRealname());
		   

	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   
   }
   
   public List<Userinfo> findAllUser(){
	   try{
	   List<Userinfo> list = new ArrayList<Userinfo>();
	   String sql = "select * from userinfo";
	   JDBConnection conn = new JDBConnection();
	   Connection con = conn.creatConnection();
	   PreparedStatement pstmt = con.prepareStatement(sql);
	   ResultSet rs = pstmt.executeQuery();
	   while(rs.next()){
		   Userinfo user = new Userinfo();
		   user.setEmail(rs.getString("email"));
		   user.setId(rs.getInt("id"));
		   user.setPassword(rs.getString("password"));
		   user.setRealname(rs.getString("realname"));
		   user.setSex(rs.getInt("sex"));
		   user.setTel(rs.getString("tel"));
		   user.setTimes(rs.getInt("times"));
		   user.setUsername(rs.getString("username"));
		   list.add(user);
		   
	   }
	   return list;
	   }catch(SQLException e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
}
