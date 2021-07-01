package logic;
import java.util.Date;
public class Board  {
	private int bId;		private String writer;
	private String title;	private String content;
	private Date regdate;	private int hit;
	private String bCode;	
	// 페이징용
	private int start;		
	// 조회용
	private String search;  private String query;	
	
	public int getStart() {	return start;	}
	public void setStart(int start) {	this.start = start;	}
	public String getSearch() {	return search;	}
	public void setSearch(String search) { this.search=search; }
	public String getQuery() {	return query;	}
	public void setQuery(String query) { this.query = query; }
	public int getbId() {	return bId;	}
	public void setbId(int bId) {	this.bId = bId;	}
	public String getWriter() {	return writer;	}
	public void setWriter(String writer) {	this.writer = writer;	}
	public String getTitle() {	return title;	}
	public void setTitle(String title) {	this.title = title;	}
	public String getContent() {	return content;	}
	public void setContent(String content) { this.content = content; }
	public Date getRegdate() {	return regdate;	}
	public void setRegdate(Date regdate) {	this.regdate = regdate;	}
	public int getHit() {	return hit;	}
	public void setHit(int hit) {	this.hit = hit;	}
	public String getbCode() {	return bCode;	}
	public void setbCode(String bCode) {	this.bCode = bCode;	}	
}