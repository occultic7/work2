package bean;

import java.sql.Timestamp;

public class StockInIfo {
	private String inno;
	private String Cno;
	private String Gno;
	private String Gname;
	private float price;
	private int innum;
	private Timestamp intime;
	private String userno;
	private String username;
	private String usertype;
	private String Sno;
	private String Sname;
	private String Sadress;
	private String linkman;
	public String getInno() {
		return inno;
	}
	public void setInno(String inno) {
		this.inno = inno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getInnum() {
		return innum;
	}
	public void setInnum(int innum) {
		this.innum = innum;
	}
	public Timestamp getIntime() {
		return intime;
	}
	public void setIntime(Timestamp intime) {
		this.intime = intime;
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
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSadress() {
		return Sadress;
	}
	public void setSadress(String sadress) {
		Sadress = sadress;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
}
