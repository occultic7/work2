package bean;
import java.sql.Timestamp;

public class StockOut {
	private String outno;
	private String Gno;
	private String userno;
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
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
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
