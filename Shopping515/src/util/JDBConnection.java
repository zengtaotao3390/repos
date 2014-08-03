package util;
import java.sql.*;
public class JDBConnection {
	private final String dbDrive = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/shopping515";
	private final String userName = "root";
	private final String password = "";
	private Connection con = null;
	public JDBConnection(){
	
			try {
				Class.forName(dbDrive);
			}  catch (ClassNotFoundException e) {
			System.out.println("数据库加载失败");
		}
	}
	public Connection creatConnection(){
		try {
			con = DriverManager.getConnection(url,userName,password);
			con.setAutoCommit(true);
			return con;
		} catch (SQLException e) {
		return null;
		}
	}
	public boolean executeUpdate(String sql){
		if(con == null){
			creatConnection();
		}
		try{
		Statement stmt = con.createStatement();
		int iCount = stmt.executeUpdate(sql);
		System.out.println("操作成功，所影响的记录数为" + String.valueOf(iCount));
		return true;
		}catch(SQLException e){
			return false;
		}
	}	
	public boolean preparedExecuteStatement(String username, int sex, String password, String email, String tel, String realname)
	{
		try{
			if(con == null)
			{
				creatConnection();
			}
			String sql = "insert into userinfo(username, sex, password, email, tel, realname) values(?, ?, ?, ?, ?, ?)";
		    PreparedStatement pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, username);
		    pstmt.setInt(2, sex);
		    pstmt.setString(3, password);
		    pstmt.setString(4, email);
		    pstmt.setString(5, tel);
		    pstmt.setString(6, realname);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	
	public ResultSet executeQuery(String sql){
		ResultSet rs;
		try{
			if(con == null)
			creatConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;
			}catch (Exception e){
				return null;
			}
			
		}
	public void closeConnection(){
		if(con == null){
			try{
				con.close();
			}catch(SQLException e){
				
			}
		}
	}
	
		
}
