package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.ContractsIfo;
import bean.MyPage;
import bean.StockInIfo;
import bean.StockOutIfo;

public class StockInDao {
	//查询所有入库信息 
	public static List<StockInIfo> getAll(){
		Connection conn=DBConnection.getConnection();
		String sql="select *from viewofstockin";
		List<StockInIfo> list=new ArrayList<StockInIfo>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StockInIfo s=new StockInIfo();
				s.setInno(rs.getString("入库号"));
				s.setCno(rs.getString("合同号"));
				s.setGno(rs.getString("货物号"));
				s.setGname(rs.getString("货物名称"));
				s.setPrice(rs.getFloat("货物单价"));
				s.setInnum(rs.getInt("入库数量"));
				s.setIntime(rs.getTimestamp("入库时间"));
				s.setUserno(rs.getString("入库人编号"));
				s.setUsername(rs.getString("入库人姓名"));
				s.setUsertype(rs.getString("入库人类型"));
				s.setSno(rs.getString("供应商编号"));
				s.setSname(rs.getString("供应商名称"));
				s.setSadress(rs.getString("供应商地址"));
				s.setLinkman(rs.getString("联系人"));
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
	//查询所有入库信息 测试
	public static void getAll2(){
		Connection conn=DBConnection.getConnection();
		String sql="select *from viewofstockin";
		List<StockInIfo> list=new ArrayList<StockInIfo>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StockInIfo s=new StockInIfo();
				System.out.println(rs.getString("入库号"));
				System.out.println(rs.getString("合同号"));
				System.out.println(rs.getString("货物号"));
				System.out.println(rs.getString("货物名称"));
				System.out.println(rs.getFloat("货物单价"));
				System.out.println(rs.getInt("入库数量"));
				System.out.println(rs.getTimestamp("入库时间"));
				System.out.println(rs.getString("入库人编号"));
				System.out.println(rs.getString("入库人姓名"));
				System.out.println(rs.getString("入库人类型"));
				System.out.println(rs.getString("供应商编号"));
				System.out.println(rs.getString("供应商名称"));
				System.out.println(rs.getString("供应商地址"));
				System.out.println(rs.getString("联系人"));
				
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
//获取所有详细入库记录,返回分页类
	public static MyPage getAllWithPage(int pageNo,int pageSize){
		Connection conn1=DBConnection.getConnection();
		Connection conn2=DBConnection.getConnection();
		String sql1="select *from viewofstockin";
		String sql2="select *from viewofstockin limit ? ,?";
		List<StockInIfo> list=new ArrayList<StockInIfo>();
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
			System.out.println("!!!!");
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next()){
				StockInIfo s=new StockInIfo();
				s.setInno(rs2.getString("入库号"));
				s.setCno(rs2.getString("合同号"));
				s.setGno(rs2.getString("货物号"));
				s.setGname(rs2.getString("货物名称"));
				s.setPrice(rs2.getFloat("货物单价"));
				s.setInnum(rs2.getInt("入库数量"));
				s.setIntime(rs2.getTimestamp("入库时间"));
				s.setUserno(rs2.getString("入库人编号"));
				s.setUsername(rs2.getString("入库人姓名"));
				s.setUsertype(rs2.getString("入库人类型"));
				s.setSno(rs2.getString("供应商编号"));
				s.setSname(rs2.getString("供应商名称"));
				s.setSadress(rs2.getString("供应商地址"));
				s.setLinkman(rs2.getString("联系人"));
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
	//获取所有详细入库记录,返回分页类测试
	public static void getAllWithPage2(int pageNo,int pageSize){
		Connection conn=DBConnection.getConnection();
		String sql="select *from viewofstockin limit ?,? ";
		List<StockInIfo> list=new ArrayList<StockInIfo>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StockInIfo s=new StockInIfo();
				System.out.println(rs.getString("入库号"));
				System.out.println(rs.getString("合同号"));
				System.out.println(rs.getString("货物号"));
				System.out.println(rs.getString("货物名称"));
				System.out.println(rs.getFloat("货物单价"));
				System.out.println(rs.getInt("入库数量"));
				System.out.println(rs.getTimestamp("入库时间"));
				System.out.println(rs.getString("入库人编号"));
				System.out.println(rs.getString("入库人姓名"));
				System.out.println(rs.getString("入库人类型"));
				System.out.println(rs.getString("供应商编号"));
				System.out.println(rs.getString("供应商名称"));
				System.out.println(rs.getString("供应商地址"));
				System.out.println(rs.getString("联系人"));
				
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
	}
	//根据货物名称和时间段查询入库信息 
		public static List<StockInIfo> getStockInByDateOrGood(String Gname,String stime,String etime){
			Connection conn=DBConnection.getConnection();
			String sql="call proc_stock_in1(?,?,?)";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			Date st=new Date();
			Date et=new Date();
			try {
				st=sdf.parse(stime);
				et=sdf2.parse(etime);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			Timestamp ti1=new Timestamp(st.getTime());
			Timestamp ti2=new Timestamp(et.getTime());
			List<StockInIfo> list=new ArrayList<StockInIfo>();
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, Gname);
				ps.setTimestamp(2, ti1);
				ps.setTimestamp(3, ti2);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					StockInIfo s=new StockInIfo();
					s.setInno(rs.getString("入库号"));
					s.setCno(rs.getString("合同号"));
					s.setGno(rs.getString("货物号"));
					s.setGname(rs.getString("货物名称"));
					s.setPrice(rs.getFloat("货物单价"));
					s.setInnum(rs.getInt("入库数量"));
					s.setIntime(rs.getTimestamp("入库时间"));
					s.setUserno(rs.getString("入库人编号"));
					s.setUsername(rs.getString("入库人姓名"));
					s.setUsertype(rs.getString("入库人类型"));
					s.setSno(rs.getString("供应商编号"));
					s.setSname(rs.getString("供应商名称"));
					s.setSadress(rs.getString("供应商地址"));
					s.setLinkman(rs.getString("联系人"));
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
		//根据入库人姓名和时间段查询入库信息 
		public static List<StockInIfo> getStockInByDateOrUser(String username,String stime,String etime){
			Connection conn=DBConnection.getConnection();
			String sql="call proc_stock_in2(?,?,?)";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			Date st=new Date();
			Date et=new Date();
			try {
				st=sdf.parse(stime);
				et=sdf2.parse(etime);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			Timestamp ti1=new Timestamp(st.getTime());
			Timestamp ti2=new Timestamp(et.getTime());
			List<StockInIfo> list=new ArrayList<StockInIfo>();
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setTimestamp(2, ti1);
				ps.setTimestamp(3, ti2);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					StockInIfo s=new StockInIfo();
					s.setInno(rs.getString("入库号"));
					s.setCno(rs.getString("合同号"));
					s.setGno(rs.getString("货物号"));
					s.setGname(rs.getString("货物名称"));
					s.setPrice(rs.getFloat("货物单价"));
					s.setInnum(rs.getInt("入库数量"));
					s.setIntime(rs.getTimestamp("入库时间"));
					s.setUserno(rs.getString("入库人编号"));
					s.setUsername(rs.getString("入库人姓名"));
					s.setUsertype(rs.getString("入库人类型"));
					s.setSno(rs.getString("供应商编号"));
					s.setSname(rs.getString("供应商名称"));
					s.setSadress(rs.getString("供应商地址"));
					s.setLinkman(rs.getString("联系人"));
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
		//getAll2();
		getAllWithPage2(1,5);
	}

}
