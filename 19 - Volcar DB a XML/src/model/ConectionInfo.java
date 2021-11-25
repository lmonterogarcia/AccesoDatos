package model;

import java.io.Serializable;
import java.util.Objects;

public class ConectionInfo implements Serializable{

	private String dbHOST;
	private String dbPORT;
	private String dbSID;
	private String dbUSER;
	private String dbPASSWORD;
	
	public ConectionInfo() {
		this.dbHOST = "";
		this.dbPORT = "";
		this.dbSID = "";
		this.dbUSER = "";
		this.dbPASSWORD = "";
	}
	
	public ConectionInfo(String dbHOST, String dbPORT, String dbSID, String dbUSER, String dbPASSWORD) {
		this.dbHOST = dbHOST;
		this.dbPORT = dbPORT;
		this.dbSID = dbSID;
		this.dbUSER = dbUSER;
		this.dbPASSWORD = dbPASSWORD;
	}

	public String getDbHOST() {
		return dbHOST;
	}

	public void setDbHOST(String dbHOST) {
		this.dbHOST = dbHOST;
	}

	public String getDbPORT() {
		return dbPORT;
	}

	public void setDbPORT(String dbPORT) {
		this.dbPORT = dbPORT;
	}

	public String getDbSID() {
		return dbSID;
	}

	public void setDbSID(String dbSID) {
		this.dbSID = dbSID;
	}

	public String getDbUSER() {
		return dbUSER;
	}

	public void setDbUSER(String dbUSER) {
		this.dbUSER = dbUSER;
	}

	public String getDbPASSWORD() {
		return dbPASSWORD;
	}

	public void setDbPASSWORD(String dbPASSWORD) {
		this.dbPASSWORD = dbPASSWORD;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dbHOST, dbPASSWORD, dbPORT, dbSID, dbUSER);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConectionInfo other = (ConectionInfo) obj;
		return Objects.equals(dbHOST, other.dbHOST) && Objects.equals(dbPASSWORD, other.dbPASSWORD)
				&& Objects.equals(dbPORT, other.dbPORT) && Objects.equals(dbSID, other.dbSID)
				&& Objects.equals(dbUSER, other.dbUSER);
	}

	@Override
	public String toString() {
		return "ConectionInfo [dbHOST=" + dbHOST + ", dbPORT=" + dbPORT + ", dbSID=" + dbSID + ", dbUSER=" + dbUSER
				+ ", dbPASSWORD=" + dbPASSWORD + "]";
	}
	
	
	
	
}
