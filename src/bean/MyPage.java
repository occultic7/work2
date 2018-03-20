package bean;
import java.util.List;
public class MyPage {
	private int pageNo;//当前页码
	private int pageCount;//分页数
	private int recordCount;//记录数
	private int pageSize;//分页大小
	private List list;//分页查询记录
	private int startrow;//该分页的开始记录
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public MyPage(){
		
	}
	public MyPage(int pageNo,int pageSize){
		this.pageNo=pageNo;
		this.pageSize=pageSize;
		this.startrow=(pageNo-1)*10;
	}
	public MyPage(int pageNo,int pageSize,int recordCount,List list){
		this.pageNo=pageNo;
		this.pageSize=pageSize;
		this.recordCount=recordCount;
		this.list=list;
		this.pageCount=(recordCount-((recordCount-1)%pageSize))/pageSize+1;
		this.startrow=(pageNo-1)*pageSize;
	}
}
