package bean;

import java.sql.Timestamp;

public class StockOutIfo {
	private String outno;
	private String Gno;
	private String Gname;
	private String userno;
	private String username;
	private String usertype;
	private int outnum;
	private Timestamp outtime;
	public String getOutno() {
		return outno;
	}
	public void setOutno(String outno) {
		this.outno = outno;
	}
	public String getGno() {
		return Gno;
	}
	public void setGno(String gno) {
		Gno = gno;
	}
	public String getGname() {
		return Gname;
	}
	public void setGname(String gname) {
		Gname = gname;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public int getOutnum() {
		return outnum;
	}
	public void setOutnum(int outnum) {
		this.outnum = outnum;
	}
	public Timestamp getOuttime() {
		return outtime;
	}
	public void setOuttime(Timestamp outtime) {
		this.outtime = outtime;
	}
	public void setOuttime(java.util.Date d){
		outtime=new Timestamp(d.getTime());
	}
}
