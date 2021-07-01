package logic;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;
public class CampSite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer sId;		private String sName;
	private String address;		private String phone;
	private String home;		private String picUrl;
	private Integer locCode;	private int reservation;
	public int getReservation() {	return reservation;	}
	public void setReservation(int reservation) {
		this.reservation = reservation;
	}
	private MultipartFile file;
	
	public MultipartFile getFile() {	return file;	}
	public void setFile(MultipartFile file) {	this.file = file;	}	
	public Integer getLocCode() {	return locCode;	}
	public void setLocCode(Integer locCode) {	this.locCode = locCode;	}
	public Integer getsId() {	return sId;	}
	public void setsId(Integer sId) {	this.sId = sId;	}
	public String getsName() {	return sName;	}
	public void setsName(String sName) {	this.sName = sName;	}
	public String getAddress() {	return address;	}
	public void setAddress(String address) {	this.address = address;	}
	public String getPhone() {	return phone;	}
	public void setPhone(String phone) {	this.phone = phone;	}
	public String getHome() {	return home;	}
	public void setHome(String home) {	this.home = home;	}
	public String getPicUrl() {	return picUrl;	}
	public void setPicUrl(String picUrl) {	this.picUrl = picUrl;	}
	public static long getSerialversionuid() {	return serialVersionUID;	}
}