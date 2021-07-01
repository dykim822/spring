package logic;
import org.springframework.web.multipart.MultipartFile;
public class Loc {
	private Integer locCode;	private String locName;
	private String locUrl;		private MultipartFile file;
	
	public MultipartFile getFile() {	return file;	}
	public void setFile(MultipartFile file) {	this.file = file;	}
	public Integer getLocCode() {	return locCode;	}
	public void setLocCode(Integer locCode) { this.locCode = locCode; }
	public String getLocName() {	return locName;	}
	public void setLocName(String locName) { this.locName = locName; }
	public String getLocUrl() {	return locUrl;	}
	public void setLocUrl(String locUrl) {	this.locUrl = locUrl;	}
}