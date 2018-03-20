package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MyPage;
import bean.StockIfo;

public class StockDao {
	//获取所有详细库存记录
	public static List<StockIfo> getAll(){
		Connection conn=DBConnection.getConnection();
		String sql="select*from viewofstock";
		List<StockIfo> list=new ArrayList<StockIfo>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StockIfo s=new StockIfo();
				s.setGno(rs.getString("货物编号"));
				s.setGname(rs.getString("货物名称"));
				s.setTno(rs.getString("类型编号"));
				s.setTname(rs.getString("类型名称"));
				s.setGother(rs.getString("配置信息"));
				s.setStocknum(rs.getInt("库存数量"));
				list.add(s);
			
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	//获取所有详细库存记录,返回分页类
		public static MyPage getAllWithPage(int pageNo,int pageSize){
			Connection conn1=DBConnection.getConnection();
			Connection conn2=DBConnection.getConnection();
			String sql1="select *from viewofstock";
			String sql2="select *from viewofstock limit ?,?";
			List<StockIfo> list=new ArrayList<StockIfo>();
			int count=0;
			try {
				PreparedStatement ps1=conn1.prepareStatement(sql1);
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
					rs1.last();
					count=rs1.getRow();
					System.out.println(count);
				}
				rs1.close();
				ps1.close();
				conn1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			try {
				PreparedStatement ps2=conn2.prepareStatement(sql2);
				ps2.setInt(1, (pageNo-1)*pageSize);
				ps2.setInt(2, pageSize);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
					StockIfo s=new StockIfo();
					s.setGno(rs2.getString("货物编号"));
					s.setGname(rs2.getString("货物名称"));
					s.setTno(rs2.getString("类型编号"));
					s.setTname(rs2.getString("类型名称"));
					s.setGother(rs2.getString("配置信息"));
					s.setStocknum(rs2.getInt("库存数量"));
					list.add(s);
				
				}
				rs2.close();
				ps2.close();
				conn2.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			MyPage page=null;
			page=new MyPage(pageNo,pageSize,count,list);
			return page;
		}
		//获取所有详细库存记录,返回分页类测试
		public static void getAllWithPage2(int pageNo,int pageSize){
			Connection conn1=DBConnection.getConnection();
			Connection conn2=DBConnection.getConnection();
			String sql1="select *from viewofstock";
			String sql2="select *from viewofstock limit ?,?";
			List<StockIfo> list=new ArrayList<StockIfo>();
			int count=0;
			try {
				PreparedStatement ps1=conn1.prepareStatement(sql1);
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
					rs1.last();
					count=rs1.getRow();
					System.out.println(count);
				
				}
				rs1.close();
				ps1.close();
				conn1.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			try {
				PreparedStatement ps2=conn2.prepareStatement(sql2);
				ps2.setInt(1, pageNo);
				ps2.setInt(2, pageSize);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
					System.out.println(rs2.getString("货物编号"));
					System.out.println(rs2.getString("货物名称"));
					System.out.println(rs2.getString("类型编号"));
					System.out.println(rs2.getString("类型名称"));
					System.out.println(rs2.getString("配置信息"));
					System.out.println(rs2.getInt("库存数量"));
				
				}
				rs2.close();
				ps2.close();
				conn2.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}


			
		}
	//通过货物名称和货物类别名称获取所有详细库存记录
	public static List<StockIfo> getAllByGood(String Gname,String Tname){
		Connection conn=DBConnection.getConnection();
		String sql="call proc_stock1(?,?)";
		List<StockIfo> list=new ArrayList<StockIfo>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Gname);
			ps.setString(2, Tname);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StockIfo s=new StockIfo();
				s.setGno(rs.getString("货物编号"));
				s.setGname(rs.getString("货物名称"));
				s.setTno(rs.getString("类型编号"));
				s.setTname(rs.getString("类型名称"));
				s.setGother(rs.getString("配置信息"));
				s.setStocknum(rs.getInt("库存数量"));
				list.add(s);
			
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	//通过货物名称和货物类别名称获取所有详细库存记录 测试
		public static List<StockIfo> getAllByGood2(String Gname,String Tname){
			Connection conn=DBConnection.getConnection();
			String sql="call proc_stock1(?,?)";
			List<StockIfo> list=new ArrayList<StockIfo>();
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, Gname);
				ps.setString(2, Tname);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					StockIfo s=new StockIfo();
					System.out.println(rs.getString("货物编号"));
					System.out.println(rs.getString("货物名称"));
					System.out.println(rs.getString("类型编号"));
					System.out.println(rs.getString("类型名称"));
					System.out.println(rs.getString("配置信息"));
					System.out.println(rs.getInt("库存数量"));
					list.add(s);
				
				}
				rs.close();
				ps.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			return list;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getAllByGood2("货物1","类型1");
		getAllWithPage2(1,10);
	}

}
