package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import bean.ContractsIfo;
import bean.MyPage;
import bean.StockIfo;

public class ContractsDao {
	//获取所有合同信息
	public static List<ContractsIfo> getAll(){
		Connection conn=DBConnection.getConnection();
		String sql="select*from viewofcontracts";
		List<ContractsIfo> list=new ArrayList<ContractsIfo>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ContractsIfo c=new ContractsIfo();
				c.setCno(rs.getString("合同编号"));
				c.setCname(rs.getString("合同名称"));
				c.setSno(rs.getString("供应商编号"));
				c.setGno(rs.getString("货物号"));
				c.setGname(rs.getString("货物名称"));
				c.setGother(rs.getString("货物配置"));
				c.setNum(rs.getInt("数量"));
				c.setPrice(rs.getFloat("单价"));
				c.setCdate(rs.getDate("进货日期"));
				c.setUserno(rs.getString("进货人员编号"));
				c.setUsername(rs.getString("进货人姓名"));
				c.setUsertype(rs.getString("进货人类型"));
				c.setSname(rs.getString("供应商名称"));
				c.setSadress(rs.getString("供应商地址"));
				c.setLinkman(rs.getString("联系人"));
				list.add(c);
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
	//获取所有合同信息测试
		public static List<ContractsIfo> getAll2(){
			Connection conn=DBConnection.getConnection();
			String sql="select*from viewofcontracts";
			List<ContractsIfo> list=new ArrayList<ContractsIfo>();
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					ContractsIfo c=new ContractsIfo();
					System.out.println(rs.getString("合同编号"));
					System.out.println(rs.getString("合同名称"));
					System.out.println(rs.getString("供应商编号"));
					System.out.println(rs.getString("货物号"));
					System.out.println(rs.getString("货物名称"));
					System.out.println(rs.getString("货物配置"));
					System.out.println(rs.getInt("数量"));
					System.out.println(rs.getFloat("单价"));
					System.out.println(rs.getDate("进货日期"));
					System.out.println(rs.getString("进货人员编号"));
					System.out.println(rs.getString("进货人姓名"));
					System.out.println(rs.getString("进货人类型"));
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
			
			return list;
			
		}
		//获取所有详细合同记录,返回分页类
		public static MyPage getAllWithPage(int pageNo,int pageSize){
			Connection conn1=DBConnection.getConnection();
			Connection conn2=DBConnection.getConnection();
			String sql1="select *from viewofcontracts";
			String sql2="select *from viewofcontracts limit ?,?";
			List<ContractsIfo> list=new ArrayList<ContractsIfo>();
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
					ContractsIfo c=new ContractsIfo();
					c.setCno(rs2.getString("合同编号"));
					c.setCname(rs2.getString("合同名称"));
					c.setSno(rs2.getString("供应商编号"));
					c.setGno(rs2.getString("货物号"));
					c.setGname(rs2.getString("货物名称"));
					c.setGother(rs2.getString("货物配置"));
					c.setNum(rs2.getInt("数量"));
					c.setPrice(rs2.getFloat("单价"));
					c.setCdate(rs2.getDate("进货日期"));
					c.setUserno(rs2.getString("进货人员编号"));
					c.setUsername(rs2.getString("进货人姓名"));
					c.setUsertype(rs2.getString("进货人类型"));
					c.setSname(rs2.getString("供应商名称"));
					c.setSadress(rs2.getString("供应商地址"));
					c.setLinkman(rs2.getString("联系人"));
					list.add(c);
				
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
		//获取所有详细合同记录,返回分页类测试
				public static void getAllWithPage2(int pageNo,int pageSize){
					Connection conn1=DBConnection.getConnection();
					Connection conn2=DBConnection.getConnection();
					String sql1="select *from viewofcontracts";
					String sql2="select *from viewofcontracts limit ?,?";
					List<ContractsIfo> list=new ArrayList<ContractsIfo>();
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
							ContractsIfo c=new ContractsIfo();
							System.out.println(rs2.getString("合同编号"));
							System.out.println(rs2.getString("合同名称"));
							System.out.println(rs2.getString("供应商编号"));
							System.out.println(rs2.getString("货物号"));
							System.out.println(rs2.getString("货物名称"));
							System.out.println(rs2.getString("货物配置"));
							System.out.println(rs2.getInt("数量"));
							System.out.println(rs2.getFloat("单价"));
							System.out.println(rs2.getDate("进货日期"));
							System.out.println(rs2.getString("进货人员编号"));
							System.out.println(rs2.getString("进货人姓名"));
							System.out.println(rs2.getString("进货人类型"));
							System.out.println(rs2.getString("供应商名称"));
							System.out.println("供应商地址");
						
						
						}
						rs2.close();
						ps2.close();
						conn2.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					
					
				}
		//根据时间段获取合同信息记录
		public static List<ContractsIfo> getAllByDate(String  start,String end){
			Connection conn=DBConnection.getConnection();
			String sql="call proc_contracts1(?,?)";
			List<ContractsIfo> list=new ArrayList<ContractsIfo>();
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setDate(1, java.sql.Date.valueOf(start));
				ps.setDate(2, java.sql.Date.valueOf(end));
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					ContractsIfo c=new ContractsIfo();
					c.setCno(rs.getString("合同编号"));
					c.setCname(rs.getString("合同名称"));
					c.setSno(rs.getString("供应商编号"));
					c.setGno(rs.getString("货物号"));
					c.setGname(rs.getString("货物名称"));
					c.setGother(rs.getString("货物配置"));
					c.setNum(rs.getInt("数量"));
					c.setPrice(rs.getFloat("单价"));
					c.setCdate(rs.getDate("进货日期"));
					c.setUserno(rs.getString("进货人员编号"));
					c.setUsername(rs.getString("进货人姓名"));
					c.setUsertype(rs.getString("进货人类型"));
					c.setSname(rs.getString("供应商名称"));
					c.setSadress(rs.getString("供应商地址"));
					c.setLinkman(rs.getString("联系人"));
					list.add(c);
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
		//根据时间段获取合同信息记录测试
		public static void getAllByDate2(String  start,String end){
			Connection conn=DBConnection.getConnection();
			String sql="call proc_contracts1(?,?)";
			List<ContractsIfo> list=new ArrayList<ContractsIfo>();
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setDate(1, java.sql.Date.valueOf(start));
				ps.setDate(2, java.sql.Date.valueOf(end));
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					ContractsIfo c=new ContractsIfo();
					System.out.println(rs.getString("合同编号"));
					System.out.println(rs.getString("合同名称"));
					System.out.println(rs.getString("供应商编号"));
					System.out.println(rs.getString("货物号"));
					System.out.println(rs.getString("货物名称"));
					System.out.println(rs.getString("货物配置"));
					System.out.println(rs.getInt("数量"));
					System.out.println(rs.getFloat("单价"));
					System.out.println(rs.getDate("进货日期"));
					System.out.println(rs.getString("进货人员编号"));
					System.out.println(rs.getString("进货人姓名"));
					System.out.println(rs.getString("进货人类型"));
					System.out.println(rs.getString("供应商名称"));
					System.out.println("供应商地址");
					
				}
				rs.close();
				ps.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			
			
		}
	public static void main(String[] args){
		//getAll2();
		//getAllByDate2("2017-01-10","2017-01-10");
		getAllWithPage2(1,10);
		

	}

}
