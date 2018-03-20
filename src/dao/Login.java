package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	public int loginVerify(String userno,String password){
		Connection conn=DBConnection.getConnection();
		String sql="select usertype from user where userno=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userno);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String t=rs.getString("usertype");
				rs.close();
				ps.close();
				conn.close();
				if(t.equals("管理员")) return 1;
				else if(t.equals("采购员")) return 2;
				else if(t.equals("客户"))		return 3;
				else return 0;
			}else{
				rs.close();
				ps.close();
				conn.close();
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public static void main(String args[]){
		String userno="201511104002";
		String p="123";
		Login l1=new Login();
		System.out.println(l1.loginVerify(userno, p));
	}
}

