package list;

import java.util.List;
// List형식으로 한건이 아니라 여러건을 받을 때
public class ListBean {
	private List<String> addr;

	public List<String> getAddr() {
		return addr;
	}
	public void setAddr(List<String> addr) {
		this.addr = addr;
	}
	
}
