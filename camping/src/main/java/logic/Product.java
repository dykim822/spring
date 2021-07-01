package logic;
import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pId;		 private String  pName;
	private Integer price;		 private String description;
	private String picUrl;		 private Integer rangeCode;	
	private Integer mdCode;		 private Integer voteCode;	
	private Integer hit;		 private Date   regdate;
	private int     quantity;
	/*이미지 */
	private MultipartFile file1; private MultipartFile file2;	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public MultipartFile getFile1() {	return file1;	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public MultipartFile getFile2() {	return file2;	}
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
	public void setRegdate(Date regdate) {	this.regdate = regdate;	}
	public Date getRegdate() {	return regdate;	}
	public Integer getpId() {	return pId;	}
	public void setpId(Integer pId) {	this.pId = pId;	}
	public String getpName() {	return pName;	}
	public void setpName(String pName) { this.pName = pName;	}
	public Integer getPrice() {	return price;	}
	public void setPrice(Integer price) {	this.price = price;	}
	public String getDescription() {	return description;	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {		return picUrl;	}
	public void setPicUrl(String picUrl) {	this.picUrl = picUrl; }
	public Integer getRangeCode() {	return rangeCode;	}
	public void setRangeCode(Integer rangeCode) {
		this.rangeCode = rangeCode;
	}
	public Integer getMdCode() {	return mdCode;	}
	public void setMdCode(Integer mdCode) {	this.mdCode = mdCode;	}
	public Integer getVoteCode() {	return voteCode;	}
	public void setVoteCode(Integer voteCode) {	this.voteCode = voteCode;	}
	public Integer getHit() {	return hit;	}
	public void setHit(Integer hit) {	this.hit = hit;	}
	public static long getSerialversionuid() {	return serialVersionUID;	}
}