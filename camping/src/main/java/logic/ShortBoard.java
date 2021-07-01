package logic;
import java.io.Serializable;
import java.util.Date;
public class ShortBoard implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pId;	private String  writer;
	private Integer sbId;	private String content;
	private Date regdate;	
	public Integer getpId() {	return pId;	}
	public void setpId(Integer pId) {	this.pId = pId;	}
	public String getWriter() {	return writer;	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Integer getSbId() {	return sbId;	}
	public void setSbId(Integer sbId) {	this.sbId = sbId;	}
	public String getContent() {	return content;	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {	return regdate;	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}