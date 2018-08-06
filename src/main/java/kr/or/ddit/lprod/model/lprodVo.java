package kr.or.ddit.lprod.model;

public class lprodVo {
	
	private int lprod_id;		//제품번호
	private String lprod_gu;	//제품구분
	private String lprod_nm;//제품이름
	
	public lprodVo() {
		
	}

	public int getLprod_id() {
		return lprod_id;
	}

	public void setLprod_id(int lprod_id) {
		this.lprod_id = lprod_id;
	}

	public String getLprod_gu() {
		return lprod_gu;
	}

	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}

	public String getLprod_nm() {
		return lprod_nm;
	}

	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}

	@Override
	public String toString() {
		return "lprodVo [lprod_id=" + lprod_id + ", lprod_gu=" + lprod_gu
				+ ", lprod_nm=" + lprod_nm + "]";
	}
	
}
