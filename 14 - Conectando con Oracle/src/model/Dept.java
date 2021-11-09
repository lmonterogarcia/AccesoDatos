package model;

import java.util.Objects;

public class Dept {

	private String sDeptNo, sDname, sLoc;

	public Dept() {
		this.sDeptNo = "";
		this.sDname = "";
		this.sLoc = "";
	}
	
	public Dept(String sDeptNo, String sDname, String sLoc) {
		this.sDeptNo = sDeptNo;
		this.sDname = sDname;
		this.sLoc = sLoc;
	}

	public String getsDeptNo() {
		return sDeptNo;
	}

	public void setsDeptNo(String sDeptNo) {
		this.sDeptNo = sDeptNo;
	}

	public String getsDname() {
		return sDname;
	}

	public void setsDname(String sDname) {
		this.sDname = sDname;
	}

	public String getsLoc() {
		return sLoc;
	}

	public void setsLoc(String sLoc) {
		this.sLoc = sLoc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sDeptNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dept other = (Dept) obj;
		return Objects.equals(sDeptNo, other.sDeptNo);
	}

	@Override
	public String toString() {
		return "Dept [sDeptNo=" + sDeptNo + ", sDname=" + sDname + ", sLoc=" + sLoc + "]";
	}
	
	
	
}
