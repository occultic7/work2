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
import bean.StockOut;
import bean.StockOutIfo;
import bean.StockOutNew;
import dao.DBConnection;

public class StockOutDao {
	public static boolean add(StockOut s){
		Connection conn=DBConnection.getConnection();
		String sql="insert into stock_out values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s.getOutno());
			ps.setString(2, s.getGno());
			ps.setInt(3, s.getOutnum());
			ps.setString(4, s.getUserno());
			ps.setTimestamp(5, s.getOuttime());
			int count=ps.executeUpdate();
			ps.close();
			conn.close();
			return count>0?true:false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public static boolean delete(String outno){
		Connection conn=DBConnection.getConnection();
		String sql="delete from stock_out where outno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, outno);
			int count=ps.executeUpdate();
			ps.close();
			conn.close();
			return count>0?true:false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public static boolean update(StockOut s){
		Connection conn=DBConnection.getConnection();
		String sql="update stock_out set Gno=?,outnum=?,userno=?,outtime=? where outno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s.getGno());
			ps.setInt(2, s.getOutnum());
			ps.setString(3, s.getUserno());
			ps.setTimestamp(4, s.getOuttime());
			ps.setString(5, s.getOutno());
			int count=ps.executeUpdate();
			ps.close();
			conn.close();
			return count>0?true:false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	//根据出库号查询一个出库记录
	public static StockOut getone(String outno){
		Connection conn=DBConnection.getConnection();
		String sql="select *from stock_out where outno=?";
		StockOut s=new StockOut();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, outno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				s.setOutno(rs.getString("outno"));
				s.setGno(rs.getString("Gno"));
				s.setOutnum(rs.getInt("outnum"));
				s.setUserno(rs.getString("userno"));
				s.setOuttime(rs.getTimestamp("outtime"));
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return s;
	}
	//根据出库单号查询详细出库记录(模糊查询)
		public static List<StockOutIfo> getAllByOutNo(String outno){
			Connection conn=DBConnection.getConnection();
			String sql="call proc_stock_out6(?)";
			List<StockOutIfo> list=new ArrayList<StockOutIfo>();
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, outno);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					StockOutIfo s=new StockOutIfo();
					s.setOutno(rs.getString("出库号"));
					s.setGno(rs.getString("货物号"));
					s.setOutnum(rs.getInt("出库数量"));
					s.setUserno(rs.getString("出库人编号"));
					s.setOuttime(rs.getTimestamp("出库时间"));
					s.setGname(rs.getString("货物名称"));
					s.setUsername(rs.getString("出库人姓名"));
					s.setUsertype(rs.getString("出库人类型"));
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
	//查询所有详细出库记录
	public static List<StockOutIfo> getAll(){
		Connection conn=DBConnection.getConnection();
		String sql="select *from viewofstockout";
		List<StockOutIfo> list=new ArrayList<StockOutIfo>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StockOutIfo s=new StockOutIfo();
				s.setOutno(rs.getString("出库号"));
				s.setGno(rs.getString("货物号"));
				s.setOutnum(rs.getInt("出库数量"));
				s.setUserno(rs.getString("出库人编号"));
				s.setOuttime(rs.getTimestamp("出库时间"));
				s.setGname(rs.getString("货物名称"));
				s.setUsername(rs.getString("出库人姓名"));
				s.setUsertype(rs.getString("出库人类型"));
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
	//查询所有详细出库记录 测试
		public static void getAll2(){
			Connection conn=DBConnection.getConnection();
			String sql="select *from viewofstockout";
			List<StockOutIfo> list=new ArrayList<StockOutIfo>();
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
			
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					
					System.out.println(rs.getString("出库号"));
					System.out.println(rs.getString("货物号"));
					System.out.println(rs.getInt("出库数量"));
					System.out.println(rs.getString("出库人编号"));
					System.out.println(rs.getTimestamp("出库时间"));
					System.out.println(rs.getString("货物名称"));
					System.out.println(rs.getString("出库人姓名"));
					System.out.println(rs.getString("出库人类型"));
					
				}
				rs.close();
				ps.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		//获取所有详细出库记录,返回分页类
		public static MyPage getAllWithPage(int pageNo,int pageSize){
			Connection conn1=DBConnection.getConnection();
			Connection conn2=DBConnection.getConnection();
			String sql1="select *from viewofstockout";
			String sql2="select *from viewofstockout limit ?,?";
			List<StockOutIfo> list=new ArrayList<StockOutIfo>();
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
					StockOutIfo s=new StockOutIfo();
					s.setOutno(rs2.getString("出库号"));
					s.setGno(rs2.getString("货物号"));
					s.setOutnum(rs2.getInt("出库数量"));
					s.setUserno(rs2.getString("出库人编号"));
					s.setOuttime(rs2.getTimestamp("出库时间"));
					s.setGname(rs2.getString("货物名称"));
					s.setUsername(rs2.getString("出库人姓名"));
					s.setUsertype(rs2.getString("出库人类型"));
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
		//根据出库人姓名查询详细出库记录  测试
		public static void getAllByUserName2(String username){
			Connection conn=DBConnection.getConnection();
			String sql="call proc_stock_out2(?)";
			List<StockOutIfo> list=new ArrayList<StockOutIfo>();
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,username);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					
					System.out.println(rs.getString("出库号"));
					System.out.println(rs.getString("货物号"));
					System.out.println(rs.getInt("出库数量"));
					System.out.println(rs.getString("出库人编号"));
					System.out.println(rs.getTimestamp("出库时间"));
					System.out.println(rs.getString("货物名称"));
					System.out.println(rs.getString("出库人姓名"));
					System.out.println(rs.getString("出库人类型"));
					
				}
				rs.close();
				ps.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
//根据出库人姓名查询详细出库记录  
		public static List<StockOutIfo> getAllByUserName(String username){
			Connection conn=DBConnection.getConnection();
			String sql="call proc_stock_out2(?)";
			List<StockOutIfo> list=new ArrayList<StockOutIfo>();
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,username);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					StockOutIfo s=new StockOutIfo();
					s.setOutno(rs.getString("出库号"));
					s.setGno(rs.getString("货物号"));
					s.setOutnum(rs.getInt("出库数量"));
					s.setUserno(rs.getString("出库人编号"));
					s.setOuttime(rs.getTimestamp("出库时间"));
					s.setGname(rs.getString("货物名称"));
					s.setUsername(rs.getString("出库人姓名"));
					s.setUsertype(rs.getString("出库人类型"));
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
//根据出库人编号查询详细出库记录  
		public static List<StockOutIfo> getAllByUserNo(String userno){
			Connection conn=DBConnection.getConnection();
			String sql="select *from viewofstockout where 出库人编号 =?";
			List<StockOutIfo> list=new ArrayList<StockOutIfo>();
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,userno);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					StockOutIfo s=new StockOutIfo();
					s.setOutno(rs.getString("出库号"));
					s.setGno(rs.getString("货物号"));
					s.setOutnum(rs.getInt("出库数量"));
					s.setUserno(rs.getString("出库人编号"));
					s.setOuttime(rs.getTimestamp("出库时间"));
					s.setGname(rs.getString("货物名称"));
					s.setUsername(rs.getString("出库人姓名"));
					s.setUsertype(rs.getString("出库人类型"));
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
	//根据出库人编号查询详细出库记录  测试
			public static void getAllByUserNo2(String userno){
				Connection conn=DBConnection.getConnection();
				String sql="select *from viewofstockout where 出库人编号 =?";
				List<StockOutIfo> list=new ArrayList<StockOutIfo>();
				
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1,userno);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						
						System.out.println(rs.getString("出库号"));
						System.out.println(rs.getString("货物号"));
						System.out.println(rs.getInt("出库数量"));
						System.out.println(rs.getString("出库人编号"));
						System.out.println(rs.getTimestamp("出库时间"));
						System.out.println(rs.getString("货物名称"));
						System.out.println(rs.getString("出库人姓名"));
						System.out.println(rs.getString("出库人类型"));
						
					}
					rs.close();
					ps.close();
					conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			}
			//统计一个时间段内的出库记录  
			public static List<StockOutNew> getStockOutNewByDate(String stime,String etime){
				Connection conn=DBConnection.getConnection();
				String sql="call proc_stock_out3(?,?)";
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
				List<StockOutNew> list=new ArrayList<StockOutNew>();
				
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setTimestamp(1, ti1);
					ps.setTimestamp(2, ti2);
					
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						StockOutNew s=new StockOutNew();
						s.setGno(rs.getString("货物号"));
						s.setGname(rs.getString("货物名称"));
						s.setOutnum(rs.getInt("出库总数"));
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
			//统计一个时间段内的出库记录  测试
			public static void getStockOutNewByDate2(String stime,String etime){
				Connection conn=DBConnection.getConnection();
				String sql="call proc_stock_out3(?,?)";
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
				List<StockOutNew> list=new ArrayList<StockOutNew>();
				
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setTimestamp(1, ti1);
					ps.setTimestamp(2, ti2);
					
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						
						System.out.println(rs.getString("货物号"));
						System.out.println(rs.getString("货物名称"));
						System.out.println(rs.getInt("出库总数"));
						
						
					}
					rs.close();
					ps.close();
					conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			}
			
			//根据时间段和商品名称查询出库记录  
			public static List<StockOutIfo> getStockOutByDateOrGood(String Gname,String stime,String etime){
				Connection conn=DBConnection.getConnection();
				String sql="call proc_stock_out4(?,?,?)";
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
				List<StockOutIfo> list=new ArrayList<StockOutIfo>();
				
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, Gname);
					ps.setTimestamp(2, ti1);
					ps.setTimestamp(3, ti2);
					
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						StockOutIfo s=new StockOutIfo();
						s.setOutno(rs.getString("出库号"));
						s.setGno(rs.getString("货物号"));
						s.setOutnum(rs.getInt("出库数量"));
						s.setUserno(rs.getString("出库人编号"));
						s.setOuttime(rs.getTimestamp("出库时间"));
						s.setGname(rs.getString("货物名称"));
						s.setUsername(rs.getString("出库人姓名"));
						s.setUsertype(rs.getString("出库人类型"));
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
			//根据时间段和商品名称查询出库记录  测试
			public static void getStockOutByDateOrGood2(String Gname,String stime,String etime){
				Connection conn=DBConnection.getConnection();
				String sql="call proc_stock_out4(?,?,?)";
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
				List<StockOutIfo> list=new ArrayList<StockOutIfo>();
				
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, Gname);
					ps.setTimestamp(2, ti1);
					ps.setTimestamp(3, ti2);
					
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						StockOutIfo s=new StockOutIfo();
						System.out.println(rs.getString("出库号"));
						System.out.println(rs.getString("货物号"));
						System.out.println(rs.getInt("出库数量"));
						System.out.println(rs.getString("出库人编号"));
						System.out.println(rs.getTimestamp("出库时间"));
						System.out.println(rs.getString("货物名称"));
						System.out.println(rs.getString("出库人姓名"));
						System.out.println(rs.getString("出库人类型"));
						
					}
					rs.close();
					ps.close();
					conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			}
			//根据时间段和工作人员名查询出库记录  
			public static List<StockOutIfo> getStockOutByDateOrUser(String username,String stime,String etime){
				Connection conn=DBConnection.getConnection();
				String sql="call proc_stock_out5(?,?,?)";
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
				List<StockOutIfo> list=new ArrayList<StockOutIfo>();
				
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setTimestamp(2, ti1);
					ps.setTimestamp(3, ti2);
					
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						StockOutIfo s=new StockOutIfo();
						s.setOutno(rs.getString("出库号"));
						s.setGno(rs.getString("货物号"));
						s.setOutnum(rs.getInt("出库数量"));
						s.setUserno(rs.getString("出库人编号"));
						s.setOuttime(rs.getTimestamp("出库时间"));
						s.setGname(rs.getString("货物名称"));
						s.setUsername(rs.getString("出库人姓名"));
						s.setUsertype(rs.getString("出库人类型"));
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
		public static void main(String args[]){
			//getAllByUserNo2("201511104000");
			//getStockOutNewByDate2("2018-01-14T15:12:25","2018-01-18T16:35:53");
			getStockOutByDateOrGood2("货物","2018-01-14T15:12:25","2018-01-17T15:12:25");
		}
		
		
}
