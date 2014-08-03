package util;
import java.sql.*;

import javax.swing.JOptionPane;

public class PageList {
   public ResultSet pageList(int pagesize,String tablename,int currentePage,String sort,String sortBy)
   throws ClassNotFoundException{
	   try{
		   JDBConnection con=new JDBConnection();
		   Connection conn=con.creatConnection();
		   
		   Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	       String sql="select * from "+tablename;
	       ResultSet rs=smt.executeQuery(sql);
	       if(currentePage==1){
	    	   String getRs="select * from "+tablename+" order by "+sortBy + " " + sort +" limit 0,"+pagesize;
	    	   
	    	   ResultSet pageRs=smt.executeQuery(getRs);
	    	   return pageRs;
	    	   
	       }else{
	    	   //rs.absolute(pagesize*(currentePage-1));//区别sql和mysql的语法
	    	   //int lastid=rs.getRow();
	    	   
	    	   int lastid=(currentePage-1)*8;
	    	   
	    	   String getRs="select * from "+tablename+" order by "+sortBy+" " + sort + " limit "+lastid+","+pagesize;
	           ResultSet pageRs=smt.executeQuery(getRs);
	           return pageRs;
	       }
	   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
   public ResultSet pageSearchList(int pagesize,String tablename,int currentePage,String keyword,String sort,String sortBy)
   throws ClassNotFoundException{
	   try{
		   JDBConnection con=new JDBConnection();
		   Connection conn=con.creatConnection();
		   
		   Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	       String sql="select * from "+tablename;
	       ResultSet rs=smt.executeQuery(sql);
	       if(currentePage==1){
	    	   String getRs1 = "select * from "+tablename+" where goodsname like '%" + keyword + "%' or introduction like '%" + keyword + "%' order by "+sortBy+" limit 0,"+pagesize;
	    	   //String getRs="select * from "+tablename+" order by "+sortBy+" limit 0,"+pagesize;
	    	   
	    	   ResultSet pageRs=smt.executeQuery(getRs1);
	    	   return pageRs;
	    	   
	       }else{
	    	   //rs.absolute(pagesize*(currentePage-1));//区别sql和mysql的语法
	    	   //int lastid=rs.getRow();
	    	   
	    	   int lastid=(currentePage-1)*8;
	    	   String getRs2 = "select * from "+tablename+" where goodsname like '%" + keyword + "%' or introduction like '%" + keyword + "%' order by "+sortBy+" limit "+lastid+","+pagesize;
	    	  // String getRs="select * from "+tablename+" order by "+sortBy+" limit "+lastid+","+pagesize;
	           ResultSet pageRs=smt.executeQuery(getRs2);
	           return pageRs;
	       }
	   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
   
   public ResultSet pageListAccount(int pagesize,String tablename,int currentePage,int userId)
   throws Exception{
	   try{
		   JDBConnection con=new JDBConnection();
		   Connection conn=con.creatConnection();
		   Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	       String sql="select * from "+tablename+" where userid="+userId;
	       ResultSet rs=smt.executeQuery(sql);
	       if(currentePage==1){
	    	   String getRs="select * from "+tablename+ " where userid="+userId+" limit 0,"+pagesize;
	    	   ResultSet pageRs=smt.executeQuery(getRs);
	    	   return pageRs;
	       }else{
	    	   //rs.absolute(pagesize*(currentePage-1));
	    	   //int lastid=rs.getRow();
	    	   int lastid=(currentePage-1)*8;
	    	   String getRs="select * from "+tablename+ " where userid="+userId+" limit "+lastid+","+pagesize;
	           ResultSet pageRs=smt.executeQuery(getRs);
	           return pageRs;
	       }
	   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
   public ResultSet pageListScart(int pagesize,String tablename,int currentePage,int userId)
   throws ClassNotFoundException{
	   try{
		   JDBConnection con=new JDBConnection();
		   Connection conn=con.creatConnection();
		   
		   Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	       String sql="select * from "+tablename+" where userId="+userId;
	       ResultSet rs=smt.executeQuery(sql);
	       if(currentePage==1){
	    	   String getRs="select * from "+tablename+ " where userId="+userId+" limit 0,"+pagesize;
	    	   ResultSet pageRs=smt.executeQuery(getRs);
	    	   return pageRs;
	       }else{
	    	   //rs.absolute(pagesize*(currentePage-1));
	    	   //int lastid=rs.getRow();
	    	   int lastid=(currentePage-1)*8;
	    	   String getRs="select * from "+tablename+ " where userId="+userId+" limit "+lastid+","+pagesize;
	           ResultSet pageRs=smt.executeQuery(getRs);
	           return pageRs;
	       }
	   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
   
   public Integer pageSize(String tablename){
	   try{
		   
		   JDBConnection con=new JDBConnection();
		   Connection conn=con.creatConnection();
		   Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		   String sql="select * from "+tablename;
		  
		   ResultSet rs=smt.executeQuery(sql);
		   rs.last();
		   int rssize=rs.getRow();
		   
		   return rssize;
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
   public Integer pageSearchSize(String keyword){
	   try{
		   JDBConnection con=new JDBConnection();
		   Connection conn=con.creatConnection();
		   Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		   String sql="select count(*) from goods where goodsname like '%" + keyword + "%' or introduction like '%" + keyword + "%'";
		   ResultSet rs=smt.executeQuery(sql);
		   rs.last();
		   int rssize=rs.getRow();
		   
		   return rssize;
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
   
   
   public Integer pageSizeScart(String tablename,int userId){
	   try{
		   JDBConnection con=new JDBConnection();
		   Connection conn=con.creatConnection();
		   Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		   String sql="select * from "+tablename+" where userId="+userId;
		   ResultSet rs=smt.executeQuery(sql);
		   rs.last();
		   int rssize=rs.getRow();
		   return rssize;
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
   public Integer pageSizeAccount(String tablename,int userId){
	   try{
		   JDBConnection con=new JDBConnection();
		   Connection conn=con.creatConnection();
		   Statement smt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		   String sql="select * from "+tablename+" where userid="+userId;
		   ResultSet rs=smt.executeQuery(sql);
		   rs.last();
		   int rssize=rs.getRow();
		   
		   return rssize;
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
   
   
}
