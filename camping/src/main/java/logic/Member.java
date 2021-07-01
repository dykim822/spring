package logic;
import java.io.Serializable;
public class Member implements Serializable {	
	private static final long serialVersionUID = 1L;
	private String  mId;		private String  password;
	private String  mName;		private String  postcode;
	private String  address;	private String  email;
	private String job;	
	
	public String getmId() {	return mId;	}
	public void setmId(String mId) {	this.mId = mId;	}
	public String getPassword() {	return password;	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getmName() {	return mName;	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getPostcode() {	return postcode;	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {	return address;	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {	return email;	}
	public void setEmail(String email) { this.email = email;	}
	public String getJob() {	return job;	}
	public void setJob(String job) {	this.job = job;	}	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}