package bean;

public class ContractsIfo {
	private String Cno;
	private String Cname;
	private String Sno;
	private String Sname;
	private String Sadress;
	private String linkman;
	private String Gno;
	private String Gname;
	private String Gother;
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	private float price;
	private java.sql.Date Cdate;
	private String userno;
	private String username;
	private String usertype;
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
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
	public String getGother() {
		return Gother;
	}
	public void setGother(String gother) {
		Gother = gother;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public java.sql.Date getCdate() {
		return Cdate;
	}
	public void setCdate(java.sql.Date cdate) {
		Cdate = cdate;
	}
	public void setCdate(java.util.Date d){
		Cdate=new java.sql.Date(d.getTime());
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
}
