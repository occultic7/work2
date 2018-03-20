package bean;

public class StockIfo {
	private String Gno;
	private String Gname;
	private String Tno;
	private String  Tname;
	private String Gother;
	private int stocknum;
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
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getGother() {
		return Gother;
	}
	public void setGother(String gother) {
		Gother = gother;
	}
	public int getStocknum() {
		return stocknum;
	}
	public void setStocknum(int stocknum) {
		this.stocknum = stocknum;
	}

}
